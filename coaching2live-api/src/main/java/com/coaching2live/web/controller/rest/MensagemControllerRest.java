package com.coaching2live.web.controller.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coaching2live.business.mensagem.dto.MensagemTO;
import com.coaching2live.business.mensagem.helper.MensagemHelper;
import com.coaching2live.model.Mensagem;
import com.coaching2live.model.Objetivo;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.service.MensagemService;

@RestController
@RequestMapping("/message")
public class MensagemControllerRest {
	
	@Autowired
	private MensagemService mensagemService;
	
	@PostMapping(value="",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<MensagemTO> create(
			@RequestBody MensagemTO mensagem) throws Coaching2liveException{
		
		Mensagem msn = MensagemHelper.toToEntity(mensagem);
		msn = this.mensagemService.create(msn);
		MensagemTO to = MensagemHelper.entityToTo(msn);
		
		return ResponseEntity.ok(to);
	}
	
	@PatchMapping(value="/set-as-read/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<MensagemTO> setAsRead(
			@PathVariable String id) throws Coaching2liveException{
		
		Mensagem msn = this.mensagemService.setAsRead(new Mensagem(id));
		MensagemTO to = MensagemHelper.entityToTo(msn);
		
		return ResponseEntity.ok(to);
	}
	
	@GetMapping(value="/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<MensagemTO> findById(
			@PathVariable String id) throws Coaching2liveException {

		Mensagem m = this.mensagemService.findByid(new Mensagem(id));
		MensagemTO to = MensagemHelper.entityToTo(m);

		return ResponseEntity.ok(to);
	}
	
	@GetMapping(value="/objective/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Collection<MensagemTO>> findByObjetivo(
			@PathVariable String id) throws Coaching2liveException {

		Collection<Mensagem> ms = this.mensagemService.findByObjetivo(new Objetivo(id));
		Collection<MensagemTO> tos = MensagemHelper.entitiesToTos(ms);

		return ResponseEntity.ok(tos);
	}
}
