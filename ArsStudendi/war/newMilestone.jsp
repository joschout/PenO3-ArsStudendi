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
	
	<link href="mobiscroll-2.2/css/mobiscroll-2.2.custom.min.css" rel="stylesheet" type="text/css" />
	<script src="mobiscroll-2.2/js/mobiscroll-2.2.custom.min.js" type="text/javascript"></script>
	
	
</head>

<body>

<script>
$(document).bind('pageinit', function() {
	$('input[name=milestoneType]').click(function() {
		if($(this).val() !== "Study") {
			$("#option2").hide();
			$("#courses").hide();
			$("#pageSlider").hide();
			$("#date").hide();
			
		}
		else if($(this).val() == "Study") {
			$("#option2").show();
			$("#courses").show();
		}
	});
	$('input[name=milestoneSort]').click(function() {
		if($(this).val() == "Page") {
			$("#pageSlider").show();
			$("#date").hide();	
		}
		else if($(this).val() == "Time") {
			$("#pageSlider").hide();
			$("#date").show();
		}
	});
});

</script>



<div data-role="page">

	<div data-role="header" data-theme="b">
	 	<a href="index.jsp" data-role="button" data-icon="home" data-iconpos="notext">Home</a>
		<h1>Create Milestone</h1>
		<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>
	</div>
	
	<div data-role="content">
	
		<form action="/newMilestone" method="post" id="newMilestone">
			
			<div>
				<input type="text" name="nameMilestone" id="nameMilestone" value="" placeholder="Description"/>
			</div>
			
			<fieldset data-role="controlgroup" id="option1">
				<legend>Choose a type:</legend>
     			<input type="radio" name="milestoneType" id="radio-choice-1" value="Study" checked="checked"/>
     			<label for="radio-choice-1">Study</label>

     			<input type="radio" name="milestoneType" id="radio-choice-2" value="Sports"/>
     			<label for="radio-choice-2">Sports</label>
			</fieldset>
			
   			<div data-role="fieldcontain" id="courses">
				<fieldset data-role="controlgroup">
				<legend>Courses:</legend>
				<%
					String[] courseNames = (String[])request.getAttribute("courseNames");
					out.println(courseNames);
					int i = 0;
					if( courseNames != null){
					while(i<courseNames.length) {
				%>
				<input type="checkbox" name=<% out.println(courseNames[i]);%> id=<% out.println(courseNames[i]);%> class="custom";"/>
				<label for=<% out.println(courseNames[i]);%>> <% out.println(courseNames[i]);%> </label>
				<% i++; } }%>
				</fieldset>
			</div>
		
			<fieldset data-role="controlgroup" id="option2">
				<legend>Sort of milestone:</legend>
     				<input type="radio" name="milestoneSort" id="radio-choice-1" value="Time" checked="checked" />
     				<label for="radio-choice-1">Time</label>
		
     				<input type="radio" name="milestoneSort" id="radio-choice-2" value="Page"  />
     				<label for="radio-choice-2">Pages</label>
			</fieldset>
			
			<div id="pageSlider">
				<label for="slider-fill">Amount of pages</label>
				<input type="range" name="amountOfPages" id="amountOfPages" value="pages" min="0" max="100" data-highlight="true"/>
			</div>	
			
			<div id="date">
				<input type="date" name="milestoneDate">
			</div>
			
			<fieldset class="ui-grid-a">
				<div class="ui-block-a"><button type="submit" data-theme="b">Submit</button></div>
				<div class="ui-block-b"><a href="milestone.jsp" data-role="button">Cancel</a></button></div>	   
			</fieldset>
		
		
		</form>
	
	
	
</body>
</html>