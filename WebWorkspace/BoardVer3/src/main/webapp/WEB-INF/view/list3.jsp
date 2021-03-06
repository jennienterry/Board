<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
<style>
table,td,th {
border: 1px solid black;
border-collapse:collapse;
}
.record {cursor:pointer;}
.record:hover{background-color : #ecf0f1;}


</style>
</head>
<body>
	<h1>목록</h1>
	<div>
		<a href="/write3"><button>글 작성하기</button></a>
	</div>
	<div>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>

			<c:forEach items="${list}" var="i">
				<tr class="record" onclick="moveToDetail(${i.iboard});">
	<!-- a태그 말고 onclick 사용하는 이유 : 밑에 td 한줄씩 각 개인으로 a태그를 적어줘야하기 때문에 한번에 하기 위해서 (a태그면 중복소스 많음) -->
					<td>${i.iboard}</td>
					<td>${i.title}</td>
					<td>${i.regdt}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<script>
		function moveToDetail(iboard) {
		console.log('iboard : %d', iboard);
		location.href='/detail3?iboard=' + iboard;
		}
	
	</script>
</body>
</html>