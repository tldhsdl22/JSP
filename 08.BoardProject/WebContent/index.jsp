<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta "charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메인메뉴</h1>

<!-- 로그인 X -->
<c:if test="${sessionScope.loginId == NULL}">
	<a href=loginForm.jsp>로그인</a>
	<hr>	
</c:if>	

<!-- 로그인 O -->
<c:if test="${sessionScope.loginId != NULL}">
	${sessionScope.loginId}님 환영합니다.
	<hr>	
	<a href=writeForm.jsp>글 쓰기</a>		
	<a href=list.board>글 목록</a>			
</c:if>
	
</body>
</html>