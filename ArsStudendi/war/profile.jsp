<!DOCTYPE html> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html> 
<head> 
	<title>ArsStudendi</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>
	<script type="text/javascript"></script>
</head>
<body> 

<div data-role="page">

	<div data-role="header" data-theme="b">
	 	<a href="index.jsp" data-role="button" data-icon="home" data-iconpos="notext">Home</a>
		<h1>Profile Settings</h1>
		
		<div data-role="content">	
			
	</div><!-- /content -->
	
		<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>
	</div><!-- /header -->
	
	
	
	<br>
	<div>
	<p>First name: <%String firstName = (String)request.getAttribute("studentFirstName"); %>
		<%out.println(firstName); %> 	
		
	<a href="#popupFirstName" data-rel="popup" data-position-to="window" data-role="button" data-inline="true" data-corners="true" data-shadow="true" data-iconshadow="true" data-wrapperels="span" data-theme="c" aria-haspopup="true" aria-owns="#popupFirstName" class="ui-btn ui-shadow ui-btn-corner-all ui-btn-inline ui-btn-up-c"><span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text">Form</span></span></a>
	
	<div class=​"ui-popup-container ui-popup-active" id=​"popupFirstName-popup" style=​"max-width:​ 1570px;​ top:​ 432.5px;​ left:​ 682px;​" tabindex=​"0">​<div class="ui-popup-container ui-popup-active" id="popupFirstName-popup" style="max-width: 1570px; top: 432.5px; left: 682px;" tabindex="0"><div data-role="popup" id="popupFirstName" data-theme="a" class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" aria-disabled="false" data-disabled="false" data-shadow="true" data-corners="true" data-transition="none" data-position-to="origin">
			<form action="/profile" method="POST" data-ajax="false">
				<div style="padding:10px 20px;">
				  <h3>Please enter your new first name</h3>
		          <label for="un" class="ui-hidden-accessible ui-input-text">Username:</label>
		          <input type="text" name="changedFirstName" id="un" value="" placeholder="first name" data-theme="a" class="ui-input-text ui-body-a ui-corner-all ui-shadow-inset"></input>
		    	  <button type="submit" data-theme="b" class="ui-btn-hidden" aria-disabled="false">Save</button>
				</div>
			</form>
	</div>
	<p>
	
	<p>Surname: <%String lastName = (String)request.getAttribute("studentLastName"); %>
		<%out.println(lastName); %>
		
	<a href="#popupLastName" data-rel="popup" data-position-to="window" data-role="button" data-inline="true" data-corners="true" data-shadow="true" data-iconshadow="true" data-wrapperels="span" data-theme="c" aria-haspopup="true" aria-owns="#popupLastName" class="ui-btn ui-shadow ui-btn-corner-all ui-btn-inline ui-btn-up-c"><span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text">Form</span></span></a>
	
	<div class=​"ui-popup-container ui-popup-active" id=​"popupLastName-popup" style=​"max-width:​ 1570px;​ top:​ 432.5px;​ left:​ 682px;​" tabindex=​"0">​<div class="ui-popup-container ui-popup-active" id="popupLastName-popup" style="max-width: 1570px; top: 432.5px; left: 682px;" tabindex="0"><div data-role="popup" id="popupLastName" data-theme="a" class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" aria-disabled="false" data-disabled="false" data-shadow="true" data-corners="true" data-transition="none" data-position-to="origin">
			<form action="/profile" method="POST" data-ajax="false">
				<div style="padding:10px 20px;">
				  <h3>Please enter your new last name</h3>
		          <label for="un" class="ui-hidden-accessible ui-input-text">Username:</label>
		          <input type="text" name="changedLastName" id="un" value="" placeholder="last name" data-theme="a" class="ui-input-text ui-body-a ui-corner-all ui-shadow-inset"></input>
		    	  <button type="submit" data-theme="b" class="ui-btn-hidden" aria-disabled="false">Save</button>
				</div>
			</form>
	</div>	
	<p>
	
	
	<p>E-mail adress: <%String email = (String)request.getAttribute("email"); %>
		<%out.println(email); %><p>	
		
	</div>
	


	
	
	
	

	

</div><!-- /page -->

     


</body>
</html>