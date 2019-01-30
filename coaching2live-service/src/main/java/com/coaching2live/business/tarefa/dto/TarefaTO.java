package com.coaching2live.business.tarefa.dto;

import java.util.Date;

import com.coaching2live.business.sessao.dto.SessaoTO;
import com.coaching2live.business.to.BaseTO;
import com.coaching2live.model.enums.FormaEntregaEnum;
import com.coaching2live.model.enums.StatusTarefaEnum;

public class TarefaTO extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3515673418494576986L;
	private SessaoTO sessao;
	private Date dataAlvo;
	private Date dataEfetiva;
	private String comentario;
	private StatusTarefaEnum status;
	private String descricao;
	private FormaEntregaEnum formaEntrega;
	
	public TarefaTO() {
		// TODO Auto-generated constructor stub
	}
	
	public TarefaTO(String id) {
		
		super.id = id;
	}
	
	public SessaoTO getSessao() {
		return sessao;
	}

	public void setSessao(SessaoTO sessao) {
		this.sessao = sessao;
	}

	public Date getDataAlvo() {
		return dataAlvo;
	}

	public void setDataAlvo(Date dataAlvo) {
		this.dataAlvo = dataAlvo;
	}

	public Date getDataEfetiva() {
		return dataEfetiva;
	}

	public void setDataEfetiva(Date dataEfetiva) {
		this.dataEfetiva = dataEfetiva;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public StatusTarefaEnum getStatus() {
		return status;
	}

	public void setStatus(StatusTarefaEnum status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FormaEntregaEnum getFormaEntrega() {
		return formaEntrega;
	}

	public void setFormaEntrega(FormaEntregaEnum formaEntrega) {
		this.formaEntrega = formaEntrega;
	}

}
