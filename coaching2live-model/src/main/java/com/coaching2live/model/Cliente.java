package com.coaching2live.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="pessoa")
@TypeAlias(value="cliente")
public class Cliente extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1878393796877498419L;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(String id) {

		super.id = id;
	}
	
	
}
