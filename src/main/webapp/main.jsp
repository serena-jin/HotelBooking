<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Grand Hotel</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<header class="w3-display-container w3-content" style="max-width:1500px;">
  <img class="w3-image" src="./images/hotel.jpg" alt="The Hotel" style="min-width:1000px" width="1500" height="800">
  <div class="w3-display-left w3-padding w3-col l6 m8">
    <div class="w3-container w3-red">
      <h2><i class="fa fa-bed w3-margin-right"></i>Welcome to Grand Hotel</h2>
    </div>    


    <div class="w3-container w3-white w3-padding-16">
    
    
    <form action="login" method="post">
        <div class="w3-row-padding" style="margin:0 -16px;">
          <div class="w3-half w3-margin-bottom">
            <label><i class="fa fa-user"></i> ID</label>
            <input type="text" name="loginId" value="id" onFocus="this.value=''">
          </div>
          <div class="w3-half">
            <label><i class="fa fa-lock"></i> Password</label>
            <input type="password" name="loginrPw" value="1234" onFocus="this.value=''">
          </div>
        </div>
        <button class="w3-button w3-dark-grey" type="submit">Log in</button>
	</form>

        
        <br><br><br>


	<form action="search" method="post">    
        <div class="w3-row-padding" style="margin:8px -16px;">
         <div class="w3-half">
            <label><i class="fa fa-search"></i> Search your booking</label>
          <input type="text" name="bookingSearchNo" value="booking number" onFocus="this.value=''">
          </div>
        </div>
        <button class="w3-button w3-dark-grey" type="submit">Search</button>
	</form>
    </div>
  </div>
  

</header>

</body>
</html>