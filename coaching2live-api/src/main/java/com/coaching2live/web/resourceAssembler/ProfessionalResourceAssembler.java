package com.coaching2live.web.resourceAssembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URISyntaxException;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.coaching2live.business.pessoa.profissional.dto.ProfissionalTO;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.web.controller.rest.ProfessionalControllerRest;

@Component
public class ProfessionalResourceAssembler implements ResourceAssembler<ProfissionalTO, Resource<ProfissionalTO>> {

	@Override
	public Resource<ProfissionalTO> toResource(ProfissionalTO profissional) {

		try {

			return new Resource<ProfissionalTO>(profissional,
					linkTo(methodOn(ProfessionalControllerRest.class).create(profissional)).withSelfRel().withType(MediaType.APPLICATION_JSON_VALUE),
					linkTo(methodOn(ProfessionalControllerRest.class).update(profissional)).withSelfRel().withType(MediaType.APPLICATION_JSON_VALUE),
					linkTo(methodOn(ProfessionalControllerRest.class).findByEmail(profissional.getEmail())).withRel("email")
					);
		} catch (Coaching2liveException | URISyntaxException e) {

			return null;
		}
	}
}
