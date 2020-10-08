<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<script type="text/javascript">
	function memberDelete(seqNo) {
		if(confirm("정말로 삭제 하시겠습니까?")){
			location.href='memberDelete.do?seqNo='+seqNo
		}
	}
</script>
</head>
<body>
	<div class="container">
		<h2 align="center">회원 정보 상세</h2>
		<table class="table table-bordered">
			<tr>
				<td>순번</td>
				<td>${member.mem_seq_no}</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>${member.mem_id}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${member.mem_name}</td>
			</tr>
			<tr>
				<td>생일</td>
				<td>${member.mem_birth}</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>${member.mem_type}</td>
			</tr>
			<tr>
				<td>핸드폰</td>
				<td>${member.mem_phone}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${member.mem_email}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${member.mem_zipcode}</td>
				<td>${member.mem_addr_master}</td>
				<td>${member.mem_addr_detail}</td>
			</tr>
			<tr>
				<td colspan="2"> 
				<input type="button" value="수정" class="btn btn-default" 
				onclick="location.href='memberForm.do?seqNo=${member.mem_seq_no}'">
				<input type="button" value="삭제" class="btn btn-default"
				onclick="memberDelete(${member.mem_seq_no})">
				<input type="button" value="목록" class="btn btn-default" onclick="location.href='memberList.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>