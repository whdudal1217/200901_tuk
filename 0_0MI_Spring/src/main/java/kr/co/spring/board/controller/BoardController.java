package kr.co.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.spring.board.model.BoardVo;
import kr.co.spring.board.service.BoardService;
import kr.co.spring.common.util.PagingUtil;
import kr.co.spring.member.model.MemberVo;

@Controller
@RequestMapping(value = "/board/")
public class BoardController {
	String veiw = "/board/";
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "boardList")
	public String memberList(
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
		
		boardList = boardService.getBoardList(paramMap);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagingUtil", pagingUtil);
		
		return veiw + "boardList";
	}
	
}
