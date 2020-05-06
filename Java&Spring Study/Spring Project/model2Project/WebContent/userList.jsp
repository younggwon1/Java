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