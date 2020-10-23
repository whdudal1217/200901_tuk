package kr.co.spring.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.Session;

import kr.co.spring.member.model.MemberVo;
import kr.co.spring.member.service.MemberService;

@Controller
@RequestMapping("/login/")
public class loginController{
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "login/loginForm";
	}

	@RequestMapping(value ="loginForm", method = RequestMethod.POST)
	public String loginForm(@RequestParam(value="mem_id", required = true) String mem_id,
							@RequestParam(value="mem_pwd", required = true) String mem_pwd,
							Model model, HttpSession sessoin ) throws Exception{
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_id", mem_id);
		MemberVo resultMmeber = memberService.getMember(paramMap);
		boolean isError = false;
		String message = "";
		if(resultMmeber == null) { //아이디가 일치하면 트루
			message = "회원정보가 없습니다";
			isError = true;
		}else {// 비밀번호가 일치하면 트루
			boolean isCheck = passwordEncoder.matches(mem_pwd, resultMmeber.getMem_pwd());
			
			if(isCheck) {
				isError = false;
			}else {
				isError = true;
			}
		}
		
		if(isError) { //로그인 실패 - 이즈에러 트루
			isError = true;
			message = "회원정보가 없습니다";
		}else {  //로그인 성공 - 이즈에러 펄스
			isError = false;
			message = resultMmeber.getMem_name()+"님 환영합니다";
			sessoin.setAttribute("LOGIN_USER", resultMmeber);
			model.addAttribute("locationURL", "/member/memberList");
		}
		model.addAttribute("isError", isError);
		model.addAttribute("message", message);
		return "common/message";
	}
	
	@RequestMapping("logOut")
	public String logOut(HttpSession session){
		session.invalidate();
//		session.removeAttribute("LOGIN_USER");
//		session.setAttribute("LOGIN_USER", null);
		return "redirect:/";
	}
}
