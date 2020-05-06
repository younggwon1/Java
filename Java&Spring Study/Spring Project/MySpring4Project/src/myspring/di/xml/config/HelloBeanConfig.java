package myspring.di.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
public class HelloBeanConfig {
	
	@Bean
	//@Bean은 XML에서 <bean id="stringPrinter" class="xx.StirngPrinter" />
	public Printer stringPrinter() {
		return new StringPrinter();
	}
	
	@Bean 
	//@Bean은 XML에서 <bean id="consolPrinter" class="xx.ConsolePrinter" />
	public Printer consolPrinter() {
		return new ConsolePrinter();
	}
	
	@Bean
//	@Scope("singleton")
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName("Config");
		hello.setPrinter(stringPrinter());
		return hello;
	}
	
}
