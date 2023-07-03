package com.vitoria.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.vitoria.workshopmongo.domain.Post;
import com.vitoria.workshopmongo.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepository;

	public List<Post> findAll(){
		List<Post> list = postRepository.findAll();
		return list;
	}
	
	public Optional<Post> findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post;
	}
	
	public List<Post> findByTitleContaining(String title) {
		List<Post> post = postRepository.findByTitleContainingIgnoreCase(title);
		return post;
	}

	
	
}
