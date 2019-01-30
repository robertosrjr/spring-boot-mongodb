package com.coaching2live.web.resourceAssembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URISyntaxException;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.coaching2live.business.pessoa.cliente.dto.ClienteTO;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.web.controller.rest.ClienteControllerRest;

@Component
public class ClienteResourceAssembler implements ResourceAssembler<ClienteTO, Resource<ClienteTO>> {

	@Override
	public Resource<ClienteTO> toResource(ClienteTO cliente) {

		try {

			return new Resource<ClienteTO>(cliente,

					linkTo(methodOn(ClienteControllerRest.class).create(cliente)).withSelfRel().withType(MediaType.APPLICATION_JSON_VALUE),
					linkTo(methodOn(ClienteControllerRest.class).update(cliente)).withSelfRel().withType(MediaType.APPLICATION_JSON_VALUE),
					linkTo(methodOn(ClienteControllerRest.class).findByEmail(cliente.getEmail())).withSelfRel()
					);
		} catch (Coaching2liveException | URISyntaxException e) {

			return null;
		}
	}
}
