package com.coaching2live.repository;

import org.springframework.stereotype.Repository;

import com.coaching2live.model.Cliente;

@Repository
public interface ClienteRepository extends PessoaRepository<Cliente> {

	Cliente findByEmail(String email);
	Cliente findByEmailAndDeleteFalse(String email);
}
