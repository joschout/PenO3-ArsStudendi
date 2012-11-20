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
		var email = $("#emailAdress").val();
		
		if(name == "" || lName == "" || pass == "" || email == "") {
			$('[type="submit"]').button('disable');
			$('[type="submit"]').button('refresh');	
		}
		else {
			$('[type="submit"]').button('enable');
			$('[type="submit"]').button('refresh');	
		}
	}
	
	//String[] courseNames = request.getAttribute("courseNames");
	
	</script>
	
	
</head> 
<body> 

<script>

</script>
<div data-role="page">

	<div data-role="header" data-theme="b">
		<h1>Register</h1>
	</div><!-- /header -->

	<div data-role="content">	
		<p>Sign up for an ArsStudendi account and enjoy the benefits of learning analytics!</p>		
	</div><!-- /content -->

	<div data-role="content">
	
	<form action="/register" method="post">
		<div data-role="fieldcontain" class="ui-hide-label">
			<input type="text" name="studentFirstName" id="studentFirstName" value="" placeholder="First Name" onchange="emptyFields()"/>
		</div>
		
		<div data-role="fieldcontain" class="ui-hide-label">
			<input type="text" name="studentLastName" id="studentLastName" value="" placeholder="Last Name" onchange="emptyFields()"/>
		</div>
		
		<div data-role="fieldcontain">
    		<input type="password" name="password" id="password" value="" placeholder="Password" onchange="emptyFields()"/>
		</div>
		
		<div data-role="fieldcontain" class="ui-hide-label">
			<input type="text" name="emailAdress" id="emailAdress" value="" placeholder="e-mail" onchange="emptyFields()"/>
		</div>
		

		<label for="select-choice-0" class="select">Study Program</label>
			<select name="studyProgram" id="studyProgram">
   			<option value=TESTPROGRAM1>TESTPROGRAM1</option>
   			<option value=TESTPROGRAM2>TESTPROGRAM2</option>
   			<option value=TESTPROGRAM3>TESTPROGRAM3</option>
   			<option value=TESTPROGRAM4>TESTPROGRAM4</option>
   			<option value=TESTPROGRAM5>TESTPROGRAM5</option>
   			<option value=TESTPROGRAM6>TESTPROGRAM6</option>
		</select>
		
		<div data-role="fieldcontain">
			<fieldset data-role="controlgroup">
			<legend>Courses:</legend>
			<%
				String[] courseNames = (String[])request.getAttribute("courseNames");
				int i = 0;
				if( courseNames != null){
				while(i<courseNames.length) {
			%>
			<input type="checkbox" name=<% out.println(courseNames[i]);%> id=<% out.println(courseNames[i]);%> class="custom";"/>
			<label for=<% out.println(courseNames[i]);%>> <% out.println(courseNames[i]);%> </label>
			<% i++; } }%>
			</fieldset>
		</div>
		
		<fieldset class="ui-grid-a">
			<div class="ui-block-a"><button type="submit" data-theme="b">Submit</button></div>
			<div class="ui-block-b"><a href="home.jsp" data-role="button">Cancel</a></button></div>	   
		</fieldset>
		
		

		
		
	</form>

	
	

</div><!-- /page -->

</body>
</html>
