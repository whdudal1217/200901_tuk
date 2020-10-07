package kr.ac.hit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.ac.hit.member.model.Member;
import kr.ac.hit.member.service.MemberService;
import kr.ac.hit.member.service.imple.MemberServiceImple;
import kr.ac.hit.web.servlet.mvc.Controller;

public class MemberDeleteController implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String strSeqNo = req.getParameter("seqNo");
		boolean isError = false;
		try {
			MemberService memberServiceImple = MemberServiceImple.getInstance();
			int updCnt = memberServiceImple.deleteMember(strSeqNo);
			if(updCnt == 0) {
				isError = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		String viewPage = "redirect:/member/memberList.do"; 
		String message = "정상적으로 삭제 되었습니다";
		String locationURL = req.getContextPath() + "/member/memberList.do";
		
		if(isError) {
			message = "회원삭제 실패!";
			viewPage = "/common/message.jsp";
		}
		req.setAttribute("isError", isError);
		req.setAttribute("message", message);
		req.setAttribute("locationURL", locationURL);
		
		return viewPage;
	}
	
}
