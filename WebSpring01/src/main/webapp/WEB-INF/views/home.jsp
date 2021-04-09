<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<img src="<%=request.getContextPath()%>/resources/1.png"/>
</div>
</body>
</html>

<!-- 
	spring에서 dbcp설정
	
	1. ojdbc8.jar를 WEB-INF/lib에 추가한다. (보안문제로 maven 코드 사용 금지)
	2. build path 설정 -> libraries에 ojdb8.jar 추가
	3. pom.xml에 dependence추가한다.
	<!-- ojdbc8.jar
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc8</artifactId>
			<version>11.2.0.1.0</version>
			<scope>system</scope>
			<systemPath>${basedir}/src/main/webapp/WEB_INF/lib/ojdbc8.jar</systemPath>
		</dependency>
		<!-- spring jdbc
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-jdbc</artifactId>
		    <version>5.2.6.RELEASE</version>
		</dependency>
	4. servlet-context.xml에 데이터베이스 정보를 추가한다.
	<!-- 오라클 서버위치, 아이디, 비번, 드라이브등 설정
	<beans:bean class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<beans:property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></beans:property>
		<beans:property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"></beans:property>
		<beans:property name="username" value="c##scott"></beans:property>
		<beans:property name="password" value="tiger"></beans:property>
	</beans:bean>
 -->