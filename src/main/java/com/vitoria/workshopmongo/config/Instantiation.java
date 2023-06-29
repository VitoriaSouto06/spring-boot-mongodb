package com.vitoria.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vitoria.workshopmongo.domain.Comment;
import com.vitoria.workshopmongo.domain.Post;
import com.vitoria.workshopmongo.domain.User;
import com.vitoria.workshopmongo.dto.AuthorDTO;
import com.vitoria.workshopmongo.repository.CommentRepository;
import com.vitoria.workshopmongo.repository.PostRepository;
import com.vitoria.workshopmongo.repository.UserRepository;
@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Comment c1 = new Comment(null,"Boa viagem mano!",sdf.parse("21/03/2028"),new AuthorDTO(alex));
		Comment c2 = new Comment(null,"Aproveite!",sdf.parse("22/03/2028"),new AuthorDTO(bob));
		Comment c3 = new Comment(null,"Tenha um ótimo dia!",sdf.parse("23/03/2028"),new AuthorDTO(alex));
		
		commentRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		Post p1 = new Post(null,sdf.parse("21/03/2028") , "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria),Arrays.asList(c1,c2));
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!",new AuthorDTO(maria),Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(p1,p2));
		
		
		maria.getPosts().addAll(Arrays.asList(p1,p2));
		userRepository.save(maria);
		
		
		
	
	}

}
