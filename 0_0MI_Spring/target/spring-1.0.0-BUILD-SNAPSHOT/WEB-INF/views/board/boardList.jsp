<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<title> BoardList </title>
<script type="text/javascript">

	/* function goViewPage(seqNo,currentPage) {
		if(typeof currentPage == "undefined"){
			currentPage = 1;
		}
		location.href ="memberView?seqNo="+seqNo+"&currentPage="+currentPage;
	} */
	
	function doSearch(page) {
		var frm = document.searchForm;
		
		if(frm.searchType.value != "" && frm.searchWord.value == "" ){
			alert('검색어를 입력해주세요');
			return false;
		}else if (frm.searchType.value == '00' ) {
			alert("검색조건을 선택해주세요")
		}
		
		frm.currentPage.value = page;
		frm.action = "boardList";
		frm.submit();
	}
</script>
<meta charset="UTF-8">
</head>
<body>
	<div class="container">
			<h2 align="center"> 게시글 목록 </h2>
			<p align="right"> 
					<input type="button" value="게시판글쓰기" class="btn btn-primary" onclick="location.href='boardForm'">
			</p>
			<form name="searchForm" method="post">
				<p align="center">
					<input type="hidden" name="currentPage" value="${param.currentPage}">
					<input type="hidden" name="bo_type" value="BBS"> <!-- 일반 게시판 : BBS -->
					<select name="searchType">
						<option value=""> 전체 </option>
						<option ${param.searchType == '01' ? 'selected' : '' } value="01">제목</option>
						<option ${param.searchType == '02' ? 'selected' : '' } value="02">내용</option>
						<option ${param.searchType == '03' ? 'selected' : '' } value="03">제목 + 내용</option>
						<option ${param.searchType == '04' ? 'selected' : '' } value="04">작성자</option>
					</select>
					<input type="text" name="searchWord" size="40" value="${param.searchWord}">
					<input type="button" value="검색" onclick="doSearch(1);">
					<label> 총 게시글 : ${pagingUtil.totalCount }</label>
					<span style="float: right;"> 
						<label> 페이지 사이즈</label> 
						<select name="pageSize" onchange="doSearch(1);">
							<option ${param.pageSize == '10' ? 'selected' : '' } value="10">10개</option>
							<option ${param.pageSize == '20' ? 'selected' : '' } value="20">20개</option>
							<option ${param.pageSize == '50' ? 'selected' : '' } value="50">50개</option>
						</select>
					</span>
				</p>
			</form>
			
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty boardList}">
						<c:forEach var="boardList" items="${boardList}">
						<tr >
							<td>${boardList.rownum}</td>
							<td><a href="boardView?boSeqNo=${boardList.bo_seq_no}&boType=${boardList.bo_type}">${boardList.bo_title}</a></td>
							<td>${boardList.bo_writer_name}</td>
							<td>${boardList.reg_date}</td>
							<td>${boardList.bo_hit_cnt}</td>
						</tr>
					</c:forEach>
					</c:if>
					
					<c:if test="${empty boardList}">
						데이터가 없습니다
					</c:if>
				</tbody>
			</table>
			<div style="text-align: center;">
				<ul class="pagination">
					${pagingUtil.pageHtml}
				</ul>
			</div>
	</div>

</body>
</html>