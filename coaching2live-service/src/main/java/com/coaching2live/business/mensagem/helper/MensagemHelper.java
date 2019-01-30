package com.coaching2live.business.mensagem.helper;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.BeanUtils;

import com.coaching2live.business.mensagem.dto.MensagemTO;
import com.coaching2live.business.objetivo.helper.ObjetivoHelper;
import com.coaching2live.business.pessoa.profissional.helper.ProfissionalHelper;
import com.coaching2live.model.Mensagem;

public class MensagemHelper {
	
	/**
	 * 
	 * */
	public static Mensagem toToEntity(MensagemTO to) {

		Mensagem m = new Mensagem();

		BeanUtils.copyProperties(to, m);
		m.setObjetivo(ObjetivoHelper.toToEntity(to.getObjetivo()));
		m.setCriador(ProfissionalHelper.toToEntity(to.getCriador()));

		return m;
	}
	
	
	/**
	 * 
	 * */
	public static MensagemTO entityToTo(Mensagem entity) {

		MensagemTO to = new MensagemTO();

		BeanUtils.copyProperties(entity, to);
		to.setObjetivo(ObjetivoHelper.entityToTO(entity.getObjetivo()));
		to.setCriador(ProfissionalHelper.entityToTo(entity.getCriador()));

		return to;
	}
	
	/**
	 * 
	 * */
	public static Collection<MensagemTO> entitiesToTos(Collection<Mensagem> entities) {

		Collection<MensagemTO> tos = new  ArrayList<MensagemTO>();
		for (Mensagem m : entities) {

			tos.add(entityToTo(m));
		}

		return tos;
	}	
}
