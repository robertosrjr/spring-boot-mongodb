package com.coaching2live.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.coaching2live.model.enums.StatusObjetivoEnum;

@Document(collection = "objetivo")
public class Objetivo extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7231915917097900053L;
	private String objetivo;
	private Date dataInicio;
	private Date dataFim;
	private StatusObjetivoEnum status;
	private Double pontuacao;
	private Integer likeCount;
	private String descricaoObjetivo;
	private String imagemObjetivo;
	private DicaLivro dicaLivro;
	@DBRef private Cliente cliente;
	@DBRef private Profissional profissional;
	
	
	public Objetivo(String id) {

		super.id = id;
		this.cliente = new Cliente();
		this.profissional = new Profissional();
		this.dicaLivro = new DicaLivro();
	}

	public Objetivo() {

		this.cliente = new Cliente();
		this.profissional = new Profissional();
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public StatusObjetivoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusObjetivoEnum status) {
		this.status = status;
	}

	public Double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public String getDescricaoObjetivo() {
		return descricaoObjetivo;
	}

	public void setDescricaoObjetivo(String descricaoObjetivo) {
		this.descricaoObjetivo = descricaoObjetivo;
	}

	public String getImagemObjetivo() {
		return imagemObjetivo;
	}

	public void setImagemObjetivo(String imagemObjetivo) {
		this.imagemObjetivo = imagemObjetivo;
	}

	public DicaLivro getDicaLivro() {
		return dicaLivro;
	}

	public void setDicaLivro(DicaLivro dicaLivro) {
		this.dicaLivro = dicaLivro;
	}
}
