package com.hpzc.model.exception;

public class BizException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BizException() {
	};

	public BizException(String message) {

		super(message);
	}

	public BizException(String message, Throwable e) {
		super(message, e);
	};

}
