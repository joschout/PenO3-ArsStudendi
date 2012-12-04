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
	
	
	<script type="text/javascript">

	$(document).ready(function() {
		emptyFields();
	});
		

		
 	function emptyFields() {
		var name = $("#studentName").val();
		var lName = $("#studentLastName").val();
		var pass = $("#password").val();
		var pass2 = $("#passwordRepeat").val();
		var email = $("#emailAdress").val();
		
		
		if(name == "" || lName == "" || pass == "" || pass2 == ""|| email == "") {
			$('[type="submit"]').button('disable');
			$('[type="submit"]').button('refresh');	
		}
		else {
			$('[type="submit"]').button('enable');
			$('[type="submit"]').button('refresh');	
		}
	}
	
 	function checkPassword()
 	{
 			var pass = $("#password").val();
 			var pass2 = $("#passwordRepeat").val();
 			if(pass != pass2) {
 				$('[type="submit"]').button('disable');
 				$('[type="submit"]').button('refresh');	
 				//alert("Please confirm your password correctly")
 			}
 	}
 	
 	 
	

	
	</script>
	
	
</head> 
<body> 

<script>

</script>
<div data-role="page">

	<div data-role="header" data-theme="b">
	<a href="index.jsp" data-icon="home">Home</a>
	<h1>Account</h1>
	<a href="logout.jsp" data-icon="star" data-theme="b">Log out</a>
</div>


	<div data-role="content">
	
	<form action="/account" method="post">
		<div data-role="fieldcontain" class="ui-hide-label">
			<input type="text" name="studentFirstName" id="studentFirstName" value="" placeholder="please fill your new first name in" onchange="emptyFields()"/>
		</div>
		
		<div data-role="fieldcontain" class="ui-hide-label">
			<input type="text" name="studentLastName" id="studentLastName" value="" placeholder="please fill your new last name in" onchange="emptyFields()"/>
		</div>
		
		
		<div data-role="fieldcontain">
    		<input type="password" name="password" id="password" value="" placeholder="Password" onchange="emptyFields()"/>
		</div>
		
		
		<div data-role="fieldcontain">

    		<input type="password" name="passwordRepeat" id="passwordRepeat" value="" placeholder="Confirm Password" onchange="emptyFields()"/>
    		
		</div>
		
		<div data-role="fieldcontain" class="ui-hide-label">
			<input type="text" name="emailAdress" id="emailAdress" value="" placeholder="e-mail" onchange="emptyFields()"/>
		</div>
		
		
			
		
		<fieldset class="ui-grid-a">
			<div  class="ui-block-a"><a href="confirm.jsp"  data-role="button">Submit</a></button></div>
			<div  class="ui-block-b"><a href="settings.jsp" data-role="button">Cancel</a></button></div>	
		</fieldset>
		

		
		
		
	</form>

	


</div><!-- /page -->

</body>
</html>

		
		