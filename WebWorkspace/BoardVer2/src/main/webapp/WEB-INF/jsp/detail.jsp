<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내용보기</title>
</head>
<body>
	
	<h1>내용보기</h1>
	<a href="/list">돌아가기</a>
	<div>제목 : ${vo.title}</div> <!-- detail servlet에서 담아둔 키값을 사용함 "vo" -->
	<div>내용 : ${vo.ctnt}</div>
	
	<a href="/delete?no=${param.no}"><button>삭제</button></a>  
	<a href="/mod?no=${param.no}"><button>수정</button></a>
</body>
</html>

<%--(키값 : 서블릿에서 set한거)
 ${담을 때 썼던 키값. 멤버필드명} : EL식 사용방법
 * request.setAttribute한거만 EL식 사용할 수 있음 --%>