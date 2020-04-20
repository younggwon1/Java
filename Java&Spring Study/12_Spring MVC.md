# Spring MVC



### Spring MVC기반 웹 어플리케이션 작성 절차

- ① 클라이언트의 요청을 받는 DispatcherServlet를 web.xml에 설정 
- ② 클라이언트의 요청을 처리할 Controller를 작성 
- ③ Spring Bean으로 Controller를 등록 
- ④ JSP를 이용한 View 영역의 코드를 작성 
- ⑤ Browser 상에서 JSP를 실행



1. **Web.xml (web container 설정)**

   - ContextLoaderListener설정 : spring beans Configuration 설정 파일 위치를 알려줌

   - FrontController 역할을 하는 DispatcherServlet 클래스 정보 설정

     - ```
       <url-pattern>*.do</url-pattern>
       ```

       

2. **Controller 클래스 작성**

- **@Controller** : 컨트롤러 클래스를 Bean으로 등록

- **@RequestMapping** : request url을 controller에 정의하는 메서드 위에 선언, HTTP 요청 URL을 처리할 Controller 메소드 정의

  - ```
    @RequestMapping("/userList.do")
    ```

  - HandlerMapping : 요청 url과 매핑되는 controller의 method명을 알고 있음

- **@RequestParam** : request.getParameter()와 동일, query string 형태로 보낸 문자열의 값을

  ​								추출할 때 사용, HTTP 요청에 포함된 파라미터 참조 시 사용
  
  - **request.getParameter()**와 동일하다.
  
  - ```
    (@RequestParam String userid, Model model)
    ```

- **@ModelAttribute** : form data 값을 추출해서 VO객체에 자동으로 저장해주는 어노테이션



**ModelAndView**(viewName, modelName, modelObject)

**Model** : addAtribute(modelName, modelObject)



1. [Spring Web MVC](https://mvnrepository.com/artifact/org.springframework/spring-webmvc/5.2.5.RELEASE)

2. 복사

   ![캡처](https://user-images.githubusercontent.com/42603919/79538283-06d5b880-80bf-11ea-943d-ee58f3d97c3a.PNG)

   

3. pom.xml에 추가하기

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
   		
   		
           
           
   
   		<!-- 추가한 부분 -->
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-webmvc</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   
   
           
           
   
   	</dependencies>
   </project>
   ```

   

4. 생성 완료

   ![캡처](https://user-images.githubusercontent.com/42603919/79538386-371d5700-80bf-11ea-9965-5a8c5c378c34.PNG)



### web.xml에 2가지 설정

- Spring Beans Configuration XML 정보를 Tomcat에 알려줘야 함
- FrontController 역할을 수행하는 DispatcherServlet 클래스를 설정



![캡처](https://user-images.githubusercontent.com/42603919/79538924-39cc7c00-80c0-11ea-8123-f3c25686d583.PNG)



1. **Spring Beans Configuration XML 정보를 Tomcat에 알려줘야 함**

```xml
# web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
  <display-name>MySpring4Project</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  
  
  <!-- 추가한 부분 -->
  <!-- ContextLoaderListener : spring beans Configuration 설정 파일 위치를 알려줌 -->
  <!-- needed for ContextLoaderListener -->
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:config/spring_beans.xml</param-value>
	</context-param>

	<!-- Bootstraps the root web application context before servlet initialization -->
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	
	
</web-app>
```



2. **FrontController 역할을 수행하는 DispatcherServlet 클래스를 설정**

```xml
# web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
  <display-name>MySpring4Project</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  
  
  <!-- needed for ContextLoaderListener -->
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:config/spring_beans.xml</param-value>
	</context-param>

	<!-- Bootstraps the root web application context before servlet initialization -->
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	
	
    
	
	<!-- 추가한 부분 -->
	<!-- The front controller of this Spring Web application, responsible for handling all application requests -->
	<servlet>
		<servlet-name>springDispatcherServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:config/spring_beans.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<!-- Map all requests to the DispatcherServlet for handling -->
	<servlet-mapping>
		<servlet-name>springDispatcherServlet</servlet-name>
		<url-pattern>*.do</url-pattern>
	</servlet-mapping>
	
	
    
</web-app>
```



### Tomcat 서버에 올리기

![캡처](https://user-images.githubusercontent.com/42603919/79539021-70a29200-80c0-11ea-9c7a-2c74bab1a2fc.PNG)



###  Tomcat 서버 실행

![캡처](https://user-images.githubusercontent.com/42603919/79539063-8ca63380-80c0-11ea-94f2-7ef7a9666ec8.PNG)



### Maven jstl 가져오기(jar(x))

1. [JSTL 1.2](https://mvnrepository.com/artifact/javax.servlet/jstl/1.2)

2. 복사

   ![캡처](https://user-images.githubusercontent.com/42603919/79543904-240f8480-80c9-11ea-8624-b43b61e36ef7.PNG)

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
   
   
   		<!-- 추가한 부분 -->
   		<!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
   		<dependency>
   			<groupId>javax.servlet</groupId>
   			<artifactId>jstl</artifactId>
   			<version>1.2</version>
   		</dependency>
   
   
   	</dependencies>
   </project>
   ```

   

4. 생성완료

   ![캡처](https://user-images.githubusercontent.com/42603919/79544170-8b2d3900-80c9-11ea-944e-a3cd76a20d1d.PNG)



---



#### 상세조회 해보기

**WebContent 밑에 index.jsp와 userList.jsp, userDetail.jsp를 복사하기**

![캡처](https://user-images.githubusercontent.com/42603919/79548722-d4cd5200-80d0-11ea-9646-c9a85420e0e7.PNG)

```jsp
# index.jsp

<%response.sendRedirect("userList.do");%>
<%--response.sendRedirect("getUserListJson.do");--%>
```



```java
# UserController.java

package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//사용자 목록 조회
	@RequestMapping("/userList.do")
	public ModelAndView userList() {
		List<UserVO> userList = userService.getUserList();
		
		
//		//2. DAO로 받아온 List 객체를 JSP에서 사용할 수 있도록 reguest 객체를 저장한다.
//		request.setAttribute("userList", users);
//		//3. 결과를 출력해줄 JSP - UserList.jsp를 포워딩(브라우저에 찍어보기)
//		rd = request.getRequestDispatcher("userList.jsp");
//		rd.forward(request, response);
		//위의 코드를 다음과 같이 표시할 수 있다.
		return new ModelAndView("userList.jsp", "userList", userList);
	}
	
	//사용자 상세정보 조회
	@RequestMapping("/userDetail.do")
	//@RequestParam : request.getParameter()와 동일하다.
	public String userDetail(@RequestParam String userid, Model model) {
		UserVO user = userService.getUser(userid);
		model.addAttribute("user", user);
		return "userDetail.jsp";
	}
	
	
	
}
```



```jsp
# userList.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>사용자 관리</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function deleteUser(userId){
		var result = confirm(userId +" 사용자를 정말로 삭제하시겠습니까?");
		if(result) {
			location.href = "deleteUser.do/"+userId;
		}
	}
</script>

</head>
<body>
	<div class="container">
		<h2 class="text-center">사용자 목록</h2>
		<table class="table table-bordered table table-hover"> 
			<thead> 
				<tr> 
					<th>아이디</th> 
					<th>이름</th> 
					<th>성별</th>
					<th>거주지</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr> 
		</thead> 
		<tbody> 
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>
					 	<a href="userDetail.do?userid=${user.userId}">${user.userId}</a>
					 </td>
					<td>${user.name}</td>
					<td>${user.gender}</td>
					<td>${user.city}</td>
					<td>
					     <a href="updateUserForm.do?id=${user.userId}">수정</a>
					</td>
					<td><a href="#" onclick="deleteUser('${user.userId}')">삭제</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
					<a href="insertUserForm.do">사용자 등록</a>
				</td>
			</tr>
		</tbody> 
	</table>
	</div>
</body>
</html>
```



```jsp
# userDetail.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 상세정보</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	    <h2 class="text-center">사용자 상세정보</h2>
		<table class="table table-bordered table table-hover">
			<tr><td>아이디 :</td><td>${user.userId}</td></tr>
			<tr><td>이름 :</td><td>${user.name}</td></tr>
			<tr><td>성별 :</td><td>${user.gender}</td></tr>
			<tr><td>거주지 :</td><td>${user.city}</td></tr>
		</table>
	</div>
</body>
</html>
```



```java
# UserServlet.java

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.user.dao.UserDAO;
import jdbc.user.vo.UserVO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("*.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
	
	private RequestDispatcher rd;
	
	@Override
	public void init() throws ServletException {
		System.out.println("UserServlet init() method called!");
		dao = new UserDAO();
	}
	
	@Override
	public void destroy() {
		System.out.println("UserServlet destroy() method called!");
	}
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public UserServlet() {
//        super();
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet doGet() method called!" + request.getMethod());
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//요청(request) 데이터의 인코딩(getParameter를 하기전에 해야한다.요청데이터에 한글이 있을 수 있기 때문에.)
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd"); //cmd라는 단어의 userDetail, userList가 온다. 분기처리 한다.
		System.out.println(">>>>>>>command : " + cmd);
		if(cmd.equals("userList")) {
			userList(request, response);
		}
		else if(cmd.equals("userDetail")) {
			userDetail(request, response);
		}
		else if(cmd.equals("userForm")) {
			userForm(request, response);
		}
		else if(cmd.equals("userInsert")) {
			userInsert(request, response);
		}
	}
	
	
	private void userInsert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//1. form data를 추출해서 UserVO에 저장한다. 
		UserVO user = new UserVO(request.getParameter("userid"),
								 request.getParameter("name"), 
								 request.getParameter("gender").charAt(0), 
								 request.getParameter("city"));
		System.out.println(user);
		//2. DAO의 InserUser() 메서드 호출
		int cnt = dao.insertUser(user);
		if(cnt==1) { // 등록 성공
			userList(request, response);
		}
	}
	
	
	private void userForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//객체를 넘기지 않고 해당페이지로만 포워딩하는 것
		response.sendRedirect("userForm.html");
		
	}

	
	
	private void userDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userid = request.getParameter("id");
		System.out.println(">>>>>>userid : " + userid);
		
		//1. DAO 호출
		UserVO userVO = dao.getUser(userid);
		//2. DAO로 받아온 List 객체를 JSP에서 사용할 수 있도록 reguest 객체를 저장한다.
		request.setAttribute("user", userVO);
		//3. 결과를 출력해줄 JSP - UserList.jsp를 포워딩(브라우저에 찍어보기)
		rd = request.getRequestDispatcher("userDetail.jsp");
		rd.forward(request, response);
	}
	
	

	private void userList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. DAO 호출
		List<UserVO> users = dao.getUsers();
		//2. DAO로 받아온 List 객체를 JSP에서 사용할 수 있도록 reguest 객체를 저장한다.
		request.setAttribute("userList", users);
		//3. 결과를 출력해줄 JSP - UserList.jsp를 포워딩(브라우저에 찍어보기)
		rd = request.getRequestDispatcher("userList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("UserServlet doPost() method called!" + request.getMethod());
		doGet(request, response);
	}

}
```



---



#### 사용자 등록해보기

![캡처](https://user-images.githubusercontent.com/42603919/79703874-73340000-82e9-11ea-8128-e30ebd1fb689.PNG)





**insert.jsp -> Controller 과정 : **

- 등록된 form data를 추출해서 VO에 저장한다.(**@ModelAttribute**)
  - **@ModelAttribute** : HTTP 요청에 포함된 파라미터를 모델 객체로 바인딩
- DAO를 호출하면서 인자로 VO를 전달 -> DB에 저장(등록)
- 사용자 목록(userList) 페이지로 포워딩(등록됐다는 것을 리스트에서 확인)



**한글 깨짐 처리하기**

servlet으로 할려면 => request.setCharacterEncoding("utf-8");이 있다.(예전에 수업했을 때)

이번에는 인코딩 filter를 가지고 한글 깨짐을 처리한다.

-> CharacterEncodingFilter를 사용하면 된다.

---

**charset=UTF-8 vs CharacterEncodingFilter**

- **charset=UTF-8** : 
  - **응답 데이터에 대한 인코딩**
  - servlet으로 할려면 => responset.setContentType("text/html; charset=utf-8");
  - 페이지 별로 각각 적용해야한다.

- **CharacterEncodingFilter** : 

  - **요청 데이터에 대한 인코딩**

  - servlet으로 할려면 =>  request.setCharacterEncoding("utf-8");

  - Servlet Filter(공통적으로 사용되는 기능을 포함한 객체)로 구현

    - Spring에서 CharacterEncodingFilter 클래스를 제공한다.

    - **web.xml에 Filter를 설정**해야한다. -> **설정한 후 서버 restart**

      - ```xml
        <filter>
        	<filter-name>CharacterEncodingFilter</filter-name>
        	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-name>
        </filter>
        
        <filter-mapping>
        	<filter-name>CharacterEncodingFilter</filter-name>
        	<url-pattern>*.do<url-pattern>
        </filter-mapping>
        ```

        

```java
# UserController.java

package myspring.user.controller;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// 사용자 목록 조회
	@RequestMapping("/userList.do")
	public ModelAndView userList() {
		List<UserVO> userList = userService.getUserList();

//		//2. DAO로 받아온 List 객체를 JSP에서 사용할 수 있도록 reguest 객체를 저장한다.
//		request.setAttribute("userList", users);
//		//3. 결과를 출력해줄 JSP - UserList.jsp를 포워딩(브라우저에 찍어보기)
//		rd = request.getRequestDispatcher("userList.jsp");
//		rd.forward(request, response);
		// 위의 코드를 다음과 같이 표시할 수 있다.
		return new ModelAndView("userList.jsp", "userList", userList);
	}

	// 사용자 상세정보 조회
	@RequestMapping("/userDetail.do")
	// @RequestParam : request.getParameter()와 동일하다.
	public String userDetail(@RequestParam String userid, Model model) {
		UserVO user = userService.getUser(userid);
		model.addAttribute("user", user);
		return "userDetail.jsp";
	}

	// 사용자 등록Form 조회
	@RequestMapping("/userInsertForm.do")
	public String insertUserForm(HttpSession session) {
		List<String> genderList = new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");
		
		//session에 genderList를 저장해보기
		session.setAttribute("genderList", genderList);

		List<String> cityList = new ArrayList<String>();
		cityList.add("서울");
		cityList.add("경기");
		cityList.add("부산");
		cityList.add("대구");
		cityList.add("제주");
		
		//session에 cityList를 저장해보기
		session.setAttribute("cityList", cityList);

		//session에 저장했기 때문에 Map은 필요없다.
//		Map<String, List<String>> map = new HashMap<>();
//		map.put("genderList", genderList);
//		map.put("cityList", cityList);

		return "userInsert.jsp";
	}
	
	//사용자 등록 처리
	//post방식이기 때문에 다음과 같이 사용해야한다. method 언급을 안하게 되면 get으로 인식
	//<form method="post" action="userInsert.do" >
	//value = "/userInsert.do",method = RequestMethod.POST
	@RequestMapping(value = "/userInsert.do",method = RequestMethod.POST)
	public String userInsert(@ModelAttribute UserVO user) {
		System.out.println(">>> UserVO " + user);
		userService.insertUser(user);
		//사용자 목록 조회를 처리하는 요청으로 포워딩을 하겠다.(사용자 목록 페이지로 포워딩)
		return "redirect:/userList.do";
	}
}
```



```jsp
# userList.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>사용자 관리</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function deleteUser(userId){
		var result = confirm(userId +" 사용자를 정말로 삭제하시겠습니까?");
		if(result) {
			location.href = "deleteUser.do/"+userId;
		}
	}
</script>

</head>
<body>
	<div class="container">
		<h2 class="text-center">사용자 목록</h2>
		<table class="table table-bordered table table-hover"> 
			<thead> 
				<tr> 
					<th>아이디</th> 
					<th>이름</th> 
					<th>성별</th>
					<th>거주지</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr> 
		</thead> 
		<tbody> 
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>
					 	<a href="userDetail.do?userid=${user.userId}">${user.userId}</a>
					 </td>
					<td>${user.name}</td>
					<td>${user.gender}</td>
					<td>${user.city}</td>
					<td>
					     <a href="updateUserForm.do?id=${user.userId}">수정</a>
					</td>
					<td><a href="#" onclick="deleteUser('${user.userId}')">삭제</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
					<a href="userInsertForm.do">사용자 등록</a>
				</td>
			</tr>
		</tbody> 
	</table>
	</div>
</body>
</html>
```



```jsp
# userInsert.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>사용자 정보 등록</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">사용자 정보 등록</h2>
		<div>
			<form method="post" action="userInsert.do" >
				<table  class="table table-bordered table table-hover">
					<tr>
						<td>아이디 :</td>
						<td><input type="text" name="userId"  /></td>
					</tr>
					<tr>
						<td>이름 :</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>성별 :</td>
						<%--EL에서 sessionScope은 session객체라고 생각하면 된다. --%>
						<td><c:forEach var="genderName" items="${sessionScope.genderList}">
									<input type="radio" name="gender" value="${genderName}">${genderName}
							  </c:forEach></td>
					</tr>
					<tr>
						<td>거주지 :</td>
						<td><select name="city">
								<c:forEach var="cityName" items="${sessionScope.cityList}">
									<option value="${cityName}">${cityName}</option>
								</c:forEach>
								</select></td>
					</tr>
					<tr>
					<td colspan="2"  class="text-center">
						<input type="submit" value="등록" /></td>
					</tr>
					<tr>					
						<td colspan="2" class="text-center"><a href="getUserList.do">사용자 목록보기</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
```



---



#### 사용자 삭제해보기

```xml
<url-pattern>/</url-pattern> <- userDelete.do/gildong과 같은 것을 처리하기 위해 사용
                                *.do는 처리를 못함.
```

![캡처](https://user-images.githubusercontent.com/42603919/79713730-a71f1d80-8309-11ea-95f9-462eadc00482.PNG)



- **@PathVariable** : 파라미터를 URL 형식으로 받을 수 있도록 해준다.
  - userDetail.do?userid=gildong <= @RequestParam
  - userDetail/gildong <= **@PathVariable**



```xml
# web.xml

<!-- 다음과 같이 변경 -->
<!-- Map all requests to the DispatcherServlet for handling -->
<servlet-mapping>
	<servlet-name>springDispatcherServlet</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>
```



#### default-servlet-handler 태그를 설정하는 이유

```xml
DispatcherServlet은 url-pattern을 "/" 와 같이 설정하게 되면서
tomcat의 web.xml에 정의되어 있는 url-pattern "/"을 무시하게 된다.(충돌발생)
결국 DispatcherServlet url-pattern을 재정의하게 되어서
DefaultServlet은 더 이상 동작할 수 없게 된 것이다.
Spring에서는 이를 해결하기 위해서
<mvc:default-servlet-handler/> 설정을 지원한다.
```



#### XML, JSON Data Support

```xml
Spring MVC에 필요한 Bean들을 자동으로 등록해주는 태그
annotation-driven 태그가 JSON과 관련하여 내부적으로 처리하는 설정
<mvc:annotation-driven></mvc:annotation-driven>
```



#### 새로운 spring_beans_web.xml 생성하기

![캡처](https://user-images.githubusercontent.com/42603919/79714152-e7cb6680-830a-11ea-9b62-a2df3696b3d4.PNG)



```xml
# spring_beans_web.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context-4.3.xsd
		http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd">
	
	<!-- DispatcherServlet의 url-pattern과 DefaultServlet의 url-pattern 충돌문제 해결해 주는 설정 -->
	<mvc:default-servlet-handler/>
	<!-- XML, JSON Data Support -->
	<mvc:annotation-driven />
</beans>
```



```java
# UserController.java

package myspring.user.controller;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// 사용자 목록 조회
	@RequestMapping("/userList.do")
	public ModelAndView userList() {
		List<UserVO> userList = userService.getUserList();

//		//2. DAO로 받아온 List 객체를 JSP에서 사용할 수 있도록 reguest 객체를 저장한다.
//		request.setAttribute("userList", users);
//		//3. 결과를 출력해줄 JSP - UserList.jsp를 포워딩(브라우저에 찍어보기)
//		rd = request.getRequestDispatcher("userList.jsp");
//		rd.forward(request, response);
		// 위의 코드를 다음과 같이 표시할 수 있다.
		return new ModelAndView("userList.jsp", "userList", userList);
	}

	// 사용자 상세정보 조회
	@RequestMapping("/userDetail.do")
	// @RequestParam : request.getParameter()와 동일하다.
	public String userDetail(@RequestParam String userid, Model model) {
		UserVO user = userService.getUser(userid);
		model.addAttribute("user", user);
		return "userDetail.jsp";
	}

	// 사용자 등록Form 조회
	@RequestMapping("/userInsertForm.do")
	public String insertUserForm(HttpSession session) {
		List<String> genderList = new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");
		
		//session에 genderList를 저장해보기
		session.setAttribute("genderList", genderList);

		List<String> cityList = new ArrayList<String>();
		cityList.add("서울");
		cityList.add("경기");
		cityList.add("부산");
		cityList.add("대구");
		cityList.add("제주");
		
		//session에 cityList를 저장해보기
		session.setAttribute("cityList", cityList);

		//session에 저장했기 때문에 Map은 필요없다.
//		Map<String, List<String>> map = new HashMap<>();
//		map.put("genderList", genderList);
//		map.put("cityList", cityList);

		return "userInsert.jsp";
	}
	
	//사용자 등록 처리
	//post방식이기 때문에 다음과 같이 사용해야한다. method 언급을 안하게 되면 get으로 인식
	//<form method="post" action="userInsert.do" >
	//value = "/userInsert.do",method = RequestMethod.POST
	@RequestMapping(value = "/userInsert.do",method = RequestMethod.POST)
	public String userInsert(@ModelAttribute UserVO user) {
		System.out.println(">>> UserVO " + user);
		userService.insertUser(user);
		//사용자 목록 조회를 처리하는 요청으로 포워딩을 하겠다.(사용자 목록 페이지로 포워딩)
		return "redirect:/userList.do";
	}
	
	//사용자 삭제 처리
	@RequestMapping("/userDelete.do/{id}")
	public String userDelete(@PathVariable("id") String userid) {
		userService.deleteUser(userid);
		//사용자 목록 조회를 처리하는 요청으로 포워딩을 하겠다.(사용자 목록 페이지로 포워딩)
		return "redirect:/userList.do";
	}
}
```



```jsp
# userList.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>사용자 관리</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function deleteUser(userId){
		var result = confirm(userId +" 사용자를 정말로 삭제하시겠습니까?");
		if(result) {
			location.href = "userDelete.do/"+userId;
		}
	}
</script>

</head>
<body>
	<div class="container">
		<h2 class="text-center">사용자 목록</h2>
		<table class="table table-bordered table table-hover"> 
			<thead> 
				<tr> 
					<th>아이디</th> 
					<th>이름</th> 
					<th>성별</th>
					<th>거주지</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr> 
		</thead> 
		<tbody> 
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>
					 	<a href="userDetail.do?userid=${user.userId}">${user.userId}</a>
					 </td>
					<td>${user.name}</td>
					<td>${user.gender}</td>
					<td>${user.city}</td>
					<td>
					     <a href="updateUserForm.do?id=${user.userId}">수정</a>
					</td>
					<td><a href="#" onclick="deleteUser('${user.userId}')">삭제</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
					<a href="userInsertForm.do">사용자 등록</a>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
</body>
</html>
```



---



#### 사용자 수정해보기

```java
# UserController.java

package myspring.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// 사용자 목록 조회
	@RequestMapping("/userList.do")
	public ModelAndView userList() {
		List<UserVO> userList = userService.getUserList();

//		//2. DAO로 받아온 List 객체를 JSP에서 사용할 수 있도록 reguest 객체를 저장한다.
//		request.setAttribute("userList", users);
//		//3. 결과를 출력해줄 JSP - UserList.jsp를 포워딩(브라우저에 찍어보기)
//		rd = request.getRequestDispatcher("userList.jsp");
//		rd.forward(request, response);
		// 위의 코드를 다음과 같이 표시할 수 있다.
		return new ModelAndView("userList", "userList", userList);
	}

	// 사용자 상세정보 조회
	@RequestMapping("/userDetail.do")
	// @RequestParam : request.getParameter()와 동일하다.
	public String userDetail(@RequestParam String userid, Model model) {
		UserVO user = userService.getUser(userid);
		model.addAttribute("user", user);
		return "userDetail";
	}

	// 사용자 등록Form 조회
	@RequestMapping("/userInsertForm.do")
	public String insertUserForm(HttpSession session) {
		List<String> genderList = new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");

		// session에 genderList를 저장해보기
		session.setAttribute("genderList", genderList);

		List<String> cityList = new ArrayList<String>();
		cityList.add("서울");
		cityList.add("경기");
		cityList.add("부산");
		cityList.add("대구");
		cityList.add("제주");

		// session에 cityList를 저장해보기
		session.setAttribute("cityList", cityList);

		// session에 저장했기 때문에 Map은 필요없다.
//		Map<String, List<String>> map = new HashMap<>();
//		map.put("genderList", genderList);
//		map.put("cityList", cityList);

		return "userInsert";
	}

	// 사용자 등록 처리
	// post방식이기 때문에 다음과 같이 사용해야한다. method 언급을 안하게 되면 get으로 인식
	// <form method="post" action="userInsert.do" >
	// value = "/userInsert.do",method = RequestMethod.POST
	@RequestMapping(value = "/userInsert.do", method = RequestMethod.POST)
	public String userInsert(@ModelAttribute UserVO user) {
		System.out.println(">>> UserVO " + user);
		userService.insertUser(user);
		// 사용자 목록 조회를 처리하는 요청으로 포워딩을 하겠다.(사용자 목록 페이지로 포워딩)
		return "redirect:/userList.do";
	}

	// 사용자 삭제 처리
	@RequestMapping("/userDelete.do/{id}")
	public String userDelete(@PathVariable("id") String userid) {
		userService.deleteUser(userid);
		// 사용자 목록 조회를 처리하는 요청으로 포워딩을 하겠다.(사용자 목록 페이지로 포워딩)
		return "redirect:/userList.do";
	}

	// 사용자 수정Form 조회
	@RequestMapping("/userUpdateForm.do")
	public String updateUserForm(@RequestParam String userid, HttpSession session) {
		UserVO user = userService.getUser(userid);
		List<String> genderList = new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");
		session.setAttribute("genderList", genderList);

		List<String> cityList = new ArrayList<String>();
		cityList.add("서울");
		cityList.add("부산");
		cityList.add("경기");
		cityList.add("대구");
		cityList.add("제주");
		session.setAttribute("cityList", cityList);

		session.setAttribute("user", user);
		return "userUpdate";

	}

	// 사용자 수정 처리
	@RequestMapping(value = "/userUpdate.do", method = RequestMethod.POST)
	public String userUpdate(@ModelAttribute UserVO user) {
		System.out.println(">>> UserVO " + user);
		userService.updateUser(user);
		// 사용자 목록 조회를 처리하는 요청으로 포워딩을 하겠다.(사용자 목록 페이지로 포워딩)
		return "redirect:/userList.do";
	}

	/*
	 * // 사용자 수정Form 조회
	 * 
	 * @RequestMapping("/userUpdateForm.do") public ModelAndView
	 * updateUserForm(@RequestParam String userid) { UserVO user =
	 * userService.getUser(userid); List<String> genderList = new
	 * ArrayList<String>(); genderList.add("남"); genderList.add("여"); List<String>
	 * cityList = new ArrayList<String>(); cityList.add("서울"); cityList.add("부산");
	 * cityList.add("대구"); cityList.add("제주"); Map<String, Object> map = new
	 * HashMap<String, Object>(); map.put("genderList", genderList);
	 * map.put("cityList", cityList); map.put("user", user); return new
	 * ModelAndView("userUpdate", "map", map); }
	 * 
	 * // 사용자 수정 처리
	 * 
	 * @RequestMapping(value = "/userUpdate.do", method = RequestMethod.POST) public
	 * String userUpdate(@ModelAttribute UserVO user) {
	 * System.out.println(">>> UserVO " + user); userService.updateUser(user); ; //
	 * 사용자 목록 조회를 처리하는 요청으로 포워딩을 하겠다.(사용자 목록 페이지로 포워딩) return
	 * "redirect:/userList.do"; }
	 */

}
```



```jsp
# userList.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>사용자 관리</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function deleteUser(userId){
		var result = confirm(userId +" 사용자를 정말로 삭제하시겠습니까?");
		if(result) {
			location.href = "userDelete.do/"+userId;
		}
	}
</script>

</head>
<body>
	<div class="container">
		<h2 class="text-center">사용자 목록</h2>
		<table class="table table-bordered table table-hover"> 
			<thead> 
				<tr> 
					<th>아이디</th> 
					<th>이름</th> 
					<th>성별</th>
					<th>거주지</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr> 
		</thead> 
		<tbody> 
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>
					 	<a href="userDetail.do?userid=${user.userId}">${user.userId}</a>
					 </td>
					<td>${user.name}</td>
					<td>${user.gender}</td>
					<td>${user.city}</td>
					<td>
					     <a href="userUpdateForm.do?userid=${user.userId}">수정</a>
					</td>
					<td><a href="#" onclick="deleteUser('${user.userId}')">삭제</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
					<a href="userInsertForm.do">사용자 등록</a>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
</body>
</html>
```



```jsp
# userUpdate.jsp
# map으로 하게 되면 sessionScope부분을 map으로 바꿔준다.

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>사용자 정보 수정</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<h2 class="text-center">사용자 정보 수정</h2>
		<div>
			<form method="post" action="userUpdate.do">
				<input type="hidden" name="userId"  value="${sessionScope.user.userId}" />
				<table class="table table-bordered table table-hover">
					<tr>
						<td>아이디 :</td>
						<td>${sessionScope.user.userId}</td>
					</tr>
					<tr>
						<td>이름 :</td>
						<td><input type="text" name="name" value="${sessionScope.user.name}" />
						</td>
					</tr>
					<tr>
						<td>성별 :</td>
						<td>
								<c:forEach items='${sessionScope.genderList}' var='genderName'>
									<c:choose>
										<c:when test="${genderName eq sessionScope.user.gender}">
											<input type="radio" name="gender" value="${genderName}"
												checked="checked">${genderName}
										</c:when>
										<c:otherwise>
											<input type="radio" name="gender" value="${genderName}">${genderName}
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</td>
					</tr>
					<tr>
						<td>거주지 :</td>
						<td>
								<select name="city">
									<c:forEach items='${sessionScope.cityList}' var='cityName'>
										<c:choose>
											<c:when test="${cityName eq sessionScope.user.city}">
												<option value="${cityName}" selected>${cityName}</option>
											</c:when>
											<c:otherwise>
												<option value="${cityName}">${cityName}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center"><input type="submit" value="수정" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>


```



---



#### web쪽으로 관련된 것(front controller)을 spring_beans_web.xml으로 빼보자

#### spring_beans.xml은 backend 쪽만 남도록

 ```xml
# spring_beans.xml
# exclude

	<!-- 상위 인터페이스로 설정 -->
	<!-- Component Auto Scanning 설정 -->
	<context:component-scan base-package="myspring.user">
		<!-- @Controller 어노테이션을 선언한 컴포넌트는 제외하겠다. -->
		<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
	</context:component-scan>
 ```



```xml
# spring_beans_web.xml
# include

	<!-- 상위 인터페이스로 설정 -->
	<!-- Component Auto Scanning 설정 -->
	<context:component-scan base-package="myspring.user">
		<!-- @Controller 어노테이션을 선언한 컴포넌트만 포함하겠다. -->
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller" />
	</context:component-scan>
```



```xml
# web.xml
# front controller 부분이기 때문에 spring_beans_web.xml에만 알려주면 된다.

	<!-- The front controller of this Spring Web application, responsible for 
		handling all application requests -->
	<servlet>
		<servlet-name>springDispatcherServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:config/spring_beans_web.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
```



---



#### 확장명 생략해보기

> 확장명 생략한 것을 spring_beans_web.xml에 알려주기

```xml
# spring_beans_web.xml

	<!-- JSP 확장명 생략할 수 있는 설정 -->
	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/" />
		<property name="suffix" value=".jsp" />
	</bean>
```

---

























