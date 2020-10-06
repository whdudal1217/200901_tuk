package kr.ac.hit.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.hit.member.model.Member;
import kr.ac.hit.member.service.imple.MemberServiceImple;
import kr.ac.hit.web.servlet.mvc.Controller;

public class MemberListController implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//서비스에서 회원정보 목록 받아오기
		MemberServiceImple memberServiceImple = MemberServiceImple.getInstance();		
		
		String searchType = req.getParameter("searchType");
		String searchWord = req.getParameter("searchWord");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		if(searchWord != null && searchType != null) {
			paramMap.put("searchType", searchType);
			paramMap.put("searchWord", searchWord);			
		}
		
		List<Member> memList = memberServiceImple.getMemberList(paramMap);

		req.setAttribute("memberList", memList);
		String viewPage = "/member/memberList.jsp";
		return viewPage;
	}

}
