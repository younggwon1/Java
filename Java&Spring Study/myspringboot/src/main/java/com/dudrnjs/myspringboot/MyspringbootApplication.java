package com.dudrnjs.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dudrnjs.myspringboot.listener.MyStartedEventListener;
import com.dudrnjs.myspringboot.listener.MyStartingEventListener;

@SpringBootApplication
public class MyspringbootApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MyspringbootApplication.class, args);
		
		//WebApplication type 변경
		SpringApplication application = new SpringApplication(MyspringbootApplication.class);
		
		//Default WebApplication Type이 Servlet이다.
		application.setWebApplicationType(WebApplicationType.SERVLET);
		
		//Default WebApplication Type을 none으로 바꿔보자.
		//application.setWebApplicationType(WebApplicationType.NONE);
		//Default WebApplication Type을 none으로 바꾸게 되면 사이트에 연결x
		
		
		//Listener 객체를 등록
		//application.addListeners(new MyStartingEventListener());
		//application.addListeners(new MyStartedEventListener());
		
		application.run(args);
	}

}
