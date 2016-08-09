<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="exam.dao.*" import="exam.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta "charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원관리 - list.jsp</h1>
<hr>

<!-- JSTL문으로 작성 -->
<% 	SystemLog.printLog("시작"); %>

<table border='1'>
	<tr><td>글번호</td>
	<td>작성자</td>
	<td>제목</td>
	<td>작성일</td>
	<td>조회수</td>
	<td>다운로드수</td></tr>
	
	<c:if test= "${ requestScope.list != NULL}" >
		<c:forEach var="select" items="${ requestScope.list }">
			<tr><td align="center" >${select.num}</td>
			<td align="center">${select.name}(${select.id})</td>
			<td width="300"><a href="view.board?num=${select.num}">${select.title} </a></td>
			<td align="center">${select.writeDate}</td>			
			<td align="center">${select.readCount}</td>
			<td align="center">${select.downCount}</td><tr>		
			
			<%-- <tr><td><a href="view.kitri?id=${select.id}">${select.id}</a></td> --%>
						
		</c:forEach>		
	</c:if>
</table>
</body>
</html>