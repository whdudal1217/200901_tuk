package kr.ac.hit.member.service;

import java.util.List;
import java.util.Map;

import kr.ac.hit.member.model.Member;

public interface MemberService {
	
	//회원정보 조회
	public List<Member> getMemberList(Map<String, Object> paramMap) throws Exception;
	//회원상세 조회
	public Member getMember(Map<String, Object> paramMap) throws Exception;
	//회원가입
	public int insertMember(Member member)throws Exception;
	//수정
	public int updateMember(Member member)throws Exception;
	//삭제
	public int deleteMember(String seqNo)throws Exception;
}
