package com.coaching2live.model.enums;

public enum BucketFolderNameEnum {

	TASK("task"),
	SESSION("session"),
	CONTRACT("contract"),
	PROFILE("profile");

	private String name;

	private BucketFolderNameEnum(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}