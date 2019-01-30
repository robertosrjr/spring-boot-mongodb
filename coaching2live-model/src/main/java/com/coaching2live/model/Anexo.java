package com.coaching2live.model;

import com.coaching2live.model.enums.ExtensaoArquivoEnum;

public class Anexo extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 151708861209140765L;
	/**
	 * 
	 */
	private byte[] arquivo;
	private String nomeArquivo;
	private ExtensaoArquivoEnum extensao;
	private String urlDownload;
	
	public Anexo() {
		// TODO Auto-generated constructor stub
	}
	
	public Anexo(String id) {
		
		super(id);
	}

	public byte[] getArquivo() {
		return arquivo;
	}
	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public ExtensaoArquivoEnum getExtensao() {
		return extensao;
	}
	public void setExtensao(ExtensaoArquivoEnum extensao) {
		this.extensao = extensao;
	}
	public String getUrlDownload() {
		return urlDownload;
	}
	public void setUrlDownload(String urlDownload) {
		this.urlDownload = urlDownload;
	}
}


