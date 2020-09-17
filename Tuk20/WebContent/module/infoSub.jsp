<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String type = request.getParameter("type");
	if(type == null){
		return;
	}
%>

<table border="1">
	<tr>
		<td> 타입 </td> <td> <%=type %> </td>
	</tr>
	<tr>
		<td> 특징 </td>
		<td>
			<%
				if(type.equals("A")){
					out.println("예쁘다");
				}else if(type.equals("B")){
					out.println("귀엽다");
				}else{
					out.println("깜찍하다");
				}
			%>
		</td>
	</tr>
</table>