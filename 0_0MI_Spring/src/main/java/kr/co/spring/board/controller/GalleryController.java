package kr.co.spring.board.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.spring.board.model.BoardVo;
import kr.co.spring.board.service.BoardService;
import kr.co.spring.common.util.PagingUtil;
import kr.co.spring.member.model.MemberVo;

@Controller
@RequestMapping(value = "/board/")
public class GalleryController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "galleryList")
	public String galleryList(
			@RequestParam(value = "searchType", required = false, defaultValue = "") String searchType,
			@RequestParam(value = "searchWord", required = false, defaultValue = "") String searchWord,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
			@RequestParam(value = "bo_type" , required = true) String bo_type, Model model
			) throws Exception{
		
		int pageCount = 5;
		int totalCount = 0;
		
		List<BoardVo> galleryList = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		
		if(!StringUtils.isBlank(searchType) && !StringUtils.isBlank(searchWord)) {
			paramMap.put("searchType", searchType);
			paramMap.put("searchWord", searchWord);
		}
		paramMap.put("bo_type", bo_type);
		
		totalCount = boardService.getBoardCount(paramMap);
				
		PagingUtil pagingUtil = new PagingUtil(currentPage, totalCount, pageSize, pageCount);
		
		paramMap.put("startRow",pagingUtil.getStartRow()+"");
		paramMap.put("endRow",pagingUtil.getEndRow()+"");
		System.out.println("pagingUtil.getEndRow() : "+pagingUtil.getEndRow());
		galleryList = boardService.getGallertList(paramMap);
		model.addAttribute("boardList", galleryList);
		model.addAttribute("pagingUtil", pagingUtil);
		
		return "/board/galleryList";
	}
	
	@RequestMapping(value = "galleryView")
	public String galleryView(@RequestParam(value = "boSeqNo", required = true)int bo_seq_no, Model model) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bo_seq_no", bo_seq_no);
		
		BoardVo board = boardService.getBoard(paramMap);
		model.addAttribute("gallery", board);
		return "/board/galleryView";
	}
	
	@RequestMapping(value="galleryForm")
	public String galleryForm( @RequestParam(value = "boSeqNo", required = false, defaultValue = "0") int bo_seq_no,
			HttpSession session, Model model
			) throws Exception {
		
		BoardVo boardVo = new BoardVo();
		MemberVo member = new MemberVo();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bo_seq_no", bo_seq_no);
		
		if(bo_seq_no != 0) {
			boardVo = boardService.getBoard(paramMap);
		}else {
			member = (MemberVo) session.getAttribute("LOGIN_USER");
			boardVo.setBo_writer(member.getMem_id());
			boardVo.setBo_writer_name(member.getMem_name());
		}
		model.addAttribute("member", member);
		model.addAttribute("gallery",boardVo);
		
		return "/board/galleryForm";
		
	}
	
	@RequestMapping(value = "galleryInsert")
	public String galleryInsert( BoardVo board ,
			MultipartHttpServletRequest mpReq, Model model) throws Exception{
		boolean isError = false;
		try {
			int updCnt = boardService.insertBoard(board, mpReq);
			if(updCnt == 0) {
				isError = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		String viewPage = "redirect:/board/galleryList?bo_type=GALLERY";
		String message = "글이 등록되었습니다";
		if(isError) {
			message = "글 등록에 실패했습니다.";
			viewPage = "common/message";
			model.addAttribute("message", message);
			model.addAttribute("isError", isError);
		}
		return viewPage;
	}
	
	@RequestMapping(value = "galleryUpdate")
	public String galleryUpdaet(BoardVo boardVo ,HttpSession session, Model model, MultipartHttpServletRequest mReq) throws Exception {
		boolean isError = false;
		try {
			MemberVo member = (MemberVo) session.getAttribute("LOGIN_USER");
			boardVo.setUpd_user(member.getMem_id());
			int updCnt = boardService.updateBoard(boardVo,mReq);
			if(updCnt ==0) {
				isError = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		
		String viewPage = "";
		String message = "";
		String locationURL ="";
		
		viewPage="redirect:/board/galleryView?boSeqNo="+boardVo.getBo_seq_no();
		message="수정되었습니다.";
		if(isError) {
			viewPage="common/message";
			message="글 수정에 실패했습니다.";
			model.addAttribute("message",message);
			model.addAttribute("isError",isError);
		}else {
			viewPage="common/message";
			locationURL="/board/galleryView?boSeqNo="+boardVo.getBo_seq_no();
			model.addAttribute("message",message);
			model.addAttribute("isError",isError);
			model.addAttribute("locationURL",locationURL);
			message ="수정되었습니당!";
		}
		return viewPage;
	}
	
	@RequestMapping(value = "galleryDelete")
	public String galleryDelete(@RequestParam(value = "boSeqNo", required = true)int seqNo,Model model, HttpSession session ) {
		boolean isError = false;
		try {
			MemberVo memVo = (MemberVo) session.getAttribute("LOGIN_USER");
			BoardVo boardVo = new BoardVo();
			boardVo.setBo_seq_no(seqNo);
			boardVo.setUpd_user(memVo.getMem_id());
			
			File file = new File("파일을 경로");
			if(file.exists()) {
				file.delete();
			}else {
				//파일 업는 경우
			}
			
			int delCnt = boardService.deleteBoard(boardVo);
			
			if(delCnt == 0) {
				isError = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		String viewPage = "";
		String message = "";
		String locationURL ="";
		
		if(isError) {
			viewPage = "common/message";
			message = "삭제 실패했습니다.";
			model.addAttribute("isError", isError);
			model.addAttribute("viewPage",viewPage);
			model.addAttribute("message",message);
		}else {
			viewPage = "common/message";
			message = "삭제 성공했습니다.";
			locationURL ="/board/galleryList?bo_type=GALLERY";
			model.addAttribute("isError", isError);
			model.addAttribute("locationURL",locationURL);
			model.addAttribute("message",message);
		}
		
		return viewPage;
	}
	
	
}




















