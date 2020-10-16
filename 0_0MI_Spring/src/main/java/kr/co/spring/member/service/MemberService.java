package kr.co.spring.member.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.spring.member.model.MemberVo;

public interface MemberService {
	public ArrayList<MemberVo> selectMemberTest() throws Exception;
	public List<MemberVo> getMemberList(Map<String,Object> paramMap)throws Exception;
	public int getMemberCount(Map<String, Object> paramMap)throws Exception;
	public MemberVo getMember(Map<String, Object> paramMap)throws Exception;
	public int insertMember(MemberVo member)throws Exception;
	public int updateMember(MemberVo member); 
}
