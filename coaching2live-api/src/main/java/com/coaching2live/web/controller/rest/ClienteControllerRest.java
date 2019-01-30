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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coaching2live.business.pessoa.cliente.dto.ClienteTO;
import com.coaching2live.business.pessoa.cliente.helper.ClienteHelper;
import com.coaching2live.business.to.ResponseTO;
import com.coaching2live.model.Cliente;
import com.coaching2live.model.Pessoa;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.service.PessoaService;
import com.coaching2live.web.resourceAssembler.ClienteResourceAssembler;
import com.google.gson.Gson;

@RestController
@RequestMapping("/client")
public class ClienteControllerRest {
	
	private final Logger logger = LogManager.getLogger(this.getClass().getName());
	private static final Gson gson = new Gson();

	@Autowired
	private PessoaService<Pessoa> pessoaService;

	@Autowired
	private ClienteResourceAssembler assembler;
	
	@GetMapping(path="/email/{email}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Resource<ClienteTO> findByEmail(
			@PathVariable String email) throws Coaching2liveException {

		logger.info("/email/"+email);

		Pessoa cliente = new Cliente();
		cliente.setEmail(email);

		cliente = this.pessoaService.findByEmail((Cliente) cliente);

		ClienteTO clienteTo = ClienteHelper.entityToDto(cliente);		

		Resource<ClienteTO> resource = this.assembler.toResource(clienteTo);
		return resource;
	}

	@PostMapping(path="",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Resource<ClienteTO>> create(
			@RequestBody ClienteTO clienteTo) throws URISyntaxException, Coaching2liveException {

		logger.info("create:" + gson.toJson(clienteTo));
		ResponseTO<ClienteTO> response = new ResponseTO<ClienteTO>();

		Pessoa cliente = ClienteHelper.toToEntity(clienteTo);

		cliente = this.pessoaService.save(cliente);

		clienteTo = ClienteHelper.entityToDto(cliente);

		Resource<ClienteTO> resource = this.assembler.toResource(clienteTo);
		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}
	
	@PutMapping(path="",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Resource<ClienteTO>> update(
			@RequestBody ClienteTO clienteTO) throws Coaching2liveException {

		logger.info("update:" + gson.toJson(clienteTO));

		Pessoa cliente = ClienteHelper.toToEntity(clienteTO);

		cliente = this.pessoaService.update(cliente);

		clienteTO = ClienteHelper.entityToDto(cliente);

		Resource<ClienteTO> resource = this.assembler.toResource(clienteTO);
		return ResponseEntity.ok(resource);
	}
}
