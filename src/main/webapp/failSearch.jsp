<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<% String url = application.getContextPath() + "/"; %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>failSearch.jsp</title>
</head>
<body>

<br><br><br>

	<center>
		<h3>${requestScope.errorMsg}</h3>
		
		<br><br><br>
		입력하신 예약번호로 예약정보가 존재하지 않습니다. <br>
		<button onclick="location.href='main.html'">메인 화면으로 이동</button>
	</center>


</body>
</html>