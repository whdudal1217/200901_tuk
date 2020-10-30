<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		$('#btnEdit').click(function(){
			location.href="boardForm?boSeqNo="+${gallery.bo_seq_no}
		});
		
		$('#btnDel').click(function(){
			if(confirm("삭제하시겠습니까?")){
				location.href="boardDelete?boSeqNo="+${gallery.bo_seq_no}				
			}
		});
	});
	
	function viewImage(fileSeqNo) {
		window.open("${pageContext.request.contextPath}/common/display?imgType=img&file_seq_no="+fileSeqNo+
				",height="+screen.height+",width="+screen.width+
				",location=no, menubar=no, status=no, toolbar=no,fullscreen=yes");
	}
</script>
</head>
<body>
<p></p>
<div class="container">
	<h2 align="center"> 갤러리 상세보기 </h2>
	<table class="table">
			<tr>
				<td>제목</td>
				<td>${gallery.bo_title}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${gallery.bo_writer}</td>
			</tr>
			<tr>
				<td>마지막 수정자</td>
				<td>${gallery.upd_user}</td>
			</tr>
			<tr>
				<td>마지막 수정일</td>
				<td>${gallery.upd_date}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${gallery.reg_date}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${gallery.bo_hit_cnt}</td>
			</tr>
			<tr>
				<td>공개여부</td>
				<td> ${gallery.bo_open_yn == 'Y' ? '공개' : '비공개' } </td>
			</tr>
			<tr>
				<td>첨부파일</td>
				
				<td>
					<c:if test="${not empty gallery.fileList}">
						<c:forEach items="${gallery.fileList}" var="fileItem">
							<br/>
							<div>
								<img class="img-thumbnail" style="width: 150px; width: 150px;" 
								src="${pageContext.request.contextPath}/common/display?file_seq_no=${fileItem.file_seq_no}" onclick="viewImage(${fileItem.file_seq_no})">
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${empty gallery.fileList}">
						첨부파일이 없습니다!
					</c:if>
				</td>
			
			</tr>
			<tr>
				<td>내용</td>
				<td style="white-space: pre;">${gallery.bo_content}</td>
			</tr>
	</table>
	<p align="center">
			<input type="button" value="갤러리 수정" class="btn btn-primary" onclick="location.href='galleryForm?bo_type=Notice&boSeqNo=${gallery.bo_seq_no}'">
			<input type="button" value="갤러리 삭제" class="btn btn-primary" onclick="location.href='galleryDelete?boSeqNo=${gallery.bo_seq_no}'">
			<input type="button" value="갤러리 목록" class="btn btn-primary" onclick="location.href='galleryList?bo_type=GALLERY'">
	</p>
</div>
</body>
</html>