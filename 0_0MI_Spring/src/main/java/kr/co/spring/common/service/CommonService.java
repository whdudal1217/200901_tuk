package kr.co.spring.common.service;

import java.util.Map;

import kr.co.spring.file.model.FileItem;

public interface CommonService {
	
	public FileItem getFileItem(Map<String,Object> paramMap) throws Exception;
	
}
