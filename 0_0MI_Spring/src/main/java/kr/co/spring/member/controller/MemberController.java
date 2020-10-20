package kr.co.spring.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.spring.common.util.PagingUtil;
import kr.co.spring.member.model.MemberVo;
import kr.co.spring.member.service.MemberService;

@Controller
@RequestMapping(value="/member/")
public class MemberController {
	String veiw = "/member/";
	@Autowired
	MemberService memberService;
	
	@Inject
	PasswordEncoder passwordEncoder; 
	//이거랑 같은 이름을 가진 bean 객체를 주입
	
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
		
		if(!StringUtils.isBlank(searchType) && !StringUtils.isBlank(searchWord)) {
			paramMap.put("searchType", searchType);
			paramMap.put("searchWord", searchWord);
		}
		
		System.out.println("searchWord : " + searchWord);
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
							 @RequestParam(value = "currentPage", required = true, defaultValue = "1")int currentPage, Model model)throws Exception {
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
	public ModelAndView memberForm(@RequestParam(value = "seqNo", required = false, defaultValue = "0")int seqNo,
			Model model) throws Exception {
		
		MemberVo member = new MemberVo();
		if(seqNo != 0) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("mem_seq_no", seqNo);
			member = memberService.getMember(paramMap);		
			System.out.println("paramMap엔 무엇이 들었을까요 : " + paramMap.get("mem_name"));
			System.out.println("memVo의 id는 :" + member.getMem_id());
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("member",member);
		mav.setViewName("/member/memberForm");
		
		return mav;
	}
	@RequestMapping(value = "memberExists", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> memberExists(@RequestParam(value = "mem_id", required = true)String mem_id) throws Exception {
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_id", mem_id);
		MemberVo memVo = memberService.getMember(paramMap);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(memVo != null) {
			resultMap.put("result", "true"); //사용중인 아이디
		}else {
			resultMap.put("result", "false"); //사용중이 아닌 아이디
		}
		return resultMap;
	}
	@RequestMapping(value = "memberInsert", method = RequestMethod.POST)
	public String memberInsert(Model model, MemberVo member) throws Exception{
		System.out.println("멤버인서트 컨트롤러");
		System.out.println("MEM_id : " + member.getMem_id());
		System.out.println("MEM_name : " + member.getMem_name());
		// mem_id(Vo) = mem_id (.jsp) 뷰에서 보내는 데이터와 vo에 저장하는 데이터의 이름이 같으면 
		boolean isError = false;
		
		try {
			String enPwd = passwordEncoder.encode(member.getMem_pwd());
			member.setMem_pwd(enPwd);
			System.out.println("암호화를 진행한 비밀번호 : " + enPwd);
			
			int updCnt = memberService.insertMember(member);
			
			if(updCnt == 0) {
				isError = true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		String viewPage = "/common/message";
		String message = "정상가입되셨습니다";
		if(isError) {
			message = "회원등록에 실패했습니다";
			model.addAttribute("isError", isError);
			model.addAttribute("message", message);
		}else {
			model.addAttribute("isError", isError);
			model.addAttribute("message", message);
			model.addAttribute("locationURL", "/member/memberList");
		}
		return viewPage;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(Model model, MemberVo member) throws Exception{
		// mem_id(Vo) = mem_id (.jsp) 뷰에서 보내는 데이터와 vo에 저장하는 데이터의 이름이 같으면 
		boolean isError = false;
		
		try {
			String enPwd = passwordEncoder.encode(member.getMem_pwd());
			member.setMem_pwd(enPwd);
			System.out.println("암호화를 진행한 비밀번호 : " + enPwd);

			int updCnt = memberService.updateMember(member);
			
			if(updCnt == 0) {
				isError = true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		String viewPage = "";
		String message = "";
		viewPage = "redirect:/member/memberView?seqNo="+ member.getMem_seq_no();
		message = "수정 되었습니다";
		if(isError) {
			message = "수정 실패했습니다";
			model.addAttribute("isError", isError);
			model.addAttribute("message", message);
		}else {
			model.addAttribute("isError", isError);
			model.addAttribute("message", message);
			viewPage = "/common/message";
		}
		return viewPage;
	}
	
	@RequestMapping(value = "memberDelete")
	public String memberDelete(Model model, @RequestParam(value = "seqNo", required = true)int seqNo) throws Exception{
		boolean isError = false;
		
		try {
			int updCnt = memberService.deleteMember(seqNo);
			
			if(updCnt == 0) {
				isError = true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		String viewPage = "";
		String message = "";
		viewPage = "/common/message";
		message = "삭제되었습니다";
		if(isError) {
			message = "삭제실패했습니다";
			model.addAttribute("isError", isError);
			model.addAttribute("message", message);
		}else {
			model.addAttribute("isError", isError);
			model.addAttribute("message", message);
			model.addAttribute("locationURL", "/member/memberList");
		}
		return viewPage;
	}
}

















