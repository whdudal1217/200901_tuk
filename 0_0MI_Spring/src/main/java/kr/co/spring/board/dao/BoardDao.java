package kr.co.spring.board.dao;

import java.util.List;
import java.util.Map;

import kr.co.spring.board.model.BoardVo;

public interface BoardDao {
	//게시글 전체 글 개수
	public int selectBoardCount(Map<String,Object> map) throws Exception;
	
	//게시글 목록조회
	public List<BoardVo> selectBoardList(Map<String,Object> map) throws Exception;
	
	//게시글 한 건 조회
	public BoardVo selectBoard(int bo_seq_no) throws Exception;
	
	//게시글 조회수 증가
	public int updateHitCnt(int bo_seq_no) throws Exception;
	
	//게시글 등록
	public int insertBoard(BoardVo board)throws Exception;
	
	//게시글 수정
	public int updateBoard(BoardVo board)throws Exception;
	
	//게시글 삭제
	public int deleteBoard(BoardVo board) throws Exception;
	
}
