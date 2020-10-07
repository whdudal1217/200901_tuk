package kr.ac.hit.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.hit.member.model.Member;
import kr.ac.hit.member.service.MemberService;
import kr.ac.hit.member.service.imple.MemberServiceImple;
import kr.ac.hit.web.servlet.mvc.Controller;

public class MemberFormController implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String strSeqNo = req.getParameter("seqNo");
		int seqNo = 0;
		
		Member member = new Member();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		if(strSeqNo != null) {
			seqNo = Integer.parseInt(strSeqNo);
			paramMap.put("mem_seq_no", seqNo);
			MemberService memberService = MemberServiceImple.getInstance();
			member = memberService.getMember(paramMap);
		}
		System.out.println(member.getMem_seq_no() + " = seqNO FormController");
		req.setAttribute("member", member);
		String viewPage = "/member/memberForm.jsp";
		return viewPage;
	}

}
