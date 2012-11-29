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

<script>
var selected = $("input[type='radio'][name='milestoneType']:checked").val();

function hideList2(){
	if(selected != "Study"){
		$("#option2").hide();
	}
	else{
		$("#option2").show();
	}
}
</script>
<script>

$("#getinfo").click(function() {

    $("input[name*="radio-choice-1"]:checked").each(function() {
        alert($(this).val());
    });

});​

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
     			<input type="radio" name="milestoneType" id="radio-choice-1" value="choice-1" checked="checked" />
     			<label for="radio-choice-1">Study</label>

     			<input type="radio" name="milestoneType" id="radio-choice-2" value="choice-2"  />
     			<label for="radio-choice-2">Social</label>

     			<input type="radio" name="milestoneType" id="radio-choice-3" value="choice-3"  />
     			<label for="radio-choice-3">Sports</label>

     			<input type="radio" name="milestoneType" id="radio-choice-4" value="choice-4"  />
     			<label for="radio-choice-4">Sleep</label>
		</fieldset>
		
   			</div>
   			
   			<div id="option2">
   				<label for="option2" class="select"></label>
				<select name="option2">
				<option value="Lecture">Lecture</option>
   				<option value="SelfTeaching">SelfTeaching</option>
   				<option value="TeamWork">TeamWork</option>
   				<option value="Practice">Practice</option>
   				</select>
   			</div>
   			
   			<a href="#" id="getinfo">getinfo</a>
		
		</form>
	
	
	
</body>
</html>