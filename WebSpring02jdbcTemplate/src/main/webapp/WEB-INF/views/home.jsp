<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>홈</h1>

<!-- 
	파일업로드 설정
	1. pom.xml에 프레임워크 추가
	<!-- fileupload
		<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload
		<dependency>
		    <groupId>commons-fileupload</groupId>
		    <artifactId>commons-fileupload</artifactId>
		    <version>1.4</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/commons-io/commons-io
		<dependency>
		    <groupId>commons-io</groupId>
		    <artifactId>commons-io</artifactId>
		    <version>2.8.0</version>
		</dependency>
		
	2. root-context.xml에 MultipartResolver 객체 만들기
		<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	 	<property name="maxUploadSize" value="-1"></property>
	 	<property name="defaultEncoding" value="UTF-8"></property>
		</bean>
		
	3. root-context.xml를 web.xml에 파일명을 추가한다. (,를 하면 알아서 split으로 짤라준다.)
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring/appServlet/servlet-context.xml,/WEB-INF/spring/root-context.xml</param-value>
		</init-param>
	
 -->

</body>
</html>
