<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="2">
				<jsp:include page="/module/top.jsp" flush="false" />
			</td>
		</tr>
		<tr>
			<td width="100" valign="top">
				<jsp:include page="/module/left.jsp" />
			</td>
			<td width="300" valign="top">
				<!-- 내용 시작 -->
				레이아웃 1
				<br /><br /><br />
				<!-- 내용 끝 -->
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<jsp:include page="/module/bottom.jsp" flush="false" />
			</td>
		</tr>
	</table>
</body>
</html>