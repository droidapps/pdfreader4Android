package io.github.droidapps.pdfreader.test;

import java.io.FileDescriptor;

import android.content.res.AssetFileDescriptor;
import android.test.InstrumentationTestCase;
import android.util.Log;
import io.github.droidapps.lib.pdf.PDF;

public class TestOpen extends InstrumentationTestCase {
		
	private final static String TAG = "io.github.droidapps.pdfreader.test";
	
	public void testOpenByFileDescriptor() throws Throwable {
        AssetFileDescriptor assetfd = getInstrumentation().getContext().getResources().getAssets().openFd("gplv3.pdf");
        FileDescriptor fd = assetfd.getFileDescriptor();
        Exception exception = null;
		try {
			PDF pdf = new PDF(fd, 2);
			Log.d(TAG, "opened file: " + pdf);
		} catch (Exception e) {
			exception = e;
		}
		assertNull(exception);
	}
	
	public void testGetPageCount() throws Throwable {
	    AssetFileDescriptor assetfd = getInstrumentation().getContext().getResources().getAssets().openFd("gplv3.pdf");
		FileDescriptor fd = assetfd.getFileDescriptor();
		Exception exception = null;
		int pageCount = -1;
		try {
			PDF pdf = new PDF(fd, 2);
			pageCount = pdf.getPageCount();
			Log.d(TAG, "page count: " + pageCount);
		} catch (Exception e) {
			exception = e;
		}
		assertNull(exception);
		assertEquals(1, pageCount);
	}
}


