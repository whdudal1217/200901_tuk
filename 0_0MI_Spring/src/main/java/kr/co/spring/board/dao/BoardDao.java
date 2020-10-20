package kr.co.spring.board.dao;

import java.util.List;
import java.util.Map;

import kr.co.spring.board.model.BoardVo;

public interface BoardDao {
	//게시글 전체 글 개수
	public int selectBoardCount(Map<String,Object> map) throws Exception;
	
	//게시글 목록조회
	public List<BoardVo> selectBoardList(Map<String,Object> map) throws Exception;
}
