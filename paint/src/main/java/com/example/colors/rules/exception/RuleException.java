package com.example.colors.rules.exception;

/**
 * Rule Exception class.
 * @author Deepika Vashishtha
 *
 */
public class RuleException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RuleException(String errorMsg) {
		super(errorMsg);
	}
}
