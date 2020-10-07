package kr.ac.hit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.ac.hit.member.model.Member;
import kr.ac.hit.member.service.MemberService;
import kr.ac.hit.member.service.imple.MemberServiceImple;
import kr.ac.hit.web.servlet.mvc.Controller;

public class MemberInsertController implements Controller{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Member member = new Member();
		//member.setMem_id(req.getParameter("mem_id"));
		BeanUtils.populate(member, req.getParameterMap()); // beabUtils.populate(mem_id ,mem_id : user1(멤버폼에서 입력한 밸류))
		
		boolean isError = false;
		
		try {
			MemberService memberService = MemberServiceImple.getInstance();
			int updCnt = memberService.insertMember(member);
			if(updCnt == 0) {
				isError = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		//성공!
		String viewPage = ""; 
		String message = "";
		String locationURL = req.getContextPath() + "/member/memberList.do?seqNo="+member.getMem_seq_no();
		
		if(!isError) {
			message = "정상적으로 회원가입이 되었습니다";
			viewPage = "/common/message.jsp";
		}
		
		if(isError) {
			message = "회원가입 실패!";
			viewPage = "/common/message.jsp";
		}
		
		req.setAttribute("isError", isError);
		req.setAttribute("message", message);
		req.setAttribute("locationURL", locationURL);
		
		return viewPage;
	}

}

















