package com.dudrnjs.myspringboot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dudrnjs.myspringboot.entity.Account;
import com.dudrnjs.myspringboot.repository.AccountRepository;

@Service
public class AccountService implements UserDetailsService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> findByUsername = accountRepository.findByUsername(username);
		Account account = findByUsername.orElseThrow(() -> new UsernameNotFoundException(username));
		return new User(account.getUsername(), account.getPassword(), authorities());
	}
	
	private Collection<? extends GrantedAuthority> authorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public Account createAccount(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
		//account.setPassword(password);
		account.setPassword(passwordEncoder.encode(password));
		return accountRepository.save(account);
	}
	
	// AccountService 클래스가 Bean으로 생성된 후에 바로 init() 메서드가 호출된다.
//	@PostConstruct
//	public void init() {
//		Optional<Account> findByUsername = accountRepository.findByUsername("test");
//		// 해당 user가 없으면
//		if(!findByUsername.isPresent()) {
//			Account createAccount = this.createAccount("test", "1234");
//			System.out.println(createAccount);
//		}
//	}
	
}
