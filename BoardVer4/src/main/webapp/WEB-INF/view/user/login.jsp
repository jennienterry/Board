<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div>
		<form>							 <!-- placeholder : 바에 연하게 뜨는거 -->
			<div><input type="text" name="uid" placeholder="아이디"></div>
			<div><input type="password" name="upw" placeholder="비밀번호"></div>
			<div>
			<input type="submit" value="Login">
			</div>
	</form>
	</div>
	<div>
	<a href="join">회원가입</a> <!-- /join 하려면 /user/join 해야함 -->
	</div>
</body>
</html>