<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String memberId = (String)session.getAttribute("MEMBERID");
	boolean login = memberId == null ? false : true; //���̸� �޽� ������ Ʈ��
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��ο��� �˻�</title>
</head>
<body>
<%
	if(login){
%>
���̵� "<%= memberId %>" �� �α��� �� ����
<%
	} else{
%>
�α������� ���� ����
<%
	}
%>
</body>
</html>