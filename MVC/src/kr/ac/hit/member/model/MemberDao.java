package kr.ac.hit.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberDao {
	
	private static MemberDao instance = new MemberDao();

	private MemberDao() {};

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	//회원정보 목록 조회
	public List<Member> selectMemberList(Connection conn, Map<String, Object> condition) throws Exception{
		List<Member> memberList = new ArrayList<Member>();
		
		try {
			StringBuffer query = new StringBuffer();
			
			query.append(" SELECT ") ;
			query.append(" MEM_SEQ_NO, ") ;
			query.append(" MEM_ID, ") ;
			query.append(" MEM_PWD, ") ;
			query.append(" MEM_NAME, ") ;
			query.append(" MEM_PHONE, ") ;
			query.append(" MEM_EMAIL, ") ;
			query.append(" MEM_BIRTH, ") ;
			query.append(" MEM_ZIPCODE, ") ;
			query.append(" MEM_ADDR_MASTER, ") ;
			query.append(" MEM_ADDR_DETAIL, ") ;
			query.append(" MEM_TYPE ") ;
			query.append(" from tb_member") ;
			query.append(" where 1=1") ; //전체목록을 조회할 수 있는 조건문
			
			if(condition != null && !condition.isEmpty()) {
				if("id".equals(condition.get("searchType"))){
					query.append(" AND mem_id = ?") ;
				}else if("name".equals(condition.get("searchType"))){
					query.append(" AND mem_name Like concat('%' , ? , '%') ") ;
				}
			}
			//query.append("order by mem_seq_no desc"); 
			
			PreparedStatement pstmt = conn.prepareStatement(query.toString());
			
			int i = 1;
			
			if(condition != null && !condition.isEmpty()) {
				if("id".equals(condition.get("searchType"))){
					pstmt.setString(i++, (String)condition.get("searchWord"));
				}else if("name".equals(condition.get("searchType"))){
					pstmt.setString(i++, (String)condition.get("searchWord"));
				}
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				
				Member member = new Member();
				
				member.setMem_seq_no(rs.getInt("mem_seq_no"));
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_pwd(rs.getString("mem_pwd"));
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_phone(rs.getString("mem_phone"));
				member.setMem_email(rs.getString("mem_email"));
				member.setMem_birth(rs.getString("mem_birth"));
				member.setMem_zipcode(rs.getString("mem_zipcode"));
				member.setMem_addr_master(rs.getString("mem_addr_master"));
				member.setMem_addr_detail(rs.getString("mem_addr_detail"));
				member.setMem_type(rs.getString("mem_type"));
				
				memberList.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return memberList;
	}

	
	public Member selectMember(Connection conn, Map<String, Object> condition) throws Exception {
		Member member = null;
		
		try {
			StringBuffer query = new StringBuffer();
			
			query.append(" SELECT ") ;
			query.append(" MEM_SEQ_NO, ") ;
			query.append(" MEM_ID, ") ;
			query.append(" MEM_PWD, ") ;
			query.append(" MEM_NAME, ") ;
			query.append(" MEM_PHONE, ") ;
			query.append(" MEM_EMAIL, ") ;
			query.append(" MEM_BIRTH, ") ;
			query.append(" MEM_ZIPCODE, ") ;
			query.append(" MEM_ADDR_MASTER, ") ;
			query.append(" MEM_ADDR_DETAIL, ") ;
			query.append(" MEM_TYPE ") ;
			query.append(" from tb_member") ;
			query.append(" where 1=1") ; //전체목록을 조회할 수 있는 조건문
			if(condition != null && !condition.isEmpty()) {
				if(condition.containsKey("mem_seq_no")) {
					query.append("  AND mem_seq_no = ?");
				}
			}
			
			PreparedStatement pstmt = conn.prepareStatement(query.toString());
			
			int i = 1;
			
			if(condition != null && !condition.isEmpty()) {
				if(condition.containsKey("mem_seq_no")){
					pstmt.setInt(i++, (int) condition.get("mem_seq_no"));
				}
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMem_seq_no(rs.getInt("mem_seq_no"));
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_pwd(rs.getString("mem_pwd"));
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_phone(rs.getString("mem_phone"));
				member.setMem_email(rs.getString("mem_email"));
				member.setMem_birth(rs.getString("mem_birth"));
				member.setMem_zipcode(rs.getString("mem_zipcode"));
				member.setMem_addr_master(rs.getString("mem_addr_master"));
				member.setMem_addr_detail(rs.getString("mem_addr_detail"));
				member.setMem_type(rs.getString("mem_type"));
			}	
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		return member;
	}
	
}


























