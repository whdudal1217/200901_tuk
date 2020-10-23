package kr.co.spring.board.service.imple;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import kr.co.spring.board.dao.BoardDao;
import kr.co.spring.board.model.BoardVo;
import kr.co.spring.board.service.BoardService;

@Service
public class BoardServiceImple implements BoardService{
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public int getBoardCount(Map<String, Object> map) throws Exception {
		return boardDao.selectBoardCount(map);
	}

	@Override
	public List<BoardVo> getBoardList(Map<String, Object> map)  throws Exception {
		return boardDao.selectBoardList(map);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardVo getBoard(Map<String, Object> paramMap) throws Exception {
		BoardVo boardVo = new BoardVo();
		boardVo.setBo_seq_no((int) paramMap.get("bo_seq_no"));
		boardDao.updateHitCnt(boardVo.getBo_seq_no());
		return boardDao.selectBoard(paramMap);
	}

	@Override
	public int insertBoard(BoardVo board) throws Exception {
		return boardDao.insertBoard(board);
	}

	@Override
	public int updateBoard(BoardVo board) throws Exception {
		return boardDao.updateBoard(board);
	}

	@Override
	public int deleteBoard(BoardVo board) throws Exception {		
		return boardDao.deleteBoard(board);
	}
	
}
