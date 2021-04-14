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
	function boardDel(no){
		if(confirm("삭제하시겠습니까?")){
			location.href="boardDel?no=${vo.no}";
		}
	}
	$(function (){
		function replyList(){
			var url = "replyList";
			var params = "no=${vo.no}";
			$.ajax({
				url : url,
				data : params,
				success : function(result){
					var $result = $(result);
					
					var tag = "<ul>";
					$result.each(function(idx, obj){
						tag += "<li style = 'border-bottom:1px solid #000'><div>" + obj.userid + "(" + obj.replydate + ") ";
						
						if(obj.userid=="${logId}"){
							tag += "<input type='button' value='수정'/>";
							tag += "<input type='button' value='삭제' title='"+obj.num +"'/>";
						}
						tag += "<br/>" + obj.content + "</div>";
						
						if(obj.userid == "${logId}"){
							tag += "<div style=='display:none'>";
							tag += "<form method='post'>";
							tag += "<textarea name='content' style='width:500px; height:80px;'>"+obj.content+"</textarea>";
							tag += "<input type='submit' value='수정하기'/>";
							tag += "<input type='hidden' name='num' value='"+obj.num+"'/>";
							tag += "</form></div>";
						}
						tag += "</li>";
					});
					tag += "</ul>";
					
					$("#replyList").html(tag);
				}, error:function(){
					console.log('댓글 가져오기 에러');
				}
			});
			
		}
		$("#replyWriteBtn").click(function(){
			if($("#content").val() != ''){
				var url = "replyWrite";
				var params = $("#replyWriteFrm").serialize();
					
				$.ajax({
					url : url,
					data : params,
					beforeSend : function(xmlHttpRequest){
						xmlHttpRequest.setRequestHeader("AJAX","true");
					},success : function(result){
						replyList();
						$("#content").val("");
					}, error:function(e){
						if(e.status==400){
							location.href=<%=request.getContextPath()%>+"/loginForm";
						}
						console.log(e.responseText);
					}
				});
				
			}else{
				alert("댓글을 입력후 저장하세요!!");
			}
		});
		$(document).on('submit', '#replyList form', function(){
			var url = "replyEdit";
			var params = $(this).serialize();
			
			$.ajax({
				url : url,
				data : params,
				type : "POST",
				beforeSend : function(xmlHttpRequest){
					xmlHttpRequest.setRequestHeader("AJAX","true");
				}, success : function(result){
					replyList();
				}, error:function(e){
					if(e.status==400){
						location.href=<%=request.getContextPath()%>+"/loginForm";
					}
					console.log(e.responseText);
				}
			});
			
		});
		
		$(document).on('click', '#replyList input[value=삭제]', function(){
			if(confirm('삭제하시겠습니까?')){
				var url="replyDel";
				console.log($(this).attr("title"));
				var params = "num="+$(this).attr("title");
				
				$.ajax({
					url : url,
					data : params,
					beforeSend : function(xmlHttpRequest){
						xmlHttpRequest.setRequestHeader("AJAX","true");
					}, success : function(result){
						replyList();
					}, error:function(e){
						if(e.status==400){
							location.href=<%=request.getContextPath()%>+"/loginForm";
						}
						console.log("댓글삭제 실패" + e.responseText);
					}
				});
			}
		});
		replyList();
		
		$(document).on('click', '#replyList input[value=수정]', function(){
			$("#replyList>ul>li>div:nth-child(1)").css("display","block");
			$("#replyList>ul>li>div:nth-child(2)").css("display","none");
			
			$(this).parent().css("display","none");
			$(this).parent().next().css("display","block");
			$(this).parent().next().css("background","#ddd");
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h1>글내용보기</h1>
		번호 : ${vo.no } <br/>
		작성자 : ${vo.userid }<br/>
		작성일 : ${vo.writedate }, 조회수 : ${vo.hit }<br/>
		제목 : ${vo.subject }<br/>
		글내용 : ${vo.content }<br/>
		<c:if test="${logId==vo.userid }">
			<a href="boardEdit?no=${vo.no }">수정</a>
			<a href="javascript:boardDel(${vo.no })">삭제</a>
		</c:if>
		
		<!-- 댓글폼 -->
		<div>
			<c:if test="${logStatus=='Y' }">
				<form method="post" id="replyWriteFrm">
					<input type="hidden" name="no" value="${vo.no }">
					<textarea name="content" id="content" style="width:500px; height:100px; margin:0"></textarea>
					<input type="button" value="댓글등록" id="replyWriteBtn"/>
				</form>
			</c:if>
		</div>
		
		<!-- 댓글리스트  -->
		<div id="replyList"></div>
	</div>
</body>
</html>