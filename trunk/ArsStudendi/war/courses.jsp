<!DOCTYPE html> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html> 
<head> 
	<title>ArsStudendi</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
	<link rel="stylesheet" type="text/css" href="main.css" />
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
	 <a href="/index" data-role="button" data-icon="home" data-iconpos="notext">Home</a>
	<h1>Courses</h1>
	<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>

	</div><!-- /header -->



	<div data-role="content">
	
	<form action="/courses" method="post" data-ajax="false">
		<div>
		<b> Courses you are enrolled in:</b>
		<%String[] courseNames = (String[])request.getAttribute("studentCourses");
			int i = 0;
			if( courseNames != null){
			while(i<courseNames.length) {
		%>
		<div class="center-align">
		<p><%out.println(courseNames[i]);%></p>
		</div>
		<%i++;}}%>
		</div>
		</form>
		
		<br>
		
				<div><a href="#popupBasic" data-rel="popup">Add Courses</a></div>

				<div data-role="popup" id="popupBasic">
					<form action="/courses" method="post" data-ajax="false">
					<div data-role="fieldcontain">
						<fieldset data-role="controlgroup">
							<legend>Courses:</legend>
							<%
								String[] addCourses = (String[])request.getAttribute("addCourses");							
								int i2 = 0;
								if( addCourses != null){
								while(i2<addCourses.length) {
								%>
								<input type="checkbox" name=<%out.println(addCourses[i2]);%> id=<% out.println(addCourses[i2]);%> class="custom";"/>
								<label for=<%out.println(addCourses[i2]);%>> <% out.println(addCourses[i2]);%> </label>
								<% i2++; }}%>
								<button type="submit" data-theme="b" class="ui-btn-hidden" aria-disabled="false">Save</button>
							</fieldset>
						</div>
						</form>
					</div>	
					
				<div><a href="#popupBasic2" data-rel="popup">Remove Courses</a></div>

				<div data-role="popup" id="popupBasic2">
					<form action="/courses" method="post" data-ajax="false">
					<div data-role="fieldcontain">
						<fieldset data-role="controlgroup">
							<legend>Courses:</legend>
							<%
								String[] removeCourses = (String[])request.getAttribute("removeCourses");							
								int i3 = 0;
								if( removeCourses != null){
								while(i3<removeCourses.length) {
								%>
								<input type="checkbox" name=<%out.println("test" + removeCourses[i3]);%> id=<% out.println("test" + removeCourses[i3]);%> class="custom";"/>
								<label for=<%out.println("test" + removeCourses[i3]);%>> <% out.println(removeCourses[i3]);%> </label>
								<% i3++; }}%>
								<button type="submit" data-theme="b" class="ui-btn-hidden" aria-disabled="false">Save</button>
							</fieldset>
						</div>
						</form>
					</div>		
		
		
		</form>
		
		

		
		
		
	</form>