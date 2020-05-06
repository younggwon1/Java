package com.dudrnjs.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //접근을 제한하겠다.
			.antMatchers("/mypage/**").authenticated() // /mypage/**는 인증을 걸겠다.
			.antMatchers("/**").permitAll() //나머지 페이지는 인증을 걸지 않겠다.
			.and()
			.formLogin()
			.and()
			.httpBasic()
		    .and()
		    .logout()
		    .logoutUrl("/app-logout")
		    .deleteCookies("JSESSIONID")
		    .logoutSuccessUrl("/");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
