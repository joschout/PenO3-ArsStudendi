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
		
 	function emptyFields() {
		var name = $("#studentName").val();
		var lName = $("#studentLastName").val();
		var pass = $("#password").val();
		var pass2 = $("#passwordRepeat").val();
		var email = $("#emailAdress").val();
		
		if(name == "" || lName == "" || pass == "" || pass2 == ""|| email == "") {
			$('[type="submit"]').button('disable');
			$('[type="submit"]').button('refresh');	
		}
		else {
			$('[type="submit"]').button('enable');
			$('[type="submit"]').button('refresh');	
		}
	}
	
 	function checkPassword()
 	{
 			var pass = $("#password").val();
 			var pass2 = $("#passwordRepeat").val();
 			if(pass != pass2) {
 				$('[type="submit"]').button('disable');
 				$('[type="submit"]').button('refresh');	
 				alert("Please confirm your password correctly")
 			}
 			else{
 			 	$('[type="submit"]').button('disable');
 				$('[type="submit"]').button('refresh');	}
 	}	
 	
 	var allNames = new Array();
 	<%String[] allNames = (String[])request.getAttribute("courseNames");%>
	<%  
		for(int n = 0; n<allNames.length; n++){%>
		allNames[parseInt(<%out.println(n);%>)] = "<%= allNames[n]%>";
		<%}%>
 	var program2 = {};
	program2["TESTPROGRAM1"] = new Array();
	<%String[] TESTPROGRAM1 = (String[])request.getAttribute("TESTPROGRAM1");%>
	<%  
		for(int n = 0; n<TESTPROGRAM1.length; n++){%>
		program2["TESTPROGRAM1"][parseInt(<%out.println(n);%>)] = "<%= TESTPROGRAM1[n]%>";
		<%}%>
	program2["TESTPROGRAM2"] = new Array();
	<%String[] TESTPROGRAM2 = (String[])request.getAttribute("TESTPROGRAM2");%>
	<%  
		for(int n = 0; n<TESTPROGRAM2.length; n++){%>
		program2["TESTPROGRAM2"][parseInt(<%out.println(n);%>)] = "<%= TESTPROGRAM2[n]%>";
		<%}%>
	program2["TESTPROGRAM3"] = new Array();
	<%String[] TESTPROGRAM3 = (String[])request.getAttribute("TESTPROGRAM3");%>
	<%  
		for(int n = 0; n<TESTPROGRAM3.length; n++){%>
		program2["TESTPROGRAM3"][parseInt(<%out.println(n);%>)] = "<%= TESTPROGRAM3[n]%>";
		<%}%>
	program2["TESTPROGRAM4"] = new Array();
	<%String[] TESTPROGRAM4 = (String[])request.getAttribute("TESTPROGRAM4");%>
	<%  
		for(int n = 0; n<TESTPROGRAM4.length; n++){%>
		program2["TESTPROGRAM4"][parseInt(<%out.println(n);%>)] = "<%= TESTPROGRAM4[n]%>";
			<%}%>
	program2["TESTPROGRAM5"] = new Array();
	<%String[] TESTPROGRAM5 = (String[])request.getAttribute("TESTPROGRAM5");%>
	<%  
		for(int n = 0; n<TESTPROGRAM5.length; n++){%>
		program2["TESTPROGRAM5"][parseInt(<%out.println(n);%>)] = "<%= TESTPROGRAM5[n]%>";
		<%}%>
	program2["TESTPROGRAM6"] = new Array();
	<%String[] TESTPROGRAM6 = (String[])request.getAttribute("TESTPROGRAM6");%>
	<%  
		for(int n = 0; n<TESTPROGRAM6.length; n++){%>
		program2["TESTPROGRAM6"][parseInt(<%out.println(n);%>)] = "<%= TESTPROGRAM6[n]%>";
		<%}%>
function changeRemove(){
	var v = $("#studyProgram option:selected").val();
	var b = new Array();
	var a = allNames;
	for(var n = 0; n<program2[v].length; n++){
		var optionName = "#" + program2[v][n];
		var optionName2 = "#test" + program2[v][n];
		$(optionName).show();
		$(optionName2).hide();
		for(var n2 = 0; n2<a.length; n2++){
			var optionName2 = "#" + a[n2];
			if( optionName2 == optionName)
			{
				b[n2] = "show";
			}
		}
	}
	for(var n = 0; n<a.length; n++){
		if(b[n] !== "show"){
		var optionName = "#" + a[n];
		var optionName2 = "#test" + a[n];
		$(optionName).hide();
		$(optionName2).show();
		}
	}
}
 	var showA = "false"
 	var showR = "false"
 	
 function showAdd()
{
	if(showA == "true"){
	$("#Boxes1").show();
	showA = "false";
	}
	else{
	$("#Boxes1").hide();
	showA = "true";
	}
}	
function showRemove()
{
	if(showR == "true"){
	$("#Boxes2").show();
	showR = "false";
	}
	else{
	$("#Boxes2").hide();
	showR = "true";
	}
}
 	
 	
 	
function myLiveEventHandler(event)
{
  if(event.handled !== true)
  {
  	showAdd();
  	showRemove();
  	changeRemove();
	emptyFields();
  }
  return false;
}


$(document).bind("pageinit", myLiveEventHandler);



	
	</script>
	
	
</head> 
<body> 

<script>

</script>
<div data-role="page">
	
	<div data-role="header" data-theme="b">
		<h1>Register</h1>
	</div><!-- /header -->

	<div data-role="content">	
		<p>Sign up for an Ars Studendi account and enjoy the benefits of learning analytics!</p>		
	</div><!-- /content -->

	<div data-role="content">
	
	<form id="form1" action="/register" method="post" data-ajax="false">
		<div data-role="fieldcontain" class="ui-hide-label">
			<input type="text" name="studentFirstName" id="studentFirstName" value="" placeholder="First Name" onchange="emptyFields()"/>
		</div>
		
		<div data-role="fieldcontain" class="ui-hide-label">
			<input type="text" name="studentLastName" id="studentLastName" value="" placeholder="Last Name" onchange="emptyFields()"/>
		</div>
		
		<div data-role="fieldcontain" class="ui-hide-label">
    		<input type="password" name="password" id="password" value="" placeholder="Password" onchange="emptyFields()"/>
		</div>
		
		
		<div data-role="fieldcontain" class="ui-hide-label">
    		<input type="password" name="passwordRepeat" id="passwordRepeat" value="" placeholder="Confirm Password" onchange="emptyFields();checkPassword();"/>	
		</div>
		
		<div data-role="fieldcontain" class="ui-hide-label">
			<input type="text" name="emailAdress" id="emailAdress" value="" placeholder="E-mail" onchange="emptyFields()"/>
		</div>
		
		<div>
		<label for="select-choice-0" class="select">Study Program</label>
			<select name="studyProgram" id="studyProgram" onChange="changeRemove()">
			<%
				String[] studyProgramNames = (String[])request.getAttribute("studyProgramNames");
				int j = 0;
				if( studyProgramNames != null){
				while(j<studyProgramNames.length) {
			%>
   			<option value=<% out.println(studyProgramNames[j]);%>><% out.println(studyProgramNames[j]);%></option>

   			<% j++; } }%>
		</select>
		</div>
		
		<div class="ui-block-a"><button type="button" id="hideboxes1" name ="hideboxes1" onClick="showAdd()" data-theme="b">Add Extra Courses</button></div> 
		<div id="Boxes1">
			<div data-role="fieldcontain" id="AddBoxes">
				<fieldset data-role="controlgroup">
					<legend>Courses:</legend>
			<%
				String[] courseNames = (String[])request.getAttribute("courseNames");
				int i = 0;
				if( courseNames != null){
				while(i<courseNames.length) {
			%>
			<div id=<% out.println("test"+ courseNames[i]);%>>
			<input type="checkbox" name=<% out.println("test" + courseNames[i]);%>  id=<%out.println("test" + i);%>  class="custom"/>
			<label for=<% out.println("test" + i);%>> <% out.println(courseNames[i]);%> </label>
			</div>
			<% i++; }}%>			
			</fieldset>
			</div>
		</div>

		<div class="ui-block-a"><button type="button" id="hideboxes2" name ="hideboxes2" value="test" onClick="showRemove()" data-theme="b">Remove Courses from Program</button></div> 
				<div id="Boxes2">
					<div data-role="fieldcontain" id="RemoveBoxes">
						<fieldset data-role="controlgroup">
							<legend>Courses:</legend>
							<% String[] programCourseNames = (String[])request.getAttribute("courseNames");			
								int i2 = 0;
								if( programCourseNames != null){
								while(i2<programCourseNames.length) {
								%>
								<div id=<% out.println(programCourseNames[i2]);%>>
								<input type="checkbox" name=<%out.println(programCourseNames[i2]);%> id=<%out.println(i2);%>  class="custom"/>
								<label for=<%out.println(i2);%>> <% out.println(programCourseNames[i2]);%> </label>
								</div>
								<% i2++; }}%>
							</fieldset>
						</div>
					</div>	

		
		<fieldset class="ui-grid-a">
			<div class="ui-block-a"><button type="submit" name ="submit1" value="submit" data-theme="b">Register</button></div>
			<div class="ui-block-b"><a href="home.jsp" name="cancel" value="cancel" data-role="button">Cancel</a></button></div>	   
		</fieldset>
		

		
		
		
	</form>



</div><!-- /page -->

</body>
</html>
