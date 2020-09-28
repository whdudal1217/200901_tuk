<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	//1.드라이버 로딩
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	try {
		String jdbcDriver = "jdbc:mysql://localhost:3306/jdbc_ex?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8&useUnicode=true&allowPublicKeyRetrieval=true";
		String dbUser = "root";
		String dbPass = "0_0MI1217";
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");

		//INSERT INTO `jdbc_ex`.`tb_member` (`MEM_SEQ_NO`, `MEM_ID`, `MEM_PWD`, `MEM_NAME`, `MEM_PHONE`, `MEM_EMAIL`)
		//VALUES ('3', '3', '3', '3', '3', '3');
		String query = "INSERT INTO tb_member ( `MEM_ID`, `MEM_PWD`, `MEM_NAME`, `MEM_EMAIL`)" 
		+ "VALUES ('" + memberId + "', '" + memberPwd + "', '" + memberName + "', '" + memberEmail + "')";
		
		/* String query2 = "INSERT INTO tb_member (`MEM_ID`, `MEM_PWD`, `MEM_NAME`,`MEM_EMAIL`)VALUES (?,?,?,?)"; */
		
		//2.데이터베이스 커넥션 생성
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

		//3. Statement 생성 
		stmt = conn.createStatement();
		
		/* //3.1 PrepareStatment 생성
		PreparedStatement pstmt = conn.prepareStatement(query2);
		int i = 1;
		pstmt.setString(i++, memberId);
		pstmt.setString(i++, memberPwd);
		pstmt.setString(i++, memberName);
		pstmt.setString(i++, memberEmail); */
		
		//4. 쿼리 실행
		int result = stmt.executeUpdate(query);
		/* int result2 = pstmt.executeUpdate(query2); */
		request.setAttribute("updCnt",result);
		/* //if (result2 == 1) */
		if (result == 1) {
	%>
	<h1>
		<%=memberId%>님 회원가입에 성공했습니다.
		<%-- ${updCnt} --%>
	</h1>
	<table>
		<tr>
			<td>아이디 </td><td><%=memberId%></td>
		</tr>
		<tr>
			<td>패스워드 </td><td><%=memberPwd%></td>
		</tr>
		<tr>
			<td>이름 </td><td><%=memberName%></td>
		</tr>
		<tr>
			<td>이메일 </td><td><%=memberEmail%></td>
		</tr>
	</table>

	<%
		} else {
	%>
	<h1>회원가입에 실패했습니다.</h1>
	<a href="memberInsertForm.jsp"> 돌아가기 </a>
	<%
			}
		} catch (SQLException ex) {
			out.print(ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	%>

</body>
</html>