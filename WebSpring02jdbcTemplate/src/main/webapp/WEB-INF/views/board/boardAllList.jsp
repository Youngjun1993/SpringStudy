<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>리스트</h1>
<c:if test="${logStatus=='Y' }">
	<a href="/jdbc/boardWrite">글쓰기</a>
</c:if>
<ul>
	<c:forEach var="v" items="${list }">
		<li>${v.no }</li>
		<li><a href="<%=request.getContextPath()%>/boardView?no=${v.no}">${v.subject }</a></li>
		<li>${v.userid }</li>
		<li>${v.writedate }</li>
		<li>${v.hit }</li>
	</c:forEach>
</ul>
</body>
</html>