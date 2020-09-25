<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="kr.ac.hit.member.model.Member" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% request.setAttribute("user_name", "����"); %>
<c:set var="name" value="ȫ�浿" />
<c:set var="age">20</c:set>
�̸� : ${name}<br />
���� : ${age}<br />
<c:set var="user_id" value="jenny" scope="request"/>
������(������Ʈ��ü) : ${user_name }<br />
�������̵�(������Ʈ��ü) : ${user_id }<br />

<%
	Member member = new Member();
	member.setMem_name("������");
	member.setMem_id("IU");
	request.setAttribute("member", member); //jstl������� �ʾ��� ��
%>
<c:set var="member" value="<%= member %>" scope="request"/>
ȸ���� : ${member.mem_name } <br /> <!-- member.getmem_id�� �ƴ� ���������� �ٷ� ���� ���� -->
ȸ�����̵� : ${member.mem_id } <br />

<c:set target="${member }" property="mem_pwd" value="1234" />
ȸ���н����� : ${member.mem_pwd }<br />

<% 
	Map<String, String> map = new HashMap<String,String>();
%>
<c:set target="<%= map %>" property="host" value="localhost"/>
ȣ��Ʈ : <%= map.get("host") %> <br />

�������� <br />
������ : ${user_name } <br />
<c:remove var="user_name" scope="request" />
������ : ${user_name } <br />

</body>
</html>