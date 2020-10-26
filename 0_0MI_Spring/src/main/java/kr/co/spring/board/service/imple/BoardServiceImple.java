package kr.co.spring.board.service.imple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.spring.board.dao.BoardDao;
import kr.co.spring.board.model.BoardVo;
import kr.co.spring.board.service.BoardService;
import kr.co.spring.common.util.FileUtils;
import kr.co.spring.file.dao.FilteDao;
import kr.co.spring.file.model.FileItem;

@Service
public class BoardServiceImple implements BoardService{
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	FilteDao fileItemDao;
	
	@Autowired
	FileUtils fileUtils;
	
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
		boardVo = boardDao.selectBoard(paramMap);
		//파일 목록 조회
		Map<String,Object> fileParamMap = new HashMap<String, Object>();
		fileParamMap.put("ref_seq_no", boardVo.getBo_seq_no());
		fileParamMap.put("biz_type", boardVo.getBo_type());
		
		List<FileItem> fileList = fileItemDao.selectFileItemList(fileParamMap);
		boardVo.setFileList(fileList);
		
		return boardVo;
	}

	@Override
	@Transactional
	public int insertBoard(BoardVo board, MultipartHttpServletRequest mpReq) throws Exception {
		int updCnt = boardDao.insertBoard(board); //bo_seq_no가 미리 들어와있음, selectKey문을 먼저 실행하도록 했음 
		
		List<FileItem> fileList = fileUtils.uploadFiles(board, mpReq);
		
		for(FileItem fileItem : fileList) {
			fileItemDao.insertFileItem(fileItem);
		}
		
		return updCnt;
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
