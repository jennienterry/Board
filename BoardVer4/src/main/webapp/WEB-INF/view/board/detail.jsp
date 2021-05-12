<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title}</title>
</head>
<body>
	<h1>디테일</h1>
	<div>${param.iboard}</div> <!-- 새로 안담아주고 받아온거 바로 써도 됨 -->
	
	<div> 글번호 : ${param.iboard}</div>
	<div> 제목 : ${vo.title}</div>
	<div> 작성자 : ${vo.unm}</div>
	<div> 작성일시 : ${vo.regdt}</div>
	<div> ${vo.ctnt}</div>
				<!-- session꺼랑     request꺼 비교 -->
	<c:if test="${loginUser.iuser == vo.iuser}">
	<div> <!-- true면 나타나고 false면 안나타남 -->
	<!-- 쿼리스트링은 key값을 사용한다. (deleteServlet 확인하기) -->
	<a href="delete?iboard=${param.iboard}"><button>삭제</button></a>
	<a href="mod?iboard=${param.iboard}"><button>수정</button></a>
	</div>
	</c:if>
	
	
</body>
</html>