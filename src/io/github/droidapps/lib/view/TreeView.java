package io.github.droidapps.lib.view;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import io.github.droidapps.pdfreader.R;

/**
 * Simple tree view used for Table of Contents.
 * 
 * This class' package is io.github.droidapps.lib.view, since TreeView might be reusable in other projects.
 * 
 * TODO: move data handling (getItemAtPosition) from TreeView to TreeAdapter,
 * 	     as it should be; TreeView should query TreeAdapter, not other way around :/
 *       however, it would still be cool to have self contained simple-api class for all of tree related stuff
 */
public class TreeView extends ListView {
	
	public final static String TAG = "io.github.droidapps.lib.view";
	
	/**
	 * Tree node model. Contains links to first child and to next element.
	 */
	public interface TreeNode {
		
		/**
		 * Get numeric id.
		 */
		public long getId();
		/**
		 * Get next element.
		 */
		public TreeNode getNext();
		/**
		 * Get down element.
		 */
		public TreeNode getDown();
		/**
		 * Return true if this node has children.
		 */
		public boolean hasChildren();
		
		/**
		 * Get list of children or null if there are no children.
		 */
		public List<TreeNode> getChildren();

		/**
		 * Get text of given node.
		 * @return text that shows up on list
		 */
		public String getText();
		
		/**
		 * Return 0-based level (depth) of this tree node.
		 * Top level elements have level 0, children of top level elements have level 1 etc.
		 */
		public int getLevel();
	}
	
	private final static class TreeAdapter extends BaseAdapter {
		
		/**
		 * Parent TreeView.
		 * For now each TreeAdapter is bound to exactly one TreeView,
		 * because TreeView is general purpose class that holds both tree
		 * data and tree state.
		 */
		private TreeView parent = null;
		
		/**
		 * TreeAdapter constructor.
		 * @param parent parent TreeView
		 */
		public TreeAdapter(TreeView parent) {
			this.parent = parent;
		}

		public int getCount() {
			return this.parent.getVisibleCount();
		}

		public Object getItem(int position) {
			TreeNode node = this.parent.getTreeNodeAtPosition(position);
			return node;
		}

		public long getItemId(int position) {
			TreeNode node = this.parent.getTreeNodeAtPosition(position);
			return node.getId();
		}

		/**
		 * Return item view type by position. Since all elements in TreeView
		 * are the same, this always returns 0.
		 * @param position item position
		 * @return 0
		 */
		public int getItemViewType(int position) {
			return 0;
		}

		/**
		 * Get view for list item for given position.
		 * TODO: handle convertView
		 */
		public View getView(final int position, View convertView, ViewGroup parent) {
			final TreeNode node = this.parent.getTreeNodeAtPosition(position);
			if (node == null) throw new RuntimeException("no node at position " + position);
			final LinearLayout l = new LinearLayout(parent.getContext());
			l.setOrientation(LinearLayout.HORIZONTAL);
			Button b = new Button(parent.getContext());

			/* TODO: do not use anonymous classes here */
			
			if (node.hasChildren()) {
				if (this.parent.isOpen(node)) {
					b.setBackgroundResource(R.drawable.minus);
					b.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							Log.d(TAG, "click on " + position + ": " + node);
							TreeAdapter.this.parent.close(node);
							TreeAdapter.this.notifyDataSetChanged();
						}
					});
				} else {
					b.setBackgroundResource(R.drawable.plus);
					b.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							Log.d(TAG, "click on " + position + ": " + node);
							TreeAdapter.this.parent.open(node);
							TreeAdapter.this.notifyDataSetChanged();
						}
					});
				}
			} else {
				b.setBackgroundColor(Color.TRANSPARENT);
				b.setEnabled(false);
			}
			
			/* TODO: don't create LinearLayout.LayoutParams for earch button */
			LinearLayout.LayoutParams blp = new LinearLayout.LayoutParams(this.parent.tocButtonSizePx, this.parent.tocButtonSizePx);
			blp.gravity = android.view.Gravity.CENTER;
			l.addView(b, blp);
			TextView tv = new TextView(parent.getContext());
			tv.setClickable(true);
			tv.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					TreeAdapter.this.parent.performItemClick(l, position, node.getId());
				}
			});
			int nodeLevel = node.getLevel();
			int pixelsPerLevel = 4;
			/* 4 + 4 for each level, but only for top 8 levels */
			tv.setPadding(4 + (nodeLevel > 7 ? 7*pixelsPerLevel : nodeLevel*pixelsPerLevel), 4, 4, 4);
			tv.setText(node.getText());
			/* TODO: create only one */
			LinearLayout.LayoutParams tvlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			tvlp.gravity = android.view.Gravity.CENTER_VERTICAL;
			l.addView(tv, tvlp);
			return l;
		}

		public int getViewTypeCount() {
			return 1;
		}

		public boolean hasStableIds() {
			return true;
		}

		/**
		 * Since we refuse to show TreeView for docs without TOC, we can safely
		 * assume that TreeView is never empty, so this method always returns
		 * false.
		 * @return false
		 */
		@Override
		public boolean isEmpty() {
			return false;
		}

	};
	
	/**
	 * Tree root.
	 */
	private TreeNode root = null;
	
	/**
	 * State: either open or closed.
	 * If not found in map, then it's closed, unless it's top level element
	 * (those are always open, since they have no parents).
	 */
	private Map<Long, Boolean> state = null;
	
	private int tocButtonSizePx = -1;
	
	private float tocButtonSizeDp = 48;
	
	private int tocButtonMinSizePx = 24;
	
	/**
	 * Construct this tree view.
	 */
	public TreeView(Context context) {
		super(context);
		final float scale = getResources().getDisplayMetrics().density;
		this.tocButtonSizePx = (int) (tocButtonSizeDp * scale + 0.5f);
		if (this.tocButtonSizePx < this.tocButtonMinSizePx) this.tocButtonSizePx = this.tocButtonMinSizePx;
		
	}

	/**
	 * Set contents.
	 * @param root root (first top level node) of tree
	 */
	public synchronized void setTree(TreeNode root) {
		if (root == null) throw new IllegalArgumentException("tree root can not be null");
		this.root = root;
		this.state = new HashMap<Long, Boolean>();
		TreeAdapter adapter = new TreeAdapter(this);
		this.setAdapter(adapter);
	}
	
	/**
	 * Check if given node is open.
	 * Root node is always open.
	 * Node state is checked in this.state.
	 * If node state is not found in this.state, then it's assumed given node is closed.
	 * @return true if given node is open, false otherwise
	 */
	public synchronized boolean isOpen(TreeNode node) {
		if (this.state.containsKey(node.getId())) {
			return this.state.get(node.getId());
		} else {
			return false;
		}
	}
	
	public synchronized void open(TreeNode node) {
		this.open(node.getId());
	}
	
	public synchronized void open(long id) {
		this.state.put(id, true);
	}
	
	public synchronized void close(TreeNode node) {
		this.close(node.getId());
	}
	
	public synchronized void close(long id) {
		this.state.remove(id);
	}
	
	/**
	 * Count visible tree elements.
	 */
	public synchronized int getVisibleCount() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		/* walk visible part of tree by not descending into closed branches */
		stack.push(this.root);
		int count = 0;
		while(!stack.empty()) {
			count += 1;
			TreeNode node = stack.pop();
			if (this.isOpen(node) && node.hasChildren()) {
				/* node is open - also count children */
				stack.push(node.getDown());
			}
			/* now count other elements at this level */
			if (node.getNext() != null) stack.push(node.getNext());
		}
		return count;
	}
	
	/**
	 * Get text for position taking account current state.
	 * Iterates over tree taking state into account until position-th element is found.
	 * TODO: this is used quite frequently, so probably it would be worth to cache results
	 * @param position 0-based position in list
	 * @return text of currently visible item at given position
	 */
	public synchronized TreeNode getTreeNodeAtPosition(int position) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(this.root);
		int i = 0;
		TreeNode found = null;
		while(!stack.empty() && found == null) {
			TreeNode node = stack.pop();
			if (i == position) {
				found = node;
				break;
			}
			if (node.getNext() != null) stack.push(node.getNext());
			if (node.getDown() != null && this.isOpen(node)) {
				stack.push(node.getDown());
			}
			i++;
		}
		return found;
	}
	
	/**
	 * Get tree state map.
	 * @return unmodifiable version of this.state
	 */
	public Map<Long, Boolean> getState() {
		return Collections.unmodifiableMap(this.state);
	}
}
