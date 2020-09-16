<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 출력</title>
</head>
<body>

name 파라미터 = <%=request.getParameter("name")%><br>
address 파라미터 = <%=request.getParameter("address")%><br>
<b> request.getParameterValues 메서드 사용</b>
<% String[] values = request.getParameterValues("pet");
	if(values != null){ //체크박스의 경우 value에 값이 있는지 없는지 먼저 확인해야함
		for(int i = 0 ; i < values.length ; i++){
%>
	<%= values[i] %>
<%	
		}
	}
%>
<p>
<b> request.getParameterNames 메서드 사용 </b>
<% 
	Enumeration paramEnum = request.getParameterNames(); //	
	while(paramEnum.hasMoreElements()){ //enum은 for문으로 돌릴 수 없어서 while문을 사용, getLength도 안 돼서 hasMoreElements를 사용
		String name = (String)paramEnum.nextElement();
%>
		<%= name %>
<%
	}
%>
<!-- 표현식이 너무 힘듦, 나중에 자바 코드 다 걷어낼 수 있음 -->
<p>
<b> request.getParameterMap 메서드 사용</b>
<%
	Map parameterMap = request.getParameterMap();
	String[] nameParam = (String[])parameterMap.get("name");
	if(nameParam != null) {
%>
	name = <%= nameParam[0] %>
<%
	}
%>
</body>
</html>







