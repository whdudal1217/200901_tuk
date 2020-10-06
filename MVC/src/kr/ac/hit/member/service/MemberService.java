package kr.ac.hit.member.service;

import java.util.List;
import java.util.Map;

import kr.ac.hit.member.model.Member;

public interface MemberService {
	
	//회원정보 조회
	public List<Member> getMemberList(Map<String, Object> paramMap) throws Exception;

	public Member getMember(Map<String, Object> paramMap) throws Exception;

}
