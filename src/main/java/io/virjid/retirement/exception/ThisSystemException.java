package io.virjid.retirement.exception;

public class ThisSystemException extends RuntimeException{
	private static final long serialVersionUID = 4420867375740373294L;
	
	private final String code;

	public ThisSystemException(String code) {
		this(code,null,null);
	}

	public String getCode() {
		return code;
	}

	public ThisSystemException(String code,String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public ThisSystemException(String code,String message) {
		super(message);
		this.code = code;
	}
}
