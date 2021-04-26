<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- <% %> 메소드 안에 메소드 만들 수 없음, 함수 사용 불가능  --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mission1</title>
</head>
<body>
	<div>스크립트릿 이해를 하였는가 미션1</div>
	<div>for문을 이용하여 1~10 세로방향으로 찍히도록</div>
	<div>각 숫자들은 div로 감싸라</div>
	<div>1</div>
	<div>...</div>
	<div>10</div>
	
	<% for(int i=1; i<=10; i++){
		out.print("<div>");
		out.print(i);
		out.print("</div>");
	}
	%>

	
	<% for(int i=1; i<=10; i++){ %>
		<div><%=i %></div>
	<% } %>
	
</body>
</html>