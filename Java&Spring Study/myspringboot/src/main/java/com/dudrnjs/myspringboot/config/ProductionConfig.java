package com.dudrnjs.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ProductionConfig {

	@Bean
	public String hello() {
		return "운영환경입니다.";
	}
}
