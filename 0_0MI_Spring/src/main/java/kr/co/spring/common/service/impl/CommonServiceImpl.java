package kr.co.spring.common.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.spring.common.service.CommonService;
import kr.co.spring.file.dao.FilteDao;
import kr.co.spring.file.model.FileItem;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	FilteDao fileDao;

	@Override
	public FileItem getFileItem(Map<String, Object> paramMap) throws Exception {
		return fileDao.selectFileItem(paramMap);
	}
	
}
