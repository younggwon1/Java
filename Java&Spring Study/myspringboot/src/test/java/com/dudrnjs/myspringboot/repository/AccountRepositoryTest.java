package com.dudrnjs.myspringboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dudrnjs.myspringboot.entity.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
	@Autowired
	AccountRepository repository;
	
	@Test
	public void findByUsername() throws Exception {
//		Account existAcct = repository.findByUsername("spring");
//		assertThat(existAcct).isNotNull();
//		
//		Account notExistAcct = repository.findByUsername("test");
//		assertThat(notExistAcct).isNull();
		
		//username이 있는 경우
		Optional<Account> existOpt = repository.findByUsername("spring");
		System.out.println(existOpt.isPresent()); //true
		if(existOpt.isPresent()) {
			Account existAcct = existOpt.get();
			System.out.println(existAcct);
		}
		
		Account account = existOpt.orElseThrow(() -> new RuntimeException("존재하지 않는 username입니다."));
		System.out.println("존재하는 Account : " + account);
		
		
		//username이 없는 경우
		Optional<Account> notexistOpt = repository.findByUsername("test");
		System.out.println(notexistOpt.isPresent()); //false
		
		//false일 때는 get을 사용하면 안된다. -> NoSuchElementException이 발생한다.
		//Account notexistAcct = notexistOpt.get();
		//System.out.println(notexistAcct);
		
		//orElseThrow()의 아규먼트 타입은 함수형 인터페이스 Supplier이다. 그래서 람다식으로 표현
		//Supplier의 추상메서드 - T get()
		Account notexistAcct = notexistOpt.orElseThrow(() -> new RuntimeException("존재하지 않는 username입니다."));
		System.out.println(notexistAcct);

	}
	
	@Test @Ignore
	public void account() throws Exception {
		//System.out.println(repository.getClass().getName());
		Account account = new Account();
		account.setUsername("spring");
		account.setPassword("1234");
		
		Account saveAcct = repository.save(account);
		System.out.println(saveAcct);
		assertThat(saveAcct).isNotNull();
		
	}
}
