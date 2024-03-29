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
	
	<link rel="stylesheet" href="jquery.ui.datepicker.mobile.css" /> 
  	<script src="jQuery.ui.datepicker.js"></script>
  	<script src="jquery.ui.datepicker.mobile.js"></script>
		<script>
		function isLoggedIn(){
		var checker = "<%= session.getAttribute("currentID")%>";
		if(checker == "null"){
			window.location.replace("/home");
		}
	}
	$(document).bind("pagecreate", isLoggedIn);
	</script>
	  	
	<script>
	function emptyFields() {
		var name = $("#nameMilestone").val();
				
		if(name == "") {
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
	 	<a href="/index" data-role="button" data-icon="home" data-iconpos="notext" data-ajax="false">Home</a> 
		<h1>Create Milestone</h1>
		<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>
	</div><!-- /header -->
	
	<div data-role="content">
		<form id="createMile" action="/createMilestone" method="post" data-ajax="false">
			<br>
			<div data-role="fieldcontain" class="ui-hide-label">
				<input type="text" name="nameMilestone" id="nameMilestone" value="" placeholder="Description" class="center-button" onchange="emptyFields()"/>
			</div>
			<div data-role="fieldcontain" class="ui-hide-label">
    			<input type="text" name="start" id="start" value="" placeholder="Start Date" class="center-button"/>
			</div>
			<div data-role="fieldcontain" class="ui-hide-label">
    			<input type="text" name="stop" id="end" value="" placeholder="End Date" class="center-button"/>
			</div>			
			
			<fieldset data-role="controlgroup">
	   			<input type="radio" name="milestone-choice" id="time" value="choice-1" checked="checked" />
     			<label for="time">Time</label>

     			<input type="radio" name="milestone-choice" id="pages" value="choice-2"  />
     			<label for="pages">Number Of Pages</label>

			</fieldset>
			
			<div>
			<label for="date">Date Input:</label>
			<input type="date" name="date" id="date" value=""  />		
			</div>	
					
			<fieldset class="ui-grid-a">
				<div class="ui-block-a"><button type="submit" data-theme="b">Create</button></div>
				<div class="ui-block-b"><a href="milestones.jsp" data-role="button">Cancel</a></button></div>	   
			</fieldset>
			
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
			
 	</form>
			
	

</div><!-- /page -->

</body>
</html>