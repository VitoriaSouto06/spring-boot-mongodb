package com.vitoria.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vitoria.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User,String> {

}
