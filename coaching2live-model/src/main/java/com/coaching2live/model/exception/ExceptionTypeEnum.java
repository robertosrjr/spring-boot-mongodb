package com.coaching2live.model.exception;

public enum ExceptionTypeEnum {
	
	ALERT_SUCCESS("alert-success"),
	ALERT_INFO("alert-info"),
	ALERT_WARNING("alert-warning"),
	ALERT_DANGER("alert-danger");

	private String value;

	private ExceptionTypeEnum(String value) {

		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
