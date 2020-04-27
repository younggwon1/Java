# RESTful 웹서비스 구현

<img src="https://user-images.githubusercontent.com/42603919/79725257-e9555880-8323-11ea-8700-88b78b72fc98.PNG" alt="캡처" style="zoom: 67%;" />

#### Spring MVC기반 RESTful 웹서비스 구현 절차

- ① RESTful 웹서비스를 처리할 RestfulController 클래스 작성 및 @RestController 어노테이션 선언하여 Bean으로 등록 
- ② 요청을 처리할 메서드에 @RequestMapping @RequestBody와 @ResponseBody 어노테이션 선언 
- ③ REST Client Tool (Postman)을 사용하여 각각의 메서드 테스트 
- ④ Ajax 통신을 하여 RESTful 웹서비스를 호출하는 HTML 페이지 작성



#### RESTful Controller를 위한 핵심 어노테이션(Annotation)

- Spring MVC에서는 클라이언트에서 전송한 XML이나 JSON 데이터를 Controller에서 Java객체로 변환해서 받을 수 있는 기능(수신)을 제공하고 있다. 
- Java객체를 XML이나 JSON으로 변환해서 전송할 수 있는 기능(송신)을 제공하고 있다.

-> **java object를 json, json을 java object로 바꿔주는 것은 Jackson이 한다.**



- **@RequestBody** : HTTP Request Body(요청 몸체)를 Java객체로 전달받을 수 있다.
- **@ResponseBody** : Java 객체를 HTTP Response Body (응답 몸체)로 전송할 수 있다.

변환된 객체 혹은 java object, json를 요청몸체나 응답몸체에 실을 수 있다



1. [Maven Jackson Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)

2. 복사

   ![캡처](https://user-images.githubusercontent.com/42603919/79723073-21f33300-8320-11ea-96d9-b2d09ca1752a.PNG)

   

3. pom.xml에 붙여넣기

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
   					<release>10</release>
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
   	<properties>
   		<spring.version>4.3.26.RELEASE</spring.version>
   	</properties>
   	<dependencies>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-context</artifactId>
   			<version>${spring.version}</version>
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
   			<version>${spring.version}</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis</artifactId>
   			<version>3.5.4</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis-spring</artifactId>
   			<version>2.0.4</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-jdbc</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   
   		<!-- Oracle JDBC Driver -->
   		<!-- 해당 파일이 Local에 있는 경우 -->
   		<dependency>
   			<groupId>ojdbc</groupId>
   			<artifactId>ojdbc</artifactId>
   			<version>6</version>
   			<scope>system</scope>
   			<systemPath>${basedir}/WebContent/WEB-INF/lib/ojdbc6.jar</systemPath>
   		</dependency>
   
   		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2 -->
   		<dependency>
   			<groupId>org.apache.commons</groupId>
   			<artifactId>commons-dbcp2</artifactId>
   			<version>2.7.0</version>
   		</dependency>
   
   		<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
   		<dependency>
   			<groupId>javax.xml.bind</groupId>
   			<artifactId>jaxb-api</artifactId>
   			<version>2.3.1</version>
   		</dependency>
   
   
   		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
   		<dependency>
   			<groupId>org.apache.logging.log4j</groupId>
   			<artifactId>log4j-core</artifactId>
   			<version>2.13.1</version>
   		</dependency>
   
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-webmvc</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   
   		<!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
   		<dependency>
   			<groupId>javax.servlet</groupId>
   			<artifactId>jstl</artifactId>
   			<version>1.2</version>
   		</dependency>
   
   
   
   		<!-- 추가한 부분 -->
   		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
   		<dependency>
   			<groupId>com.fasterxml.jackson.core</groupId>
   			<artifactId>jackson-databind</artifactId>
   			<version>2.10.3</version>
   		</dependency>
   
   
   
   
   
   	</dependencies>
   </project>
   ```

   

4. 생성 완료

   <img src="https://user-images.githubusercontent.com/42603919/79723199-4f3fe100-8320-11ea-9366-2b9488a79913.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79727857-fffdae80-8327-11ea-90cf-e761d7b40370.PNG" alt="캡처" style="zoom:80%;" />



#### json 형식

```java
# RestUserController.java

package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RestController
//@RequestMapping("/users")
public class RestUserController {
	@Autowired
	UserService userService;

	// 사용자 목록
	@GetMapping("/users") //GET
	public List<UserVO> userList() {
		return userService.getUserList();
	}

	// 상세조회
	@GetMapping("/users/{id}") //GET
	public UserVO userDetail(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	// 등록하기
	@PostMapping("/users")
	//Json -> java object
	public Boolean userInsert(@RequestBody UserVO user) {
		if(user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}
	
	//수정하기
	@PutMapping("/users")
	public Boolean userUpdate(@RequestBody UserVO user) {
		if(user != null) {
			userService.updateUser(user);
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}
	
	//삭제하기
	@DeleteMapping("/users/{id}")
	public Boolean userDelete(@RequestBody String id) {
		if(id != null) {
			userService.deleteUser(id);
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}
}
```



#### Postman 사용하기(chromeapp으로 사용해보기)

<img src="https://user-images.githubusercontent.com/42603919/79812603-67f9d680-83b4-11ea-9d99-1f85eb100e52.PNG" alt="get1" style="zoom: 80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79812607-692b0380-83b4-11ea-9a6c-ded5b43c74e3.PNG" alt="get2" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79812610-6a5c3080-83b4-11ea-87ab-4a5bbf79f124.PNG" alt="post1" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79812612-6af4c700-83b4-11ea-8875-3bf8ae24ba8c.PNG" alt="post2" style="zoom:80%;" />





---



#### xml 형식

**다음을 추가**

```xml
# pom.xml

		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.1</version>
		</dependency>
		
		<dependency>
			<groupId>javax.xml</groupId>
			<artifactId>jaxb-impl</artifactId>
			<version>2.1</version>
		</dependency>
```



```java
# RestUserController.java

package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.UserVOXML;

@RestController
//@RequestMapping("/users")
public class RestUserController {
	@Autowired
	UserService userService;

	
	//사용자 목록 xml형식
	@GetMapping("/usersxml")
	public UserVOXML userListXml() {
		List<UserVO> userList = userService.getUserList();
		return new UserVOXML("success", userList);
	}

	
}
```





<img src="https://user-images.githubusercontent.com/42603919/79812480-0afe2080-83b4-11ea-9003-fe32ffc3b851.PNG" alt="캡처" style="zoom:80%;" />



---



#### FrontEnd Framework/Library

- jQuery
- React, Vuejs, Angular
- Server Side 연동할 때 ajax(비동기)

##### 기존 서버코드는 jsp를 사용해서 구현, 그러면 클라이언트 js를 Vuejs나 react를 사용하는 것이 가능할까??

**서버는 클라이언트에게 data(json, xml)만 전달해야한다. 따라서 불가능하다.**

데이터를 가지고 ajax(비동기 방식)으로 통신을 한다. **따라서 xml, json으로 내려주는 controller를 만들어야 클라이언트 js를 Vuejs나 react사용이 가능하다.** 