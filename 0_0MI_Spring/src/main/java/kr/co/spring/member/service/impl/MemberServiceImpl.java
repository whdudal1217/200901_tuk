package kr.co.spring.member.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.spring.member.dao.MemberDao;
import kr.co.spring.member.model.MemberVo;
import kr.co.spring.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public ArrayList<MemberVo> selectMemberTest() throws Exception {
		/* 원래 이런 식으로 멤버다오의 메소드를 실행하고 그걸 어레이에 담아서 리턴으로 돌려줬지만
		 * @Service 어노테이션을 붙이면 그냥 리턴에 냅다 갖다 붙이면 됨
		 * ArrayList<MemberVo> memberList = new ArrayList<MemberVo>(); memberList =
		 * memberList = memberDao.selectMemberTest();
		 */
		return memberDao.selectMemberTest();
	}

}
