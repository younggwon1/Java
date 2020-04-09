# Spring Framework

[Spring Framework](https://spring.io/projects/spring-framework#overview)

[Reference](https://docs.spring.io/spring/docs/5.1.14.RELEASE/spring-framework-reference/)

[API-doc](https://docs.spring.io/spring/docs/5.1.14.RELEASE/javadoc-api/)



> 자바 플랫폼을 위한 **오픈소스 애플리케이션 프레임워크**로서 **스프링(Spring)**이라고도 불린다.
>
> **동적인 웹 사이트를 개발**하기 위한 여러 가지 서비스를 제공한다. 



### 개발자는 로직에만 신경쓰게하고, 비기능적인 부분(성능, 보안, 확장성, 안정성 등)에서는 Framework에서 제공한다.



**core technologies** : dependency injection(가장 중요), AOP(Aspect Oriented Programming), IoC(Inversion of Control)

**Testing** : TestContext framework

**Data Access** : DAO(Data Access Object) support, JDBC(Java Data Access Connectivity),      ORM(Object Reletional Mapping) -> database와 연동할 때 사용 : MyBatis, JPA

**Spring MVC**(Spring Model View Controller) : 웹 애플리케이션을 작성하는데 필요한 Framework



### 프레임워크와 라이브러리 차이점

**라이브러리** : **객체 생성을 직접 개발자**가 한다.

**프레임워크** : 클래스만 만들고, **객체 생성은 프레임워크 제공하는 컨테이너**가 한다. 개발자는 XML에 설정을 반드시 해야한다.(클래스에 대한 정보 제공)



![캡처](https://user-images.githubusercontent.com/42603919/78849104-81169500-7a4e-11ea-9ae3-2d271b94470d.PNG)





## Import 하기

**File -> Import**



![캡처](https://user-images.githubusercontent.com/42603919/78850704-cc32a700-7a52-11ea-9842-26cc54be94ee.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78850466-40b91600-7a52-11ea-806d-c73104a0cc18.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78850541-6f36f100-7a52-11ea-9b67-14055c694da8.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78852357-0e5de780-7a57-11ea-8102-77653cad76a1.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78858929-bc25c200-7a68-11ea-93f0-8009d3ecbf43.PNG)



**사용자 밑에 .m2라는 폴더가 생성됨** 

![캡처](https://user-images.githubusercontent.com/42603919/78850580-84ac1b00-7a52-11ea-9d0f-479b29445ff9.PNG)



---



### Tomcat

[download][https://tomcat.apache.org/download-80.cgi#8.5.53]

Core -> zip 다운로드

폴더가 생성되지 않게끔 압축풀기 (C:\Users\sku66\java\apache-tomcat-8.5.53)

![캡처](https://user-images.githubusercontent.com/42603919/78851709-70b5e880-7a55-11ea-87bb-b8f94c824dba.PNG)



#### Tomcat 서버 등록하기

마우스 우측버튼 -> NEW -> Server



**apache에서**

![캡처](https://user-images.githubusercontent.com/42603919/78851896-ee79f400-7a55-11ea-8f5f-b776565ffd57.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78851911-fafe4c80-7a55-11ea-993d-dd23ff37e665.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78851947-19644800-7a56-11ea-88b8-9336cc4e0d27.PNG)



**포트번호 변경하기**

tomcat 서버 더블클릭

8080 -> 8087 변경 (DB(8080)와 충돌하기 때문에)

![캡처](https://user-images.githubusercontent.com/42603919/78852142-8c6dbe80-7a56-11ea-9ea2-205e02ee522b.PNG)



**서버시작**

![캡처](https://user-images.githubusercontent.com/42603919/78852220-b7f0a900-7a56-11ea-82b3-39a504d707c0.PNG)

**서버중지**

![캡처](https://user-images.githubusercontent.com/42603919/78852265-d35bb400-7a56-11ea-8fbc-9738bfba7323.PNG)





### pom.xml

> Maven 설정파일

![캡처](https://user-images.githubusercontent.com/42603919/78852422-38afa500-7a57-11ea-8758-b56be0972734.PNG)



```xml
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
		
		dependency가 중요하다.
```



---

![캡처](https://user-images.githubusercontent.com/42603919/78860062-2c821280-7a6c-11ea-9ccb-5b52ff975097.PNG)

### [시작]

### 1. Dynamic web project

마우스 우측버튼 -> NEW -> Dynamic web project

![캡처](https://user-images.githubusercontent.com/42603919/78857055-4ec36280-7a63-11ea-8630-b0ea8414d9a4.PNG)



![캡처1](https://user-images.githubusercontent.com/42603919/78857059-4ff48f80-7a63-11ea-8188-d6423eca4c89.PNG)



![캡처2](https://user-images.githubusercontent.com/42603919/78857060-5125bc80-7a63-11ea-916c-58656d81a321.PNG)



#### **Finish -> No**



---

### 2. Maven project으로 변경하기

해당 프로젝트 우측버튼 -> Configure -> Convert to Maven Project

![캡처](https://user-images.githubusercontent.com/42603919/78857160-98ac4880-7a63-11ea-885b-86347c8f5c2e.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78857279-e9bc3c80-7a63-11ea-8d3c-f315687e894e.PNG)



#### **2.1 dependencies 추가하기**

1. ### Maven [Spring Context](https://mvnrepository.com/artifact/org.springframework/spring-context/4.3.26.RELEASE)

2. 해당 프로젝트의 pom.xml에 붙여넣기 -> 실행

   ![캡처](https://user-images.githubusercontent.com/42603919/78857473-71a24680-7a64-11ea-8444-7d420f551a32.PNG)

   

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>MySpring4Project</groupId>
	<artifactId>MySpring4Project</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<build>
		<sourceDirectory>src</sourceDirectory>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<release>11</release>
				</configuration>
			</plugin>
			<plugin>
				<artifactId>maven-war-plugin</artifactId>
				<version>3.2.1</version>
				<configuration>
					<warSourceDirectory>WebContent</warSourceDirectory>
				</configuration>
			</plugin>
		</plugins>
	</build>
	<dependencies>
        
        <!-- 추가한 부분 -->
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>4.3.26.RELEASE</version>
		</dependency>

	</dependencies>
</project>
```



---



### 3. config 폴더 만들기 (설정파일 만들기)

1. src 우측버튼 -> new -> folder(config)
2. config 우측버튼 -> new -> spring beans configuration file 

![캡처](https://user-images.githubusercontent.com/42603919/78857684-0311b880-7a65-11ea-87c4-6a6a11f12fc8.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78858064-4a4c7900-7a66-11ea-9737-2a9153abfbef.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78858246-d068bf80-7a66-11ea-8f6b-383275d91cef.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78858365-2fc6cf80-7a67-11ea-9950-a1ae01e65dd9.PNG)



---



### [실습]

![캡처](https://user-images.githubusercontent.com/42603919/78861876-e9766e00-7a70-11ea-8b07-43d1e81c65f9.PNG)



```java
# Hello.java
package myspring.di.xml;

import java.util.List;

public class Hello {
	String name;
	Printer printer; //상위 인터페이스만 의존한다.
	List<String> names;

	public Hello() {
		System.out.println("hello default constructor called...");
	}

	public Hello(String name, Printer printer) {
		System.out.println("overloading hello constructor called...");
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
		System.out.println("hello setName() called..." + name);
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		System.out.println("hello setPrinter() called" + printer.getClass().getName());
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
# Printer.java
package myspring.di.xml;

public interface Printer {
	public void print(String message);
}

```



```java
# ConsolePrinter.java
package myspring.di.xml;

public class ConsolePrinter implements Printer {
	public void print(String message) {
		System.out.println(message);
	}
}

```



```java
# StringPrinter.java
package myspring.di.xml;

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



#### config -> xml 파일에 설정을 해 볼 것임



---

**property는 set메소드를 가리킨다.**

![캡처](https://user-images.githubusercontent.com/42603919/78864253-3c065900-7a76-11ea-8553-f53d79324106.PNG)

---



**Config 안에 XML 파일 설정해보기**

```xml
spring_beans.xml 파일

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
	<bean id="hello" class="myspring.di.xml.Hello">
		<!-- setter Injection -->
	 	<property name="name" value="Spring"/>
	 	<property name="printer" ref="sPrinter"/>
	</bean>
	
</beans>
```

---



### Junit

> Java에서 독립된 단위테스트(Unit Test)를 지원해주는 프레임워크이다.



```
단위테스트(Unit Test)란?
소스 코드의 특정 모듈이 의도된 대로 정확히 작동하는지 검증하는
절차, 즉 모든 함수와 메소드에 대한 테스트 케이스(Test case)를
작성하는 절차를 말한다.
jUnit은 보이지 않고 숨겨진 단위 테스트를 끌어내어 정형화시켜
단위테스트를 쉽게 해주는 테스트 지원 프레임워크다. 
```



#### 특징

- jUnit4부터는 테스트를 지원하는 어노테이션을 제공한다. **@Test(중요)** @Before @After 

- 각 @Test 메서드가 호출할 때 마다 새로운 인스턴스를 생성하여 독립적인 테스트가 이루어지도록 한다.

- 단정(assert) 메서드로 테스트 케이스의 수행 결과를 판별한다. 예) assertEquals(예상 값, 실제 값) 

  

**첫번째 방법**

해당 프로젝트 우측버튼 클릭 -> build path -> configure build path

![캡처](https://user-images.githubusercontent.com/42603919/78865612-dcf61380-7a78-11ea-95f5-21b324cb6eca.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78865479-a6b89400-7a78-11ea-8e6b-441e5fbe46a0.PNG)



![캡처1](https://user-images.githubusercontent.com/42603919/78865483-a7e9c100-7a78-11ea-8127-12d4f71be4a8.PNG)



**두번째 방법**

1. [Maven JUnit 4.13](https://mvnrepository.com/artifact/junit/junit/4.13)

2. 복사

   ![캡처](https://user-images.githubusercontent.com/42603919/78865952-82a98280-7a79-11ea-90a2-8c679f546ce4.PNG)

3. 해당 프로젝트의 pom.xml에 붙여넣기 -> 실행

   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0"
   	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   	<modelVersion>4.0.0</modelVersion>
   	<groupId>MySpring4Project</groupId>
   	<artifactId>MySpring4Project</artifactId>
   	<version>0.0.1-SNAPSHOT</version>
   	<packaging>war</packaging>
   	<build>
   		<sourceDirectory>src</sourceDirectory>
   		<plugins>
   			<plugin>
   				<artifactId>maven-compiler-plugin</artifactId>
   				<version>3.8.0</version>
   				<configuration>
   					<release>11</release>
   				</configuration>
   			</plugin>
   			<plugin>
   				<artifactId>maven-war-plugin</artifactId>
   				<version>3.2.1</version>
   				<configuration>
   					<warSourceDirectory>WebContent</warSourceDirectory>
   				</configuration>
   			</plugin>
   		</plugins>
   	</build>
   	<dependencies>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-context</artifactId>
   			<version>4.3.26.RELEASE</version>
   		</dependency>
   
           <!-- 추가한 부분 -->
   		<!-- https://mvnrepository.com/artifact/junit/junit -->
   		<dependency>
   			<groupId>junit</groupId>
   			<artifactId>junit</artifactId>
   			<version>4.13</version>
   <!-- 			<scope>test</scope> -->
   		</dependency>
   
   
   	</dependencies>
   </project>
   ```

4. 생성 완료

   ![캡처](https://user-images.githubusercontent.com/42603919/78866560-91446980-7a7a-11ea-95b1-7f44321808e0.PNG)

---



### TestCase Method 만들기

![캡처](https://user-images.githubusercontent.com/42603919/78867520-314ec280-7a7c-11ea-8ccd-3832e062891a.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78867385-fc427000-7a7b-11ea-8852-b0d8f96f6f4b.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78867588-4af00a00-7a7c-11ea-8c9f-8275cb7563d2.PNG)



```xml
spring_beans.xml 파일

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
	<!-- scope : 1. singleton, 2. prototype, 3. request, 4. session -->
	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
		<!-- setter Injection -->
	 	<property name="name" value="Spring"/>
	 	<property name="printer" ref="sPrinter"/>
	</bean>
	
</beans>
```



### @Test 추가

```java
# HelloBeanJunitTest.java
package myspring.di.xml.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Printer;

public class HelloBeanJunitTest {
	/**
	 * 
	 * TestCase 메서드를 선언할 때 규칙 1. @Test 어노테이션을 반드시 선언한다. 2. 테스트 메서드의 접근 제한자는 반드시
	 * public void 이어야한다.
	 * 
	 */

	@Test
	public void hello() {
		// 1. Spring Bean Container 객체 생성
		// config 밑에있는 xml 파일의 정보를 설정.
		BeanFactory factory = new GenericXmlApplicationContext("config/spring_beans.xml");
		// 2. Container에게 Hello Bean을 요청
		// "" 안에 id값을 대소문자 지켜서 작성
		// 두가지 방식이 있다. 아래에 표현
		Hello hello = (Hello) factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);

		// 2.1 Assert.assertSame() 메서드를 사용해서 주소 비교
		Assert.assertSame(hello, hello2);

		// 2.2 Assert.assertEquals() 메서드를 사용해서 값을 비교
		//
		// Hello.java에 있는 sayHello
		// public String sayHello() {
		// return "Hello " + name;
		// }
		//
		// spring_beans.xml에 있는 <property name="name" value="Spring"/>
		// 값을 비교
		Assert.assertEquals("Hello Spring", hello.sayHello());

		// 3. Container에게 String Bean을 요청
		Printer printer = factory.getBean("sPrinter", Printer.class);
		Assert.assertEquals("Hello Spring", printer.toString());
	}

}
```



#### @Before 추가

```java
# HelloBeanJunitTest.java
package myspring.di.xml.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Printer;

public class HelloBeanJunitTest {
	BeanFactory factory;
	
	@Before
	public void init() {
		// 1. Spring Bean Container 객체 생성
		// config 밑에있는 xml 파일의 정보를 설정.
		factory = new GenericXmlApplicationContext("config/spring_beans.xml");
		
	}
	
	/**
	 * 
	 * TestCase 메서드를 선언할 때 규칙 1. @Test 어노테이션을 반드시 선언한다. 2. 테스트 메서드의 접근 제한자는 반드시
	 * public void 이어야한다.
	 * 
	 */

	@Test
	public void hello() {
		// 2. Container에게 Hello Bean을 요청
		// "" 안에 id값을 대소문자 지켜서 작성
		// 두가지 방식이 있다. 아래에 표현
		Hello hello = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);

		// 2.1 Assert.assertSame() 메서드를 사용해서 주소 비교
		Assert.assertSame(hello, hello2);

		// 2.2 Assert.assertEquals() 메서드를 사용해서 값을 비교
		//
		// Hello.java에 있는 sayHello
		// public String sayHello() {
		// return "Hello " + name;
		// }
		//
		// spring_beans.xml에 있는 <property name="name" value="Spring"/>
		// 값을 비교
		Assert.assertEquals("Hello Spring", hello.sayHello());

		// 3. Container에게 String Bean을 요청
		Printer printer = factory.getBean("sPrinter", Printer.class);
		Assert.assertEquals("Hello Spring", printer.toString());
	}

}
```



---



### Spring Test(Junit을 랩핑)

1. [Spring Test](https://mvnrepository.com/artifact/org.springframework/spring-test/4.3.26.RELEASE)

2. 복사

   ![캡처](https://user-images.githubusercontent.com/42603919/78874700-bdb2b280-7a87-11ea-85ce-d109b68d4ef1.PNG)

3. 해당 프로젝트의 pom.xml에 붙여넣기 -> 실행

   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0"
   	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   	<modelVersion>4.0.0</modelVersion>
   	<groupId>MySpring4Project</groupId>
   	<artifactId>MySpring4Project</artifactId>
   	<version>0.0.1-SNAPSHOT</version>
   	<packaging>war</packaging>
   	<build>
   		<sourceDirectory>src</sourceDirectory>
   		<plugins>
   			<plugin>
   				<artifactId>maven-compiler-plugin</artifactId>
   				<version>3.8.0</version>
   				<configuration>
   					<release>11</release>
   				</configuration>
   			</plugin>
   			<plugin>
   				<artifactId>maven-war-plugin</artifactId>
   				<version>3.2.1</version>
   				<configuration>
   					<warSourceDirectory>WebContent</warSourceDirectory>
   				</configuration>
   			</plugin>
   		</plugins>
   	</build>
   	<dependencies>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-context</artifactId>
   			<version>4.3.26.RELEASE</version>
   		</dependency>
   
   		<!-- https://mvnrepository.com/artifact/junit/junit -->
   		<dependency>
   			<groupId>junit</groupId>
   			<artifactId>junit</artifactId>
   			<version>4.13</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   
           <!-- 추가한 부분 -->
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-test</artifactId>
   			<version>4.3.26.RELEASE</version>
   <!-- 			<scope>test</scope> -->
   		</dependency>
   
   
   	</dependencies>
   </project>
   ```

4. 생성 완료

   ![캡처](https://user-images.githubusercontent.com/42603919/78874818-f05cab00-7a87-11ea-8ff3-2893bc695177.PNG)



---

### spring version setting

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>MySpring4Project</groupId>
	<artifactId>MySpring4Project</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<build>
		<sourceDirectory>src</sourceDirectory>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<release>11</release>
				</configuration>
			</plugin>
			<plugin>
				<artifactId>maven-war-plugin</artifactId>
				<version>3.2.1</version>
				<configuration>
					<warSourceDirectory>WebContent</warSourceDirectory>
				</configuration>
			</plugin>
		</plugins>
	</build>
    <!-- 추가한 부분 -->
	<properties>
		<spring.version>
			4.3.26.RELEASE
		</spring.version>
	</properties>
	<dependencies>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version> <!-- 추가한 부분 -->
		</dependency>

		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13</version>
			<!-- <scope>test</scope> -->
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>${spring.version}</version> <!-- 추가한 부분 -->
<!-- 			<scope>test</scope> -->
		</dependency>


	</dependencies>
</project>
```

---





![캡처](https://user-images.githubusercontent.com/42603919/78875664-35351180-7a89-11ea-9d71-bdc29c106cc1.PNG)



```java
package myspring.di.xml.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")

public class HelloBeanSpringTest {

}
```









#### 참고

[https://moolgogiheart.tistory.com/87](https://moolgogiheart.tistory.com/87)