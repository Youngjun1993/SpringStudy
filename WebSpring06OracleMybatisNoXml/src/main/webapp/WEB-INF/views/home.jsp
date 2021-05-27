<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
	
</head>
<body>
<h1>
	HOME
</h1>
<c:if test="${logStatus!='Y' }">
	<a href="loginForm">로그인</a>
</c:if>
<c:if test="${logStatus=='Y' }">
	${logName }님 <a href="logOut">로그아웃</a>
</c:if>
<a href="list">게시판</a>

</body>
</html>
