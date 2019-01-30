package com.coaching2live.model;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="contrato")
public class Contrato extends AbstractEntity implements Anexavel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2553948156326157395L;

	private Objetivo objetivo;
	private BigDecimal valor;
	
	public Contrato() {
	
	}

	public Contrato(String id) {

		super.id = id;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	

}
