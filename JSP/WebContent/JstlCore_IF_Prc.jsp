<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> 이걸로 하면 test="${param.name=='IU'}"이게 잘 안먹힘--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> JSTL 코어태그 IF문 </title>
</head>
<body>
<c:if test="true">
무조건 수행 <br/>
</c:if>
<c:if test="${param.name=='IU'}">
name 파라미터의 값이 ${param.name}입니다 <br />
</c:if>
<c:if test="${18 < param.age }">
당신의 나이는 18세 이상입니다<br />

<c:choose>
	<c:when test="${param.sung=='lee'}">
	성은 ${param.sung }씨 입니다.
	</c:when>
	<c:otherwise>
	성이 다릅니다.
	</c:otherwise>
</c:choose>

</c:if>
</body>
</html>