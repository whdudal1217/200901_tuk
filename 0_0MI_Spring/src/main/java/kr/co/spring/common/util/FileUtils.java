package kr.co.spring.common.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.spring.board.model.BoardVo;
import kr.co.spring.file.model.FileItem;

@Component("fileUtils")
public class FileUtils {
	public static final String filePath = "C:\\Users\\HIT\\Desktop\\SpringUpload\\upload"; //서버가 분리되어 잇다면 서버경로도 입력
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	
	//파일 업로드 메소드
	public List<FileItem> uploadFiles(BoardVo board, MultipartHttpServletRequest mReq) throws Exception{
		
		List<FileItem> fileList = new ArrayList<FileItem>();
		
		List<MultipartFile> mfList = mReq.getFiles("uploadFiles");
		
		File file = null;
		
		for(MultipartFile parts : mfList) {
			if(parts.isEmpty() == false) {
				FileItem fileItem = new FileItem();
				//db에 저장될 형식
				fileItem.setRef_seq_no(board.getBo_seq_no()); //
				fileItem.setReg_user(board.getBo_writer()); //
				fileItem.setBiz_type(board.getBo_type()); //
				fileItem.setFile_fancy_size(getFancySize(parts.getSize())); //파일사이즈지정
				fileItem.setFile_size(parts.getSize()); 
				fileItem.setFile_name(parts.getOriginalFilename());//파일의 실제 이름
				fileItem.setFile_save_name(UUID.randomUUID().toString()+"_"+parts.getOriginalFilename());//실제 db에 저장 될 땐 랜덤으로 아이디를 만들어 저장
				fileItem.setFile_path(board.getBo_type()+"/"+dateFormat.format(new Date())); //파일이 지정된 경로
				fileItem.setFile_path(board.getBo_type()+"/"+dateFormat.format(new Date())); //파일이 지정된 경로
				
				//실제 파일 저장
				try {
					file = new File(filePath+"/"+fileItem.getFile_path()+"/"+fileItem.getFile_save_name());
					if(file.exists() == false) {
						file.mkdirs();
					}
					parts.transferTo(file); //outputStream을 쓸 수도 있고 transferTo를 사용할 수도 있음
					//확장자 추출
					String ext = parts.getOriginalFilename().substring(parts.getOriginalFilename().lastIndexOf(".")+1);
					
					if(MediaUtils.getMediaType(ext) != null && "GALLERY".equals(fileItem.getBiz_type())) {
						String thumbSaveName = createThum(fileItem.getFile_path(), fileItem.getFile_save_name(), ext);
						fileItem.setThumb_save_name(thumbSaveName);
					}
					//청부파일이 이미지, 갤러리 게시판인 경우 썸네일 이미지 생성
				} catch (Exception e) {
					e.printStackTrace();
				}
				fileList.add(fileItem);
			}
		}
		
		return fileList;
	}
	
	//파일 사이즈 연산 메소드
	public static String getFancySize(long size) {
		String fancy = "";
		DecimalFormat decimalFormat = new DecimalFormat();
		if(size < 1024) { 
			fancy = decimalFormat.format(size) + "bytes";
		}else if(size < (1024*1024)) {
			fancy = decimalFormat.format(size / 1024.0) + "Kb";
		}else {
			fancy = decimalFormat.format(size / (1024.0 * 1024.0)) + "Mb";
		}
		return fancy;
	}
	
	public String createThum(String path, String fileName, String ext) {
		BufferedImage sourceImg;
		String thumbnailName = "";
		
		try {
			sourceImg = ImageIO.read(new File(filePath+ File.separator + path, fileName));
			
			BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,150);
			thumbnailName = filePath + File.separator + path + File.separator + "thumb_" + fileName;
			//File.separator -> "\" or "/"
			File file = new File(thumbnailName);
			ImageIO.write(destImg, ext, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "thumb_"+fileName;
	}
	
}

















