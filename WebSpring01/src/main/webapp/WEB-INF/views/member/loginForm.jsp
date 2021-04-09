<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<h1>로그인 폼</h1>
	<form method="post" action="<%=request.getContextPath()%>/loginOk">
		아이디 : <input type="text" name="userid" id="userid"/><br/>
		비밀번호 : <input type="text" name="userpwd" id="userpwd"><br/>
		<input type="submit" value="로그인"/>
	</form>
</div>
</body>
</html>