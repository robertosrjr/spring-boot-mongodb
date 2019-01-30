package com.coaching2live.model.enums;

public enum ExtensaoImagemEnum {
	
	JPG("jpg"),
	PNG("png");

	private String value;

	private ExtensaoImagemEnum(String value) {

		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
