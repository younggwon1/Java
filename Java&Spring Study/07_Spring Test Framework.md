# Spring Test Framework



### @RunWith (SpringJUnit4ClassRunner.class)

- @RunWith는 jUnit 프레임워크의 테스트 실행방법을 확장할 때 사용하는 어노테이션이다.
- SpringJUnit4ClassRunner라는 클래스를 지정해주면 jUnit이 테스트를 진행하는 중에 ApplicationContext를 만들고 관리하는 작업을 진행해 준다. 
- @RunWith 어노테이션은 각각의 테스트 별로 객체가 생성되더라도 싱글톤(Singleton)의 ApplicationContext를 보장한다.



### @ContextConfiguration

- **스프링 빈(Bean) 설정 파일의 위치를 지정**할 때 사용되는 어노테이션이다.



### @Autowired

- 스프링DI에서 사용되는 특별한 어노테이션이다. 
- 해당 변수에 자동으로 **빈(Bean)을 매핑** 해준다. 
- 스프링 빈(Bean) 설정 파일을 읽기 위해 굳이 GenericXmlApplicationContext를 사용할 필요가 없다.





### [실습]

![캡처](https://user-images.githubusercontent.com/42603919/78957262-d8386a80-7b1f-11ea-8e4c-1ba93654820c.PNG)



```java
# HelloBeanSpringTest.java

package myspring.di.xml.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class HelloBeanSpringTest {
	
	@Autowired
	Hello hello; //Hello hello = (Hello)factory.getBean("hello");와 동일
	
	@Test
	public void hellobean() {
		System.out.println(hello.sayHello());//sPrinter 출력
	}
}
```





### Constructor Injection

![캡처](https://user-images.githubusercontent.com/42603919/78953129-c7352c80-7b12-11ea-90d5-071cc8a5e294.PNG)



```java
# Hello.java
    
public Hello(String name, Printer printer) {
	System.out.println("OverLoading Hello Constructor called..");
	this.name = name;
	this.printer = printer;
}
```
```xml
# spring_beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<!-- StringPrinter 클래스를 Bean으로 설정 -->
	<bean id="sPrinter" class="myspring.di.xml.StringPrinter" />
	<!-- ConsolePrinter 클래스를 Bean으로 설정 -->
	<bean id="cPrinter" class="myspring.di.xml.ConsolePrinter" />
	
	<!-- Hello 클래스를 Bean으로 설정 -->
	<!-- scope 추가 -->
	<!-- scope : singleton, prototype, request, session -->
	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
		<!-- setter injection : default constructor를 사용해서 객체를 생성 -->
		<property name="name" value="Spring" />
		<property name="printer" ref="sPrinter" />
	</bean>
	
	<!-- construct injection 추가 아규면트가 있는(중복정의된) constructor를 사용해서 객체를 생성함-->
	<bean id="helloC" class="myspring.di.xml.Hello">
		<!-- constructor injextion -->
		<constructor-arg index="0" value="생성자" />
		<constructor-arg index="1" ref="sPrinter" />
	</bean>
</beans>
```



#### helloC 참조

#### @Qualifier 사용

```java
# HelloBeanSpringTest.java

package myspring.di.xml.test;

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
	//Qualifier가 없다면 변수명에 따라서 찾아감, Hello hello;
	//Qualifier가 있다면 Qualifier 변수명에 따라서 찾아감, @Qualifier("helloC")
	@Qualifier("helloC")
	Hello hello; //Hello hello = (Hello)factory.getBean("hello");와 동일
	
	@Test
	public void hellobean() {
		System.out.println(hello.sayHello()); //sPrinter 출력
		hello.print(); //cPrinter 출력
	}
}
```



```xml
# spring_beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<!-- StringPrinter 클래스를 Bean으로 설정 -->
	<bean id="sPrinter" class="myspring.di.xml.StringPrinter" />
	<!-- ConsolePrinter 클래스를 Bean으로 설정 -->
	<bean id="cPrinter" class="myspring.di.xml.ConsolePrinter" />
	
	<!-- Hello 클래스를 Bean으로 설정 -->
	<!-- scope 추가 -->
	<!-- scope : singleton, prototype, request, session -->
	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
		<!-- setter injection -->
		<property name="name" value="Spring" />
		<property name="printer" ref="sPrinter" />
	</bean>
	
	<bean id="helloC" class="myspring.di.xml.Hello">
		<!-- constructor injection -->
		<constructor-arg index="0" value="생성자" />
		<constructor-arg index="1" ref="cPrinter" />
	</bean>
</beans>

```



### 컬렉션(Collection) 타입의 값 주입(Injection)

![캡처](https://user-images.githubusercontent.com/42603919/78954444-33b22a80-7b17-11ea-85aa-1dede4629a53.PNG)



```java
# Hello.java

package myspring.di.xml;

import java.util.List;


public class Hello {
	String name;
	Printer printer;
    
	List<String> names;
	

	public Hello() {
		System.out.println("Hello Default Constructor called...");
	}

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

	public void setName(String name) {
		System.out.println("Hello setName() called.." + name);
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		System.out.println("Hello setPrinter() called.." + printer.getClass().getName());
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}

```



```java
# HelloBeanSpringTest.java

package myspring.di.xml.test;

import java.util.List;

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
	//Qualifier가 없다면 변수명에 따라서 찾아감, Hello hello;
	//Qualifier가 있다면 Qualifier 변수명에 따라서 찾아감, @Qualifier("helloC")
	@Qualifier("helloC")
	Hello hello; //Hello hello = (Hello)factory.getBean("hello");와 동일
	
	@Test
	public void hellobean() {
		System.out.println(hello.sayHello());
		hello.print();
		
		List<String> names = hello.getNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
```



```xml
# spring_beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<!-- StringPrinter 클래스를 Bean으로 설정 -->
	<bean id="sPrinter" class="myspring.di.xml.StringPrinter" />
	<!-- ConsolePrinter 클래스를 Bean으로 설정 -->
	<bean id="cPrinter" class="myspring.di.xml.ConsolePrinter" />
	
	<!-- Hello 클래스를 Bean으로 설정 -->
	<!-- scope 추가 -->
	<!-- scope : singleton, prototype, request, session -->
	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
		<!-- setter injection -->
		<property name="name" value="Spring" />
		<property name="printer" ref="sPrinter" />
	</bean>
	
	<bean id="helloC" class="myspring.di.xml.Hello">
		<!-- constructor injection -->
		<constructor-arg index="0" value="생성자" />
		<constructor-arg index="1" ref="cPrinter" />
		<property name="name"> <!-- setName(List<String>) -->
			<list>
				<value>Java</value>
				<value>Kotlin</value>
				<value>Scalar</value>
				<value>Java</value>
			</list>
		</property>
	</bean>
</beans>
```





![캡처](https://user-images.githubusercontent.com/42603919/78954624-ac18eb80-7b17-11ea-8036-f146a7ee8fb1.PNG)



```java
# Hello.java

package myspring.di.xml;

import java.util.List;
import java.util.Map;

public class Hello {
	String name;
	Printer printer;
	List<String> names;
    
	Map<String, Integer> ages;

	public Hello() {
		System.out.println("Hello Default Constructor called...");
	}

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

	public void setName(String name) {
		System.out.println("Hello setName() called.." + name);
		this.name = name;
	}


	public void setPrinter(Printer printer) {
		System.out.println("Hello setPrinter() called.." + printer.getClass().getName());
		this.printer = printer;
	}
    
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

```



```java
# HelloBeanSpringTest.java

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
	//Qualifier가 없다면 변수명에 따라서 찾아감, Hello hello;
	//Qualifier가 있다면 Qualifier 변수명에 따라서 찾아감, @Qualifier("helloC")
	@Qualifier("helloC")
	Hello hello; //Hello hello = (Hello)factory.getBean("hello");와 동일
	
	@Test
	public void hellobean() {
		System.out.println(hello.sayHello());
		hello.print();
		
		List<String> names = hello.getNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		Map<String, Integer> ages = hello.getAges();
		
		// Map의 key값과 value값을 가지고 오는 방법
		// 1. Map의 keySet() 사용
		// ages.keySet() => Set<String> 타입
		for(String key : ages.keySet()) {
			System.out.println(key + ages.get(key));
		}
		
		// 2. Map의 entrySet() 사용
		// ages.entrySet() => Map.Entry<String, Integer>
		for(Map.Entry<String,Integer> entry : ages.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}
}
```



```xml
# spring_beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<!-- StringPrinter 클래스를 Bean으로 설정 -->
	<bean id="sPrinter" class="myspring.di.xml.StringPrinter" />
	<!-- ConsolePrinter 클래스를 Bean으로 설정 -->
	<bean id="cPrinter" class="myspring.di.xml.ConsolePrinter" />
	
	<!-- Hello 클래스를 Bean으로 설정 -->
	<!-- scope : singleton, prototype, request, session -->
	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
		<!-- setter injection : default constructor를 사용해서 객체를 생성함 -->
		<property name="name" value="Spring" /> <!-- String -->
		<property name="printer" ref="sPrinter" /> <!-- Printer -->
	</bean>
	
	<bean id="helloC" class="myspring.di.xml.Hello">
		<!-- consturctor injection : 아규먼트가 있는 (중복정의된) constructor 를 사용해서 객체를 생성-->
		<constructor-arg index="0" value="Constructor" />
		<constructor-arg index="1" ref="cPrinter" /> <!-- Hello가 ConsolePrinter를 참조하게 됨 -->
		<property name="names">  <!-- setNames(List<String>) -->
			<list>
				<value>Java</value>
				<value>Kotlin</value>
				<value>Scalar</value>
				<value>Java</value>
			</list>
		</property>
		<property name="ages"> <!-- setAges(Map<String,Integer>) -->
			<map>
				<entry key="java" value="10" />
				<entry key="js" value="20" />
				<entry key="react" value="30" />
			</map>
		</property>
	</bean>
</beans>

```



---



![캡처](https://user-images.githubusercontent.com/42603919/78957108-55afab00-7b1f-11ea-818d-433cc420b1d4.PNG)



## Annotation Based(XML 부분적으로 사용)

> Component-scan 설정을 위해서 xml 부분적으로 사용

1. **bean등록 : @Component**
2. **setter injection : 어노테이션을 변수, setter 메서드 위에 선언**
   - **@Value**
   - **@AutoWired, @Qualifier**

3. **constructor injection : 어노테이션을 변수 옆에, 생성자 위에 선언**
   - **@Value, @Qualifier는 생성자의 변수 옆에**
   - **@AutoWired는 생성자 위에**



### - @Component는 <bean id="" class="" />와 동일, Spring Bean 등록(생성)

### - @Value는 <property value="" />와 동일, Spring Bean의 의존성 주입, 값을 주입

### - @Autowired는 <property ref="" />와 동일, 타입으로 해당되는 Bean을 찾아서 주입해주는 어노테이션, Reference를 주입

### - @Qualifier는 동일한 타입이 여러개가 있을 때 특정 Bean을 지정하는 어노테이션, @Autowired와 같이 씀

### - @Resource는 Bean의 이름(id)으로 해당되는 Bean을 찾아서 주입해주는 어노테이션



![캡처](https://user-images.githubusercontent.com/42603919/78960919-8812d580-7b2a-11ea-8ae1-e44882979c0a.PNG)



### setter injection

```java
# Hello.java

package myspring.di.annot;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloA")
public class Hello {
	
    // setter injection
	@Value("Annotation") 
	//<property name="name" value="스프링" />과 동일
	String name;
	
	@Autowired 
	@Qualifier("stringPrinter")
	//<property name="printer" ref="stringPrinter" />과 동일
	
	Printer printer;
	List<String> names;
	Map<String, Integer> ages;

	public Hello() {
		System.out.println("Hello Default Constructor called...");
	}

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

//	public void setName(String name) {
//		System.out.println("Hello setName() called.." + name);
//		this.name = name;
//	}
//
//	public void setPrinter(Printer printer) {
//		System.out.println("Hello setPrinter() called.." + printer.getClass().getName());
//		this.printer = printer;
//	}

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
```



```java
# ConsolePrinter.java

package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("consolePrinter") //bean의 id를 입력o (비교하기 위해서)
public class ConsolePrinter implements Printer {
	public void print(String message) {
		System.out.println(message);
	}
}
```



```java
# StringPrinter.java

package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component //bean의 id를 입력x (비교하기 위해서)
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
```



**xml의 s = spring bean**

**annnot에 s가 없다. 따라서 위치를 알려줘서 s (spring bean)가 붙도록 해야한다.**

**<context:component-scan base-package="" />**를 추가한다.





![캡처](https://user-images.githubusercontent.com/42603919/78962067-6fa4ba00-7b2e-11ea-9719-891e32002e28.PNG)



```xml
# spring_beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context-4.3.xsd">

    
    
    <!-- 추가된 부분 -->
	<!-- Component Auto Scanning 설정 -->
	<context:component-scan base-package="myspring.di.annot" />
	
    
    
	<!-- StringPrinter 클래스를 Bean으로 설정 -->
	<bean id="sPrinter" class="myspring.di.xml.StringPrinter" />
	<!-- ConsolePrinter 클래스를 Bean으로 설정 -->
	<bean id="cPrinter" class="myspring.di.xml.ConsolePrinter" />
	
	<!-- Hello 클래스를 Bean으로 설정 -->
	<!-- scope : singleton, prototype, request, session -->
	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
		<!-- setter injection : default constructor를 사용해서 객체를 생성함 -->
		<property name="name" value="Spring" /> <!-- String -->
		<property name="printer" ref="sPrinter" /> <!-- Printer -->
	</bean>
	
	<bean id="helloC" class="myspring.di.xml.Hello">
		<!-- consturctor injection : 아규먼트가 있는 (중복정의된) constructor 를 사용해서 객체를 생성-->
		<constructor-arg index="0" value="Constructor" />
		<constructor-arg index="1" ref="cPrinter" /> <!-- Hello가 ConsolePrinter를 참조하게 됨 -->
		<property name="names">  <!-- setNames(List<String>) -->
			<list>
				<value>Java</value>
				<value>Kotlin</value>
				<value>Scalar</value>
				<value>Java</value>
			</list>
		</property>
		<property name="ages"> <!-- setAges(Map<String,Integer>) -->
			<map>
				<entry key="java" value="10" />
				<entry key="js" value="20" />
				<entry key="react" value="30" />
			</map>
		</property>
	</bean>
</beans>
```

![캡처](https://user-images.githubusercontent.com/42603919/78962621-98797f00-7b2f-11ea-849d-24711af1601b.PNG)



#### s가 붙어있는 것을 확인할 수 있다.



#### namespace

> XML 네임스페이스는 XML 요소 간의 이름에 대한 충돌을 방지해 주는 방법을 제공합니다.
>
> XML 네임스페이스는 요소의 이름과 속성의 이름을 하나의 그룹으로 묶어주어 이름에 대한 충돌을 해결합니다.
>
> 이러한 XML 네임스페이스는 URI(Uniform Resource Identifiers)로 식별됩니다.



**다음을 생성**

![캡처](https://user-images.githubusercontent.com/42603919/78963361-2fdfd180-7b32-11ea-81d3-91dbc7ebbfcd.PNG)



```java
# HelloAnnotateBeanSpringTest.java

package myspring.di.annot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.annot.Hello;
import myspring.di.annot.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class HelloAnnotateBeanSpringTest {
	@Autowired
	Hello hello;
	
	@Autowired
	@Qualifier("stringPrinter") //printer가 두 개이기 때문에 하나로 지정해야한다.
	//@Qualifier("consolePrinter")
	Printer printer;
	// Printer consolePrinter; consolePrinter로 지정
    // Printer stringPrinter; stringPrinter로 지정
	
	@Test
	public void hello() {
		System.out.println(hello.sayHello());
		hello.print();
		System.out.println(printer.toString());
	}
}
```



---



### constructor injection

```java
# Hello.java

package myspring.di.annot;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloA")
public class Hello {
	
//	@Value("Annotation") 
	//<property name="name" value="Annotation" />과 동일
	String name;
	
//	@Autowired 
//	@Qualifier("stringPrinter")
	//<property name="printer" ref="stringPrinter" />과 동일
	
	Printer printer;
	List<String> names;
	Map<String, Integer> ages;

	public Hello() {
		System.out.println("Hello Default Constructor called...");
	}

    // constructor injection
	@Autowired
	public Hello(@Value("Annotation") String name, @Qualifier("stringPrinter") Printer printer) {
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

//	public void setName(String name) {
//		System.out.println("Hello setName() called.." + name);
//		this.name = name;
//	}
//
//	public void setPrinter(Printer printer) {
//		System.out.println("Hello setPrinter() called.." + printer.getClass().getName());
//		this.printer = printer;
//	}

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
```



### @Resource

```java
package myspring.di.annot;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloA")
public class Hello {
	
	@Value("Annotation") 
	//<property name="name" value="Annotation" />과 동일
	String name;
	
//	@Autowired 
//	@Qualifier("stringPrinter")
	//<property name="printer" ref="stringPrinter" />과 동일
	
    
    //@Resource 추가
	@Resource(name = "stringPrinter")
	Printer printer;
	List<String> names;
	Map<String, Integer> ages;

	public Hello() {
		System.out.println("Hello Default Constructor called...");
	}

    
//	@Autowired
//	public Hello(@Value("Annotation") String name, @Qualifier("stringPrinter") Printer printer) {
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

//	public void setName(String name) {
//		System.out.println("Hello setName() called.." + name);
//		this.name = name;
//	}
//
//	public void setPrinter(Printer printer) {
//		System.out.println("Hello setPrinter() called.." + printer.getClass().getName());
//		this.printer = printer;
//	}

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
```



---



### 환경에 따라 자주 변경되는 내용의 분리

- XML의 Bean 설정 메타정보는 애플리케이션 구조가 바뀌지 않으면 자주 변경되지 않는다. 
- 반면에 프로퍼티 값으로 제공되는 일부 설정정보 (예-DataSource Bean이 사용하는 DB 연결정보)는 애플리케이션이 동작하는 환경(개발, 테스트, 스테이징, 운영)에 따라서 자주 바뀔 수 있다. 
- 변경되는 이유와 시점이 다르다면 분리하는 것이 객체지향 설계의 기본 원칙이다. 설정에도 동일한 원칙을 적용할 수 있다. 
- **환경에 따라 자주 변경될 수 있는 내용은 ``properties`` 파일로 분리하는 것이 가장 깔끔**하다 XML 처럼 복잡한 구성이 필요 없고 키와 값의 쌍(**key=value**)으로 구성하면 된다.



**config 우측클릭 -> new -> file**



![캡처](https://user-images.githubusercontent.com/42603919/78967820-53a91480-7b3e-11ea-817c-67ac7158fb6e.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78967863-67ed1180-7b3e-11ea-9429-934fe41d4335.PNG)



### values.properties 작성

```
# values.properties

name = Annotation
myprinter=stringPrinter
```



### properties파일을 xml에 등록

- 프로퍼티 파일로 분리한 정보는 ${ } (프로퍼티 치환자)을 이용하여 설정한다. 

- ${ } 값을 치환해주는 기능은  태그에 의해 자동으로 등록되는 PropertyPlaceHolderConfigurer Bean이 담당한다.

  

```xml
# spring_beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context-4.3.xsd">

    
	<!-- 추가한 부분 -->
	<!-- properties file 설정 -->
	<context:property-placeholder location="classpath:config/values.properties"/>
	
	
	<!-- Component Auto Scanning 설정 -->
	<context:component-scan base-package="myspring.di.annot" />
	
	<!-- StringPrinter 클래스를 Bean으로 설정 -->
	<bean id="sPrinter" class="myspring.di.xml.StringPrinter" />
	<!-- ConsolePrinter 클래스를 Bean으로 설정 -->
	<bean id="cPrinter" class="myspring.di.xml.ConsolePrinter" />
	
	<!-- Hello 클래스를 Bean으로 설정 -->
	<!-- scope : singleton, prototype, request, session -->
	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
		<!-- setter injection : default constructor를 사용해서 객체를 생성함 -->
		<property name="name" value="Spring" /> <!-- String -->
		<property name="printer" ref="sPrinter" /> <!-- Printer -->
	</bean>
	
	<bean id="helloC" class="myspring.di.xml.Hello">
		<!-- consturctor injection : 아규먼트가 있는 (중복정의된) constructor 를 사용해서 객체를 생성-->
		<constructor-arg index="0" value="Constructor" />
		<constructor-arg index="1" ref="cPrinter" /> <!-- Hello가 ConsolePrinter를 참조하게 됨 -->
		<property name="names">  <!-- setNames(List<String>) -->
			<list>
				<value>Java</value>
				<value>Kotlin</value>
				<value>Scalar</value>
				<value>Java</value>
			</list>
		</property>
		<property name="ages"> <!-- setAges(Map<String,Integer>) -->
			<map>
				<entry key="java" value="10" />
				<entry key="js" value="20" />
				<entry key="react" value="30" />
			</map>
		</property>
	</bean>
</beans>
```



#### ${ } 값을 치환

```java
# Hello.java

package myspring.di.annot;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloA")
public class Hello {
	
	@Value("${name}") 
	//<property name="name" value="Annotation" />과 동일
	String name;
	
//	@Autowired 
//	@Qualifier("stringPrinter")
	//<property name="printer" ref="stringPrinter" />과 동일
	
	@Resource(name = "${myprinter}")
    //@Resource 대신 @Autowired, @Qualifier를 사용하여 ${ } 값을 치환할 수 없다.
	Printer printer;
	List<String> names;
	Map<String, Integer> ages;

	public Hello() {
		System.out.println("Hello Default Constructor called...");
	}

//	@Autowired
//	public Hello(@Value("Annotation") String name, @Qualifier("stringPrinter") Printer printer) {
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

//	public void setName(String name) {
//		System.out.println("Hello setName() called.." + name);
//		this.name = name;
//	}
//
//	public void setPrinter(Printer printer) {
//		System.out.println("Hello setPrinter() called.." + printer.getClass().getName());
//		this.printer = printer;
//	}

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
```



---



![캡처](https://user-images.githubusercontent.com/42603919/78972053-d8e4f700-7b47-11ea-9534-8a4804bce94b.PNG)



## Annotation Based(XML사용 x)

> XML을 전혀 사용하지 않는 것이 핵심 -> XML에 했던 설정을 자바코드를 이용하여 작성
>
> Java로 Configuration 클래스를 작성한다.



- **@Bean** : @Bean 어노테이션은 새로운 빈 객체를 제공할 때 사용되며 @Bean이 적용된 메서드의 이름을 Bean의 식별값으로 사용한다. 
- **@Configuration** : 클래스에 @Configuration 어노테이션을 선언하는 것은 스프링 IoC 컨테이너가 해당 클래스를 Bean 정의의 설정으로 사용한다는 것을 나타낸다.



**Spring의 새로운 자바 설정 지원의 핵심 부분은 @Configuration 어노테이션이 붙은 클래스이다. **

**이러한 클래스들은 스프링 IoC 컨테이너가 관리하는 객체의 인스턴스화, 설정, 초기화 로직을 정의하는 **

**@Bean 어노테이션이 붙은 메서드들로 이루어져 있다.** 



![캡처](https://user-images.githubusercontent.com/42603919/78973268-83f6b000-7b4a-11ea-8c56-981f6003264b.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78973320-9cff6100-7b4a-11ea-8ae9-be3ed88e057b.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78976018-5280e300-7b50-11ea-86dc-7e639c943f7a.PNG)

```java
# AnnotatedHelloBeanConfig.java

package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"myspring.di.annot"}) //<context:component-scan base-package="myspring.di.annot" />와 동일
public class AnnotatedHelloBeanConfig {

}
```





### Spring-Test에서 테스트를 지원하는 어노테이션(Annotation)

#### @ContextConfiguration

```java
@ContextConfiguration(classes=HelloConfig.class,loader=AnnotationConfigContextLoader.class)
```



- Spring Bean Configuration XML을 사용하는 경우 : **GenericXmlApplicationContext**를 사용

- Spring Bean Configuration 클래스(XML x)을 사용하는 경우 : **AnnotationConfigApplicationContext**를 사용



![캡처](https://user-images.githubusercontent.com/42603919/78974261-91149e80-7b4c-11ea-8e55-d5cd26f4e73d.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78974296-a5589b80-7b4c-11ea-9988-fe24ff1a4a6d.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78974432-ecdf2780-7b4c-11ea-992c-f3091410166b.PNG)



```java
# HelloConfigTest.java

package myspring.di.annot.config.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.Hello;
import myspring.di.annot.config.AnnotatedHelloBeanConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnotatedHelloBeanConfig.class, loader = AnnotationConfigContextLoader.class)
public class HelloConfigTest {
	@Autowired
	Hello hello;
	
	@Test
	public void hello() {
		System.out.println(hello.sayHello());
	}
}
```



```java
# AnnotatedHelloBeanConfig.java

package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"myspring.di.annot"}) //<context:component-scan base-package="myspring.di.annot" />와 동일
@PropertySource("classpath:config/values.properties")
public class AnnotatedHelloBeanConfig {

}
```



### **전략3이지만 전략1, 전략2를 커버할 수 있다.**

![캡처](https://user-images.githubusercontent.com/42603919/78975957-311ff700-7b50-11ea-9c33-a2dddb8319a5.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78976018-5280e300-7b50-11ea-86dc-7e639c943f7a.PNG)







![캡처](https://user-images.githubusercontent.com/42603919/78976195-a5f33100-7b50-11ea-9fde-91f6d6b75409.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78976219-b1465c80-7b50-11ea-94e2-d0d1506175d5.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78975957-311ff700-7b50-11ea-9c33-a2dddb8319a5.PNG)

```java
# HelloBeanConfig.java

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
```



![캡처](https://user-images.githubusercontent.com/42603919/78976839-fae37700-7b51-11ea-9d6d-01fb5d39749f.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78977163-9f65b900-7b52-11ea-9c48-a755cc2f95b4.PNG)





```java
# HelloBeanConfigTest.java

package myspring.di.xml.config.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.xml.Hello;
import myspring.di.xml.config.HelloBeanConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HelloBeanConfig.class, loader = AnnotationConfigContextLoader.class)
public class HelloBeanConfigTest {
	@Autowired
	Hello hello;
	
	@Test
	public void hello() {
		System.out.println(hello.sayHello());
	}
}
```







#### 참고

[Spring Collections](https://mkyong.com/spring/spring-collections-list-set-map-and-properties-example/)

