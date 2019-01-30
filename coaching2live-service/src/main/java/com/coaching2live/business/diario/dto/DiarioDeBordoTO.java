package com.coaching2live.business.diario.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.coaching2live.business.sessao.dto.SessaoTO;
import com.coaching2live.business.to.BaseTO;

@Document(collection="diarioDeBordo")
public class DiarioDeBordoTO extends BaseTO { 

	/**
	 * 
	 */
	private static final long serialVersionUID = -9088113736042595791L;
	private SessaoTO sessao;
	private String conteudoSessao;
	private Date dataCadastro;
	
	public SessaoTO getSessao() {
		return sessao;
	}
	public void setSessao(SessaoTO sessao) {
		this.sessao = sessao;
	}
	public String getConteudoSessao() {
		return conteudoSessao;
	}
	public void setConteudoSessao(String conteudoSessao) {
		this.conteudoSessao = conteudoSessao;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
