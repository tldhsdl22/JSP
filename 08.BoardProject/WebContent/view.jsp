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
	<c:set value="${ requestScope.detail}" var="detail"/>
	<c:if test= "${ detail != NULL}" >
		<tr><td>글번호</td><td align="center" >${detail.num}</td></tr>
		<tr><td>작성자</td><td align="center">${detail.name}(${detail.id})</td></tr>
		<tr><td>제목</td><td  align="center" width="300">${detail.title}</td></tr>
		<tr><td>내용</td><td  align="center" width="300">${detail.content}</td></tr>
		<tr><td>작성일</td><td align="center">${detail.writeDate}</td></tr>
		<tr><td>조회수</td><td align="center">${detail.readCount}</td></tr>
		<tr><td>다운로드수</td><td align="center">${detail.downCount}</td></tr>			
	</c:if>
</table>
</body>
</html>