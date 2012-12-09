

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





<div data-role="page">

	<div data-role="header" data-theme="b">
	 	<a href="/index" data-role="button" data-icon="home" data-iconpos="notext" data-ajax="false">Home</a> 
		<h1>Settings</h1>
		<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>
	</div><!-- /header -->
	
<div data-role="content">	
	<br>
	<a href="/profile" data-role="button" target="_self">Account</a> <br>
	<a href="courses.jsp" data-role="button" target="_self">Courses</a> <br>
</div><!-- /content -->
</div><!-- /page -->

     


</body>
</html>