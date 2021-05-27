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
	function claseDelCheck(){
		if(confirm("삭제하시겠습니까")){
			location.href="claseDel?no=${dto.no}";
		}
	}
</script>
</head>
<body>
	<div class="container">
		<h1>답변형게시판 글내용보기</h1>
		<ul>
			<li>번호 : ${dto.no }</li>
			<li>작성자 : ${dto.userid }</li>
			<li>등록일 : ${dto.writedate }, 조회수 : ${dto.hit }</li>
			<li>제목 : ${dto.subject }</li>
			<li>글내용 : ${dto.content }</li>
		</ul>
		<div>
			<a href="claseEdit?no=${dto.no }">수정</a>
			<a href="javascript:claseDelCheck()">삭제</a>
			<a href="claseWriteForm?no=${dto.no }">답글</a> <!-- dto.no가 원글 글번호다. -->
		</div>
		<c:if test="${nextPre.step==0 }">
			<div>
				<ul>
					<li>
						이전글 <c:if test="${nextPre.next_subject!='null'}"><a href="claseView?no=${nextPre.next_no }">${nextPre.next_subject }</a></c:if>
							 <c:if test="${nextPre.next_subject=='null'}">이전글이없습니다.</c:if>
					</li>
					<li>
						다음글 <c:if test="${nextPre.pre_subject!='null'}"><a href="claseView?no=${nextPre.pre_no }">${nextPre.pre_subject }</a></c:if>
							 <c:if test="${nextPre.pre_subject=='null'}">다음글이없습니다.</c:if>
					
					</li>
				</ul>
			</div>
		</c:if>
	</div>
</body>
</html>