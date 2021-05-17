<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
	<h1>수정하기</h1>
	<a href="/board/detail"><button>뒤로가기</button></a>
	<form action="/board/mod" method="post">
		<input type="hidden" name="iboard" value="${param.iboard}">
		<input type="hidden" name="iuser" value="${vo.iuser}">
		<div>
			<input type="text" name="title" value="${vo.title}">
		</div>
		<div>
			<textarea name="ctnt" rows="10" cols="10">${vo.ctnt}</textarea>
		</div>

		<div>
			<input type="submit" value="수정"> <input type="reset"
				value="초기화">
		</div>
	</form>
</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
	<h1> 수정하기 </h1>
	<a href="/board/detail"><button>뒤로가기</button></a>
	<form action="/board/mod" method="post">
	<div>
	<input type="text" name="title" value="${vo.title}">
	</div>
	<div>
	<textarea name="ctnt" rows="10" cols="10">${vo.ctnt}</textarea>
	</div>
	
	<div>
	<input type="submit" value="수정">
	<input type="reset" value="초기화">
	</div>
	</form>
</body>
>>>>>>> refs/remotes/origin/main
</html>