package kr.co.spring.member.dao;

import java.util.ArrayList;

import kr.co.spring.member.model.MemberVo;

public interface MemberDao {
	
	public ArrayList<MemberVo> selectMemberTest() throws Exception;
	
}
