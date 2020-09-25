<%@page import="kr.ac.hit.member.model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="kr.ac.hit.member.model.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	HashMap<String, Object> mapDate = new HashMap<>();
mapDate.put("name", "아이유");
mapDate.put("today", new java.util.Date());
%>
<c:set var="intArray" value="<%=new int[] { 1, 2, 3, 4, 5 }%>" />
<c:set var="map" value="<%=mapDate%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach 태그</title>
</head>
<body>
	
	
	<h3>int형 배열</h3>
	<c:forEach var="i" items="${intArray }" begin="2" end="4" varStatus="status">
 	status.index : ${status.index}<br /> status.count : ${status.count}<br /> i : [${i}]<br /><br />
	</c:forEach>
	
	<!-- ------------------------------------------ -->
	
	<h3>Map</h3>
	<c:forEach var="i" items="${map}">
	${i.key} = ${i.value }<br />
	</c:forEach>
	${map.today }
	
	<!-- ------------------------------------------ -->
	<%
		ArrayList<Member> memberList = new ArrayList<>();
		memberList.add(new Member("IU","아이유"));
		memberList.add(new Member("JOY","조이"));
		memberList.add(new Member("IREN","아이린"));
		
		request.setAttribute("memList", memberList);
	%>
	<br />
	<br />
	<h3> MemberVo를 이용한 member 입력 & 출력</h3>
	<table border="1">
		<tr>
			<td>NO</td>
			<td>ID</td>
			<td>NAME</td>
		</tr>
			<c:forEach var="member" items="${memList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${member.mem_id}</td>
					<td>${member.mem_name}</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>



















