<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<h1>파일업로드2</h1>
	<form method="post" action="/jdbc/upload2" enctype="multipart/form-data">
		<input type="text" name="title" style="width:100%;" placeholder="제목"/><br/>
		<textarea name="content" style="width:100%;"></textarea><br/>
		첨부파일 : <input type="file" name="filename"/>
				<input type="file" name="filename"/><br/>
		<input type="submit" value="업로드"/>
	</form>
</div>
	
</body>
</html>