package myspring.di.annot;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloA")
public class Hello {
	//<property name="name" value="스프링" />
	@Value("${name}")
	String name;
	
	@Autowired
	//@Qualifier("${myprinter}")  //지원하지 않는다. 오류발생
	@Qualifier("stringPrinter")
	//<property name="printer" ref="stringPrinter" />
	//@Resource(name = "${myprinter}")  //지원한다. 
	Printer printer;
	
	List<String> names;
	Map<String, Integer> ages;

	public Hello() {
		System.out.println("Hello Default Constructor called...");
	}

	//@Autowired
	//public Hello(@Value("Annotation") String name, @Qualifier("stringPrinter") Printer printer) {
	public Hello(String name, Printer printer) {
		System.out.println("OverLoading Hello Constructor called..");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}
	
	//setName(), setPrinter()는 제거함

	public void setAges(Map<String, Integer> ages) {
		this.ages = ages;
	}
	
	public Map<String, Integer> getAges() {
		return ages;
	}
	
	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
