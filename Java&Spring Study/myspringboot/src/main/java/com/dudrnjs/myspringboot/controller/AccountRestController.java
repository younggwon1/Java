package com.dudrnjs.myspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dudrnjs.myspringboot.entity.Account;
import com.dudrnjs.myspringboot.exception.ResourceNotFoundException;
import com.dudrnjs.myspringboot.repository.AccountRepository;

@RestController
public class AccountRestController {
	@Autowired
	private AccountRepository repository1;
	
	@PostMapping("/userss")
	public Account create(@RequestBody Account account) {
		return repository1.save(account);
	}
	
	//전체 조회
	@GetMapping("/userss")
	public List<Account> getUsers(){
		return repository1.findAll();
	}
	
	//상세 조회
	@GetMapping("/userss/{id}")
	public Account getUser(@PathVariable Long id) {
		Optional<Account> accountOpt = repository1.findById(id);
		Account account = accountOpt.orElseThrow(() -> new ResourceNotFoundException("Account", "id", id));
		return account;
	}
	
	//수정하기
	@PutMapping("/userss/{id}")
	public Account updateUser(@PathVariable Long id, @RequestBody Account accountDetail) {
		Account account = repository1.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account", "id", id));
		account.setUsername(account.getUsername());
		account.setPassword(account.getPassword());
		account.setEmail(account.getEmail());
		
		Account updateAccount = repository1.save(account);
		return updateAccount;
		
		
	}
	
	//삭제하기
	@DeleteMapping("/userss/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		Account account = repository1.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		repository1.delete(account);
		return new ResponseEntity<String>(account.getId() + "delete", HttpStatus.OK);
	}
}
