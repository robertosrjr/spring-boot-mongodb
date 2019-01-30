package com.coaching2live.service;

import java.util.Collection;

import com.coaching2live.model.Anexavel;
import com.coaching2live.model.Anexo;
import com.coaching2live.model.exception.Coaching2liveException;

public interface AnexoService<T extends Anexo> {

	T create(T anexo) throws Coaching2liveException;
	T generatePresignedURL(T anexo) throws Coaching2liveException;
	Collection<T> findByAnexavel(Anexavel anexavel) throws Coaching2liveException;
	void desativar(String idAnexo) throws Coaching2liveException;
}
