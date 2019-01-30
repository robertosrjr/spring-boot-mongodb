package com.coaching2live.service;

import com.coaching2live.model.Pessoa;
import com.coaching2live.model.exception.Coaching2liveException;

public interface PessoaService<T extends Pessoa> {

	T save(T pessoa) throws Coaching2liveException;
	T update(T pessoa) throws Coaching2liveException;
	T findByEmail(T pessoa) throws Coaching2liveException;
}
