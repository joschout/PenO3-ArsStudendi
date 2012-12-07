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
	 	<a href="index.jsp" data-role="button" data-icon="home" data-iconpos="notext">Home</a>
		<h1>Milestones</h1>
		<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>
	</div><!-- /header -->
	
	<div data-role="content">
		<div>
			<%
				String[] milestoneNames = (String[])request.getAttribute("milestoneNames");
				//out.println(milestoneNames);
				int i = 0;
				if( milestoneNames != null){
				while(i<milestoneNames.length) {
			%>
   				<p><% out.println(milestoneNames[i]);%></p>
				<% i++; } }%>
			
		</div>
	
	</div>
	
	
</div><!-- /page -->

</body>
</html>