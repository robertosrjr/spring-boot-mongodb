package com.coaching2live.business.tarefa;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coaching2live.model.Sessao;
import com.coaching2live.model.Tarefa;
import com.coaching2live.model.enums.StatusTarefaEnum;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.repository.SessaoRepository;
import com.coaching2live.repository.TarefaRepository;
import com.coaching2live.service.TarefaService;

@Service
public class TarefaBusiness implements TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	private SessaoRepository sessaoRepository;

	@Override
	public Tarefa create(Tarefa tarefa) throws Coaching2liveException {

		Optional<Sessao> sessao = this.sessaoRepository.findById(tarefa.getSessao().getId());
		if (!sessao.isPresent()) {

			throw new Coaching2liveException("Sessão não encontrada.");
		}

		tarefa.setSessao(sessao.get());
		return this.tarefaRepository.save(tarefa);
	}

	@Override
	public Tarefa update(Tarefa tarefa) throws Coaching2liveException {
		
		Optional<Sessao> sessao = this.sessaoRepository.findById(tarefa.getSessao().getId());
		if (!sessao.isPresent()) {

			throw new Coaching2liveException("Sessão não encontrada.");
		}

		Optional<Tarefa> t = this.tarefaRepository.findById(tarefa.getId());
		if (!t.isPresent()) {

			throw new Coaching2liveException("Tarefa não encontrada.");
		}

		t.get().setSessao(tarefa.getSessao());
		t.get().setDataAlvo(tarefa.getDataAlvo());
		t.get().setDataEfetiva(tarefa.getDataEfetiva());
		t.get().setComentario(tarefa.getComentario());
		t.get().setStatus(tarefa.getStatus());
		t.get().setDescricao(tarefa.getDescricao());
		t.get().setFormaEntrega(tarefa.getFormaEntrega());
		t.get().setSessao(sessao.get());

		return this.tarefaRepository.save(t.get());
	}

	@Override
	public Tarefa endTask(Tarefa tarefa) throws Coaching2liveException {

		Optional<Tarefa> t = this.tarefaRepository.findById(tarefa.getId());
		if (!t.isPresent()) {

			throw new Coaching2liveException("Tarefa não encontrada.");
		}

		t.get().setComentario(t.get().getComentario().concat(".\n - ").concat(tarefa.getComentario()));
		t.get().setStatus(StatusTarefaEnum.CONCLUIDO);
		t.get().setDataEfetiva(new Date());

		return this.tarefaRepository.save(t.get());
	}

	@Override
	public Collection<Tarefa> findBySessao(Sessao sessao) throws Coaching2liveException {

		return this.tarefaRepository.findBySessao(new ObjectId(sessao.getId()));
	}
}
