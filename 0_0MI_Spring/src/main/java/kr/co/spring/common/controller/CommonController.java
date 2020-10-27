package kr.co.spring.common.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.spring.common.service.CommonService;
import kr.co.spring.common.util.FileUtils;
import kr.co.spring.file.model.FileItem;

@Controller
public class CommonController {

	@Autowired
	CommonService comService;
	
	@RequestMapping(value = "/common/downLoad")
	public void fileDownLoad(
			@RequestParam(value = "file_seq_no", required= true) String fileSeqNo, HttpServletResponse resp
			) throws Exception{ //화면 새로고침이 없으므로 void타입
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("file_seq_no", fileSeqNo);
		
		FileItem fileItem = comService.getFileItem(paramMap);
		
		if(fileItem == null) { //첨부파일 넣었는데 모르고 db에서 지웠을 수도 있음
			throw new RuntimeException("첨부파일이 존재하지 않습니다.");
		}
		//파일 다운로드
		byte[] fileByte = org.apache.commons.io.FileUtils.readFileToByteArray(new File(FileUtils.filePath + "/" +
				fileItem.getFile_path() +"/"+ fileItem.getFile_save_name())); 
		//업로드 할 파일의 위치와 이름 정보를 주고 파일을 바이트 배열로 가지고 옴, 왜 바이트어레이로 받아오지?
		System.out.println("fileByte는 어떻게 생겼을까~? : "+fileByte);
		resp.setContentType("application/octet-stream");//MIME타입
		resp.setContentLength(fileByte.length);
		resp.setHeader("Content-Disposition", "attachment; fileName = \"" + URLEncoder.encode(fileItem.getFile_name(), "UTF-8")); //화면에 보여줄건지 다운 받을건지
		resp.getOutputStream().write(fileByte);
		resp.getOutputStream().flush();
		resp.getOutputStream().close();
	}
}


















