package com.coaching2live.service;

import java.util.Collection;

import com.coaching2live.model.Sessao;
import com.coaching2live.model.Tarefa;
import com.coaching2live.model.exception.Coaching2liveException;

public interface TarefaService {

	Tarefa create (Tarefa tarefa) throws Coaching2liveException;
	Tarefa update (Tarefa tarefa) throws Coaching2liveException;
	Tarefa endTask (Tarefa tarefa) throws Coaching2liveException;
	Collection<Tarefa> findBySessao (Sessao sessao) throws Coaching2liveException;
}