<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<h1>디테일</h1>
	<div>
	 <a href ="/del3?iboard=${param.iboard}"><button>삭제</button></a>
	 <a href ="/mod3?iboard=${param.iboard}"><button>수정</button></a>
	
	</div>
	<div><a href="/list3"><button>리스트</button></a></div>
	<div>제목 : ${data.title}</div>
	<div>작성일 : ${data.regdt}</div>
	<div>${data.ctnt}</div>
</body>
</html>