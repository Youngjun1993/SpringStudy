<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<h1>글쓰기</h1>
	<form method="post" action="/jdbc/boardWriteOk">
		제목 : <input type="text" name="subject"/>
		글내용 : <textarea name="content"></textarea>
		<script>
			CKEDITOR.replace("content");
		</script>
		<input type="submit" value="글등록하기"/>
	</form>
</div>	
</body>
</html>