package com.dudrnjs.myspringboot.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("dudrnjs")
public class dudrnjsProperties {
	private String name;
	private int age;
	private String fullName;
	
	//getName은 우리가 호출, setName은 framework가 호출
	//이유는 .property 파일값을 넣어야하기 때문이다.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
