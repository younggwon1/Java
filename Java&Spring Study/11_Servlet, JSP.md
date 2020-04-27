# Servlet, JSP



### 리뷰

- J2EE(Enterprise Edition) 기술
  
- J2EE가 제공하는 API에는 대부분이 인터페이스로 구성되어 있다.
  - 인터페이스들은 WAS Vender가 구현한다.
    - WAS : web container + ejb container
  
  - Servlet, JSP(Java Server page), JSTL(Java Standard Tag Library)
  
- Spring MVC 구조와 핵심 컴포넌트



---



### J2EE 기술중에서 Servlet, JSP(java server page, JSTL(java standard tag library))

- Tomcat(web container라고 부른다.) 서버에서 동작한다.(서버가 필요하다.)

- Servlet은 클래스, JSP는 스크립트

- JSP와 비슷한 종류는 php, asp

- html, css, javascript : 정적인(static) 컨텐츠 생산

  - html 에서 UserDAO(DB 연동) 객체의 method를 호출(x)

- Servlet, JSP : 동적인(dynamic) 컨텐츠 생산
  
- **Servlet** : java code 내에 html을 포함시킬 수 있다. 컴파일 방식
  
  - **JSP** : html 내에 java code를 포함시킬 수 있다. 스크립트 방식
  
  - **html -> servlet, JSP -> DAO객체**
  
- **MVC 패턴**

  - **Model, View, Controller**의 약자

  - Separation of Concerns(=Responsibility 책임, 역할) <- 역할을 분리(유지보수 원활)

  - MVC 패턴을 기반으로 하는 web architecture

    - model 1 아키텍쳐

      ```
      Model : java(DAO, Server, VO)
      View : JSP, HTML
      Controller(Model과 View를 연결) : JSP 
      ```

    - model 2 아키텍쳐

      ```
      Model : java(DAO, Server, VO)
      View : JSP, HTML
      Controller(Model과 View를 연결) : Servlet
      
      Spring MVC는 Model 2 아키텍쳐이며 Front Controller 역할을 하는 DispatcherServlet 클래스를 제공한다.
      ```



---



### [실습] Dynamic web project

> ### **WebContent : jsp, html**
>
> ### **src : java 클래스 종류**(DAO, VO, Servlet)



**dynamic web project 생성하기**

<img src="https://user-images.githubusercontent.com/42603919/79406432-04e1fb80-7fd2-11ea-8d5f-8af4ca5b450e.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79406440-090e1900-7fd2-11ea-970c-4bc0465da164.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79406536-55f1ef80-7fd2-11ea-97b9-102bd6edddd4.PNG" alt="캡처" style="zoom:80%;" />



![캡처](https://user-images.githubusercontent.com/42603919/79406760-dd3f6300-7fd2-11ea-8367-2e06f96b34aa.PNG)

---

#### JSP 생성을 위한 설정

1. **Window -> Web browser -> Chrome (실행할 때 chrome으로 실행된다.)**

2. **UTF-8로 설정**

**Window -> Preferences**

<img src="https://user-images.githubusercontent.com/42603919/79407109-a453be00-7fd3-11ea-8064-0d98913b95c1.PNG" alt="캡처" style="zoom:80%;" />

3. **JSP 만들기**

**WebContent 우측버튼 -> new -> other**

<img src="https://user-images.githubusercontent.com/42603919/79407059-7f5f4b00-7fd3-11ea-8b13-4446d0b90fd6.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79407502-54c1c200-7fd4-11ea-9482-bbea3e2ce9d3.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79407601-6b681900-7fd4-11ea-8301-39169d49cbe0.PNG" alt="캡처" style="zoom:80%;" />



![캡처](https://user-images.githubusercontent.com/42603919/79407652-7ae76200-7fd4-11ea-83a9-5e34afa7c490.PNG)



```jsp
# index.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 관리 메인</h2>
	<!-- html 주석 -->
	<%-- jsp 주석 --%>
	<%-- <% %> : jsp안에 java code를 자유롭게 기술할 수 있는 영역 --%>
	<%-- <%= %> : java의 method의 실행결과, 변수를 출력 --%>
	<% 
		Date date = new Date();
		out.println(date);
	%>
	
	<h4>현재 날짜는<%=date %></h4>
</body>
</html>
```

4. **tomcat에  배포하기**

**tomcat 우측버튼 클릭 -> add and remove**

<img src="https://user-images.githubusercontent.com/42603919/79408214-c64e4000-7fd5-11ea-8b31-34fce892e3b3.PNG" alt="캡처" style="zoom:80%;" />



#### RUN하기

**JSP file 우측버튼 -> run as -> run on server**

<img src="https://user-images.githubusercontent.com/42603919/79408257-e2ea7800-7fd5-11ea-97fa-8cbe26476804.PNG" alt="캡처" style="zoom:80%;" />



#### 실행결과

<img src="https://user-images.githubusercontent.com/42603919/79408408-3a88e380-7fd6-11ea-983d-385391d1677c.PNG" alt="캡처" style="zoom:80%;" />



---



### 위의 과정을 Servlet으로 해보자

**src 우측버튼-> new -> other**

<img src="https://user-images.githubusercontent.com/42603919/79413589-50e96c00-7fe3-11ea-8de4-3c0ac7cabce3.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79413606-5ba40100-7fe3-11ea-9e7e-249fd95b6f4c.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79413633-71192b00-7fe3-11ea-874e-2dfee5ca1a42.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79413701-9e65d900-7fe3-11ea-9434-c1b69fb981c2.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79413710-a756aa80-7fe3-11ea-9e8c-4f336f841ec0.PNG" alt="캡처" style="zoom:80%;" />



```java
# HelloServlet.java

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * request : 요청, response : 응답
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//1. Content type 설정 - Mime type, encoding
		response.setContentType("text/html;charset=utf-8");
		//2. 출력 스트림 생성
		PrintWriter out = response.getWriter();
		//3. html 생성
		Date date = new Date();
		out.println("<h2>현재 날짜는" + date + "</h2>");
		out.println("Http Method : " + request.getMethod());
		//출력 스트림 종료
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

```



---



### 어노테이션으로 하는 것이 아니라 xml로 작성해보기(@WebServlet("/hello") 대신)



```java
# HelloServlet.java

//@WebServlet("/hello") <- 주석처리
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
```



```xml
# web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
  <display-name>model2Project</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  
  <!-- 추가한 부분 -->
  <servlet>
  	<servlet-name>HelloServlet</servlet-name>
  	<servlet-class>controller.HelloServlet</servlet-class>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>HelloServlet</servlet-name>
  	<url-pattern>/hello</url-pattern>
  </servlet-mapping>
    
</web-app>
```



---



### DB와 연동할 수 있는 클래스 만들어서 웹 브라우저에 띄어보기

![캡처](https://user-images.githubusercontent.com/42603919/79419908-ba24ab80-7ff2-11ea-9c18-ed5de4377139.PNG)

**흐름 : index.jsp에서 user.servlet을 호출한다. 그리고 user.servlet에서 dao를 부르고 db에 접속한다.(JDBC : DB 데이터 조회) db에서 받아온 것을 dao로 전달하고 dao한테 받아온 list를 userlist.jsp에 전달해야한다. 따라서 userlist.jsp에서 for문을 돌려 출력되게한다. 따라서 데이터를 받기 위해서는 controller를 통해서 가져와야한다.**



<img src="https://user-images.githubusercontent.com/42603919/79418404-8431f800-7fef-11ea-8e6f-f3bc2e4a0493.PNG" alt="캡처" style="zoom:80%;" />



### Servlet 생성

<img src="https://user-images.githubusercontent.com/42603919/79418632-13d7a680-7ff0-11ea-994f-a78b46146120.PNG" alt="캡처" style="zoom:80%;" />



![캡처](https://user-images.githubusercontent.com/42603919/79418683-32d63880-7ff0-11ea-91b6-863dd0c39084.PNG)



#### Life Cycle 확인해보기

```java
# UserServlet.java

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.user.dao.UserDAO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("*.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("UserServlet init() method called!");
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
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("UserServlet doGet() method called!");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

```



### console에 찍어보기

```
List<UserVO> users = dao.getUsers();
System.out.println(users); //console에 찍어보기
```



```java
# UserServlet.java

package controller;

import java.io.IOException;
import java.util.List;

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
    
    <!--추가-->
	private UserDAO dao;
	
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
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("UserServlet doGet() method called!");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        
        <!--추가-->
		List<UserVO> users = dao.getUsers();
		System.out.println(users); //console에 찍어보기
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

```



### 브라우저에 찍어보기

- **request.setAttribute()** 
  - DAO로 받아온 List 객체를 JSP에서 사용할 수 있도록 reguest 객체를 저장한다. 정보를 입력할 수 있다.
- **request.getRequestDispatcher()**
  - 결과를 출력해줄 JSP - UserList.jsp를 포워딩

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
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("UserServlet doGet() method called!");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
```



### userList.jsp 생성하기

<img src="https://user-images.githubusercontent.com/42603919/79422485-eb53aa80-7ff7-11ea-9e8f-6ae5cade8f4d.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/79422504-f73f6c80-7ff7-11ea-89f5-f60ac5420bff.PNG" alt="캡처" style="zoom:80%;" />



### user.do를 치기 귀찮으니 index.jsp에 링크를 걸어 userList로 넘어갈 수 있도록 해보자

```jsp
# index.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 관리 메인</h2>
	<!-- html 주석 -->
	<%-- jsp 주석 --%>
	<%-- <% %> : jsp안에 java code를 자유롭게 기술할 수 있는 영역 --%>
	<%-- <%= %> : java의 method의 실행결과, 변수를 출력 --%>
	<% 
		Date date = new Date();
		out.println(date);
	%>
	
	<h4>현재 날짜는<%=date %></h4>
	
	
	<h2>사용자 관리 메인</h2>
	<ol>
		<li><a href="user.do">사용자 리스트</li>
	</ol>
</body>
</html>
```



- **request.getAttribute()**
  - Object Type이기 때문에 List<UserVO>를 통해 형변환을 해주어야 한다.
  - UserServlet.java가 포워딩한 정보를 **request.getAttribute()**를 통해서 받을 수 있다.

```jsp
# userList.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,jdbc.user.vo.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 리스트</h2>
	<%
		//1. request 객체에 저장된 리스트 객체를 가져오기
		List<UserVO> list = (List<UserVO>)request.getAttribute("userList");
    	out.println(list); //출력
	%>
</body>
</html>
```



#### JSTL

> jstl이란? JSP Standard Tag Library의 약어 
>
> 사용 목적 : 1. scriptless, jsp를 작성할 때 java code를 배제하기 위해서 사용(<% %>)



##### JSTL.jar파일 받아오기

<img src="https://user-images.githubusercontent.com/42603919/79428157-b861e480-8000-11ea-932f-a398eabce2f8.PNG" alt="캡처" style="zoom:80%;" />



```jsp
# userList.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 리스트</h2>
	<%--EL(Expression Langage --%>
	<%-- List<UserVO> list = (List<UserVO>)request.getAttribute("userList");
		와 같다. 출력까지 해준다.
	 --%>
	${userList}
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>주소</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.userid}</td>
				<td>${user.name}</td>
				<td>${user.gender}</td>
				<td>${user.city}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
```



#### 사용자 리스트 출력(이름을 누르면 상세페이지 나오게끔 구현해보기)

#### Servlet 분기 처리

<img src="https://user-images.githubusercontent.com/42603919/79522031-96ff0800-8095-11ea-9fbc-6791409318c0.PNG" alt="캡처" style="zoom:80%;" />

```jsp
# index.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 관리 메인</h2>
	<!-- html 주석 -->
	<%-- jsp 주석 --%>
	<%-- <% %> : jsp안에 java code를 자유롭게 기술할 수 있는 영역 --%>
	<%-- <%= %> : java의 method의 실행결과, 변수를 출력 --%>
	<% 
		Date date = new Date();
		out.println(date);
	%>
	
	<h4>현재 날짜는<%=date %></h4>
	<h2>사용자 관리 메인</h2>
	<ol>
		<li><a href="user.do?cmd=userList">사용자 리스트</a></li>
	</ol>
</body>
</html>
```



- if 문을 통해 **userList** , **userDetail** 중 어느 것을 정보를 요청했는지 파악
  - **userList**의 경우 **user List** 정보를 넘겨 주고, 화면에 **user id, user name** 이 출력된다.
  - **userDetail**의 경우 **user name**을 클릭 할 경우, 해당되는 **user id** 값을 **Console** 에 출력해준다.

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
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet doGet() method called!");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        
        
		String cmd = request.getParameter("cmd"); //cmd라는 단어의 userDetail, userList가 온다. 분기처리 한다.
		System.out.println(">>>>>>>command : " + cmd);
        
        
		if(cmd.equals("userList")) {
			userList(request, response);
		}
		else if(cmd.equals("userDetail")) {
			userDetail(request, response);
		}
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
```



```java
# UserDAO.java

package jdbc.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.user.vo.UserVO;

public class UserDAO {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String pass = "tiger";

	public UserDAO() {
		//1. Driver class loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loading OK!!");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	}
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
	
	public void close(Statement stmt, Connection con) throws SQLException {
		if (stmt != null) stmt.close();
		if (con != null) con.close();
	}
	
	//update 하는 메서드
	public int updateUser(UserVO user) {
		String sql = "update users set name = ?, gender = ?, city = ? where userid = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		int updateCnt = 0;
		try {
			con = getConnection();
			//auto commit 해제
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, Character.toString(user.getGender()));
			stmt.setString(3, user.getCity());
			stmt.setString(4, user.getUserid());
			updateCnt = stmt.executeUpdate();
			//커밋
			con.commit();
		}catch(SQLException e) {
			//롤백
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				close(stmt,con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updateCnt;
	}
	
	//userid를 입력 받아서 1개의 row를 반환하는 메서드
	public UserVO getUser(String userid) {
		String sql = "select * from users where userid = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		UserVO user = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userid);
			ResultSet rs =  stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO(rs.getString("userid"), 
						          rs.getString("name"), 
						          rs.getString("gender").charAt(0), 
						          rs.getString("city"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(stmt,con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
	//전체 row를 반환하는 메서드
	public List<UserVO> getUsers() {
		String sql = "select * from users order by userid";
		Connection con = null;
		PreparedStatement stmt = null;
		UserVO user = null;
		List<UserVO> userList = new ArrayList<>();
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet rs =  stmt.executeQuery();
			while(rs.next()) {
				user = new UserVO(rs.getString("userid"), 
						          rs.getString("name"), 
						          rs.getString("gender").charAt(0), 
						          rs.getString("city"));
				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(stmt,con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userList;
	}//getUserList
	
	
}

```



```jsp
# userList.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%-- <%@ page import="java.util.List,jdbc.user.vo.*" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 리스트</h2>
	<%--EL(Expression Langage --%>
	<%-- List<UserVO> list = (List<UserVO>)request.getAttribute("userList");
		와 같다. 출력까지 해준다.
	 --%>
	${userList}
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.userid}</td>
				<td><a href="user.do?id=${user.userid}&cmd=userDetail">${user.name}</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
	<%--
		//1. request 객체에 저장된 리스트 객체를 가져오기
		List<UserVO> list = (List<UserVO>)request.getAttribute("userList");
		
	--%>
</body>
</html>
```



```jsp
# userDetail.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 상세정보</h2>
	${user}
	<ul>
		<li>아이디 : ${user.userid}</li>
		<li>이름 : ${user.name}</li>
		<li>성별 : ${user.gender}</li>
		<li>주소 : ${user.city}</li>
	</ul>
</body>
</html>
```



#### 사용자 등록해보기

<img src="https://user-images.githubusercontent.com/42603919/79522118-d4639580-8095-11ea-8db0-71135137a4c6.PNG" alt="캡처" style="zoom:80%;" />



```jsp
# index.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html 주석 -->
	<%-- jsp 주석 --%>
	<%-- <% %> : jsp안에 java code를 자유롭게 기술할 수 있는 영역 --%>
	<%-- <%= %> : java의 method의 실행결과, 변수를 출력 --%>
	<%
		Date date = new Date();
		out.println(date);
	%>

	<h4>
		현재 날짜는<%=date%></h4>
	<h2>사용자 관리 메인</h2>
	<ol>
		
		<li><a href="user.do?cmd=userList">사용자 리스트</a></li>
		<li><a href="user.do?cmd=userForm">사용자 등록</a></li>
	</ol>
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



```java
# UserDAO.java

package jdbc.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.user.vo.UserVO;

public class UserDAO {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String pass = "tiger";

	public UserDAO() {
		//1. Driver class loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loading OK!!");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	}
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
	
	public void close(Statement stmt, Connection con) throws SQLException {
		if (stmt != null) stmt.close();
		if (con != null) con.close();
	}
	
	
	//Insert 하는 메서드
	public int insertUser(UserVO user) {
		String sql = "insert into users values(?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		int updateCnt = 0;
		try {
			con = getConnection();
			//auto commit 해제
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUserid());
			stmt.setString(2, user.getName());
			stmt.setString(3, Character.toString(user.getGender()));
			stmt.setString(4, user.getCity());
			updateCnt = stmt.executeUpdate();
			//커밋
			con.commit();
		}catch(SQLException e) {
			//롤백
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				close(stmt,con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCnt;
	}
	
	
	//update 하는 메서드
	public int updateUser(UserVO user) {
		String sql = "update users set name = ?, gender = ?, city = ? where userid = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		int updateCnt = 0;
		try {
			con = getConnection();
			//auto commit 해제
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, Character.toString(user.getGender()));
			stmt.setString(3, user.getCity());
			stmt.setString(4, user.getUserid());
			updateCnt = stmt.executeUpdate();
			//커밋
			con.commit();
		}catch(SQLException e) {
			//롤백
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				close(stmt,con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCnt;
	}
	
	//userid를 입력 받아서 1개의 row를 반환하는 메서드
	public UserVO getUser(String userid) {
		String sql = "select * from users where userid = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		UserVO user = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userid);
			ResultSet rs =  stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO(rs.getString("userid"), 
						          rs.getString("name"), 
						          rs.getString("gender").charAt(0), 
						          rs.getString("city"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(stmt,con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	//전체 row를 반환하는 메서드
	public List<UserVO> getUsers() {
		String sql = "select * from users order by userid";
		Connection con = null;
		PreparedStatement stmt = null;
		UserVO user = null;
		List<UserVO> userList = new ArrayList<>();
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet rs =  stmt.executeQuery();
			while(rs.next()) {
				user = new UserVO(rs.getString("userid"), 
						          rs.getString("name"), 
						          rs.getString("gender").charAt(0), 
						          rs.getString("city"));
				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(stmt,con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}//getUserList
	
	
}

```



```java
# UserVO.java

package jdbc.user.vo;
/**
 * VO(Value Object)
 * Java Beans, DTO(Data Transfer Object, Entity를 통칭해서 VO라고 한다.
 *	
 */

public class UserVO {
	private String userid;
	private String name;
	private char gender;
	private String city;

	public UserVO() {
	}

	public UserVO(String userid, String name, char gender, String city) {
		super();
		this.userid = userid;
		this.name = name;
		this.gender = gender;
		this.city = city;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", name=" + name + ", gender=" + gender + ", city=" + city + "]";
	}

	
}
```



```html
# userForm.html

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 등록</h2>
	<form action="user.do" method="post">
		<input type="hidden" name="cmd" value="userInsert"> 
		<lable>아이디 : </lable>
		<input type="text" name="userid"><br>
		
		<lable>이름 : </lable>
		<input type="text" name="name"><br>
		
		<lable>성별 : </lable>
		<input type="radio" name="gender" value="남">남
		<input type="radio" name="gender" value="여">여<br>
				
		<lable>주소 : </lable>
		<select name="city">
			<option value="">주소 선택</option>
			<option value="서울">서울</option>
			<option value="경기">경기</option>
			<option value="부산">부산</option>
			<option value="제주">제주</option>
		</select><br>
		
		<input type="submit" value="등록">
	</form>
</body>
</html>
```



## 시작은 index.jsp에서 run한다.

