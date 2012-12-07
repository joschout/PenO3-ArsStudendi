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
		<h1>Milestones</h1>
		<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>
	</div><!-- /header -->
	
	<div data-role="content">
		<div>
			<form action="/showMilestones" method="post" data-ajax="false">
			<div data-role="collapsible-set" data-collapsed-icon="arrow-r" data-expanded-icon="arrow-d" data-content-theme="d">
			<%
				String[] milestoneNames = (String[])request.getAttribute("milestoneNames");
				int[] milestoneProcents = (int[])request.getAttribute("milestoneProcents");
				
				int i = 0;
				if( milestoneNames != null){
				while(i<milestoneNames.length) {
			%>
				<div data-role="collapsible" data-collapsed="false">
					<h3><% out.println(milestoneNames[i]);%></h3>
					<p><% out.println("The fraction of your work that's done: " + milestoneProcents[i] + "%");%></p>
				</div>
			<% i++; } }%>
		</div>	
			</form>
			
		</div>
	
	</div>
	
	
</div><!-- /page -->

</body>
</html>