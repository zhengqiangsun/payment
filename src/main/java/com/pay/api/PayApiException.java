package com.pay.api;

/**
 * 支付API异常
 * @author sunzhengqiang
 * @date 2016年11月21日
 */
public class PayApiException extends RuntimeException {
	
	

	public PayApiException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PayApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PayApiException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PayApiException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PayApiException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

}
