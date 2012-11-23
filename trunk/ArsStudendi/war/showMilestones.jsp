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
	function emptyFields() {
		var name = $("#checkbox-1").val();
				
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
	<div data-role="header" data-theme="d">
	 	<a href="index.jsp" data-role="button" data-icon="home" data-iconpos="notext">Home</a>
		<h1>Milestones</h1>
		<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>
	</div><!-- /header -->
	
	<fieldset data-role="controlgroup">
		<input type="checkbox" name="checkbox-1" id="checkbox-1" value="" class="custom" onchange="emptyFields()"/>
		<label for="checkbox-1">Test1</label>
		<input type="checkbox" name="checkbox-2" id="checkbox-2" class="custom" />
		<label for="checkbox-2">Test2</label>
	</fieldset>
	
	<fieldset class="ui-grid-a">
				<div class="ui-block-a"><button type="submit" data-theme="b">Remove</button></div>
				<div class="ui-block-b"><a href="milestones.jsp" data-role="button">Back</a></button></div>	   
	</fieldset>
</div><!-- /page -->

</body>
</html>