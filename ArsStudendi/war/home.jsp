<!DOCTYPE html> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html> 
<head> 
	<title>ArsStudendi</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
	<link rel="stylesheet" type="text/css" href="main.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>

	<script>
	function emptyFields() {
		var email = $("#emailAdress").val();
		var pass = $("#password").val();
		
		if(pass == "" || email == "") {
			$('[type="submit"]').button('disable');
			$('[type="submit"]').button('refresh');	
		}
		else {
			$('[type="submit"]').button('enable');
			$('[type="submit"]').button('refresh');	
		}
	}


	$(document).ready(function() {
		emptyFields();
	
		
	});
	
	
	
	

	</script>
</head> 
<body> 



<div data-role="page">

	<div data-role="header" data-theme="b">
		<h1>Log In</h1>
		<a href="/register" data-role="button" data-icon="check" target="_self" class="ui-btn-right">Sign Up</a> 
	</div><!-- /header -->
	
	
	<div data-role="content">
		<form id="logIn" action="/home" method="post" data-ajax="false">
				
						<br>
						
						<div class="center-align" width="45%">
							<img src="/images/Logo_final.png" alt="logo" width="45%"/>
						</div>
						
						<br>
							
						<div data-role="fieldcontain" class="ui-hide-label">

							<input type="text" name="emailAdress" id="emailAdress" value="" placeholder="E-mail Adress" class="center-button" class="required email" onchange="emptyFields()"/>

						</div>
			
						<div data-role="fieldcontain" class="ui-hide-label">
    						<input type="password" name="password" id="password" value="" placeholder="Password" class="center-button" onchange="emptyFields()" />
						</div>	
						
						<br>
						
						<div><button type="submit" data-theme="b" value="Log In"/>Log In</div>


		</form>
		
		
	</div>
	

</body>
</html>