<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<h1>회원가입</h1>
	<form method="post" action="/home/memberOk">
		아이디 : <input type="text" name="userid"/><br/>
		비밀번호 : <input type="password" name="userpwd"/><br/>
		이름 : <input type="text" name="username"/><br/>
		연락처 : <input type="text" name="tel1"/>-
				<input type="text" name="tel2"/>-
				<input type="text" name="tel3"/><br/>
		이메일 : <input type="text" name="emailid"/>@<input type="text" name="eamildomain" /><br/>
		우편번호 : <input type="text" name="zipcode"/><br/>
		주소 : <input type="text" name="addr"/><br/>
		상세주소 : <input type="text" name="detailaddr"/><br/>
		관심분야 : <input type="checkbox" name="interestArr" value="컴퓨터"/>컴퓨터
				<input type="checkbox" name="interestArr" value="쇼핑"/>쇼핑
				<input type="checkbox" name="interestArr" value="등산"/>등산
				<input type="checkbox" name="interestArr" value="독서"/>독서
				<input type="checkbox" name="interestArr" value="웹툰"/>웹툰
				<input type="checkbox" name="interestArr" value="인라인"/>인라인<br/>
		<input type="submit" value="가입하기"/>
	</form>
</div>

</body>
</html>