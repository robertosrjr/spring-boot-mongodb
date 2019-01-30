package com.coaching2live.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.coaching2live.model.Login;

@Repository
public interface LoginRepository extends MongoRepository<Login, String> {

}
