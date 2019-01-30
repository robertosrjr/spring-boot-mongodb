package com.coaching2live.web.resourceAssembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URISyntaxException;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.coaching2live.business.login.dto.LoginTO;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.web.controller.rest.LoginControllerRest;

@Component
public class LoginResourceAssembler implements ResourceAssembler<LoginTO, Resource<LoginTO>> {

	@Override
	public Resource<LoginTO> toResource(LoginTO login) {

		try {

			return new Resource<LoginTO>(login,
					linkTo(methodOn(LoginControllerRest.class).findById(login.getId())).withSelfRel().withType(HttpMethod.GET.toString()),
					linkTo(methodOn(LoginControllerRest.class).findByEmail(login.getPessoa().getEmail())).withSelfRel().withType(HttpMethod.GET.toString()),
					linkTo(methodOn(LoginControllerRest.class).createClient(login)).withSelfRel().withType(MediaType.APPLICATION_JSON_VALUE),
					linkTo(methodOn(LoginControllerRest.class).createProfessional(login)).withSelfRel().withType(MediaType.APPLICATION_JSON_VALUE)
					);
		} catch (Coaching2liveException | URISyntaxException e) {

			return null;
		}
	}
}
