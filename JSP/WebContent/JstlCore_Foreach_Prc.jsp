<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOREACH를 사용해서 1~100까지 더하기</title>
</head>
<body>
	
	<!-- 1번째 -->
	<h2> 1번째 방법 </h2>
	<c:set var="i" value="0" />
	<c:forEach var="j" begin="1" end="100">
		<p hidden="true">${i = i + j}</p>
	</c:forEach>
	1~100까지의 합 : ${i} <br/>
	
	<c:set var="i2" value="0" />
	<c:forEach var="j" begin="1" end="100" step="2">
		<p hidden="true">${i2 = i2 + j}</p>
	</c:forEach>
	1~100까지의 홀수의 합 : ${i2} <br/>
	
	<c:set var="i4" value="0" />
	<c:forEach var="j" begin="2" end="100" step="2">
		<p hidden="true">${i4 = i4 + j}</p>
	</c:forEach>
	1~100까지의 짝수의 합 : ${i4} <br/>
	
	<!-- 2번째 -->
	<h2> 2번째 방법 </h2>
	<c:forEach var="j" begin="1" end="100">
		<c:set var="i5" value="${i5 = i5 + j}" />
	</c:forEach>
	1~100까지의 합 : ${i5} <br/>
	
	<c:forEach var="j" begin="1" end="100" step="2">
		<c:set var="i6" value="${i6 = i6 + j}" />
	</c:forEach>
	1~100까지의 홀수의 합 : ${i6} <br/>
	
	<c:forEach var="j" begin="2" end="100" step="2">
		<c:set var="i1" value="${i1 = i1 + j}" />
	</c:forEach>
	1~100까지의 홀수의 합 : ${i1} <br/> 
	
	<h2> 3번째 방법 </h2>
	<c:set var="sum" value="0" />
	<c:forEach var="j" begin="1" end="100">
		<c:set var="sum" value="${sum = sum + j}" /> <!-- 어차피 다시 선언하면 덮어씌우기 하니까 굳이 히든을 쓸 필요도 없음 -->
	</c:forEach>
	1~100까지의 합 : ${sum} <br/>
	
	<c:set var="sum1" value="0" />
	<c:forEach var="j" begin="1" end="100" step="2">
		<c:set var="sum1" value="${sum1 = sum1 + j}" /> <!-- 어차피 다시 선언하면 덮어씌우기 하니까 굳이 히든을 쓸 필요도 없음 -->
	</c:forEach>
	1~100까지의 홀수의 합 : ${sum1} <br/>
	
	<c:set var="sum2" value="0" />
	<c:forEach var="j" begin="2" end="100" step="2">
		<c:set var="sum2" value="${sum2 = sum2 + j}" /> <!-- 어차피 다시 선언하면 덮어씌우기 하니까 굳이 히든을 쓸 필요도 없음 -->
	</c:forEach>
	1~100까지의 짝수의 합 : ${sum2} <br/>
	
	
</body>
</html>