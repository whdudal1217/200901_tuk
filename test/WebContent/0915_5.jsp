<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
클라이언트 IP(request.getRemoteAddr()) = <%= request.getRemoteAddr() %> <br />
요청정보길이 (request.request.getContentLength()) = <%= request.getContentLength() %><br />
요청정보 인코딩 (request.getCharacterEncoding()) = <%= request.getCharacterEncoding() %><br />
요청정보 컨텐츠타입 (request.getContentType()) = <%= request.getContentType() %><br />
요청정보 프로토콜 (request.getProtocol()) = <%= request.getProtocol() %><br />
요청정보 전송방식 (request.getMethod()) = <%= request.getMethod() %><br />
요청 URI (request.getRequestURI()) = <%= request.getRequestURI() %><br />
컨텍스트 경로 (request.getContextPath()) = <%= request.getContextPath() %><br />
서버이름 (request.getServerName()) = <%= request.getServerName() %><br />
서버포트 (request.getServerPort()) = <%= request.getServerPort() %><br />
</body>
</html>