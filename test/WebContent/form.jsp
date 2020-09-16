<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 폼 생성 </title>
</head>
<body>
	<form action = "/test/viewParameter.jsp" method="post">
		이름 : <input type="text" name="name" size="10"><br>
		주소 : <input type="text" name="address" size="30"><br>
		좋아하는 동물 : 
		<input type="checkbox" name="pet" value="cat">고영희<br>
		<input type="checkbox" name="pet" value="puppy">강아지<br>
		<input type="checkbox" name="pet" value="rabbit">토끼<br> 
		<input type="submit" value="전송">
	</form>
</body>
</html>