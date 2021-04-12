<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<h1>자료실 리스트</h1>
	<a href="/jdbc/dataWrite1">글쓰기(파일업로드1)</a>
	<a href="/jdbc/dataWrite2">글쓰기(파일업로드2)</a>
	<ul>
		<c:forEach var="vo" items="${dataList }">
			<li>${vo.no }</li>
			<li><a href="/jdbc/dataView?no=${vo.no }">${vo.title }</a></li>
			<li>${vo.userid }</li>
			<li>
				<a href="/jdbc/upload/${vo.filename1 }" download>${vo.filename1 }</a>
				<c:if test="${vo.filename2!=null }">
				, <a href="/jdbc/upload/${vo.filename2 }" download>${vo.filename2 }</a>
				</c:if>
			</li>
			<li>${vo.writedate }</li>
			<li style="border-bottom:1px solid #ddd">${vo.hit }</li>
		</c:forEach>
	</ul>
</div>

</body>
</html>