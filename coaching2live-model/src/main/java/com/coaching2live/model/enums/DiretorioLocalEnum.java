package com.coaching2live.model.enums;

public enum DiretorioLocalEnum {

	ARQUIVOS("c:/uploadedFiles/arquivos/"),
	IMAGENS("c:/uploadedFiles/imagens/");

	private String caminho;

	private DiretorioLocalEnum(String caminho) {

		this.caminho = caminho;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
