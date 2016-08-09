<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="exam.util.*"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta "charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- JSTL문으로 작성 -->
<% 	SystemLog.printLog("시작"); %>


<h1>글작성 페이지 - writeForm.jsp</h1>
	<form action = "write.kitri">

		<fieldset>
			<legend>글작성</legend>
			<table>
				<tr>
				<td align="center">제목</td>				
				<td><input type="text" name="title" size="50"></td>
				</tr>
				<tr>
				<td align="center">내용</td>
				<td><textarea name="content" cols="53" rows="13"></textarea></td>
				</tr>
				<tr>
				<td align="center">파일 첨부</td>
				<td><input type="file" name="fileName"></td>
				</tr>			
				<tr><td></td><td align="right"><input type="submit" value="작성"></td></tr>						
			</table>			
		</fieldset>
	</form>
</body>
</html>