package com.coaching2live.model.exception;

public class Coaching2liveException extends Exception {
	
	private ExceptionTypeEnum exceptionTypeEnum;
	
	public Coaching2liveException() {

		exceptionTypeEnum = ExceptionTypeEnum.ALERT_DANGER;
	}
	
	public Coaching2liveException(String message) {
        super(message);
    }
	
	public Coaching2liveException(ExceptionTypeEnum exceptionTypeEnum, String message) {

		super(message);
        this.exceptionTypeEnum = exceptionTypeEnum;
    }

	public Coaching2liveException(Throwable cause) {
        super(cause);
    }

	public Coaching2liveException(String message, Throwable cause) {
        super(message, cause);
    }
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8598378701773923294L;

	public ExceptionTypeEnum getExceptionTypeEnum() {
		return exceptionTypeEnum;
	}
}
