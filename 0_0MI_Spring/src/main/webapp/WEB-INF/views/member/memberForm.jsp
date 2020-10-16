<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	var duplicateCheck = false;

	$(function() {
		$("#btn_idCheck").click(function() {
			fn_idCheck();
		});
		function fn_idCheck() {
			var frm = document.memberForm;
			var params = {
				"mem_id" : frm.mem_id.value
			};
			if (frm.mem_id.value == "") {
				alert("아이디를 입력해주세요");
				return false;
			}
			$.ajax({
				type : 'post',
				url : "memberExists",
				data : params,
				success : function(data, status) {
					duplicateCheck = data.result;
					if (data.result == "true") {

						$("#lbl_result").text("해당 아이디는 사용중 입니다.");
						duplicateCheck = false;

					} else {

						$("#lbl_result").text("해당 아이디는 사용 가능합니다.");
						duplicateCheck = true;

					}

				},
				error : function(error) {
					console.log(error);
					console.log(error.status);
				}
			});// -end ajax-
		} // -fn_idCheck()-
	}); // -function-

	function validate() {
		var frm = document.memberForm;

		/* if (!duplicateCheck) {
			alert("아이디 중복을 체큭 해주세요.");
			return false;
		} */

		if (frm.mem_name.value == "") {
			alert("이름을 입력해주세요.");
			frm.mem_name.focus();
			return false;
		}
		if (frm.mem_id.value == "") {
			alert("아이디를 입력해주세요.");
			frm.mem_id.focus();
			return false;
		}
		if (frm.mem_pwd.value == "") {
			alert("패스워드를 입력해주세요.");
			frm.mem_pwd.focus();
			return false;
		} else {
			if (frm.mem_pwd_ck.value == "") {
				alert("비밀번호 확인을 입력해주세요.");
				return false;
			} else {
				if (frm.mem_pwd.value != frm.mem_pwd_ck.value) {
					alert("비밀번호와 비밀번호 확인이 맞지 않습니다.");
					return false;
				}
			}
		}
		if (frm.mem_birth.value == "") {
			alert("생일 입력해주세요.");
			frm.mem_birth.focus();
			return false;
		}
		if (frm.mem_phone.value == "") {
			alert("전화번호를 입력해주세요.");
			frm.mem_phone.focus();
			return false;
		}
		if (frm.mem_email.value == "") {
			alert("이메일을 입력해주세요.");
			frm.mem_email.focus();
			return false;
		}
		return true;
	}

	function doSubmit(type) {
		
		var frm = document.memberForm;
		if (!validate()) {
			return false;
		}
		if (type == 1) {
			frm.mem_seq_no.value=0;
			frm.action = "memberInsert";
		}
		if (type == 2) {
			duplicateCheck = true;
			frm.action = "memberUpdate";
		}
		frm.submit();
	}
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	function execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
						var fullAddr = ''; //최종주소변수
						var extraAddr = ''; //최종주소변수
						if (data.userSelectedType === 'R') {
							fullAddr = data.roadAddress;
						} else {
							fullAddr = data.jibunAddress;
						}

						if (data.userSelectedType === 'R') {
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ','
										+ data.buildingName : data.buildingName);
							}
							fullAddr += (extraAddr !== '' ? '(' + extraAddr
									+ ')' : '');
						}
						document.getElementById('mem_zipcode').value = data.zonecode;
						document.getElementById('mem_addr_master').value = fullAddr;

						document.getElementById('mem_addr_detail').focus();
					}
				}).open();
	}
</script>
</head>
<body>
	<div>
		<form name="memberForm" method="post" accept-charset="utf-8">
			<input type="hidden" name="mem_seq_no" value="${member.mem_seq_no}">
			<table class="table table-bordered table-hover">
				<tr>
					<td>성명</td>
					<td><input type="text" name="mem_name" size="20"
						value="${member.mem_name}"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mem_id" size="20"
						value="${member.mem_id}"
						${member.mem_id == null ? '' : 'readonly' }>
					<c:if test="${member.mem_id == null}">
						<button type="button" class="btn btn-default" id="btn_idCheck">Id체크</button>
						<br/>
						<label id="lbl_result"></label>
					</c:if>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="mem_pwd" size="20">
						8~20자리 숫자와 영문자 조합</td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td><input type="password" name="mem_pwd_ck" size="20"">
					8~20자리 숫자와 영문자 조합
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="mem_birth" size="20"
						value="${member.mem_birth}"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="mem_phone" size="20"
						value="${member.mem_phone}"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="mem_email" size="20"
						value="${member.mem_email}"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<p>
							<input type="text" name="mem_zipcode" id="mem_zipcode" size="5"
								value="${member.mem_zipcode}" readonly="readonly">
							<button type="button" name="mem_address" id="mem_address" class="btn btn-default"
								onclick="execDaumPostcode()">우편번호검색</button>
						</p>
						<p>
							<input type="text" name="mem_addr_master" id="mem_addr_master" size="20"
								value="${member.mem_addr_master}" readonly="readonly">
						</p>
						<p>
							<input type="text" name="mem_addr_detail" id="mem_addr_detail" size="20"
								value="${member.mem_addr_detail}">
						</p>
					</td>
				</tr>
				<tr>
					<td colspan="2"><c:if test="${empty member.mem_id}">
							<input type="button" value="가입하기" class="btn btn-default"
								onclick="doSubmit(1);">
						</c:if> <c:if test="${not empty member.mem_id}">
							<input type="button" value="수정하기" class="btn btn-default"
								onclick="doSubmit(2);">
						</c:if> <input type="reset" value="취소" class="btn btn-default"> <input
						type="button" value="목룩" class="btn btn-default"
						onclick="location.href='memberList'">
				</tr>
			</table>


		</form>
	</div>
</body>
</html>