package io.virjid.retirement.common.validator;

import io.virjid.retirement.exception.ThisSystemException;

public class ValidateException extends ThisSystemException{
	private static final long serialVersionUID = 612000001131071067L;

	public ValidateException(String code, String message, Throwable cause) {
		super(code, message, cause);
	}

	public ValidateException(String code, String message) {
		super(code, message);
	}

	public ValidateException(String code) {
		super(code);
	}
}
