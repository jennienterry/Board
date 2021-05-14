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
</html>