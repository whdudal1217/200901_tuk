<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page isErrorPage="true" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> error </title>
</head>
<body>
요청처리 과정에서 예외가 발생하였습니다. <br>
빠른시간 내에 문제를 해결하도록 하겠습니다.
<p>
<%-- 에러타입 : <%= exception.getClass().getName() %>
에러타입 : <%= exception.getMessage() %> --%>
</body>
</html>
<!-- 익스플로러에선 512바이트보다 작으면 자체적으로 제공하는 HTTP 오류 메세지 화면을 출력합니다 즉, 512바이트를 꼭 넘도록 
오류페이지를 만들어주세요. -->