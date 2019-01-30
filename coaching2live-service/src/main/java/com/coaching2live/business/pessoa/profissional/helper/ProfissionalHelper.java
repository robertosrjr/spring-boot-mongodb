package com.coaching2live.business.pessoa.profissional.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.coaching2live.business.pessoa.dto.PessoaTO;
import com.coaching2live.business.pessoa.profissional.dto.ProfissionalTO;
import com.coaching2live.model.Pessoa;
import com.coaching2live.model.Profissional;

@Component
public class ProfissionalHelper {

	/**
	 * 
	 * */
	public static ProfissionalTO entityToTo(Pessoa profissional) {

		ProfissionalTO to = new ProfissionalTO();
		BeanUtils.copyProperties(profissional, to);

		return to;
	}
	
	/**
	 * 
	 * */
	public static Profissional toToEntity(PessoaTO to) {

		Profissional p = new Profissional();
		BeanUtils.copyProperties(to, p);

		return p;
	}
}
