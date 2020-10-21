package kr.co.spring.board.service;

import java.util.List;
import java.util.Map;

import kr.co.spring.board.model.BoardVo;

public interface BoardService {
	
	public int getBoardCount(Map<String,Object> map) throws Exception ;
	
	//게시글 목록조회
	public List<BoardVo> getBoardList(Map<String,Object> map) throws Exception;
	
	//게시글 한 건 조회
	public BoardVo getBoard(int bo_seq_no) throws Exception;
	
}
