package myspring.di.xml.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	@Qualifier("helloC")
	Hello hello;
	//Hello hello = (Hello)factory.getBean("hello");
	
	@Test
	public void hellobean() {
		System.out.println(hello.sayHello());
		hello.print();
		
		List<String> names = hello.getNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		Map<String, Integer> ages = hello.getAges();
		//1. Map의 keySet() 사용
		//ages.keySet() => Set<String>
		for(String key : ages.keySet()) {
			System.out.println(key + " : " + ages.get(key));
		}		
		//2. Map의 entrySet() 사용
		//ages.entrySet() => Map.Entry<String,Integer>
		for(Map.Entry<String,Integer> entry : ages.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	
}
