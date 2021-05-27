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
<script>
	$(()=>{
		$("#boardDel").click(()=>{
			if(confirm("삭제할까요?")){
				location.href="boardDel?no=${vo.no}";
			}
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h1>글내용보기</h1>
		<ul>
			<li>번호 : ${vo.no }</li>
			<li>작성자 : ${vo.userid }</li>
			<li>작성일 : ${vo.writedate }</li>
			<li>조회수 : ${vo.hit }</li>
			<li>제목 : ${vo.subject }</li>
			<li>글내용<br/>${vo.content }</li>
		</ul>
		<div>
			<c:if test="${logId==vo.userid }">
				<a href="boardEdit?no=${vo.no }">수정</a>
				<a href="#" id="boardDel">삭제</a>
			</c:if>
		</div>
	</div>
</body>
</html>