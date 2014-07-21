package io.github.droidapps.pdfreader;

/**
 * High level user-visible application exception.
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 3168318522532680977L;

	public ApplicationException(String message) {
		super(message);
	}
}
