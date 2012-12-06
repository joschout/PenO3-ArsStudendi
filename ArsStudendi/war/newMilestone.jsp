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
var typeCheck = "";
var sortCheck = "";
$(document).bind('pageinit', function() {
			$("#option2").hide();
			$("#pageSlider").hide();
			$("#time").hide();
			$("#sportsTime").hide();
				$('[type="submit"]').button('disable');
				$('[type="submit"]').button('refresh');
	$('input[name=milestoneType]').click(function() {
		if($(this).val() == "Sports") {
			typeCheck = "Sports";
			$("#option2").hide();
			$("#sportsTime").show();
		}
		else if($(this).val() == "Study") {
			typeCheck = "Study";
			$("#option2").show();
			$("#sportsTime").hide();
			
		}
	});
	$('input[name=milestoneSort]').click(function() {
		if($(this).val() == "Page") {
			sortCheck = "Page";
			$("#pageSlider").show();
			$("#time").hide();
		}
		else if($(this).val() == "Time") {
			sortCheck = "Time";
			$("#pageSlider").hide();
			$("#time").show();
			
		}
	});
});

	

</script>

<script>
	function emptyFields() {
		var name = $("#nameMilestone").val();
		if(name == "") {
			$('[type="submit"]').button('disable');
			$('[type="submit"]').button('refresh');
		}
		else {
			if(typeCheck == "") {
				$('[type="submit"]').button('disable');
				$('[type="submit"]').button('refresh');
			}
			if(typeCheck == "Sports") {
				$('[type="submit"]').button('enable');
				$('[type="submit"]').button('refresh');
			}
			if(typeCheck == "Study") {
				$('[type="submit"]').button('disable');
				$('[type="submit"]').button('refresh');
				if(sortCheck != "") {
					$('[type="submit"]').button('enable');
					$('[type="submit"]').button('refresh');
				}
			}
			
			
		}	
	}
	
	
</script>
	<script>
	function changeStart(){
	var a = new Array(1,3,5,7,8,10,12);
	var x = parseInt($("#select-start-month option:selected").val());
	if(a.indexOf(x) == -1){
	$("#31").hide();
		if($("#select-start-day option:selected").val() == "31"){
			var myselect = $("select#select-start-day");
			myselect[0].selectedIndex = 0;
			myselect.selectmenu("refresh", true);
		}
		else{}
		if(x == 2){
			$("#29").hide();
			$("#30").hide();
			if($("#select-start-day option:selected").val() == "30"){
			var myselect = $("select#select-start-day");
			myselect[0].selectedIndex = 0;
			myselect.selectmenu("refresh", true);
			}
		}
		else{
			$("#29").show();
			$("#30").show();
		}
	}
	else{
	$("#29").show();
	$("#30").show();
	$("#31").show();
	}
	}
	function changeStop(){
	var a = new Array(1,3,5,7,8,10,12);
	var x = parseInt($("#select-stop-month option:selected").val());
	if(a.indexOf(x) == -1){
	$("#31").hide();
		if($("#select-stop-day option:selected").val() == "31"){
			var myselect = $("select#select-stop-day");
			myselect[0].selectedIndex = 0;
			myselect.selectmenu("refresh", true);
		}
		else{}
		if(x == 2){
			$("#29").hide();
			$("#30").hide();
			if($("#select-stop-day option:selected").val() == "30"){
			var myselect = $("select#select-stop-day");
			myselect[0].selectedIndex = 0;
			myselect.selectmenu("refresh", true);
			}
		}
		else{
			$("#29").show();
			$("#30").show();
		}
	}
	else{
	$("#29").show();
	$("#30").show();
	$("#31").show();
	}
	}
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
				<input type="text" name="nameMilestone" id="nameMilestone" value="" placeholder="Description" onchange="emptyFields()"/>
		</div>
		
		<div data-role="fieldcontain" id="date"/>
		<legend>Milestone time:</legend>
		<fieldset data-role="controlgroup" data-type="horizontal">
		<legend>(Day, Month, Year)</legend>
		
		<select name="select-stop-day" id="select-stop-day">
        <% int k1 = 1;
           while(k1<32){%>
         <option id=<%out.println(k1);%> value=<%out.println(k1);%>><%if(k1<10){out.println("0" + k1);} else{out.println(k1);}%></option>
        <% k1++;}%>
        </select>
        
       	<select name="select-stop-month" id="select-stop-month" onChange="changeStart();">
        <% int k2 = 1;
           while(k2<13){%>
         <option value=<%out.println(k2);%>><%if(k2<10){out.println("0" + k2);} else{out.println(k2);}%></option>
        <% k2++;}%>
        </select>
        
		<select name="select-stop-year" id="select-stop-year">
        <% int k3 = 2010;
           while(k3<2030){%>
         <option value=<%out.println(k3);%>><%out.println(k3);%></option>
        <% k3++;}%>
        </select> 
        </fieldset>
        </div>
			
			
			<fieldset data-role="controlgroup" id="option1">
				<legend>Choose a type:</legend>
     			<input type="radio" name="milestoneType" id="radio-choice-1" value="Study" onchange="emptyFields()"/>
     			<label for="radio-choice-1">Study</label>

     			<input type="radio" name="milestoneType" id="radio-choice-2" value="Sports" onchange="emptyFields()"/>
     			<label for="radio-choice-2">Sports</label>
			</fieldset>
		
			
			
		
			<div id="option2">
			
				<div data-role="fieldcontain" id="courses">
					<select name="select-choice-0" id="select-choice-0">
						<%
							String[] courseNames = (String[])request.getAttribute("courseNames");
							//out.println(courseNames);
							int i = 0;
							if( courseNames != null){
							while(i<courseNames.length) {
						%>
   								<option value="<% out.println(courseNames[i]);%>"><% out.println(courseNames[i]);%></option>
						<% i++; } }%>
					</select>	
				</div>
				
				<fieldset data-role="controlgroup" id="option2">
					<legend>Sort of milestone:</legend>
     					<input type="radio" name="milestoneSort" id="radio-choice-1" value="Time" onchange="emptyFields()"/>
     					<label for="radio-choice-1">Time</label>
		
     					<input type="radio" name="milestoneSort" id="radio-choice-2" value="Page" onchange="emptyFields()"/>
     					<label for="radio-choice-2">Pages</label>
				</fieldset>
				
				<div id="pageSlider">
					<label for="amountOfPages">Amount of pages:</label>
					<input type="range" name="amountOfPages" id="amountOfPages" value="25" min="0" max="100" data-highlight="true"/>
				</div>
				
				<div data-role="fieldcontain" id="time">
        			<fieldset data-role="controlgroup" data-type="horizontal">
					<legend>(Hours, Minutes)</legend>
       			 <select name="studyHour" id="studyHour"> 
          			  <% int k4 = 0;
           					while(k4<24){%>
          			  <option value=<%out.println(k4);%>><%if(k4<10){out.println("0" + k4);} else{out.println(k4);}%></option>
         			   <% k4++;}%>
      			  </select>
      			  <select name="studyMinute" id="studyMinute">
         			   <% int k5 = 0;
        			    	while(k5<60){%>
         			   <option value=<%out.println(k5);%>><%if(k5<10){out.println("0" + k5);} else{out.println(k5);}%></option>
						<% k5++;}%>
      			  </select>
      			  </fieldset>
      			</div>
				
			
			</div>
			
			<div data-role="fieldcontain" id="sportsTime">
        			<fieldset data-role="controlgroup" data-type="horizontal">
					<legend>(Hours, Minutes)</legend>
       			 <select name="sportsHour" id="sportsHour">  
          			  <% int l4 = 0;
           					while(l4<24){%>
          			  <option value=<%out.println(l4);%>><%if(l4<10){out.println("0" + l4);} else{out.println(l4);}%></option>
         			   <% l4++;}%>
      			  </select>
      			  <select name="sportsMinute" id="sportsMinute"  />
         			   <% int l5 = 0;
        			    	while(l5<60){%>
         			   <option value=<%out.println(l5);%>><%if(l5<10){out.println("0" + l5);} else{out.println(l5);}%></option>
						<% l5++;}%>
      			  </select>
      			  </fieldset>
      		</div>
			
			
			<fieldset class="ui-grid-a">
				<div class="ui-block-a"><button type="submit" data-theme="b">Create Milestone</button></div>
				<div class="ui-block-b"><a href="milestones.jsp" data-role="button">Cancel</a></button></div>	   
			</fieldset>
		
		
		</form>
	
	
	
</body>
</html>