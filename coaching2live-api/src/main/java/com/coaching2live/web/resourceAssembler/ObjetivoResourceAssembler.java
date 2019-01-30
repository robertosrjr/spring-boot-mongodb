package com.coaching2live.web.resourceAssembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URISyntaxException;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.coaching2live.business.objetivo.dto.ObjetivoTO;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.web.controller.rest.ObjetivoControllerRest;

@Component
public class ObjetivoResourceAssembler<T> implements ResourceAssembler<T, Resource<T>> {

	@Override
	public Resource<T> toResource(T objetivo) {

		try {

			return new Resource<T>(objetivo,
					linkTo(methodOn(ObjetivoControllerRest.class).create((ObjetivoTO) objetivo)).withSelfRel().withType(MediaType.APPLICATION_JSON_VALUE)
					);
		} catch (Coaching2liveException | URISyntaxException e) {

			return null;
		}
	}
}
