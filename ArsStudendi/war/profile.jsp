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
	 	<a href="/index" data-role="button" data-icon="home" data-iconpos="notext" data-ajax="false">Home</a> 
		<h1>Profile Settings</h1>
		<a href="/logout" data-role="button" data-icon="delete" data-ajax="false">Log Out</a> 	
	</div><!-- /header -->
	
	
<div data-role="content">	
	<div>First name: <%String firstName = (String)request.getAttribute("studentFirstName"); %>
		<%out.println(firstName); %> 	
		<a href="#popupFirstName" data-rel="popup" data-position-to="window" data-role="button" data-inline="true" data-corners="true" data-shadow="true" data-iconshadow="true" data-wrapperels="span" data-theme="c" aria-haspopup="true" aria-owns="#popupFirstName" class="ui-btn ui-shadow ui-btn-corner-all ui-btn-inline ui-btn-up-c"><span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text">Change your first name</span></span></a>
	
		<div class=​"ui-popup-container ui-popup-active" id=​"popupFirstName" style=​"max-width:​ 1570px;​ top:​ 432.5px;​ left:​ 682px;​" tabindex=​"0">​<div class="ui-popup-container ui-popup-active" id="popupFirstName1" style="max-width: 1570px; top: 432.5px; left: 682px;" tabindex="0"><div data-role="popup" id="popupFirstName" data-theme="a" class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" aria-disabled="false" data-disabled="false" data-shadow="true" data-corners="true" data-transition="none" data-position-to="origin">
			<form action="/profile" method="POST" data-ajax="false">
				<div style="padding:10px 20px;">
				  <h3>Please enter your new first name</h3>
		          <label for="un1" class="ui-hidden-accessible ui-input-text">Username:</label>
		          <input type="text" name="changedFirstName" id="un1" value="" placeholder="first name" data-theme="a" class="ui-input-text ui-body-a ui-corner-all ui-shadow-inset"></input>
		    	  <button type="submit" data-theme="b" class="ui-btn-hidden" aria-disabled="false">Save</button>
				</div>
			</form>
		</div>
	</div>
	
	<div>Surname: <%String lastName = (String)request.getAttribute("studentLastName"); %>
		<%out.println(lastName); %>
			<a href="#popupLastName" data-rel="popup" data-position-to="window" data-role="button" data-inline="true" data-corners="true" data-shadow="true" data-iconshadow="true" data-wrapperels="span" data-theme="c" aria-haspopup="true" aria-owns="#popupLastName" class="ui-btn ui-shadow ui-btn-corner-all ui-btn-inline ui-btn-up-c"><span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text">Change surname</span></span></a>
	
		<div class=​"ui-popup-container ui-popup-active" id=​"popupLastName" style=​"max-width:​ 1570px;​ top:​ 432.5px;​ left:​ 682px;​" tabindex=​"0">​<div class="ui-popup-container ui-popup-active" id="popupLastName1" style="max-width: 1570px; top: 432.5px; left: 682px;" tabindex="0"><div data-role="popup" id="popupLastName" data-theme="a" class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" aria-disabled="false" data-disabled="false" data-shadow="true" data-corners="true" data-transition="none" data-position-to="origin">
			<form action="/profile" method="POST" data-ajax="false">
				<div style="padding:10px 20px;">
				  <h3>Please enter your new last name</h3>
		          <label for="un2" class="ui-hidden-accessible ui-input-text">Username:</label>
		          <input type="text" name="changedLastName" id="un2" value="" placeholder="last name" data-theme="a" class="ui-input-text ui-body-a ui-corner-all ui-shadow-inset"></input>
		    	  <button type="submit" data-theme="b" class="ui-btn-hidden" aria-disabled="false">Save</button>
				</div>
			</form>
		</div>	
	
	</div>
	
	
	<div>E-mail adress: <%String email = (String)request.getAttribute("email"); %>
		<%out.println(email); %>
		
		<a href="#popupEmail" data-rel="popup" data-position-to="window" data-role="button" data-inline="true" data-corners="true" data-shadow="true" data-iconshadow="true" data-wrapperels="span" data-theme="c" aria-haspopup="true" aria-owns="#popupEmail" class="ui-btn ui-shadow ui-btn-corner-all ui-btn-inline ui-btn-up-c"><span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text">Change e-mail</span></span></a>
	
		<div class=​"ui-popup-container ui-popup-active" id=​"popupEmail" style=​"max-width:​ 1570px;​ top:​ 432.5px;​ left:​ 682px;​" tabindex=​"0">​<div class="ui-popup-container ui-popup-active" id="popupEmail1" style="max-width: 1570px; top: 432.5px; left: 682px;" tabindex="0"><div data-role="popup" id="popupEmail" data-theme="a" class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" aria-disabled="false" data-disabled="false" data-shadow="true" data-corners="true" data-transition="none" data-position-to="origin">
			<form action="/profile" method="POST" data-ajax="false">
				<div style="padding:10px 20px;">
				  <h3>Please enter your new e-mail adress</h3>
		          <label for="un3" class="ui-hidden-accessible ui-input-text">Username:</label>
		          <input type="text" name="changedEmailAdress" id="un3" value="" placeholder="e-mail adress" data-theme="a" class="ui-input-text ui-body-a ui-corner-all ui-shadow-inset"></input>
		    	  <button type="submit" data-theme="b" class="ui-btn-hidden" aria-disabled="false">Save</button>
				</div>
			</form>
		</div>	
	
	</div>
	
	<div>Password: <%String password = (String)request.getAttribute("password"); %>
		
		<a href="#popupPassword" data-rel="popup" data-position-to="window" data-role="button" data-inline="true" data-corners="true" data-shadow="true" data-iconshadow="true" data-wrapperels="span" data-theme="c" aria-haspopup="true" aria-owns="#popupPassword" class="ui-btn ui-shadow ui-btn-corner-all ui-btn-inline ui-btn-up-c"><span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text">Change e-mail</span></span></a>
	
		<div class=​"ui-popup-container ui-popup-active" id=​"popupPassword" style=​"max-width:​ 1570px;​ top:​ 432.5px;​ left:​ 682px;​" tabindex=​"0">​<div class="ui-popup-container ui-popup-active" id="popupPassword1" style="max-width: 1570px; top: 432.5px; left: 682px;" tabindex="0"><div data-role="popup" id="popupPassword" data-theme="a" class="ui-corner-all ui-popup ui-body-a ui-overlay-shadow" aria-disabled="false" data-disabled="false" data-shadow="true" data-corners="true" data-transition="none" data-position-to="origin">
			<form action="/profile" method="POST" data-ajax="false">
				<div style="padding:10px 20px;">
				  <h3>Please enter your new password</h3>
		          <label for="un3" class="ui-hidden-accessible ui-input-text">Username:</label>
		          <input type="password" name="changedPassword1" id="un4" value="" placeholder="password1" data-theme="a" class="ui-input-text ui-body-a ui-corner-all ui-shadow-inset"></input>
		    	  <button type="submit" data-theme="b" class="ui-btn-hidden" aria-disabled="false">Save</button>
				</div>
			</form>
		</div>	
	
	</div>
	
			

	



	
	
	
</div><!-- /content -->	

	

</div><!-- /page -->

     


</body>
</html>