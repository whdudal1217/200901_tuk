package kr.co.spring.member.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Override
	public List<MemberVo> getMemberList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.selectMemberList(paramMap);
	}

	@Override
	public int getMemberCount(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.selectMemberCount(paramMap);
	}

	@Override
	public MemberVo getMember(Map<String, Object> paramMap) throws Exception {
		return memberDao.selectMember(paramMap);
	}

	@Override
	public int insertMember(MemberVo member) throws Exception {
		return memberDao.insertMember(member);
	}

	@Override
	public int updateMember(MemberVo member) {		
		return memberDao.updateMember(member);
	}

	@Override
	public int deleteMember(int seqNo) {
		return memberDao.deleteMember(seqNo);
	}

}
