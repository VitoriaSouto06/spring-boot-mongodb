package com.vitoria.workshopmongo.resources;

import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vitoria.workshopmongo.domain.Post;
import com.vitoria.workshopmongo.domain.User;
import com.vitoria.workshopmongo.dto.UserDTO;
import com.vitoria.workshopmongo.resources.util.URL;
import com.vitoria.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userService.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value= "/{id}",method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDto) {
		User user = userService.fromDTO(userDto);
		userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value= "/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value= "/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable String id,@RequestBody User user) {
		userService.update(id, user);
		return null;
	}
	
	@RequestMapping(value="/namesearch",method=RequestMethod.GET)
	public ResponseEntity<List<User>> findByName(@RequestParam(value="name",defaultValue="")String name){
		name = URL.decodeParam(name);
		List<User> list = userService.findByNameContaining(name);
		return ResponseEntity.ok().body(list);
		
	}
	
	
	
}
