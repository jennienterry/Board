<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- write와 비슷하다. 창 뜨는게 똑같고 수정창에서는 전에 썼던 내용만 추가로 더 가지고 있으면 되니까 -->
<title>수정하기</title>
</head>
	<body>
	<h1>수정하기</h1>
	<div><a href="/list3">목록</a></div>
	<form action="/mod3" method="post">
	<input type="hidden" name="iboard" value="${param.iboard}">
		<div> 제목 : <input type="text" name="title" value="${data.title}"></div>
		<div> 내용 : <textarea name="ctnt">${data.ctnt}</textarea></div>

	<div>
		<input type="submit" value="수정">
	 	<input type="reset" value="초기화">
	</div>
	
	</form>
</body>
</html>