package kr.co.spring.member.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.spring.member.model.MemberVo;
import kr.co.spring.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/member/memberTest")
	public String memberTest(Model model) throws Exception {
		ArrayList<MemberVo> memberList = new ArrayList<MemberVo>();
		memberList = memberService.selectMemberTest();
		model.addAttribute("memberList", memberList);
		return "/member/memberTest";
	}
	
}
