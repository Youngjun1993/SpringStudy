<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js_css/style.css" type="text/css"/>
	<script src="<%=request.getContextPath()%>/js_css/script.js"></script>
</head>
<body>
	<div>
		<!-- 			맵핑주소설정		 -->
		<a href="/myapp/aLink?name=홍길동&age=25">클릭하세요..1</a>
		<a href="/myapp/aLink2?name=이순신&age=30">클릭하세요..2</a>
		<a href="/myapp/aLink3?username=세종대왕&age=40">클릭하세요..3</a>
		<a href="/myapp/aLink4?username=장영실&age=50">클릭하세요..4</a><br/>
		<a href="/myapp/formData">클릭하세요..폼으로 이동</a>
	</div>
	
	<img src="<%=request.getContextPath()%>/img/1.png"/>
</body>
</html>
