<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% session.invalidate(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
세션을 종료했습니다. <br>
MEMBERID : <%= session.getAttribute("MEMBERID") %> <br> <!-- NullPointException -->
NAME : <%= session.getAttribute("NAME") %> <br>
</body>
</html>