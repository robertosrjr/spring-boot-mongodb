package com.coaching2live.business.diario;

import java.util.Collection;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coaching2live.model.DiarioDeBordo;
import com.coaching2live.model.Sessao;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.repository.DiarioDeBordoRepository;
import com.coaching2live.repository.SessaoRepository;
import com.coaching2live.service.DiarioDeBordoService;
import com.mongodb.client.model.Collation;

@Service
public class DiarioDeBordoBusiness implements DiarioDeBordoService {

	@Autowired
	private DiarioDeBordoRepository diarioDeBordoRepository;

	@Autowired
	private SessaoRepository sessaoRepository;

	@Override
	public DiarioDeBordo create(DiarioDeBordo diarioDeBordo) throws Coaching2liveException {

		Optional<Sessao> sessao = sessaoRepository.findById(diarioDeBordo.getSessao().getId());
		if (!sessao.isPresent()) {

			throw new Coaching2liveException("Sessão não encontrada.");
		}

		diarioDeBordo.setSessao(sessao.get());		
		return diarioDeBordoRepository.save(diarioDeBordo);
	}

	@Override
	public DiarioDeBordo update(DiarioDeBordo diarioDeBordo) throws Coaching2liveException {

		Optional<Sessao> sessao = sessaoRepository.findById(diarioDeBordo.getSessao().getId());
		if (!sessao.isPresent()) {

			throw new Coaching2liveException("Sessão não encontrada.");
		}
		Optional<DiarioDeBordo> diario = this.diarioDeBordoRepository.findById(diarioDeBordo.getId());
		if (!diario.isPresent()) {

			throw new Coaching2liveException("Diário não encontrado.");
		}

		diario.get().setConteudoSessao(diarioDeBordo.getConteudoSessao());
		diario.get().setSessao(sessao.get());

		return diarioDeBordoRepository.save(diario.get());
	}

	@Override
	public Collection<DiarioDeBordo> findBySessao(DiarioDeBordo diarioDeBordo) throws Coaching2liveException {

		return this.diarioDeBordoRepository.findBySessao(new ObjectId(diarioDeBordo.getSessao().getId()));
	}

	@Override
	public DiarioDeBordo findById(DiarioDeBordo diarioDeBordo) throws Coaching2liveException {

		return this.diarioDeBordoRepository.findById(diarioDeBordo.getId()).get();
	}
}
