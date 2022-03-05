<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% 	
	String url = application.getContextPath() + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>예약 내역 상세 정보 화면</title>
</head>
<body>


<br><br><br>
<center>

${requestScope.successMsg}

<h3>예약 내역 상세 보기</h3>
<hr><p> 
 
<table border="1">
	<tr>
		<th>예약 번호</th><th>체크인 날짜</th><th>체크아웃 날짜</th><th>성인</th><th>어린이</th>
	</tr>
 	<tr>
 		<td>${booking.reservationNum}</td>
 		<td>${booking.checkin}</td>
 		<td>${booking.checkout}</td>
 		<td>${booking.adults}</td>
 		<td>${booking.kids}</td>
 	</tr>
</table>

<br><br><br>
<a href="probono?command=updateBookingAdults&bookingReservationNum=${booking.reservationNum}">성인 인원 수정하기</a>
<a href="probono?command=updateBookingKids&bookingReservationNum=${booking.reservationNum}">아동 인원 수정하기</a>
<a href="probono?command=deleteBooking&bookingReservationNum=${booking.reservationNum}">예약 취소하기</a>

&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/main.html">메인 화면 이동</a>

</center>


</body>
</html>