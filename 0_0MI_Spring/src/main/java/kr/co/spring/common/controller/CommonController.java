package kr.co.spring.common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.spring.common.service.CommonService;
import kr.co.spring.common.util.FileUtils;
import kr.co.spring.common.util.MediaUtils;
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
	
	@RequestMapping(value = "/common/display")
	@ResponseBody //화면이동이 없이 결과를 돌려쥼
	public ResponseEntity<byte[]> display(@RequestParam(value="file_seq_no", required = false)String fileSeqNo,
			@RequestParam(value="imgType", required = false)String imgType) throws IOException{
		
		InputStream input = null;
		ResponseEntity<byte[]> entity = null; //이미지를 바이트 배열로 읽어와서 화면에 보여주기 위해
		
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("file_seq_no", fileSeqNo);
			FileItem fileItem = comService.getFileItem(paramMap);
			
			String ext = fileItem.getFile_name().substring(fileItem.getFile_name().lastIndexOf(".")+1);
			MediaType mediaType = null;
			
			mediaType = MediaUtils.getMediaType(ext);
			
			HttpHeaders header = new HttpHeaders();
			
			if(mediaType != null) {
				if(!StringUtils.isEmpty(imgType) && imgType.equals("img")) {
					input = new FileInputStream(FileUtils.filePath + "/" +fileItem.getFile_path()+"/"+fileItem.getFile_save_name()); 
				}else {
					input= new FileInputStream(FileUtils.filePath + "/" +fileItem.getFile_path()+"/"+fileItem.getThumb_save_name());
				}
				header.setContentType(mediaType);
				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(input),header,HttpStatus.CREATED);
			}else {
				System.out.println("media type is null");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			input.close();
		}
		return entity;
		
	}
	
}


















