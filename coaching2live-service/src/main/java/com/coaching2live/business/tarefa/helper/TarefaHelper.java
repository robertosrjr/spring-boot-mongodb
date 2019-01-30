package com.coaching2live.business.tarefa.helper;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.coaching2live.business.sessao.helper.SessaoHelper;
import com.coaching2live.business.tarefa.dto.TarefaTO;
import com.coaching2live.model.Tarefa;

@Component
public class TarefaHelper {
	
	/**
	 * 
	 * */
	public static TarefaTO entityToTO(Tarefa tarefa) {

		TarefaTO to = new TarefaTO();

		BeanUtils.copyProperties(tarefa, to);
		to.setSessao(SessaoHelper.entityToTO(tarefa.getSessao()));
		
		return to;
	}
	
	/**
	 * 
	 * */
	public static Collection<TarefaTO> entities(Collection<Tarefa> tarefas) {

		Collection<TarefaTO> tos = new ArrayList<TarefaTO>();
		for (Tarefa tarefa : tarefas) {

			tos.add(entityToTO(tarefa));
		}
		return tos;
	}
	
	/**
	 * 
	 * */
	public static Tarefa toToEntity(TarefaTO to) {

		Tarefa tarefa = new Tarefa();
		BeanUtils.copyProperties(to, tarefa);
		tarefa.setSessao(SessaoHelper.toToEntity(to.getSessao()));

		return tarefa;
	}
}
