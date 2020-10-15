package kr.co.spring.member.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import kr.co.spring.common.util.PagingUtil;
import kr.co.spring.member.model.MemberVo;
import kr.co.spring.member.service.MemberService;

@Controller
@RequestMapping(value="/member/")
public class MemberController {
	String veiw = "/member/";
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "memberTest")
	public String memberTest(Model model) throws Exception {
		ArrayList<MemberVo> memberList = new ArrayList<MemberVo>();
		memberList = memberService.selectMemberTest();
		model.addAttribute("memberList", memberList);
		return veiw + "memberTest";
	}
	
	@RequestMapping(value = "memberList")
	public String memberList(
			@RequestParam(value = "searchType", required = false, defaultValue = "") String searchType,
			@RequestParam(value = "searchWord", required = false, defaultValue = "") String searchWord,
			@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage,
			@RequestParam(value="pageSize", required = false, defaultValue = "10") int pageSize, Model model
			) throws Exception{
		int pageCount = 5;
		int totalCount = 0;
		List<MemberVo> memberList = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		if(!StringUtils.isBlank(searchType) && !StringUtils.isBlank(searchType)) {
			paramMap.put("searchType", searchType);
			paramMap.put("searchWord", searchWord);
		}
		
		//전체회원수
		totalCount = memberService.getMemberCount(paramMap);
		
		PagingUtil pagingUtil = new PagingUtil(currentPage, totalCount, pageSize, pageCount);
		
		paramMap.put("startRow",pagingUtil.getStartRow());
		paramMap.put("endRow",pagingUtil.getEndRow());
		
		memberList = memberService.getMemberList(paramMap);
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("pagingUtil", pagingUtil);
		
		return veiw + "memberList";
	}
	
	@RequestMapping(value = "memberView")
	public String memberView(@RequestParam(value = "seqNo", required = true)int SeqNo,
							 @RequestParam(value = "currentPage", required = true)int currentPage, Model model)throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(Integer.toString(currentPage) == "undefined") {
			currentPage = 1;
		}
		paramMap.put("mem_seq_no", SeqNo);
		MemberVo memVo = memberService.getMember(paramMap);
		model.addAttribute("member", memVo);
		model.addAttribute("currentPage", currentPage);
		
		return veiw + "memberView";
		
	}
	@RequestMapping(value = "memberForm")
	public String memberForm(@RequestParam(value = "seqNo", required = false, defaultValue = "0")int seqNo,
			Model model) {
		return veiw + "memberForm";
	}
	
	
}

















