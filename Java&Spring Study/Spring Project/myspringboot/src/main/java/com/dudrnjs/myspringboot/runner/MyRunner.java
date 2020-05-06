package com.dudrnjs.myspringboot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dudrnjs.myspringboot.property.dudrnjsProperties;

@Component
@Order(1) //Runner 클래스 중에서 실행 우선 순위가 가장 먼저임.
public class MyRunner implements ApplicationRunner{
	
	@Value("${dudrnjs.name}")
	private String name;
	
	@Value("${dudrnjs.age}")
	private int age;
	
	@Autowired
	dudrnjsProperties properties;
	
	@Autowired
	String hello;
	
	private Logger logger = LoggerFactory.getLogger(MyRunner.class);
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		logger.debug("hello bean : " + hello);

		logger.debug(">> Property Name " + name);
		logger.debug(">> Property Age " + age);
		logger.debug(">> Property Name  " + properties.getName());
		logger.debug(">> Property Age " + properties.getAge());
		logger.debug(">> Property fullName " + properties.getFullName());
				
		
		logger.info("SourceArgs : " + args.getOptionNames());
		logger.info("Program Arguments : " + args.containsOption("bar"));
		logger.info("VM Arguments : " + args.containsOption("foo"));
	}
}
