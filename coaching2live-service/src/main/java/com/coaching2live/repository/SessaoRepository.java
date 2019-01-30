package com.coaching2live.repository;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.coaching2live.model.Sessao;

public interface SessaoRepository extends MongoRepository<Sessao, String> {

	@Query("{'objetivo._id' : ?0 }")
	Collection<Sessao> findByObjetivo(ObjectId objetivo);
	
}
