<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h1>수정</h1>
	<div>
	<form action="/mod" method="post">
		<input type="hidden" name="index" value="${param.no}">
		<div> 제목 : <input type="text" name="title" value="${vo.title}"></div>
		<div> 내용 : <textarea name="ctnt">${vo.ctnt}</textarea></div>
		<input type="submit" value="수정">
		<input type="reset" value="초기화">
	
	
	</form>
	
	</div>
</body>
</html>