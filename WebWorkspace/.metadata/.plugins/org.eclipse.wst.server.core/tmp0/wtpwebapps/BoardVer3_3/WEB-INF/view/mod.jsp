<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>

	<a href="list"><button>목록</button></a>
	<form action="/mod?iboard=${vo.iboard}" method="post" >
		<div>
			제목 : <input type="text" name="title" value="${vo.title}">
		</div>
		<div>
			내용 :
			<textarea name="ctnt" rows="10" cols="10">${vo.ctnt}</textarea>
		</div>

		<input type="submit" value="등록"> 
		<input type="reset" value="초기화">
	</form>
</body>
</html>