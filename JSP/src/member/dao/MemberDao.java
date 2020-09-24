package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.model.Member;

public class MemberDao { // query를 모아놓은 클래스
	// 싱글톤 패턴
	private MemberDao() {
	}

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}

	// select메소드
	public ArrayList<Member> selectMemberList(Connection conn) throws SQLException {
		ArrayList<Member> memberList = new ArrayList<Member>();
		String query = " SELECT MEM_SEQ_NO, MEM_ID, MEM_PWD, MEM_NAME, MEM_PHONE, MEM_EMAIL FROM tb_member ORDER BY MEM_SEQ_NO DESC ";
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Member member = new Member();
			member.setMem_seq_no(rs.getInt("MEM_SEQ_NO"));
			member.setMem_id(rs.getString("MEM_ID"));
			member.setMem_pwd(rs.getString("MEM_PWD"));
			member.setMem_name(rs.getString("MEM_NAME"));
			member.setMem_phone(rs.getString("MEM_PHONE"));
			member.setMem_email(rs.getString("MEM_EMAIL"));
			memberList.add(member);
		}
		return memberList;
	}

	// insert메소드
	public int insertMember(Connection conn, Member member) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO tb_member ( ");
		query.append(" MEM_ID,     ");
		query.append(" MEM_PWD,    ");
		query.append(" MEM_NAME,   ");
		query.append(" MEM_PHONE,  ");
		query.append(" MEM_EMAIL   ");
		query.append(" ) VALUES (  ");
		query.append(" ?,          "); // 1
		query.append(" ?,          "); // 2
		query.append(" ?,          "); // 3
		query.append(" ?,          "); // 4
		query.append(" ?           "); // 5
		query.append(" )           ");
		PreparedStatement pstmt = conn.prepareStatement(query.toString()); // prepareStatement는 스트링만 들어옴
		int i = 1;
		pstmt.setString(i++, member.getMem_id());
		pstmt.setString(i++, member.getMem_pwd());
		pstmt.setString(i++, member.getMem_name());
		pstmt.setString(i++, member.getMem_phone());
		pstmt.setString(i++, member.getMem_email());
		int updCnt = pstmt.executeUpdate();
		return updCnt;
	}
	// update메소드

}
