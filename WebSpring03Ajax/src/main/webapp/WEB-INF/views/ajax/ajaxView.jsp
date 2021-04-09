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
<script type="text/javascript">
	$(function(){
		var params = "num=12345&name=홍길동&id=zerojunee";
		//비동기식으로 서버에 데이터를 보내기 / 문자열을 리턴받는다.
		$("#ajaxString").click(function(){
			var url = "/myapp/ajaxString";
			$.ajax({
				url : url,
				data : params,
				success : function(result){
					$("#resultData").html(result);
				}, error:function(){
					$("#resultData").html("전송받기 실패..");
				}
			});
		});
		$("#ajaxObject").click(function(){
			var url = "/myapp/ajaxObject";
			$.ajax({
				url : url,
				data : params,
				success : function(result){
					var tag="<ul>";
					tag += "<li>번호 : " + result.num + "</li>";
					tag += "<li>이름 : " + result.name + "</li>";
					tag += "<li>아이디 : " + result.id + "</li>";
					tag += "<li>연락처 : " + result.tel + "</li>";
					tag += "<li>주소 : " + result.addr + "</li></ul>";
					
					$("#resultData").html(tag);
				},error:function(){
					$("#resultData").html("Object전송실패");
				}
			});
		});
		$("#ajaxList").on("click",function(){
			var url = "/myapp/ajaxList";
			$.ajax({
				url : url,
				success : function(result){
					//List객체 내의 vo에 순서대로 접근하기 위해서는 $(result)처리를 해주어야 한다.
					var $result = $(result);
					$("#resultData").html("<ul></ul>");
					$result.each(function(idx,vo){
						$("#resultData ul").append("<li>"+vo.num+", "+vo.name+", "+vo.id+", "+vo.tel+", "+vo.addr+"</li>");
					});					
					
				},error:function(){
					$("#resultData").html("List전송실패");
				}
			});
		});
		$("#ajaxMap").click(function(){
			var url = "/myapp/ajaxMap";
			
			$.ajax({
				url : url,
				success : function(result){
					var tag = "<ul>";
					//					 key value
					tag += "<li>"+result.p1.num + ", " + result.p1.name+", " + result.p1.tel + ", " + result.p1.addr + "</li>";
					tag += "<li>"+result.p2.num + ", " + result.p2.name+", " + result.p2.tel + ", " + result.p2.addr + "</li>";
					tag += "<li>"+result.p3.num + ", " + result.p3.name+", " + result.p3.tel + ", " + result.p3.addr + "</li></ul>";
					
					$("#resultData").append(tag);
				}, error:function(){
					$("#resultData").html("Map전송실패");
				}
			});
		});
		$("#ajaxJson").click(function(){
			var url = "/myapp/ajaxJson";
			$.ajax({
				url : url,
				success : function(result){
					//문자열로 된 json데이터를 파싱한다.
					var jsonData = JSON.parse(result);
					$("#resultData").append("<br/>번호="+jsonData.no);
					$("#resultData").append("<br/>이름="+jsonData.name);
					$("#resultData").append("<br/>전화번호="+jsonData.tel);
					$("#resultData").append("<br/>주소="+jsonData.addr);
					$("#resultData").append("<br/>이메일="+jsonData.email);
				}, error:function(){
					console.log("json 받기 에러...!");
				}
			});
		});
	});
</script>
</head>
<body>
<div class="container">
	<h1>비동기식 데이터 전송과 데이터 받기</h1>
	<button id="ajaxString">ajax 문자열</button>
	<button id="ajaxObject">ajax 객체형(object)</button>
	<button id="ajaxList">ajax List형</button>
	<button id="ajaxMap">ajax Map형</button>
	<button id="ajaxJson">ajax json형</button>
	
	<div id="resultData" style="background:pink">결과 표시된 곳</div>
</div>	
</body>
</html>