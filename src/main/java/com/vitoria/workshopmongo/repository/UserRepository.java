package com.vitoria.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vitoria.workshopmongo.domain.Post;
import com.vitoria.workshopmongo.domain.User;
import com.vitoria.workshopmongo.dto.UserDTO;

public interface UserRepository extends MongoRepository<User,String> {
	@Query("{ 'name': { $regex: ?0, $options: 'i' } }")
	List<User> findByName(String name);
}
