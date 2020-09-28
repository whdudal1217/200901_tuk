<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pool을 사용한 회원 목록</title>
</head>
<body>
<H3> 아파치의 Pool 라이브러리를 이용한 dbpool </H3>
	<%
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try{
				String jdbcDriver = "jdbc:apache:commons:dbcp:DBConn";		
				String query = "SELECT * FROM tb_member"; 
				conn=DriverManager.getConnection(jdbcDriver);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				while(rs.next()){ //true면 데이터 있는 거
					
		%>
	<table width="100%" height="100%" border="1">
		<tr>
			<td>아이디</td>
			<td><%= rs.getString("MEM_ID") %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%= rs.getString("MEM_PWD") %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%= rs.getString("MEM_NAME") %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%= rs.getString("MEM_EMAIL") %></td>
		</tr>
	</table>
	<%
				}
			}catch(SQLException ex){
				out.print(ex.getMessage());
				ex.printStackTrace();
			}finally{
				try{
					if(conn!=null) conn.close();
					if(stmt!=null) stmt.close();
					if(rs!=null) rs.close();		
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		%>

</body>
</html>



















