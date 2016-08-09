<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta "charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>request 객체 - loginForm.jsp</h1>
	<form action = "login.board">
		<fieldset>
			<legend>로그인</legend>
			<ul>
				<li>아이디 : <input type="text" name="id" value="test">
				<li>비밀번호 : <input type="password" name="pwd" value="1234">
			</ul>
			<input type="submit" value="로그인">
		</fieldset>
	</form>
</body>
</html>