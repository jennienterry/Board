<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>		<!-- 시크릿모드로 하기/ 캐시 지우기/ css?ver=?숫자 붙이기 -->
<link href="/res/css/boardList.css?" rel="stylesheet">
<script defer src="/res/js/boardList.js"></script>
<!-- defer주면 화면부터 먼저 띄우고 script마지막에 읽음 = defer안쓰면 맨 밑에 적기 -->
<!-- script와 css는 ..으로 접근x html사진만 ! -->

</head>
<body>
 <h1> 목록 </h1>		<!-- ${sessionScope.loginUser.uid} 하면 좋음 -->
 <h3>${loginUser.unm}(${loginUser.uid})님 환영합니다 </h3>
 <a href="/user/logout"><button>로그아웃</button></a>
<table>
<tr>
 <th>번호</th>
 <th>제목</th>
 <th>작성자</th>
 <th>작성일시</th>
</tr>
				<!-- ${requestScope.list} 하면 좋음 -->
<c:forEach var="i" items="${list}">
	<tr class="record" onclick="moveToDetail(${i.iboard})">
	<td>${i.iboard}</td> <!-- pageScope로 하지만 제일먼저 물어보기 때문에 굳이 적을필요 x -->
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
=======
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
>>>>>>> refs/remotes/origin/main
</html>