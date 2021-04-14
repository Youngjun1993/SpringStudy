<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<style>
	ul, li{list-style: none; margin: 0; padding: 0;}
	.claseList li{float:left; width:10%; height:40px; line-height: 40px; border-bottom:1px solid #ddd;}
	.claseList li:nth-child(5n+2){width:60%;}
	.wordcut{white-space: nowrap; overflow: hidden; text-overflow: ellipsis;}
</style>
</head>
<body>
	<div class="container">
		<h1>답변형 게시판 리스트</h1>
		<a href="claseWrite">글쓰기</a>
		<ul class="claseList">
			<li>번호</li>
			<li><a href="">제목</a></li>
			<li>글쓴이</li>
			<li>등록일</li>
			<li>조회수</li>
			
				<li>번호</li>
				<li class="wordcut"><a href="">제목</a></li>
				<li>글쓴이</li>
				<li>등록일</li>
				<li>조회수</li>
		</ul>
	</div>
</body>
</html>