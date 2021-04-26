<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿</title>
</head>
<body>
<%
	int a = 10;
	int b = 20;
	int c = a + b;

	out.print("<div>");
	out.print(c + 2);
	out.print("</div>");
%>


<hr>
<div><%=c + 1 %> </div> <!-- 위 out.print 세줄과 같은 의미 -->
</body>
</html>

<!--  <% %> 하면 자바문법이 사용 가능하다. 요즘 실무에서는 사용안함 -->
<!-- 톰캣이 자바 문법들을 해석해서 값을 내준다. -->