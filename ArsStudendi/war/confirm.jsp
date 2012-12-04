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
		<h1>Confirm</h1>
	</div><!-- /header -->

	<div data-role="content">	
		<p>Are you sure you want to change the settings?</p>		
	</div><!-- /content -->
	
	<form id="LogOut" action="/logout" method="post">
	<fieldset class="ui-grid-a">
			<div class="ui-block-a"><button type="submit" data-theme="b">Yes</button></div>
			<div class="ui-block-b"><a href="index.jsp" data-role="button">No</a></button></div>	   
	</fieldset>
	</form>

</div><!-- /page -->

</body>
</html>