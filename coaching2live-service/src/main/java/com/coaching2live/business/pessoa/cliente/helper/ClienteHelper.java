package com.coaching2live.business.pessoa.cliente.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.coaching2live.model.Pessoa;
import com.coaching2live.business.pessoa.cliente.dto.ClienteTO;
import com.coaching2live.business.pessoa.dto.PessoaTO;
import com.coaching2live.model.Cliente;

@Component
public class ClienteHelper {

	/**
	 * 
	 * */
	public static ClienteTO entityToDto(Pessoa cliente) {

		ClienteTO to = new ClienteTO();
		BeanUtils.copyProperties(cliente, to);

		return to;
	}

	/**
	 * 
	 * */
	public static Cliente toToEntity(PessoaTO to) {

		Cliente c = new Cliente();
		BeanUtils.copyProperties(to, c);

		return c;
	}
}
