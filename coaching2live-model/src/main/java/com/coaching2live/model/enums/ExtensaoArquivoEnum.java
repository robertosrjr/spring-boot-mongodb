package com.coaching2live.model.enums;

public enum ExtensaoArquivoEnum {

	PDF("pdf"),
	DOCX("docx"),
	DOC("doc"),
	XLSX("xlsx"),
	XLS("xls"),
	PPT("ppt"),
	TXT("txt"),
	PNG("png"),
	JPG("jpg"),
	JPEG("jpeg"),
	GIF("gif");

private String value;

	private ExtensaoArquivoEnum(String value) {

		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
