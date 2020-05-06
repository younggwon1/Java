package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("consolePrinter") //bean의 id를 입력o
public class ConsolePrinter implements Printer {
	public void print(String message) {
		System.out.println(message);
	}
}
