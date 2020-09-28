<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	MEMBER 테이블의 내용
	<table with="100%" border="1">
		<tr>
			<td>이름</td>
			<td>아이디</td>
			<td>이메일</td>
		</tr>
		<%
			//1.드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try{
				String jdbcDriver = "jdbc:mysql://localhost:3306/jdbc_ex?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8&useUnicode=true&allowPublicKeyRetrieval=true";
				String dbUser = "root";
				String dbPass = "0_0MI1217";
				
				String query = "SELECT * FROM tb_member ORDER BY MEM_ID";
				
				//2.데이터베이스 커넥션 생성
				conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
				
				//3. Statement 생성 
				stmt = conn.createStatement();
				
				//4. 쿼리 실행
				rs = stmt.executeQuery(query);
				
				while(rs.next()){
		%>
		<tr>
			<td><%= rs.getString("MEM_NAME") %></td>
			<td><%= rs.getString("MEM_ID") %></td>
			<td><%= rs.getString("MEM_EMAIL") %></td>
		</tr>
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

	</table>
</body>
</html>



















