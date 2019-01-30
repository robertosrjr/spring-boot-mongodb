package com.coaching2live.web.controller.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coaching2live.business.sessao.dto.SessaoTO;
import com.coaching2live.business.sessao.helper.SessaoHelper;
import com.coaching2live.model.Objetivo;
import com.coaching2live.model.Sessao;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.service.SessaoService;

@RestController
@RequestMapping("/session")
public class SessaoControllerRest {

	@Autowired
	private SessaoService sessaoService;

	@PostMapping(path = "",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<SessaoTO> create(
			@RequestBody SessaoTO sessaoTO) throws Coaching2liveException{

		Sessao sessao = SessaoHelper.toToEntity(sessaoTO);
		sessao = this.sessaoService.create(sessao);
		sessaoTO = SessaoHelper.entityToTO(sessao);

		return ResponseEntity.ok(sessaoTO);
	}

	@PutMapping(path = "",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<SessaoTO> update(
			@RequestBody SessaoTO sessaoTO) throws Coaching2liveException{
		
		Sessao sessao = SessaoHelper.toToEntity(sessaoTO);
		sessao = this.sessaoService.update(sessao);
		sessaoTO = SessaoHelper.entityToTO(sessao);

		return ResponseEntity.ok(sessaoTO);
	}
	
	@GetMapping(path = "/objective/{idObjetivo}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Collection<SessaoTO>> findByObjetivo(
			@PathVariable String idObjetivo) throws Coaching2liveException{


		Collection<Sessao> sessoes = this.sessaoService.findByObjetivo(new Objetivo(idObjetivo));
		Collection<SessaoTO> tos = SessaoHelper.entitiesToTOs(sessoes);

		return ResponseEntity.ok(tos);
	}
	
	@GetMapping(path = "/{idSession}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<SessaoTO> findById(
			@PathVariable String idSession) throws Coaching2liveException{
		
		Sessao sessao = new Sessao(idSession);
		sessao = this.sessaoService.findById(sessao);
		SessaoTO sessaoTO = SessaoHelper.entityToTO(sessao);

		return ResponseEntity.ok(sessaoTO);
	}
	
	@PatchMapping(path = "/{idSession}/notifyEmail",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Resource<SessaoTO>> notifyEmail(
			@PathVariable String idSession) throws Coaching2liveException{
		
		return null;
	}
	
	@PatchMapping(path = "",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Resource<SessaoTO>> reagenderSession(
			@RequestBody SessaoTO sessaoTO) throws Coaching2liveException{
		
		return null;
	}
}
