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
	ul, li{margin:0; padding:0; list-style:none;}
	li{float:left; width:10%;, height:40px; line-height:40px; border-bottom:1px solid lightblue;}
	li:nth-child(5n+2){width:60%;}
	.clearfix:after{
		content:"";
		display:block;
		clear:both;
	}
	.wordcut{white-space: nowrap; overflow: hidden; text-overflow: ellipsis;}
	[href="write"]{
		display:block;
		float:left;
		
	}
	#listFrm{
		float:right;
		margin-bottom: 20px;
	}
</style>
<script>
	$(function(){
		//전체선택 선택시 모든 체크박스 체크
		$("#listAllCheck").click(function(){
			$("#boardList input[type=checkbox]").prop("checked", $("#listAllCheck").prop("checked"));
		});
		//선택삭제 클릭시
		$("#delSelect").click(()=>{
			$("#delList").submit();
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h1>Oracle Mybatis no XML 리스트</h1>
		<div class="clearfix">
			<c:if test="${logStatus=='Y' }">
				<a href="write">글쓰기</a>
			</c:if>
			<form id="listFrm" method="post" action="searchList">
				<select name="searchKey" id="searchKey">
					<option value="subject">제목</option>
					<option value="userid">작성자</option>
					<option value="content">글내용</option>
				</select>
				<input type="text" name="searchWord" id="searchWord" />
				<input type="submit" value="search"/>
			</form>
		</div>
		
		<input type="checkbox" id="listAllCheck"/>전체선택
		<input type="button" value="선택삭제" id="delSelect"/>
		
		<ul id="boardList" class="clearfix">
			<li>번호</li>
			<li>제목</li>
			<li>작성자</li>
			<li>등록일</li>
			<li>조회수</li>
			<form method="post" id="delList" action="multiDel">		
				<c:forEach var="vo" items="${list }">
					<li><input type="checkbox" name="noList" value="${vo.no }"> ${vo.no }</li>
					<li class="wordcut"><a href="view?no=${vo.no }">${vo.subject }</a></li>
					<li>${vo.userid }</li>
					<li>${vo.writedate }</li>
					<li>${vo.hit }</li>
				</c:forEach>
			</form>
		</ul>
	</div>
</body>
</html>