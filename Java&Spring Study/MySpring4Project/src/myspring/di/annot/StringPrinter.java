package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component //bean의 id를 입력x
//<bean id="stringPrinter" class="myspring.di.annto.StringPrinter" />
public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();

	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}
}
