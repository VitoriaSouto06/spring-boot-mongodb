package com.vitoria.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vitoria.workshopmongo.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment,String>{

}
