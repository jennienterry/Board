<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<!-- html은 정수개념 없다. number적었다고 해서 의미 없음 -->
		<input type="text" id="num1" value="">
		<input type="text" id="num2" value="">
		<button onclick="sum()">더하기</button>
		<button onclick="minus()">빼기</button>
	</div>
	<div>
		<input type="text" id="result">
	</div>

	<script>
	var num1Elem = document.getElementById('num1');
	var num2Elem = document.querySelector('#num2');
	var resultElem = document.querySelector('#result');
	
	function sum (){
		<!-- 그냥 하면 html은 text취급하기 때문에 정수로 변환해줘야 한다. -->
		var num1 = parseInt(num1Elem.value); <!-- 주소값에 접근 -->
		var num2 = Number(num2Elem.value); <!-- javascript 형변환 방법 -->
		console.log('num1 : %s', num1);
		console.log('num2 : %s', num2);
		resultElem.value = num1+num2;
		var result = num1 + num2;
		console.log('num1 : %s + num2 : %s = %s', num1, num2, result)
	}
	
	function minus (){
		var num1 = parseInt(num1Elem.value);
		var num2 = Number(num2Elem.value);
		resultElem.value = num1-num2;
		
		console.log()
	}
	
</script>
</body>
</html>