package com.coaching2live.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reflexao")
public class Reflexao extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3577333620712667330L;
	@DBRef private Cliente cliente;
	private String mensagem;
	private String urlImagem;
	private String urlVideo;
	private String urlAudio;
	
	public Reflexao() {
		// TODO Auto-generated constructor stub
	}

	public Reflexao(String id) {

		super.id = id;
	}
	
	public Reflexao(Cliente cliente) {

		this.cliente = cliente;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getUrlVideo() {
		return urlVideo;
	}
	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}
	public String getUrlAudio() {
		return urlAudio;
	}
	public void setUrlAudio(String urlAudio) {
		this.urlAudio = urlAudio;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
