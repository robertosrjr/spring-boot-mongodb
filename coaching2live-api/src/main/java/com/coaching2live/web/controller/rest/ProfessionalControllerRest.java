package com.coaching2live.web.controller.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.coaching2live.business.pessoa.profissional.dto.ProfissionalTO;
import com.coaching2live.business.pessoa.profissional.helper.ProfissionalHelper;
import com.coaching2live.model.Profissional;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.service.ProfissionalService;
import com.coaching2live.web.resourceAssembler.ProfessionalResourceAssembler;
import com.google.gson.Gson;

@RestController
@RequestMapping("/professional")
public class ProfessionalControllerRest {

	private final Logger logger = LogManager.getLogger(this.getClass().getName());
	private static final Gson gson = new Gson();

	@Autowired private ProfissionalService profissionalService;
	@Autowired private ProfessionalResourceAssembler assembler;

	@GetMapping(value="/email/{email}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ProfissionalTO> findByEmail(
			@PathVariable("email") String email) throws Coaching2liveException {

		logger.info("/email"+email);

		Profissional profissional = new Profissional();
		profissional.setEmail(email);

		profissional = this.profissionalService.findByEmail((Profissional) profissional);
		ProfissionalTO profissionalTO = ProfissionalHelper.entityToTo(profissional);

		return ResponseEntity.ok(profissionalTO);
	}

	@PostMapping(value="",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Resource<ProfissionalTO>> create(
			@RequestBody ProfissionalTO profissionalTO) throws Coaching2liveException, URISyntaxException {

		logger.info("save:" + gson.toJson(profissionalTO));

		Profissional profissional = ProfissionalHelper.toToEntity(profissionalTO);

		profissional = this.profissionalService.save(profissional);

		profissionalTO = ProfissionalHelper.entityToTo(profissional);

		Resource<ProfissionalTO> resource = this.assembler.toResource(profissionalTO);
		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}

	@PutMapping(value="",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Resource<ProfissionalTO>> update(
			@RequestBody ProfissionalTO profissionalTO) throws Coaching2liveException {

		logger.info("update:" + gson.toJson(profissionalTO));

		Profissional profissional = ProfissionalHelper.toToEntity(profissionalTO);	

		profissional = this.profissionalService.update(profissional);

		profissionalTO = ProfissionalHelper.entityToTo(profissional);

		Resource<ProfissionalTO> resource = this.assembler.toResource(profissionalTO);
		return ResponseEntity.ok(resource);
	}
	
	@PatchMapping(value="/bind-clients",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ProfissionalTO> bindClients(
			@RequestBody ProfissionalTO profissionalTO) throws Coaching2liveException {

		logger.info("bindClients:" + gson.toJson(profissionalTO));

		profissionalTO = this.profissionalService.bindClients(profissionalTO);
		return ResponseEntity.ok(profissionalTO);
	}
}
