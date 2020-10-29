<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>

<script type="text/javascript">

	$(document).ready(function(){
		
		$('#bo_title').focus();
		
		$('#btnGoList').click(function(){
			location.href="noticeList?bo_type=Notice"
		});
		
		$('#boardForm').validate({
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
				doSubmit();
			}
			
		});
		
		$frm = $("#boardForm");
		
		$(".btn-new-file", $frm).click(function() {
	
			$("#fileList").append(
				
				'<div>'+
				'<hr>'+
					'<input name="uploadFiles" id="uploadFiles" type="file" multiple="multiple" style="display: inline-block;" >'+
					'<button type="button" class="btn btn-primary btn-xs btn-delete-file" style="margin: 4px;" > x </button>'+
				'</div>'
			);
		});
		
		$("#fileList").on("click", ".btn-delete-file", function() {
			$(this).parent().remove();
		});
	
		function checkFiles() {
			var regex = new RegExp("(,*?)\.(exe|sh|alz|zip)");
			var maxSize = 10485760;
			var files = $("input[name = 'uploadFiles']")[0].files;
			for (var i = 0; i < files.length; i++) {
				var fileName = files[i].name;
				var fileSize = files[i].size;
				var ext = fileName.split(".").pop().toLowerCase();
			
				if(fileSize >= maxSize){
					alert("파일의 용량이 너무 큽니다");
				}
				if(regex.test(fileName)){
					alert("확장자가 불가능합니다.")
					return false;
				}
			}
				return true;
		}
	
		$(".btn-delete-exist").click(function() {
			$(this).parent().html("<input type= 'hidden' name='delFileSeq' value='"+ $(this).data("file_seq_no")  +"'>")
		});
		
	});
	
	
	
	function doSubmit(){
		
		var frm = document.boardForm;
		<c:if test = "${board.bo_seq_no == '0'}"> //공백조심
			frm.action = "noticeInsert";
		</c:if>
		
		<c:if test = "${board.bo_seq_no != 0}">	
			frm.action = "noticeUpdate";
		</c:if>
		frm.submit();
	}
	
	
</script>

</head>
<body>
	<div class="container">
		<h2 align="center">공지사항 글 등록</h2>
		<form name="boardForm" id="boardForm" method="post"  enctype="multipart/form-data">
			<input type="hidden" name="bo_type" id="bo_type" value="Notice">
			<input type="hidden" name="bo_seq_no" id="bo_seq_no"
				value="${board.bo_seq_no}">
			<table class="table">
				<tr>
					<td>제목</td>
					<td><input type="text" name="bo_title" id="bo_title"
						size="100" value="${board.bo_title}"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="hidden" name="bo_writer" id="bo_writer"
						size="20" value="${board.bo_writer}" /> <input type="text"
						name="bo_writer_name" id="bo_writer_name" readonly="readonly"
						value="${board.bo_writer}" /></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td>
						<c:forEach items="${board.fileList}" var="fileItem">
								<div>
									<p>${fileItem.file_name} (${fileItem.file_fancy_size})</p>
									<button type="button"
										class="btn btn-danger btn-xs btn-delete-exist"
										data-file_seq_no=${fileItem.file_seq_no} style="display: inline-block;">x</button>
								</div>
							</c:forEach>
							<p>
								<button type="button" class="btn btn-primary btn-xs btn-new-file" accept=".gif, .jpg, .png"> 추가 </button>
							<div id="fileList">
								<div>
									<input name="uploadFiles" id="uploadFiles" type="file"
										multiple="multiple">
									<button type="button"
										class="btn btn-primary btn-xs btn-delete-file">삭제</button>
								</div>
							</div>
							</p>
						</td>
				</tr>

				<tr>
					<td>내용</td>
					<td><textarea name="bo_content" id="bo_content" rows="15"
							cols="100">${board.bo_content}</textarea></td>
				</tr>
			</table>

			<p>
				<c:if test="${sessionScope.LOGIN_USER.mem_type == 'A' }">
					<input type="submit" value="저장" class="btn btn-primary" />
					<input type="reset" value="취소" class="btn btn-primary" />
					<input type="button" id="btnGoList" value="목록"
						class="btn btn-primary" />
				</c:if>
			</p>

		</form>
	</div>
</body>
</html>
