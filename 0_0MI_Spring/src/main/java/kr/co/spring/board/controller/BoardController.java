package kr.co.spring.board.controller;

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
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "boardList")
	public String boardList(
			@RequestParam(value = "searchType", required = false, defaultValue = "") String searchType,
			@RequestParam(value = "searchWord", required = false, defaultValue = "") String searchWord,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
			@RequestParam(value = "bo_type" , required = true) String bo_type, Model model
			) throws Exception{
		
		int pageCount = 5;
		int totalCount = 0;
		
		List<BoardVo> boardList = null;
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
		boardList = boardService.getBoardList(paramMap);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagingUtil", pagingUtil);
		
		return "/board/boardList";
	}
	
	@RequestMapping(value = "boardView")
	public String boardView(@RequestParam(value = "boSeqNo", required = true)int bo_seq_no, Model model) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bo_seq_no", bo_seq_no);
		
		BoardVo board = boardService.getBoard(paramMap);
		model.addAttribute("board", board);
		return "/board/boardView";
	}
	
	@RequestMapping(value="boardForm")
	public String boardForm( @RequestParam(value = "boSeqNo", required = false, defaultValue = "0") int bo_seq_no,
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
		model.addAttribute("board",boardVo);
		
		return "/board/boardForm";
		
	}
	
	@RequestMapping(value = "boardInsert")
	public String boardInsert( BoardVo board ,
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
		String viewPage = "redirect:/board/boardList?bo_type=BBS";
		String message = "글이 등록되었습니다";
		if(isError) {
			message = "글 등록에 실패했습니다.";
			viewPage = "common/meessage";
			model.addAttribute("message", message);
			model.addAttribute("isError", isError);
		}
		return viewPage;
	}
	
	@RequestMapping(value = "boardUpdate")
	public String boardUpdaet(BoardVo boardVo ,HttpSession session, Model model, MultipartHttpServletRequest mReq) throws Exception {
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
		
		viewPage="redirect:/board/boardView?boSeqNo="+boardVo.getBo_seq_no();
		message="수정되었습니다.";
		if(isError) {
			viewPage="common/message";
			message="글 수정에 실패했습니다.";
			model.addAttribute("message",message);
			model.addAttribute("isError",isError);
		}else {
			viewPage="common/message";
			locationURL="/board/boardView?boSeqNo="+boardVo.getBo_seq_no();
			model.addAttribute("message",message);
			model.addAttribute("isError",isError);
			model.addAttribute("locationURL",locationURL);
			message ="수정되었습니당!";
		}
		return viewPage;
	}
	
	@RequestMapping(value = "boardDelete")
	public String boardDelete(@RequestParam(value = "boSeqNo", required = true)int seqNo,Model model, HttpSession session ) {
		boolean isError = false;
		try {
			MemberVo memVo = (MemberVo) session.getAttribute("LOGIN_USER");
			BoardVo boardVo = new BoardVo();
			boardVo.setBo_seq_no(seqNo);
			boardVo.setUpd_user(memVo.getMem_id());
			
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
			locationURL ="/board/boardList?bo_type=BBS";
			model.addAttribute("isError", isError);
			model.addAttribute("locationURL",locationURL);
			model.addAttribute("message",message);
		}
		
		return viewPage;
	}
	
	@RequestMapping("noticeList")
	public String noticeList(@RequestParam(value = "bo_type", required = true) String bo_type,
							@RequestParam(value = "searchType", required = false, defaultValue = "") String searchType,
							@RequestParam(value = "searchWord", required = false, defaultValue = "") String searchWord,
							@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
							@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize, Model model) throws Exception {
		
			int pageCount = 5;
			int totalCount = 0;
			
			List<BoardVo> boardList = null;
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
			boardList = boardService.getBoardList(paramMap);
			model.addAttribute("boardList", boardList);
			model.addAttribute("pagingUtil", pagingUtil);
			
			return "/board/noticeList";
		
	}
	
	@RequestMapping("noticeForm")
	public String noticeForm( @RequestParam(value = "boSeqNo", required = false, defaultValue = "0") int bo_seq_no,
			HttpSession session, Model model) throws Exception {
		BoardVo boardVo = new BoardVo();
		MemberVo member = new MemberVo();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bo_seq_no", bo_seq_no);
		paramMap.put("bo_type", "Notice");
		
		System.out.println("bo_seq_no" + paramMap.get("bo_seq_no"));
		if(bo_seq_no != 0) {
			
				boardVo = boardService.getBoard(paramMap);		
		}else {
			member = (MemberVo) session.getAttribute("LOGIN_USER");
			boardVo.setBo_writer(member.getMem_id());
			boardVo.setBo_writer_name(member.getMem_name());
		}
		model.addAttribute("board",boardVo);
		
		return "/board/noticeForm";
		
	}
	
	@RequestMapping(value = "noticeView")
	public String noticeView(@RequestParam(value = "boSeqNo", required = true)int bo_seq_no, Model model) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bo_seq_no", bo_seq_no);
		
		BoardVo board = boardService.getBoard(paramMap);
		model.addAttribute("board", board);
		return "/board/noticeView";
	}
	
	@RequestMapping(value = "noticeInsert")
	public String noticeInsert( BoardVo board , Model model) throws Exception{
		boolean isError = false;
		try {
			int updCnt = boardService.insertBoard(board, null);
			if(updCnt == 0) {
				isError = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		String viewPage = "redirect:/board/noticeList?bo_type=Notice";
		String message = "글이 등록되었습니다";
		if(isError) {
			message = "글 등록에 실패했습니다.";
			viewPage = "common/meessage";
			model.addAttribute("message", message);
			model.addAttribute("isError", isError);
		}
		return viewPage;
	}
	
	@RequestMapping(value = "noticeUpdate")
	public String noticeUpdaet(BoardVo boardVo ,HttpSession session, Model model, MultipartHttpServletRequest mReq) throws Exception {
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
		
		viewPage="redirect:/board/boardView?boSeqNo="+boardVo.getBo_seq_no();
		message="수정되었습니다.";
		if(isError) {
			viewPage="common/message";
			message="글 수정에 실패했습니다.";
			model.addAttribute("message",message);
			model.addAttribute("isError",isError);
		}else {
			viewPage="common/message";
			locationURL="/board/boardView?boSeqNo="+boardVo.getBo_seq_no();
			model.addAttribute("message",message);
			model.addAttribute("isError",isError);
			model.addAttribute("locationURL",locationURL);
			message ="수정되었습니당!";
		}
		return viewPage;
	}
	
	@RequestMapping(value = "noticeDelete")
	public String noticeDelete(@RequestParam(value = "boSeqNo", required = true)int seqNo,Model model, HttpSession session ) {
		boolean isError = false;
		try {
			MemberVo memVo = (MemberVo) session.getAttribute("LOGIN_USER");
			BoardVo boardVo = new BoardVo();
			boardVo.setBo_seq_no(seqNo);
			boardVo.setUpd_user(memVo.getMem_id());
			
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
			locationURL ="/board/noticeList?bo_type=Notice";
			model.addAttribute("isError", isError);
			model.addAttribute("locationURL",locationURL);
			model.addAttribute("message",message);
		}
		
		return viewPage;
	}
	
	
}




















