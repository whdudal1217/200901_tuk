package kr.ac.hit.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.hit.member.model.Member;
import kr.ac.hit.member.service.imple.MemberServiceImple;
import kr.ac.hit.web.servlet.mvc.Controller;

public class MemberListController implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MemberServiceImple memberServiceImple = MemberServiceImple.getInstance();
		List<Member> memList = memberServiceImple.getMemberList();
		//이러고 돌려줄 jsp랑 memList map에 담아서 돌려주면 됨~!ㄴ 난 배가 너무 고픔
		return null;
	}

}
