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
			location.href="boardForm?boSeqNo="+${board.bo_seq_no}
		});
		
		$('#btnDel').click(function(){
			if(confirm("삭제하시겠습니까?")){
				location.href="boardDelete?boSeqNo="+${board.bo_seq_no}				
			}
		});
	});
</script>
</head>
<body>
<p></p>
<div class="container">
	<h2 align="center"> 게시글 상세보기 </h2>
	<table class="table">
			<tr>
				<td>제목</td>
				<td>${board.bo_title}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.bo_writer}</td>
			</tr>
			<tr>
				<td>마지막 수정자</td>
				<td>${board.upd_user}</td>
			</tr>
			<tr>
				<td>마지막 수정일</td>
				<td>${board.upd_date}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${board.reg_date}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${board.bo_hit_cnt}</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<c:if test="${not empty  board.fileList}">
						<c:forEach items="${board.fileList}" var="fileItem">
							<br/>
							파일명 : <a href="${pageContext.request.contextPath}/common/downLoad?file_seq_no=${fileItem.file_seq_no}">${fileItem.file_name}</a><br/>
							파일크기 : ${fileItem.file_fancy_size}<br/>
						</c:forEach>
					</c:if>
					<c:if test="${empty board.fileList}">
						첨부파일이 없습니다!
					</c:if>
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td style="white-space: pre;">${board.bo_content}</td>
			</tr>
	</table>
	<p align="center">
		<c:if test="${not empty sessionScope.LOGIN_USER || sessionScope.LOGIN_USER.mem_id == board.bo_writer}">
			<c:if test="${board.bo_type == 'Notice' && sessionScope.LOGIN_USER.mem_type == 'A' }">
				<input type="button" value="수정" class="btn btn-primary" onclick="location.href='noticeForm?bo_type=Notice&boSeqNo=${board.bo_seq_no}'">
				<input type="button" value="삭제" class="btn btn-primary" onclick="location.href='noticeDelete?bo_type=Notice&boSeqNo=${board.bo_seq_no}'">
			</c:if>
				<input type="button" value="목록" class="btn btn-primary" onclick="location.href='noticeList?bo_type=Notice'">
		</c:if>
	</p>
</div>
</body>
</html>