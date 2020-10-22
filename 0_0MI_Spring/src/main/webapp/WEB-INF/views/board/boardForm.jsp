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
			location.href="boardList?bo_type=BBS"
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
	});
	
	function doSubmit(){
		
		var frm = document.boardForm;
		<c:if test = "${board.bo_seq_no == '0'}"> //공백조심
			frm.action = "boardInsert";
		</c:if>
		
		<c:if test = "${board.bo_seq_no != 0}">	
			frm.action = "boardUpdate";
		</c:if>
		frm.submit();
	}
	
	
</script>

</head>
<body>
	<div class="container">
		<h2 align="center"> 게시글 등록 </h2>
		<form name="boardForm" id="boardForm" method="post">
			<input type="hidden" name="bo_type" id="bo_type" value="BBS">
			<input type="hidden" name="bo_seq_no" id="bo_seq_no" value="${board.bo_seq_no}">
			<table class="table">
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="bo_title" id="bo_title" size="100" value="${board.bo_title}">
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>
						<input type="hidden" name="bo_writer" id="bo_writer" size="20" value="${board.bo_writer}" />
						<input type="text" name="bo_writer_name" id="bo_writer_name" readonly="readonly" value="${board.bo_writer}" />
					</td>
				</tr>
				<tr>
					<td>공개여부</td>
					<td>
						<input type="checkbox" name="bo_open_yn" id="bo_open_yn" value="Y" ${board.bo_open_yn == 'N' ? '' : 'checked'}/>
						&nbsp;&nbsp;&nbsp;(체크하면 비공개)
					</td>
				</tr>
				<tr>
					<td> 내용 </td>
					<td>
						<textarea name="bo_content" id="bo_content" rows="15" cols="100">${board.bo_content }</textarea>
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
