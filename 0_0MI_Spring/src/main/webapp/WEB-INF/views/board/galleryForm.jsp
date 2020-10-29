<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>

<script type="text/javascript">

	$(document).ready(function(){	
		
		$('#bo_title').focus();
		
		$('#btnGoList').click(function(){
			location.href="galleryList?bo_type=GALLERY"
		});
		
		$('#galleryForm').validate({
			rules : {
				bo_title : { required : true },
				bo_content :  "required" 
			},
			messages : {
				bo_title : "제목을 입력해주세요",
				bo_content : "내용을 입력해주세요"
			},
			submitHandler : function(frm){
				//유효성체크 후 실행되는 부분
				if(!checkFiles()){
					return false;
				}else{
					doSubmit();					
				}
			}
			
		});
		
		$frm = $("#galleryForm");
		//파일추가
		$(".btn-new-file", $frm).click(function () {
			$("#fileList").append(
				'<hr>'+
				'<div>'+
					'<input name="uploadFiles" id="uploadFiles" type="file" multiple="multiple" style="display: inline-block;" />'+
					'<button type="button" class="btn btn-primary btn-xs btn-delete-file" style="margin: 4px;"> x </button>' +
				'</div>'
			);
		});
		//파일삭제
		$('#fileList').on("click", ".btn-delete-file", function() {
			$(this).parent().remove();
		});
		
		
		function checkFiles(){
			var regex = new RegExp("(.*?)\.(exe|sh|alz|zip)$"); //정규식, 업로드 불가능하게 RegExp -jquery함수
			var maxSize = 10485760; //10 MB, 파일의 최대 사이즈
			var files = $("input[name = 'uploadFiles']")[0].files;
			for(var i=0; i<files.length; i++){
				var fileName = files[i].name;
				var fileSize = files[i].size;
				var ext = fileName.split(".").pop().toLowerCase(); // .아래로 전부 추출 후 -> pop 꺼내서 -> 소문자로 /
				console.log("file Name : " + fileName);
				console.log("file Size : " + fileSize);
				console.log("file 확장자 : " + ext);
				
				if(fileSize >= maxSize){
					alert("대용량 파일(10mb 이상)은 업로드 할 수 없습니다. ");
				}
				
				if(regex.test(fileName)){
					alert("해당 확장자는 업로드 불가능 합니다.");
					return false;
				}
				
				//특정 확장자만 업로드 할 수 있게
				/* if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1 ){ //inArray(배열, [값1,값2,값3]) -> 배열에 값1~값3까지의 데이터가 있으면 1을 반환
					alert("'gif','png','jpg','jpeg' 확장자만 업로드 할 수 있습니다.");
					return false;
				} */
			}
			return true;
		}
		
		//파일삭제
		$(".btn-delete-exist",).click(function () {
			//innerHtml 의 제이쿼리버전 ""가 바깥 ''가 안
			$(this).parent().html("<input type='hidden' name='delFileSeq' value='"+ $(this).data("file_seq_no")+ "'>")
		});
		// $(this).data("file_seq_no") -> 클릭한 나한테 있는 data-이름(data-file_seq_no) 의 밸류를 가져옴
	});
	
	function doSubmit(){
		
		var frm = document.galleryForm;
		<c:if test = "${gallery.bo_seq_no == '0'}"> //공백조심
			frm.action = "galleryInsert";
		</c:if>
		
		<c:if test = "${gallery.bo_seq_no != 0}">	
			frm.action = "galleryUpdate";
		</c:if>
		frm.submit();
	}
	
	
	
	
</script>

</head>
<body>
	<div class="container">
		<h2 align="center"> 게시글 등록 </h2>
		<form name="galleryForm" id="galleryForm" method="post" enctype="multipart/form-data">
			<input type="hidden" name="bo_type" id="bo_type" value="GALLERY" />
			<input type="hidden" name="bo_seq_no" id="bo_seq_no" value="${gallery.bo_seq_no}">
			<table class="table">
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="bo_title" id="bo_title" size="100" value="${gallery.bo_title}">
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>
						<input type="hidden" name="bo_writer" id="bo_writer" size="20" value="${gallery.bo_writer}" />
						<input type="text" name="bo_writer_name" id="bo_writer_name" readonly="readonly" value="${gallery.bo_writer}" />
					</td>
				</tr>
				<tr>
					<td>공개여부</td>
					<td>
						<input type="checkbox" name="bo_open_yn" id="bo_open_yn" value="Y" ${gallery.bo_open_yn == 'N' ? '' : 'checked'}/>
						&nbsp;&nbsp;&nbsp;(체크하면 비공개)
					</td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td> 
						<!-- 수정 시 업로드 된 파일 목록 -->
						<c:forEach items="${gallery.fileList}" var="fileItem">
							<div>
								<p>${fileItem.file_name} (${fileItem.file_fancy_size})</p>
								<button type="button" class="btn btn-danger btn-xs btn-delete-exist" data-file_seq_no=${fileItem.file_seq_no}
								style="display: inline-block;">x</button>
							</div> 
						</c:forEach>
						<p>
							<button type="button" class="btn btn-primary btn-xs btn-new-file"> 추가 </button>
								<div id="fileList">
									<div>
										<input name="uploadFiles" id="uploadFiles" type="file" multiple="multiple" />
										<button type="button" class="btn btn-primary btn-xs btn-delete-file"> 삭제 </button> 								
									</div>
								</div>
						</p> 
					</td>
				</tr>
				<tr>
					<td> 내용 </td>
					<td>
						<textarea name="bo_content" id="bo_content" rows="15" cols="100">${gallery.bo_content }</textarea>
					</td>
				</tr>
			</table>
			
			<p>
				<input type="submit" value="저장" class="btn btn-primary" />
				<input type="reset" value="취소" class="btn btn-primary" />
				<input type="button" id="btnGoList" value="목록" class="btn btn-primary" />
			</p>
			
		</form>
	</div>
</body>
</html>
