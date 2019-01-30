package com.coaching2live.business.mensagem;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coaching2live.model.Mensagem;
import com.coaching2live.model.Objetivo;
import com.coaching2live.model.Pessoa;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.repository.MensagemRepository;
import com.coaching2live.repository.ObjetivoRepository;
import com.coaching2live.repository.PessoaRepository;
import com.coaching2live.service.MensagemService;

@Service
public class MensagemBusiness implements MensagemService {
	
	@Autowired private MensagemRepository mensagemRepository;
	@Autowired private ObjetivoRepository objetivoRepository;
	@Autowired private PessoaRepository<Pessoa> pessoaRepository;

	@Override
	public Mensagem create(Mensagem mensagem) throws Coaching2liveException {

		Optional<Objetivo> obj = this.objetivoRepository.findById(mensagem.getObjetivo().getId());
		if (!obj.isPresent()) {

			throw new Coaching2liveException("Objetico não encontrado.");
		}

		Optional<Pessoa> prof = this.pessoaRepository.findById(mensagem.getCriador().getId());
		if (!prof.isPresent()) {

			throw new Coaching2liveException("Profissional não encontrado.");
		}

		mensagem.setCriador(prof.get());
		mensagem.setObjetivo(obj.get());		
		return this.mensagemRepository.save(mensagem);
	}

	@Override
	public Mensagem setAsRead(Mensagem mensagem) throws Coaching2liveException {

		Optional<Mensagem> m = this.mensagemRepository.findById(mensagem.getId());
		m.get().setLida(true);
		m.get().setDataLeitura(new Date());
		return this.mensagemRepository.save(m.get());
	}

	@Override
	public Mensagem findByid(Mensagem mensagem) throws Coaching2liveException {

		return this.mensagemRepository.findById(mensagem.getId()).get();
	}

	@Override
	public Collection<Mensagem> findByObjetivo(Objetivo objetivo) throws Coaching2liveException {

		return this.mensagemRepository.findByObjetivo(new ObjectId(objetivo.getId()));
	}
}
