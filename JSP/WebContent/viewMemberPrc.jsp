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

	<%
			//1.드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String memberId = request.getParameter("memberId");
			
			try{
				String jdbcDriver = "jdbc:mysql://localhost:3306/jdbc_ex?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8&useUnicode=true&allowPublicKeyRetrieval=true";
				String dbUser = "root";
				String dbPass = "0_0MI1217";
				
				String query = "SELECT * FROM tb_member where MEM_ID = '"+ memberId +"' "; //공백주의
				
				//2.데이터베이스 커넥션 생성
				conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
				
				//3. Statement 생성 
				stmt = conn.createStatement();
				
				//4. 쿼리 실행
				rs = stmt.executeQuery(query);
				if(rs.next()){ //true면 데이터 있는 거
					
		%>
	<table width="100%" border="1">
		<tr>
			<td>아이디</td>
			<td><%= memberId %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%= rs.getString("MEM_ID") %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%= rs.getString("MEM_ID") %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%= rs.getString("MEM_ID") %></td>
		</tr>
	</table>
	<%
				}else{
					out.println(memberId + "에 해당하는 정보가 존재하지 않습니다.");
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



















