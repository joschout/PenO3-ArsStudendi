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
	
	
</head> 
<body> 

<script>

</script>
<div data-role="page">

	<div data-role="header" data-theme="b">
		<h1>Course</h1>
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
			<div class="ui-block-a"><button type="submit" data-theme="b">Submit</button></div>
			<div class="ui-block-b"><a href="home.jsp" data-role="button">Cancel</a></button></div>	   
		</fieldset>
		

		
		
		
	</form>