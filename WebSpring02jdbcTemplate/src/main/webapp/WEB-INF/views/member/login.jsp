<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>로그인</h1>
<form method="post" action="/jdbc/loginOk">
	아이디 : <input type="text" name="userid" /><br/>
	비밀번호 : <input type="text" name="userpwd"/><br/>
	<input type="submit" value="로그인"/>
</form>
	
</body>
</html>