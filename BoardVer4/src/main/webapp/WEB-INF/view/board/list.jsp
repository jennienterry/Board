<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
table,th,td{
 border:1px solid black;
 border-collapse: collapse;
}
</style>
</head>
<body>
	<div>로그인 성공</div>
	<div>${loginUser.unm}님
		(${loginUser.uid}) 환영합니다 ^ㅇ^ <a href="/user/logout">Logout</a>
	</div>

	<div>
		<a href="write"><button>글쓰기</button></a>
	</div>
	<div>

		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
			</tr>

			<c:forEach var="i" items="${list}">
				<tr>
					<td>${i.iboard}</td>
					<td>${i.title}</td>
					<td>${i.unm}</td>
					<td>${i.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>