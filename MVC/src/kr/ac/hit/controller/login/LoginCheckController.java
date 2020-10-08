package kr.ac.hit.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.hit.member.model.Member;
import kr.ac.hit.member.service.MemberService;
import kr.ac.hit.member.service.imple.MemberServiceImple;
import kr.ac.hit.web.servlet.mvc.Controller;

public class LoginCheckController implements Controller{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String mem_id = req.getParameter("mem_id");
		String mem_pwd = req.getParameter("mem_pwd");
		System.out.println("LoginCheckController_mem_id : " + mem_id);
		System.out.println("LoginCheckController_mem_pwd : " + mem_pwd);
		HttpSession session = req.getSession();
		
		MemberService memberService = MemberServiceImple.getInstance();
		
		Map<String, Object> condition = new HashMap<String, Object>();
		
		if(mem_id!=null && mem_pwd!=null){
			condition.put("memId", mem_id);
			condition.put("memPwd", mem_pwd);
		}
		
		Member member = memberService.getMember(condition);
		
		String viewPage = ""; 
		String message = "";
		boolean isError = false;
		String locationURL = req.getContextPath() + "/member/memberList.do";
		
		if(member != null) {
			if(mem_pwd.equals(member.getMem_pwd())){
			message = "로그인 성공!!";
			session.setAttribute("LOGIN_USER", member);
			viewPage = "/common/message.jsp";
			isError = false;
			}
		}else{
			message = "해당 정보 존재하지 않습니다!";
			isError = true;
		}
		req.setAttribute("message", message);
		req.setAttribute("locationURL", locationURL);
		req.setAttribute("isError", isError);
		
		return viewPage;
	}

}
