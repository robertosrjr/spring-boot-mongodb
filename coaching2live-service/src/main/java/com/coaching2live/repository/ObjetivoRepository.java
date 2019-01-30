package com.coaching2live.repository;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.coaching2live.model.Objetivo;

@Repository
public interface ObjetivoRepository extends MongoRepository<Objetivo, String> {

	@Query("{'profissional.$id' : ?0 }")
	Collection<Objetivo>findByProfissionalId(ObjectId idProfissional);

	@Query("{'cliente.$id' : ?0 }")
	Collection<Objetivo>findByClienteId(ObjectId idCliente);
}
