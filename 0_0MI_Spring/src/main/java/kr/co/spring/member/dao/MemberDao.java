package kr.co.spring.member.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.spring.member.model.MemberVo;

public interface MemberDao {
	
	public ArrayList<MemberVo> selectMemberTest() throws Exception;
	
	//tb_member 테이블의 전체 갯수
	public int selectMemberCount(Map<String, Object> paramMap) throws Exception;
	
	public List<MemberVo> selectMemberList(Map<String, Object> paramMap)throws Exception;
	
	//회원정보조회 1건
	public MemberVo selectMember(Map<String, Object> paramMap)throws Exception;
	
	//회원정보등록
	public int insertMember(MemberVo member);

	public int updateMember(MemberVo member);
	
	//회원정보수정
	//회원정보삭제
	
}
