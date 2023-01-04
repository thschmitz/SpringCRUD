package com.thschmitz.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thschmitz.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{ // O dominio e o tipo do ID
	
}
