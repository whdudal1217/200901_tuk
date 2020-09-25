<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp로만 학점 계산하기</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.score<=100 && param.score>=90}">
				${param.score}는 A학점입니다.
		</c:when>
		<c:when test="${param.score<90 && param.score>=80}">
				${param.score}는 B학점입니다.
		</c:when>
		<c:when test="${param.score<80 && param.score>=70}">
				${param.score}는 C학점입니다.
		</c:when>
		<c:when test="${param.score<70 && param.score>=60}">
				${param.score}는 D학점입니다.
		</c:when>
		<c:when test="${param.score<60 && param.score>=0}">
				${param.score}는 F학점입니다.
		</c:when>
		<c:otherwise>
				파라미터 값을 입력해주세요
		</c:otherwise>
	</c:choose>
</body>
</html>