# Spring Boot

> 단독으로 실행이 가능하고(stand-alone), 제품 수준의(production-grade) 스프링 기반 어플리케이션을 제작하는 것을 목표로 진행된 프로젝트

- 단독 실행이 가능한 수준의 스프링 어플리케이션 제작이 가능하다.
- 내장된 Tomcat, Jetty, UnderTow 등의 서버를 이용해서 별도의 서버를 설치하지 않고 실행 가능하다. 
- 최대한 내부적으로 자동화된 설정을 제공한다. 
- XML 설정 없이 단순한 설정 방식을 제공한다.
- 스프링 프레임워크를 사용할 때 했던 많은 XML 설정들이 어노테이션으로 간편 해졌고, Java Config를 사용하며 더욱 단순해 졌는데 이것보다 더 단순화 된 프로젝트가 스프링 부트 (Spring Boot)이다. 
- 스프링 부트는 스프링의 여러 기술들(Data, Batch, Integration, Web, JDBC, Security)을 사용자가 쉽게 사용할 수 있게 해준다.



[spring boot](https://spring.io/projects/spring-boot)

[Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#getting-started-introducing-spring-boot)

[spring initializer](https://start.spring.io/)



### [설정]

![캡처](https://user-images.githubusercontent.com/42603919/79817391-58808a80-83c0-11ea-95a4-cc6a69b5135d.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/79817509-98e00880-83c0-11ea-95cf-71d615eec301.PNG)



![캡처2](https://user-images.githubusercontent.com/42603919/79817512-9a113580-83c0-11ea-99b6-e9d5abc7ecad.PNG)

### Generate 클릭

![캡처](https://user-images.githubusercontent.com/42603919/79817671-fa07dc00-83c0-11ea-83ca-a95f913d8545.PNG)



---



**file -> open projects from file system**

![캡처](https://user-images.githubusercontent.com/42603919/79818103-f1fc6c00-83c1-11ea-9257-a8592d515425.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/79818705-6b488e80-83c3-11ea-994c-d0d1562cbcd5.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/79819182-6afcc300-83c4-11ea-80c0-56813c44af22.PNG)

### oracle이 사용하는 port번호와 충돌하므로 port번호 바꾸기

```
# application.properties

server.port=8085
```



### 실행하기

1. boot file 우측버튼 클릭 -> run as -> spring boot app
2. boot Dashboard에서 -> boot file 우측버튼 클릭 -> start 

---



![캡처](https://user-images.githubusercontent.com/42603919/79819362-cb8c0000-83c4-11ea-83c7-540ebc1e9688.PNG)

**package나 java file을 만들 때**는  src/main/java 밑에 com.이름.myspringboot(base package) 밑에 만들어야한다. 그러지않고 만들게 되면 오류가 발생한다.

이유 : **base package가 componentScan을 시작하는 package이기 때문이다.**



![캡처](https://user-images.githubusercontent.com/42603919/79819451-fc6c3500-83c4-11ea-99ff-a066794b8946.PNG)

**test case**는 src/test/java 밑에 com.이름.myspringboot(base package) 밑에 만들어야한다. 그렇지 않으면 오류가 발생한다.

이유 :  **boot test Dependency 설정에서 scope이 test로 범위가 정해져 있기 때문이다.**



![캡처](https://user-images.githubusercontent.com/42603919/79819182-6afcc300-83c4-11ea-80c0-56813c44af22.PNG)

**application.properties**에 많은 설정을 지정한다. 

**static**은 정적인 파일(순수 웹페이지), html, css, js

**templates**는 engin templates을 설정할 때 사용, jsp, html(thymeleaf)



#### base package 아래 Application 클래스

**@SpringBootApplication** 는 아래의 3가지 어노테이션을 합친 것이다 

- **@SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan**
  - **1단계 : @ComponentScan** : project 생성시 정해준 default 팩키지 부터 scanning을 한다. 스프링 빈을 나타내는 어노테이션을 @ComponentScan이 붙은 클래스가 위치해 있는 현재 패키지를 기준 으로 그 아래 패키지까지 찾아내서 스프링 빈으로 등록하는 기능을 가진 어노테이션입니다.
  - **2단계 : @EnableAutoConfiguration** : 스프링 프레임워크에서 많이 쓰이는 스프링 bean 들을 자동적으로 컨테이너에 등록하는 역할을 하는 어노테이션입니다. 

- **xml 설정은 없다. => configuration class를 이미 만들어 제공하기 때문이다. 그 목록이 spring.factories에 있다.**

- **역할 : Spring Bean Container 생성**



---



### [실습]

![캡처](https://user-images.githubusercontent.com/42603919/79829461-1c5c2280-83de-11ea-9984-6af6c4a2a133.PNG)

```html
# index.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome 스프링부트!!</h2>
</body>
</html>
```



```java
# MyspringbootApplication.java

package com.dudrnjs.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		application.run(args);
	}

}
```



### 서버를 재시작해서 실행한다.



![캡처](https://user-images.githubusercontent.com/42603919/79829352-cb4c2e80-83dd-11ea-843a-f6559fc23f26.PNG)



---



#### jar 파일 만들어보자

1. pom.xml에 jar 추가

```xml
# pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.13.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.dudrnjs</groupId>
	<artifactId>myspringboot</artifactId>
	<version>0.0.1-SNAPSHOT</version>
    
    <!-- jar 추가 -->
	<packaging>jar</packaging>
    
	<name>myspringboot</name>
	<description>first spring boot project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
		<spring.version>5.1.12.RELEASE</spring.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

2. Spring Boot 프로젝트를 jar 파일로 생성하기 :  Run As -> Maven Build -> Goals : package -> Run

   ![캡처](https://user-images.githubusercontent.com/42603919/79831716-e79e9a00-83e2-11ea-86be-beeb388eeb80.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/79831884-3fd59c00-83e3-11ea-8d98-1797ac8a50a6.PNG)



#### 잠시 서버를 중지하고(포트번호가 충돌하기 때문에) 시작한다.

**Terminal 창 만들기**

![캡처](https://user-images.githubusercontent.com/42603919/79832089-9f33ac00-83e3-11ea-9d70-6cc18ccea67f.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/79832201-e28e1a80-83e3-11ea-912c-270d248d42c0.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/79832224-f043a000-83e3-11ea-8c47-9e3ac61797ee.PNG)

```
C:\Users\sku66\java\myspringboot\target>java -jar myspringboot-0.0.1-SNAPSHOT.jar
```

![캡처](https://user-images.githubusercontent.com/42603919/79829352-cb4c2e80-83dd-11ea-843a-f6559fc23f26.PNG)

### 동일하게 웹 페이지에 출력된다.



---



#### Event Listener

- **ApplicationStartingEvent**

  > ApplicationContext를 만들기 전에 호출되는 ApplicationListener
  >
  > 따라서 @Component를 사용할 수 없다. Bean으로 등록할 수 없다.

  ```java
  # MyspringbootApplication.java
  
  package com.dudrnjs.myspringboot;
  
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.WebApplicationType;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  
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
  		application.addListeners(new MyStartingEventListener());
  		
  		application.run(args);
  	}
  
  }
  ```

  ```java
  # MyStartingEventListener.java
  
  package com.dudrnjs.myspringboot.listener;
  
  import java.util.Date;
  
  import org.springframework.boot.context.event.ApplicationStartingEvent;
  import org.springframework.context.ApplicationListener;
  
  public class MyStartingEventListener implements ApplicationListener<ApplicationStartingEvent>{
  	@Override
  	public void onApplicationEvent(ApplicationStartingEvent event) {
  		System.out.println("Spring Bean 컨테이너 생성에 호출됨 ApplicationStarting Event" + 
  					new Date(event.getTimestamp()));
  		
  	}
  }
  ```

  

- **ApplicationStartedEvent**

  > ApplicationContext를 만든 후에 호출되는 ApplicationListener
  >
  > 따라서 @Component를 사용할 수 있다. Bean으로 등록할 수 있다.

  ```java
  # MyspringbootApplication.java
  
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
  		
  		
  		application.run(args);
  	}
  
  }
  
  ```

  ```java
  # MyStartedEventListener.java
  
  package com.dudrnjs.myspringboot.listener;
  
  import java.util.Date;
  
  import org.springframework.boot.context.event.ApplicationStartedEvent;
  import org.springframework.context.ApplicationListener;
  import org.springframework.stereotype.Component;
  
  @Component
  public class MyStartedEventListener implements ApplicationListener<ApplicationStartedEvent>{
  
  	@Override
  	public void onApplicationEvent(ApplicationStartedEvent event) {
  		System.out.println("Spring Bean 컨테이너 생성에 호출됨 ApplicationStarted Event" + new Date(event.getTimestamp()));
  		
  	}
  	
  }
  ```

  

---



#### ApplicationRunner 작성 : 커맨드 아규먼트 처리

> SpringApplication 실행된 후에 arguments 값을 받거나, 무엇인가를 실행하고 싶을 때 ApplicationRunner 인터페이스를 구현하는 Runner 클래스를 작성한다.

![캡처](https://user-images.githubusercontent.com/42603919/79837413-53d1cb80-83ec-11ea-9cf6-88c1590ca1e1.PNG)

```java
# MyRunner.java

package com.dudrnjs.myspringboot.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) //Runner 클래스 중에서 실행 우선 순위가 가장 먼저임.
public class MyRunner implements ApplicationRunner{
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("SourceArgs : " + args.getOptionNames());
		System.out.println("Program Arguments : " + args.containsOption("bar"));
		System.out.println("VM Arguments : " + args.containsOption("foo"));
	}
}

결과
SourceArgs : [spring.output.ansi.enabled, bar]
Program Arguments : true
VM Arguments : false
```



#### Terminal에서 jar로 실행해보기(서버 중지하고 실행)

```
C:\Users\sku66\java\myspringboot\target>java -jar -Dfoo myspringboot-0.0.1-SNAPSHOT.jar --bar

결과
SourceArgs [bar]
Program Arguments : true
VM Arguments : false
```



---



#### 외부 설정

1. **Properties 파일을 통한 설정 : properties의 값은 @Value 어노테이션을 통해 읽어올 수 있다.**

   ```
   # application.properties
   
   server.port=8085
   dudrnjs.name=\uC2A4\uD504\uB9C1(스프링)
   dudrnjs.age=${random.int(1,50)}
   dudrnjs.fullName=${dudrnjs.name} \uBD80\uD2B8(부트)
   ```

   ```java
   # MyRunner.java
   
   package com.dudrnjs.myspringboot.runner;
   
   import org.springframework.beans.factory.annotation.Value;
   import org.springframework.boot.ApplicationArguments;
   import org.springframework.boot.ApplicationRunner;
   import org.springframework.core.annotation.Order;
   import org.springframework.stereotype.Component;
   
   @Component
   @Order(1) //Runner 클래스 중에서 실행 우선 순위가 가장 먼저임.
   public class MyRunner implements ApplicationRunner{
   	
   	@Value("${dudrnjs.name}")
   	private String name;
   	
   	@Value("${dudrnjs.age}")
   	private int age;
   	
   	
   	@Override
   	public void run(ApplicationArguments args) throws Exception {
   		
   		System.out.println(">> Property Name " + name);
   		System.out.println(">> Property Age " + age);
   		
   		System.out.println("SourceArgs : " + args.getOptionNames());
   		System.out.println("Program Arguments : " + args.containsOption("bar"));
   		System.out.println("VM Arguments : " + args.containsOption("foo"));
   	}
   }
   
   결과
   >> Property Name 스프링
   >> Property Age 29
   SourceArgs : [spring.output.ansi.enabled, bar]
   Program Arguments : true
   VM Arguments : false
   ```



#### 우선순위

#### Terminal에서 실행

```
java -jar myspringboot-0.0.1-SNAPSHOT.jar --dudrnjs.name=코틀린 이라는 명령어(커맨드)가 properties에 적혀있는 dudrnjs.name=스프링보다 우선순위가 높기 때문에 출력에는 코틀린이 나오게 된다.

C:\Users\sku66\java\myspringboot\target>java -jar myspringboot-0.0.1-SNAPSHOT.jar --dudrnjs.name=코틀린


결과
Property Name 코틀린
Property Age 29
SourceArgs [dudrnjs.name]
Program Arguments : true
VM Arguments : false
```



2. **@ConfigurationProperties 어노테이션을 통한 외부 설정값 주입**

   > properties에 있는 키 값을 참조할 때 좀 더 type-safe하게 가져오기 위해서 사용한다.


![캡처](https://user-images.githubusercontent.com/42603919/79927959-64ca1d80-847c-11ea-9d56-acbe3ac1fe94.PNG)



**@ConfigurationProperties를 사용하기 위해서 dependency를 추가해야한다.**

```xml
# pom.xml

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-configuration-processor</artifactId>
	<optional>true</optional>
</dependency>
```



```java
# dudrnjsProperties.java

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
```



```java
# MyRunner.java

package com.dudrnjs.myspringboot.runner;

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
	
	@Autowired
	dudrnjsProperties properties;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println(">> Property Name  " + properties.getName());
		System.out.println(">> Property Age " + properties.getAge());
		System.out.println(">> Property fullName " + properties.getFullName());
		
		System.out.println("SourceArgs : " + args.getOptionNames());
		System.out.println("Program Arguments : " + args.containsOption("bar"));
		System.out.println("VM Arguments : " + args.containsOption("foo"));
	}
}

결과
>> Property Name  스프링
>> Property Age 1
>> Property fullName 스프링 부트
SourceArgs : [spring.output.ansi.enabled, bar]
Program Arguments : true
VM Arguments : false
```



---



#### 스프링 부트 프로파일

- 스프링 부트에서는 프로파일(Profile)을 통해 스프링 부트 애플리케이션의 런타임 환경을 관리할 수 있습니다. **어플리케이션 작동 시 테스트 환경에서 실행할 지, 프로덕션 환경에서 실행할 지를 프로파일을 통해 관리**할 수 있습니다.
- **프로덕션과 테스트 환경을 각각 외부 설정 파일을 통해서 관리**합니다. **spring.profiles.active 키값**을 통해 어떤 프로파일을 활성화 할 것인지를 결정합니다.
- **@Profile** 어노테이션을 통해 프로파일 기능을 구현할 수 있습니다. **@Profile에 인자로 들어가는 값은 프로파일이 현재 인자값과 일치할 때 명시한 스프링 bean을 등록하라는 뜻**입니다.



![캡처](https://user-images.githubusercontent.com/42603919/79929764-a01b1b00-8481-11ea-877b-578e35d14447.PNG)



```
# application.properties

spring.profiles.active=test
```



```java
# ProductionConfig.java

package com.dudrnjs.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ProductionConfig {

	@Bean
	public String hello() {
		return "운영환경입니다.";
	}
}
```



```java
# TestConfig.java

package com.dudrnjs.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfig {

	@Bean
	public String hello() {
		return "테스트환경에서 사용되는 hello bean.";
	}
}
```



```java
# MyRunner.java

package com.dudrnjs.myspringboot.runner;

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
	

	@Autowired
	String hello;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("hello bean : " + hello);
		

	}
}

결과
hello bean : 테스트환경에서 사용되는 hello bean.
```



#### jar로 만들어 Terminal에서 실행

```
C:\Users\sku66\java\myspringboot\target>java -jar myspringboot-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod

결과
운영환경입니다.
```



#### 운영용 테스트용을 따로 만들어서 해보자

![캡처](https://user-images.githubusercontent.com/42603919/79931371-d5c20300-8485-11ea-8657-4a9d99af762f.PNG)

```
# application-prod.properties

dudrnjs.fullName=${dudrnjs.name} For Production
```

```
# application-test.properties

dudrnjs.fullName=${dudrnjs.name} For Test
```

```
# application.properties

spring.profiles.active=test
결과 : >> Property fullName 스프링 For Test

spring.profiles.active=prod
결과 : >> Property fullName 스프링 For Production
```



---



####  Spring-Boot-Devtools

> 클래스 패스에 있는 파일이 변경 될 때마다 자동으로 재시작 해준다. 

- 캐쉬 설정을 개발 환경에 맞게 off 해준다. 직접 껐다 켜는 (cold start) 보다 빠르다.
- 리스타트 하고 싶지 않은 리소스는? spring.devtools.restart.exclude 
- 리스타트 기능 끄려면? spring.devtools.restart.enabled=false



#####  devtools dependency 추가

```xml
# pom.xml

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
</dependency>
```



---



####  Logging

```
# application.properties

server.port=8085
dudrnjs.name=\uC2A4\uD504\uB9C1
dudrnjs.age=${random.int(1,50)}
dudrnjs.fullName=${dudrnjs.name} \uBD80\uD2B8

spring.profiles.active=prod


# logging
logging.path=logs
```

```
# application-prod.properties

dudrnjs.fullName=${dudrnjs.name} For Production

# log level
logging.level.com.com.dudrnjs.myspringboot=info
```

```
# application-test.properties

dudrnjs.fullName=${dudrnjs.name} For Test

# log level
logging.level.com.com.dudrnjs.myspringboot=debug
```

```java
# MyRunner.java

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
```



---



#### 로거를 Log4j2로 변경하기

```xml
# pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.13.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.dudrnjs</groupId>
	<artifactId>myspringboot</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>
	<name>myspringboot</name>
	<description>first spring boot project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
		<spring.version>5.1.12.RELEASE</spring.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<!-- logback 배제 -->
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<!-- log4j2 추가 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-log4j2</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
		</dependency>
	</dependencies>


	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

```



---

### h2 DB 연동하기

#### H2 데이터베이스와 Spring-jdbc 의존성 추가

> Spring-boot-starter-jdbc 의존성을 추가하면 설정이 필요한 bean을 자동으로 설정 해준다. 
>
> DataSource 와 JdbcTemplate

```XML
# pom.xml

<!-- h2 memory DB -->
	<dependency>
		<groupId>com.h2database</groupId>
		<artifactId>h2</artifactId>
		<scope>runtime</scope>
	</dependency>
<!-- boot JDBC -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-jdbc</artifactId>
	</dependency>
```



```
# application.properties

# h2 console
spring.h2.console.enabled=true
```



![캡처](https://user-images.githubusercontent.com/42603919/79939666-a5d12a80-849a-11ea-9f0d-bfb42cb17fef.PNG)

```java
# DatabaseRunner.java

package com.dudrnjs.myspringboot.runner;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements ApplicationRunner{
	@Autowired
	DataSource dataSource;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("URL : " + metaData.getURL());
			System.out.println("User : " + metaData.getUserName());
			System.out.println("DataSource Class Name : " + dataSource.getClass().getName());
		}
		
	}
}

결과
URL : jdbc:h2:mem:testdb
User : SA
DataSource Class Name : com.zaxxer.hikari.HikariDataSource
```

```
: URL=> jdbc:h2:mem:testdb
: Username => SA
```



![캡처](https://user-images.githubusercontent.com/42603919/79940294-4d029180-849c-11ea-86b6-e6b12687d87f.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/79940244-1f1d4d00-849c-11ea-8d0b-18111672af63.PNG)



#### Table 생성 및 데이터 추가하고 h2 Console에서 확인한다

```java
# DatabaseRunner.java

package com.dudrnjs.myspringboot.runner;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements ApplicationRunner{
	@Autowired
	DataSource dataSource;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("URL : " + metaData.getURL());
			System.out.println("User : " + metaData.getUserName());
			System.out.println("DataSource Class Name : " + dataSource.getClass().getName());
            
			String sql = "CREATE TABLE CUSTOMER (ID INTEGER NOT NULL, name VARCHAR(255),PRIMARY\r\n" + "KEY (id))";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

		}
		
	}
}

```



![캡처](https://user-images.githubusercontent.com/42603919/79940642-488aa880-849d-11ea-9bb4-dbdb58df7914.PNG)

#### 값을 넣어보고 h2에서 확인해보기

```java
# DatabaseRunner.java

package com.dudrnjs.myspringboot.runner;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements ApplicationRunner{
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("URL : " + metaData.getURL());
			System.out.println("User : " + metaData.getUserName());
			System.out.println("DataSource Class Name : " + dataSource.getClass().getName());
            
			String sql = "CREATE TABLE CUSTOMER (ID INTEGER NOT NULL, name VARCHAR(255),PRIMARY\r\n" + "KEY (id))";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

			jdbcTemplate.execute("insert into customer values(1,'spring')");
		}
		
	}
}

```

![캡처](https://user-images.githubusercontent.com/42603919/79940843-cea6ef00-849d-11ea-8431-5929423c34c1.PNG)

---

### MariaDB 연결하기

##### MySQL 커넥터 의존성 추가

```xml
# pom.xml

<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.13</version>
</dependency>
```

##### 설치 유념사항

1. **root password - mysql**
2. **utf-8 check**

![캡처](https://user-images.githubusercontent.com/42603919/79942714-6d354f00-84a2-11ea-9f67-fd5591f086ce.PNG)



#### mysql client 접속하기

![캡처](https://user-images.githubusercontent.com/42603919/79942787-98b83980-84a2-11ea-9576-54580b770b2a.PNG)



#### Spring Data : Maria 데이터베이스

```mysql
MariaDB [(none)]> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| test               |
+--------------------+
4 rows in set (0.010 sec)

MariaDB [(none)]> use mysql;
Database changed
MariaDB [mysql]> create user spring@localhost identified by 'spring';
Query OK, 0 rows affected (0.001 sec)

MariaDB [mysql]> grant all on *.* to spring@localhost;
Query OK, 0 rows affected (0.000 sec)

MariaDB [mysql]> flush privileges;
Query OK, 0 rows affected (0.001 sec)

MariaDB [mysql]> exit;
Bye

C:\Program Files\MariaDB 10.3\bin>mysql -u spring -p
Enter password: ******
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 9
Server version: 10.3.11-MariaDB mariadb.org binary distribution

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> create database spring_db;
Query OK, 1 row affected (0.002 sec)

MariaDB [(none)]> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| spring_db          |
| test               |
+--------------------+
5 rows in set (0.006 sec)

MariaDB [(none)]> use spring_db;
Database changed
```



#### MySQL DataSource 설정

```
# application.properties

# mysql
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/spring_db?useUnicode=true&charaterEncoding=utf-8&useSSL=false&serverTimezone=UTC
spring.datasource.username=spring
spring.datasource.password=spring
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
```



#### MySQL db 연동 확인하기(데이터 확인하기)

```mysql
MariaDB [spring_db]> show tables;
+---------------------+
| Tables_in_spring_db |
+---------------------+
| customer            |
+---------------------+
1 row in set (0.001 sec)
```



---



### Spring Data : ORM과 JPA

- ORM(Object-Relational Mapping)과 JPA (Java Persistence API) 
  - 객체와 릴레이션을 맵핑 할 때 발생하는 개념적 불일치를 해결하는 프레임워크
-  JPA (Java Persistence API) 
  - ORM을 위한 자바 (EE) 표준이다.



#### Spring Data : Spring-Data-JPA

- JPA를 쉽게 사용하기 위해 스프링에서 제공하는 프레임워크이다.
- Repository Bean을 자동 생성해 준다. 
- **쿼리 메소드 자동 구현 (쿼리문을 사용자가 직접 작성할 필요가 없다.)**
- @EnableJpaRepositories (스프링 부트가 자동으로 설정 해줌.)



##### 스프링 데이터 JPA 의존성 추가

```XML
# pom.xml

<dependency>
 	<groupId>org.springframework.boot</groupId>
 	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```



#### Spring Data : Entity 클래스 작성

- **@Entity** : **엔티티 클래스임을 지정하며 DB 테이블과 매핑하는 객체를 나타내는 어노테이션**이다. 앤티티(Entity)란 데이터베이스에서 표현하려고 하는 유형, 무형의 객체로서 서로 구별되는 것을 뜻한다. 이 객체들은 DB 상에서는 보통 table로서 나타내어진다. 
- **@Id** : **엔티티의 기본키를 나타내는 어노테이션**이다. 
- **@GeneratedValue** : **주키의 값을 자동 생성하기 위해 명시하는 데 사용되는 어노테이션**이다. 자동 생성 전략은 (AUTO, IDENTITY, SEQUENCE, TABLE) 이 있다.



![캡처](https://user-images.githubusercontent.com/42603919/79947080-411ecb80-84ac-11ea-82b6-a777e0b80964.PNG)



```java
# DatabaseRunner.java

package com.dudrnjs.myspringboot.runner;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements ApplicationRunner{
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try(Connection connection = dataSource.getConnection()){
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("URL : " + metaData.getURL());
			System.out.println("User : " + metaData.getUserName());
			System.out.println("DataSource Class Name : " + dataSource.getClass().getName());
			
			// 주석처리
//			String sql = "CREATE TABLE CUSTOMER (ID INTEGER NOT NULL, name VARCHAR(255),PRIMARY\r\n" + "KEY (id))";
//			Statement statement = connection.createStatement();
//			statement.executeUpdate(sql);
//			jdbcTemplate.execute("insert into customer values(1,'spring')");
		}
		
	}
}

```



```java
# Account.java

package com.dudrnjs.myspringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true) // 중복 허용x
	private String username;

	@Column
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
```



#### h2에서 확인해보기

![캡처](https://user-images.githubusercontent.com/42603919/79947765-8099e780-84ad-11ea-9a7e-5e159789736b.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/79947736-6e1fae00-84ad-11ea-8823-61b2aa562d48.PNG)



#### mysql에서 확인해보기

**Spring Data : JPA를 사용한 데이터베이스 초기화**

```
• spring.jpa.hibernate.ddl-auto=create|create-drop|update|validate

 create
JPA가 DB와 상호작용할 때 기존에 있던 스키마(테이블)을 삭제하고 새로 만드는 것을 뜻한다.
 create-drop
JPA 종료 시점에 기존에 있었던 테이블을 삭제한다.
 update
기존 스키마는 유지하고, 새로운 것만 추가하고, 기존의 데이터도 유지한다. 변경된 부분만 반영함
 주로 개발 할 때 적합하다.
 validate
엔티티와 테이블이 정상 매핑 되어 있는지를 검증한다.

• spring.jpa.show-sql=true
: JPA가 생성한 SQL문을 보여줄 지에 대한 여부를 알려주는 프로퍼티이다.
```



```
# application.properties

spring.jpa.hibernate.ddl-auto=create(또는 update)
spring.jpa.show-sql=true
```



```mysql
MariaDB [spring_db]> show tables;
+---------------------+
| Tables_in_spring_db |
+---------------------+
| account             |
| customer            |
| hibernate_sequence  |
+---------------------+
3 rows in set (0.001 sec)

MariaDB [spring_db]> desc account;
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| id       | bigint(20)   | NO   | PRI | NULL    |       |
| password | varchar(255) | YES  |     | NULL    |       |
| username | varchar(255) | YES  | UNI | NULL    |       |
+----------+--------------+------+-----+---------+-------+
3 rows in set (0.032 sec)

MariaDB [spring_db]> desc hibernate_sequence;
+----------+------------+------+-----+---------+-------+
| Field    | Type       | Null | Key | Default | Extra |
+----------+------------+------+-----+---------+-------+
| next_val | bigint(20) | YES  |     | NULL    |       |
+----------+------------+------+-----+---------+-------+
1 row in set (0.024 sec)
```



---



#### Spring Data : Repository 인터페이스 작성

- AccountRepository의 구현체를 따로 작성하지 않아도 Spring-Data-JPA가 자동적으로 해당 문자열 username에 대한 인수를 받아 자동적으로 DB Table과 매핑한다.

```java
# Account.java

package com.dudrnjs.myspringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long id;

    // toString 추가
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	@Column(unique = true) // 중복 허용x
	private String username;

	@Column
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
```



![캡처](https://user-images.githubusercontent.com/42603919/79949477-978e0900-84b0-11ea-8549-44430b6d18be.PNG)



```java
# AccountRepository.java

package com.dudrnjs.myspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dudrnjs.myspringboot.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findByUsername(String username);
}
```





#### Spring Data : JPA 테스트

![캡처](https://user-images.githubusercontent.com/42603919/79953738-4fbeb000-84b7-11ea-95e8-766ac8d84101.PNG)

```java
# AccountRepositoryTest.java

package com.dudrnjs.myspringboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dudrnjs.myspringboot.entity.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
	@Autowired
	AccountRepository repository;
	
	@Test
	public void account() throws Exception {
		//System.out.println(repository.getClass().getName());
		Account account = new Account();
		account.setUsername("spring");
		account.setPassword("1234");
		
		Account saveAcct = repository.save(account);
		System.out.println(saveAcct);
		assertThat(saveAcct).isNotNull();
		
	}
}
```



#### mariadb에서 확인

```mysql
MariaDB [spring_db]> select*from account;
+----+----------+----------+
| id | password | username |
+----+----------+----------+
|  1 | 1234     | spring   |
+----+----------+----------+
1 row in set (0.000 sec)
```



#### 조회해보기

```java
# AccountRepositoryTest.java

package com.dudrnjs.myspringboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dudrnjs.myspringboot.entity.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
	@Autowired
	AccountRepository repository;
	
	@Test
	public void findByUsername() throws Exception {
		Account existAcct = repository.findByUsername("spring");
		assertThat(existAcct).isNotNull();
		
		Account notExistAcct = repository.findByUsername("test");
		assertThat(notExistAcct).isNull();
	}
	
	@Test @Ignore
	public void account() throws Exception {
		//System.out.println(repository.getClass().getName());
		Account account = new Account();
		account.setUsername("spring");
		account.setPassword("1234");
		
		Account saveAcct = repository.save(account);
		System.out.println(saveAcct);
		assertThat(saveAcct).isNotNull();
		
	}
}
```



---



####  Spring Data : Repository 인터페이스 수정

- **Optional 객체 반환** 
- : Java8은 함수형 언어의 접근 방식에서 영감을 받아 java.util.Optional라는 새로운 클래스를 도입하였다. 
- : Optional는 “존재할 수도 있지만 안할 수도 있는 객체”, 즉, ”null이 될 수도 있는 객체” 을 감싸고 있는 일종의 래퍼 클래스이다. 
- : 명시적으로 해당 변수가 null일 수도 있다는 가능성을 표현할 수 있다. (따라서 불필요한 NullPointException 방어 로직을 줄일 수 있다.)