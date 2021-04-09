<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	function delCheck(recordNo){
		if(confirm("삭제할까요?")){
			location.href = "/home/boardDel?no="+recordNo;
		}
	}
	
	//ajax 댓글처리
	$(function(){
		function replyList(){
			var url = "/home/replyList";
			var params = "no=${vo.no}";
			
			$.ajax({
				url : url,
				data : params,
				success : function(result){
					var $result = $(result);
					
					var tag = "<ul>";
					$result.each(function(idx, obj){
						tag += "<li style='border-bottom:1px solid #ddd'><div>" + obj.userid + "(" + obj.replydate + ") ";
						
						if(obj.userid=="${logId}"){
							tag += "<input type='button' value='수정'/>";
							tag += "<input type='button' value='삭제' title='"+ obj.num +"'/>";
							
						}
						tag += "<br/>" + obj.content + "</div>";
						
						if(obj.userid =="${logId}"){
							tag += "<div style='display:none'>";
							tag += "<form method='post'>";
							tag += "<textarea name='content' style='width:500px height:80px;'>"+obj.content+"</textarea>";
							tag += "<input type='submit' value='수정하기'/>";
							tag += "<input type='hidden' name='num' value='"+obj.num+"'/>";
							tag += "</form></div>";
							
						}
						
						tag += "</li>";
					});
					tag += "</ul>";
					
					$("#replyList").html(tag);
				}, error : function(){
					console.log('댓글 가져오기 에러');
				}
			});
		}
	});
</script>
<div class="container">
	<h1>글내용보기</h1>
	<ul>
		<li>번호 : ${vo.no }</li>
		<li>작성자 : ${vo.userid }</li>
		<li>등록일 : ${vo.writedate }, 조회수 : ${vo.hit }</li>
		<li>제목 : ${vo.subject }</li>
		<li>${vo.content }</li>
	</ul>
	<div>
		<c:if test="${logId==vo.userid }">
			<a href="/home/boardEdit?no=${vo.no }">수정</a>
			<a href="javascript:delCheck(${vo.no })">삭제</a>
		</c:if>
	</div>
	<!-- 댓글폼 -->
	<div>
		<c:if test="${logStatus=='Y'}">
			<form method="post" id="replyWriteFrm">
				<input type="hidden" name="no" value="${vo.no }">
				<textarea name="content" id="content" style="width:500px; height:100px; margin:0"></textarea>
				<input type="button" value="댓글등록" id="replyWriteBtn"/>
			</form>
		</c:if>
	</div>
	<!-- 댓글리스트 -->
	<div id="replyList"></div>
</div>

</body>
</html>