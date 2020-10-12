<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.hit.member.model.Member" %>
<%@ page import="kr.ac.hit.member.service.imple.MemberServiceImple" %>
<%@ page import="kr.ac.hit.member.service.MemberService" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	String mem_id = request.getParameter("mem_id");
	String mem_pwd = request.getParameter("mem_pwd");
	
	MemberService memberService = MemberServiceImple.getInstance();
	
	Map<String, Object> condition = new HashMap<String, Object>();
	
	if(mem_id!=null && mem_pwd!=null){
		condition.put("memId", mem_id);
		condition.put("memPwd", mem_pwd);
	}
	
	Member member = memberService.getMember(condition);
	
	String message = null;
	
	if(member != null){
		if(mem_pwd.equals(member.getMem_pwd())){
			session.setAttribute("LOGIN_USER", member);
		}
	}else{
		message = "해당 정보 존재하지 않습니다!";
	}
	
	
	out.println("<script>");
	if(message != null){
		out.println("alert('"+message+"');");
		out.println("history.go(-1);");
		
	}else{
		out.println("alert('환영합니다.')");
		out.println("location.href='"+request.getContextPath()+"/member/memberList.do'");
	}
	out.println("</script>");
	
	
%>
</body>
</html>