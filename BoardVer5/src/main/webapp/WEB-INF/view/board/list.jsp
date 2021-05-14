<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>

<table>
<tr>
 <th>번호</th>
 <th>제목</th>
 <th>작성자</th>
 <th>작성일</th>
</tr>

<c:forEach var="i" items="${list}">
	<tr onclick="moveToDetail(${i.iboard})">
	<td>${i.iboard}</td>
	<td>${i.title}</td>
	<td>${i.unm}</td>
	<td>${i.regdt}</td>
	</tr>
</c:forEach>
</table>

<a href="write"><button>글 작성하기</button></a>
<script>
function moveToDetail(iboard) {
	location.href="/board/detail?iboard=" + iboard
}
</script>
</body>
</html>