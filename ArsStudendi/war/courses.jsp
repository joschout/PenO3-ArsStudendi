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
		<script>
		function isLoggedIn(){
		var checker = "<%= session.getAttribute("currentID")%>";
		if(checker == "null"){
			window.location.replace("/home");
		}
	}
	$(document).bind("pagecreate", isLoggedIn);
	</script>
	
</head> 
<body> 

<script>


<div data-role="page">

	<div data-role="header" data-theme="b">
	 <a href="/index" data-role="button" data-icon="home" data-iconpos="notext">Home</a>
	<h1>Course</h1>
	<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>

	</div><!-- /header -->



	<div data-role="content">
	
	<form action="/account" method="post">
	
		

		<label for="select-choice-0" class="select">Change Your Study Program</label>
			<select name="studyProgram" id="studyProgram">
   			<option value=TESTPROGRAM1>TESTPROGRAM1</option>
   			<option value=TESTPROGRAM2>TESTPROGRAM2</option>
   			<option value=TESTPROGRAM3>TESTPROGRAM3</option>
   			<option value=TESTPROGRAM4>TESTPROGRAM4</option>
   			<option value=TESTPROGRAM5>TESTPROGRAM5</option>
   			<option value=TESTPROGRAM6>TESTPROGRAM6</option>
		</select>
		
		
			
		</div>
		
		<fieldset class="ui-grid-a">
			<div  class="ui-block-a"><a href="confirm.jsp"  data-role="button">Submit</a></button></div>
			<div  class="ui-block-b"><a href="settings.jsp" data-role="button">Cancel</a></button></div>	   
		</fieldset>
		

		
		
		
	</form>