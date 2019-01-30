package com.coaching2live.web.controller.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coaching2live.business.diario.dto.DiarioDeBordoTO;
import com.coaching2live.business.diario.helper.DiarioDeBordoHelper;
import com.coaching2live.model.DiarioDeBordo;
import com.coaching2live.model.Sessao;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.service.DiarioDeBordoService;

@RestController
@RequestMapping("/logbook")
public class DiarioDeBordoControllerRest {
	
	@Autowired
	private DiarioDeBordoService diarioDeBordoService;
	
	@Autowired
	private DiarioDeBordoHelper diarioDeBordoHelper;

	@PostMapping(value="",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<DiarioDeBordoTO> create(
			@RequestBody DiarioDeBordoTO diario) throws Coaching2liveException {
		
		DiarioDeBordo db = diarioDeBordoHelper.toToEntity(diario);
		db = this.diarioDeBordoService.create(db);
		diario = diarioDeBordoHelper.entityToTo(db);
		
		return ResponseEntity.ok(diario);
	}
	
	@PutMapping(value="",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<DiarioDeBordoTO> update(
			@RequestBody DiarioDeBordoTO diario) throws Coaching2liveException{

		DiarioDeBordo db = diarioDeBordoHelper.toToEntity(diario);
		db = this.diarioDeBordoService.update(db);
		diario = diarioDeBordoHelper.entityToTo(db);

		return ResponseEntity.ok(diario);
	}
	
	@GetMapping(value="/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<DiarioDeBordoTO> findById(
			@PathVariable String id) throws Coaching2liveException{

		DiarioDeBordo db = this.diarioDeBordoService.findById(new DiarioDeBordo(id));
		DiarioDeBordoTO to = diarioDeBordoHelper.entityToTo(db);

		return ResponseEntity.ok(to);
	}
	
	@GetMapping(value="/session/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Collection<DiarioDeBordoTO>> findBySessao(
			@PathVariable String id) throws Coaching2liveException {

		DiarioDeBordo db = new DiarioDeBordo(new Sessao(id));
		Collection<DiarioDeBordo> dbs = this.diarioDeBordoService.findBySessao(db);
		Collection<DiarioDeBordoTO> tos = diarioDeBordoHelper.entitiesToTOs(dbs);

		return ResponseEntity.ok(tos);
	}
}
