package com.coaching2live.service;

import java.util.Collection;

import com.coaching2live.model.Objetivo;
import com.coaching2live.model.exception.Coaching2liveException;

public interface ObjetivoService {

	Objetivo save(Objetivo objetivo) throws Coaching2liveException;
	Objetivo updateStatus(Objetivo objetivo) throws Coaching2liveException;
	Collection<Objetivo> findByEmailProfessional(Objetivo objetivo) throws Coaching2liveException;
	Collection<Objetivo> findByEmailCliente(Objetivo objetivo) throws Coaching2liveException;
}
