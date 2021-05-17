<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${requestScope.param.title}</title>
<script defer src="/res/js/boardDetail.js"></script>
</head>
<body>
	<h1>디테일</h1>
	<div>
		<a href="list">리스트로 돌아가기</a>
	</div>
	<div>글번호 : ${param.iboard}</div>
	<div>제목 : ${vo.title}</div>
	<div>작성자 : ${vo.unm}</div>
	<div>작성일시 : ${vo.regdt}</div>
	<div>${vo.ctnt}</div>

	<c:if test="${loginUser.iuser == vo.iuser}">
		<div>
			<form action="delete" method="post">
				<input type="hidden" name="iboard" value="${param.iboard}">
				<input type="hidden" name="iuser" value="${vo.iuser}">
				<input type="submit" value="삭제">
			</form>
		<!-- 누구를 삭제하고 수정할지 생각하기 -->
<!-- 	<a href="delete?iboard=${param.iboard}"><button>삭제</button></a> --> 
		<a href="mod?iboard=${param.iboard}"><button>수정</button></a>
		</div>
	</c:if>

	<div>
		<form action="cmt" method="post">
			<input type="hidden" name="iboard" value="${param.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
	</div>

	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<c:forEach var="i" items="${requestScope.cmtList}">
			<tr>
				<td>${i.cmt}</td>
				<td>${i.unm}</td>
				<td>${i.regdate}</td>
				<td>		<!-- sessionScope-->
				<c:if test="${loginUser.iuser == i.iuser}">
				<input type="button" value="수정">
				<button onclick="delCmt(${param.iboard}, ${i.icmt})">삭제</button>
				</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<h1>디테일</h1>
	<div>글번호 : ${param.iboard}</div>
	<div>제목 : ${vo.title}</div>
	<div>작성자 : ${vo.unm}</div>
	<div>작성일시 : ${vo.regdt}</div>
	<div>${vo.ctnt}</div>
	 
	 <c:if test="${loginUser.iuser == vo.iuser}">
	 
	 <div> <!-- 누구를 삭제하고 수정할지 생각하기 -->
	 <a href="delete?iboard=${param.iboard}"><button>삭제</button></a>
	 <a href="mod?iboard=${param.iboard}"><button>수정</button></a>
	 </div>
	 
	 
	 </c:if>
	 
</body>
>>>>>>> refs/remotes/origin/main
</html>