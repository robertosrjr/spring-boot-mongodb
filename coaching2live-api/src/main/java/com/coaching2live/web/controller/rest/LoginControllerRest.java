package com.coaching2live.web.controller.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coaching2live.business.login.dto.LoginTO;
import com.coaching2live.model.Cliente;
import com.coaching2live.model.Login;
import com.coaching2live.model.Profissional;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.service.LoginService;
import com.coaching2live.web.resourceAssembler.LoginResourceAssembler;
import com.google.gson.Gson;

@RestController
@RequestMapping("/login")
public class LoginControllerRest {

	private final Logger logger = LogManager.getLogger(this.getClass().getName());
	private static final Gson gson = new Gson();

	@Autowired
	private LoginService loginService;

	@Autowired
	private LoginResourceAssembler assembler;
	
	@GetMapping(value="/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Resource<LoginTO> findById(
			@PathVariable String id) throws Coaching2liveException{

		logger.info("/"+id);
		throw new Coaching2liveException("Método não implementado.");
	}
	
	@GetMapping(value="/email/{email}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Resource<LoginTO> findByEmail(
			@PathVariable("email") String email) throws Coaching2liveException{

		logger.info("/"+email);
		throw new Coaching2liveException("Método não implementado.");
	}
	
	
	@PostMapping(value="/professional",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Resource<LoginTO>> createProfessional(
			@RequestBody LoginTO loginTO) throws Coaching2liveException, URISyntaxException {

		logger.info("create:" + gson.toJson(loginTO));

		Login login = new Login(new Profissional()); 
		BeanUtils.copyProperties(loginTO.getPessoa(), login.getPessoa());
		BeanUtils.copyProperties(loginTO, login);

		login = this.loginService.registrarLogin(login);

		BeanUtils.copyProperties(login.getPessoa(), loginTO.getPessoa());
		BeanUtils.copyProperties(login, loginTO);
	
		Resource<LoginTO> resource = this.assembler.toResource(loginTO);
		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}
	
	@PostMapping(value="/client",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Resource<LoginTO>> createClient(
			@RequestBody LoginTO loginTO) throws Coaching2liveException, URISyntaxException {

		logger.info("create:" + gson.toJson(loginTO));

		Login login = new Login(new Cliente()); 
		BeanUtils.copyProperties(loginTO.getPessoa(), login.getPessoa());
		BeanUtils.copyProperties(loginTO, login);

		login = this.loginService.registrarLogin(login);

		BeanUtils.copyProperties(login.getPessoa(), loginTO.getPessoa());
		BeanUtils.copyProperties(login, loginTO);
	
		Resource<LoginTO> resource = this.assembler.toResource(loginTO);
		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}	
}
