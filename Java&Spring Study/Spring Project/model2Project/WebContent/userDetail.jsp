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