package com.vitoria.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vitoria.workshopmongo.domain.User;
import com.vitoria.workshopmongo.dto.UserDTO;
import com.vitoria.workshopmongo.repository.UserRepository;
import com.vitoria.workshopmongo.services.exception.ObjectNotFoundException;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User>findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encotrado na base de dados"));
		
	}
	
	
	public void insert(User user) {
		userRepository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(String id,User user) {
		User userUpdate = findById(id);
		userUpdate.setEmail(user.getEmail());
		userUpdate.setName(user.getName());
		userRepository.save(userUpdate);
		return userUpdate;
		
	}
	
	public User fromDTO(UserDTO userdto) {
		return new User(userdto.getId(),userdto.getName(),userdto.getEmail());
	}
	
}
