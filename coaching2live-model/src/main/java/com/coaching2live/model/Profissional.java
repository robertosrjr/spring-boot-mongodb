package com.coaching2live.model;

import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="pessoa")
@TypeAlias(value="profissional")
public class Profissional extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2307152834490843981L;
	private List<Cliente> clientes;
	
	public Profissional() {

	}

	public Profissional(String id) {

		super.id = id;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
