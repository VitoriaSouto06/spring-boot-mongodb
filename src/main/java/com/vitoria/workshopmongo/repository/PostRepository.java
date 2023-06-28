package com.vitoria.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vitoria.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post,String>{

}
