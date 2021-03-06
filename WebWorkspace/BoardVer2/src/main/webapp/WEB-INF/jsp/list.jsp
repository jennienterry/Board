<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 명령어 시작은 c -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h1>목록</h1>
	<a href="/write"><button>글 작성</button></a>

	<c:forEach var="i" begin="1" end="10"> <!-- 변수명, 목록데이터,  / 음수값ㄴㄴ -->
	<!-- end는 종료값 , 배수 step="2"-->
		<span>${i}</span> <!-- 어딘가(pageContext) setAttribute가 있다는 의미가 된다. -->
	</c:forEach>
	
	<table>
	<tr>
	<td>번호</td>
	<td>제목</td >
	</tr>
	<tr>
	<c:forEach var="item" items="${list}" varStatus="status"> <!-- 상대값을 저장하는 것, 몇번째 인덱스인지 찍어줌 -->
	<tr>
	<td>${status.index}</td> <!-- 여기만 값이 바뀔 수 있다. -->
	<td><a href="/detail?no=${status.index}">${item.title}</a></td>
	</tr>
	</c:forEach> 
	</table>

</body>
</html>