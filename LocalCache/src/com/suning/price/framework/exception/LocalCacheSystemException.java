package com.suning.price.framework.exception;

public class LocalCacheSystemException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;//Error code.

	private ErrorMessage msg;// Error message.
	
	public LocalCacheSystemException() {}
	
	public LocalCacheSystemException(Throwable cause) {
		super(cause);
	}
	
	public LocalCacheSystemException(String code, ErrorMessage message) {
		super(code);
		this.code = code;
		this.msg = message;
		this.msg.setCode(code);
	}

	public String getCode() {
		return code;
	}


	public ErrorMessage getMsg() {
		return msg;
	}

	
	
}
