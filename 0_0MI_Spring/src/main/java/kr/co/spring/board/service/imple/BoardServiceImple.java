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
	public BoardVo getBoard(int bo_seq_no) throws Exception {
		boardDao.updateHitCnt(bo_seq_no);
		return boardDao.selectBoard(bo_seq_no);
	}

}
