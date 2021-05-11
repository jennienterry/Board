<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
.errMsg {color:red};
</style>
</head>
<body>
	<div>
	<div class = "errMsg">${errMsg}</div>
		<form action="login" method="post">			 <!-- placeholder : 바에 연하게 뜨는거 -->
			<div><input type="text" name="uid" placeholder="아이디" value="jimin"></div>
			<div><input type="password" name="upw" placeholder="비밀번호" value="terry"></div>
			<div>											<!-- value는 테스트용 -->
			<input type="submit" value="Login">
			</div>
	</form>
	</div>
	<div>
	<a href="join">회원가입</a> <!-- /join 하려면 /user/join 해야함 -->
	</div>
</body>
</html>