<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div>${errMsg}</div>
	<div>		<!-- servlet이름 -->
		<form action="/user/login" method="post">
			<div>
				아이디 : <input type="text" name="uid" placeholder="아이디">
			</div>
			<div>
				비밀번호 : <input type="password" name="upw" placeholder="비밀번호">
			</div>
			<input type="submit" value="로그인">
		</form>
	</div>
	<a href="join"><button>회원가입</button></a>
</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div>${errMsg}</div>
	<div>		<!-- servlet이름 -->
		<form action="/user/login" method="post">
			<div>
				아이디 : <input type="text" name="uid" placeholder="아이디">
			</div>
			<div>
				비밀번호 : <input type="password" name="upw" placeholder="비밀번호">
			</div>
			<input type="submit" value="로그인">
		</form>
	</div>
	<a href="join"><button>회원가입</button></a>
</body>
>>>>>>> refs/remotes/origin/main
</html>