package com.coaching2live.model.enums;

public enum BucketNameEnum {

	ATTACHMENT("coaching2live-attachments"),
	IMAGES("coaching2live-images");
	
	private String name;
	
	private BucketNameEnum(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
