package com.coaching2live.repository;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.coaching2live.model.Imagem;

public interface ImagemRepository extends MongoRepository<Imagem, String> {
	
	@Query("{ $and : [ { 'pessoa._id' : ?0 } ] }")
	Collection<Imagem> findImageByPessoa(ObjectId idPessoa);
}
