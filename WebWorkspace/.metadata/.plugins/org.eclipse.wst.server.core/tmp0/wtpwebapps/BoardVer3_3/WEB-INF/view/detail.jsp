<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 자세히보기 </title>
</head>
<body>
	<a href="list"><button>목록</button></a>
	<div>
	제목 : ${vo.title}
	</div>
	<div>
	내용 : ${vo.ctnt}
	</div>
	
	<a href="/delete?iboard=${vo.iboard}" ><button>삭제</button></a>
	<a href="/mod?iboard=${vo.iboard}" ><button>수정</button></a>
	

</body>
</html>