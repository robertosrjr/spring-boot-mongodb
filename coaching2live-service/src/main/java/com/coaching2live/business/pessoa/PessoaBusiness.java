package com.coaching2live.business.pessoa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coaching2live.model.Pessoa;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.model.exception.ExceptionTypeEnum;
import com.coaching2live.repository.PessoaRepository;
import com.coaching2live.service.PessoaService;

@Service
public class PessoaBusiness<T extends Pessoa> implements PessoaService<T> {

	private final Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	private PessoaRepository<T> pessoaRepository;

	@Override
	public T save(T pessoa) throws Coaching2liveException {

		logger.info("save: " + pessoa.toString());
		T pessoaBase = this.pessoaRepository.findByEmail(pessoa.getEmail());
		if (null != pessoaBase) {

			throw new Coaching2liveException(ExceptionTypeEnum.ALERT_WARNING, "O E-mail " + pessoa.getEmail() + " já está cadastrado."); 
		}

		return this.pessoaRepository.save(pessoa);
	}

	@Override
	public T findByEmail(T pessoa) throws Coaching2liveException {

		logger.info("findByEmail: " + pessoa.getEmail());
		pessoa = this.pessoaRepository.findByEmail(pessoa.getEmail());
		if (null == pessoa) {

			throw new Coaching2liveException(ExceptionTypeEnum.ALERT_WARNING, "Email não encontrado.");
		}

		return pessoa;
	}

	@Override
	public T update(T pessoa) throws Coaching2liveException {

		T pessoaBase = null;
		logger.info("update: " + pessoa.getEmail());
		pessoaBase = this.pessoaRepository.findByEmail(pessoa.getEmail());

		if (null == pessoaBase) {

			throw new Coaching2liveException(ExceptionTypeEnum.ALERT_WARNING, pessoa.getClass().getName() + " não cadastrado.");
		}

		pessoaBase.setNome(pessoa.getNome());
		pessoaBase.setSobrenome(pessoa.getSobrenome());
		pessoaBase.setIdSocialUsuario(pessoa.getIdSocialUsuario());
		pessoaBase.setEmail(pessoa.getEmail());
		pessoaBase.setDataNascimento(pessoa.getDataNascimento());
		pessoaBase.setCpf(pessoa.getCpf());
		pessoaBase.setDdi(pessoa.getDdi());
		pessoaBase.setDdd(pessoa.getDdd());
		pessoaBase.setNumeroTelefone(pessoa.getNumeroTelefone());
		pessoaBase.setHobbies(pessoa.getHobbies());
		pessoaBase.setProfissao(pessoa.getProfissao());
		pessoaBase.setBiografia(pessoa.getBiografia());

		pessoaBase = pessoaRepository.save((T) pessoaBase);

		return (T) pessoaBase;
	}	
}
