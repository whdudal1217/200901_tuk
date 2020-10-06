package kr.ac.hit.member.service.imple;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import kr.ac.hit.common.jdbc.ConnectionProvider;
import kr.ac.hit.member.model.Member;
import kr.ac.hit.member.model.MemberDao;
import kr.ac.hit.member.service.MemberService;

public class MemberServiceImple implements MemberService {

	MemberDao memberDao = MemberDao.getInstance();

	private MemberServiceImple() {
	};

	private static MemberServiceImple instance = new MemberServiceImple();

	public static MemberServiceImple getInstance() {
		if (instance == null) {
			instance = new MemberServiceImple();
		}
		return instance;

	}

	@Override
	public List<Member> getMemberList(Map<String, Object> paramMap) throws Exception {

		Connection conn = null;
		List<Member> memberList = null;

		try {
			conn = ConnectionProvider.getConnection();
			memberList = memberDao.selectMemberList(conn, paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			conn.close();
		}

		return memberList;
	}

	@Override
	public Member getMember(Map<String, Object> paramMap) throws Exception {

		Connection conn = null;
		Member member = null;

		try {
			conn = ConnectionProvider.getConnection();
			member = memberDao.selectMember(conn, paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			conn.close();
		}
		return member;
	}

}
