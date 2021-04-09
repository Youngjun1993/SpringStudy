<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<h1>글수정</h1>
	<form method="post" action="/jdbc/boardEditOk">
		<input type="hidden" name="no" value="${vo.no }"/>
		제목 : <input type="text" name="subject" value="${vo.subject }"/> <br/>
		글내용 : <textarea name="content">${vo.content }</textarea>
		<input type="submit" value="글수정"/>
		<script>
			CKEDITOR.replace("content");
		</script>
	</form>
</div>
</body>
</html>