package com.coaching2live.business.diario.helper;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.coaching2live.business.diario.dto.DiarioDeBordoTO;
import com.coaching2live.business.sessao.helper.SessaoHelper;
import com.coaching2live.model.DiarioDeBordo;

@Component
public class DiarioDeBordoHelper {
	
	/**
	 * 
	 * */
	public DiarioDeBordo toToEntity(DiarioDeBordoTO to) {

		DiarioDeBordo db = new DiarioDeBordo();

		BeanUtils.copyProperties(to, db);
		db.setSessao(SessaoHelper.toToEntity(to.getSessao()));
		
		return db;
	}

	/**
	 * 
	 * */
	public DiarioDeBordoTO entityToTo(DiarioDeBordo db) {

		DiarioDeBordoTO to = new DiarioDeBordoTO();

		BeanUtils.copyProperties(db, to);
		to.setSessao(SessaoHelper.entityToTO(db.getSessao()));

		return to;
	}
	
	/**
	 * 
	 * */
	public Collection<DiarioDeBordoTO> entitiesToTOs(Collection<DiarioDeBordo> entities) {

		Collection<DiarioDeBordoTO> tos = new ArrayList<DiarioDeBordoTO>();
		for (DiarioDeBordo ent : entities) {

			tos.add(entityToTo(ent));
		}

		return tos;
	}
}
