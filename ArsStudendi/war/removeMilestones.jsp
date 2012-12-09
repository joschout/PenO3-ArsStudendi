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
	<div data-role="header" data-theme="b">
	 	<a href="/index" data-role="button" data-icon="home" data-iconpos="notext" data-ajax="false">Home</a> 
		<h1>Milestones</h1>
		<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>
	</div><!-- /header -->
	
	<div data-role="content">
	<form action="/removeMilestones" method="post">
	
	<p>Select the milestones you want to delete: </p>
		<div data-role="fieldcontain">
			<fieldset data-role="controlgroup">
			<%
				String[] milestoneNames = (String[])request.getAttribute("milestoneNames");
				int i = 0;
				if( milestoneNames != null){
				while(i<milestoneNames.length) {
			%>
			<input type="checkbox" name=<% out.println(milestoneNames[i]);%> id=<% out.println(milestoneNames[i]);%> class="custom";"/>
			<label for=<% out.println(milestoneNames[i]);%>> <% out.println(milestoneNames[i]);%> </label>
			<% i++; } }%>
			</fieldset>
			
		</div>
			<fieldset class="ui-grid-a">
			<div class="ui-block-a"><button type="submit" data-theme="b">Delete</button></div>
			<div class="ui-block-b"><a href="milestones.jsp" data-role="button">Cancel</a></button></div>	   
		</fieldset>
		
	</form>
	</div>

</body>
</html>