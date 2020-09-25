<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임포트 하는 페이지</title>
</head>
<body>
<c:choose>
	<c:when test="${param.type == 'blog' }">
		<c:import url="http://search.daum.net/search?">
			<c:param name="w=blog"> blog </c:param>
			<c:param name="q"> 이채연 </c:param>
		</c:import>
	</c:when>
	
	<c:when test="${param.type == 'youtube' }">
		<c:import url="https://www.youtube.com/results">
			<c:param name="search_query"> 이채연 </c:param>
		</c:import>
	</c:when>
	<c:otherwise>
		<c:import url="JstlCore_Imported_Prc.jsp">
			<c:param name="message">선택해주세요</c:param>
		</c:import>
	</c:otherwise>
</c:choose>
</body>
</html>