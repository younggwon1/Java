package com.dudrnjs.myspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.entity.Users;
import com.dudrnjs.myspringboot.exception.ResourceNotFoundException;
import com.dudrnjs.myspringboot.repository.UserRepository;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserRestController {
	@Autowired
	private UserRepository repository;
	
	@GetMapping(value = "/users", produces = {"application/json"})
	public User create(@RequestBody User user) {
		return repository.save(user);
	}
	
	//전체 조회
	@GetMapping("/users")
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	//상세 조회
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		Optional<User> userOpt = repository.findById(id);
		User user = userOpt.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return user;
	}
	
	//수정하기
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		user.setName(userDetail.getName());
		user.setEmail(userDetail.getEmail());
		
		User updateUser = repository.save(user);
		return updateUser;
		
		
	}
	
	//삭제하기
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		repository.delete(user);
		return new ResponseEntity<String>(user.getId() + "delete", HttpStatus.OK);
	}
	
//	//xml
//	@GetMapping(value = "/usersxml", produces = {"application/xml"})
//	public List<User> getUsersXml() {
//		return repository.findAll();
//	}
	
	//xml
	@GetMapping(value = "/usersxml", produces = {"application/xml"})
	public Users getUsersXml() {
		Users users = new Users();
		users.setUsers(repository.findAll());
		return users;
	}
}


