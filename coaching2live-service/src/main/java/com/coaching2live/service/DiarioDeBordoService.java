package com.coaching2live.service;

import java.util.Collection;

import com.coaching2live.model.DiarioDeBordo;
import com.coaching2live.model.exception.Coaching2liveException;

public interface DiarioDeBordoService {

	DiarioDeBordo create(DiarioDeBordo diarioDeBordo) throws Coaching2liveException;
	DiarioDeBordo update(DiarioDeBordo diarioDeBordo) throws Coaching2liveException;
	Collection<DiarioDeBordo> findBySessao(DiarioDeBordo diarioDeBordo) throws Coaching2liveException;
	DiarioDeBordo findById(DiarioDeBordo diarioDeBordo) throws Coaching2liveException;
}
