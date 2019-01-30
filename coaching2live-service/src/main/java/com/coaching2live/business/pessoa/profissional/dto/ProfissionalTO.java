package com.coaching2live.business.pessoa.profissional.dto;

import java.util.List;

import com.coaching2live.business.pessoa.cliente.dto.ClienteTO;
import com.coaching2live.business.pessoa.dto.PessoaTO;

public class ProfissionalTO extends PessoaTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 660347980244232765L;

	private List<ClienteTO> clientes;

	public List<ClienteTO> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteTO> clientes) {
		this.clientes = clientes;
	}

}
