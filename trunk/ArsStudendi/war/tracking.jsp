<!DOCTYPE html> 
<html> 
<head> 
	<title>ArsStudendi</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
	<link rel="stylesheet" type="text/css" href="main.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>
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
		
 		
<script>
var check;
function reNew(){
<% String aCheck = (String)request.getAttribute("aCheck");
		if(aCheck == null){
		%>
		check= "stopped";
		$("#footer").hide();
		$("#demo").hide();
		$("#numPages").hide();
		<%}
		else{%>	
		check= "started"; 
		<%}%>
 }

	var timePassed = "<%= request.getAttribute("timePassed")%>";
	timePassed = parseInt(timePassed);
	var localTP;
	var time;
	var hours;
	var minutes;
	var seconds;
	var timeString
	
	function localTime(){
	if(timePassed == -1){
		localTP = "Testing";
	}
	else{
	localTP = timePassed;
	}
	}
	function myTimer()
	{
	localTP = localTP + 1;
	time = localTP;
	hours = time/3600;
	hours = parseInt(hours);
	time = time % 3600;
	if(hours<10){
	hours = "0" + hours;
	}
	minutes = time/60;
	minutes = parseInt(minutes);
	time = time % 60;
	if(minutes<10){
	minutes = "0" + minutes;
	}
	seconds = time;
	if(seconds<10){
	seconds = "0" + seconds;
	}
	timeString = hours +":" + minutes +":" + seconds;
	
	
	$("#demo").text(timeString);
	}
	function display(){
	setInterval("myTimer()",1000);
	}

		
function hideList2(){
	if($("#option1 option:selected").val() == "SLEEP"){
	$("#option2").hide();
	$("#option3").hide();
	$("#description").hide();
	$("#pageSlider").hide();
	$("#courses").hide();
	}
	if($("#option1 option:selected").val() == "FREETIME"){
	$("#option2").hide();
	$("#option3").show();
	$("#description").show();
	$("#pageSlider").hide();
	$("#courses").hide();
	}
	if($("#option1 option:selected").val() == "STUDY"){
	$("#option2").show();
	$("#option3").hide();
	$("#description").show();
	$("#pageSlider").hide();
	$("#courses").show();
		if($("#option2 option:selected").val() == "Practice")
		{
		$("#pageSlider").show();}
	}
	}

function testF(){
if(check == "started"){
	$("#start").hide();

}
else{
	$("#stop").hide();
	$("#cancel").hide();
	$("#numPages").hide();
	$("#description").hide();
	$("#pageSlider").hide();
	$("#courses").hide();
	$("#option1").hide();
	$("#option2").hide();
	$("#option3").hide();
}
}


function myLiveEventHandler(event)
{
  if(event.handled !== true)
  {
 	hideList2();
  	reNew();
  	localTime();
  	display();
    testF();
    event.handled = true;
  }
  return false;
}
$(document).bind("pageinit", myLiveEventHandler);

</script>


	<div data-role="header" data-theme="b">
		<a href="/index" data-role="button" data-icon="home" data-iconpos="notext" data-ajax="false">Home</a> 
		<h1><%out.println("Tracking");%></h1>
		<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>
		
		
	</div>
	
		<div data-role="content" >
		<form action="/tracking" method="POST" data-ajax="false">
		
			<div id="addActivity"><button type="submit" name="addActivity" data-theme="b" value="addActivity">addActivity</button></div>
			
			<div data-role="fieldcontain">
   				<fieldset data-role="controlgroup">
   			
   					<div id="option1">
						<label for="option1" class="select"></label>
						<select name="option1" id="option1" onChange="hideList2();">
							<option value=STUDY>Study</option>
							<option value=FREETIME>FreeTime</option>
   							<option value=SLEEP>Sleep</option>
   						</select>
   					</div>
   			
   					<div id="option2">
   						<label for="option2" class="select"></label>
						<select name="option2" onChange="hideList2();">
							<option value="Lecture">Lecture</option>
   							<option value="TeamWork">TeamWork</option>
   							<option value="Practice">Practice</option>
   						</select>
   					</div>
   					
   					<div id="option3">
   						<label for="option3" class="select"></label>
						<select name="option3">
							<option value="Sport">Sport</option>
   							<option value="Social">Social</option>
   							<option value="Hobby">Hobby</option>
   							<option value="Other">Other</option>
   						</select>
   					</div>
   			
   				</fieldset>
			</div>
			
			<div id="start">
				<button type="submit" name="start" data-theme="c" value="start">Start</button>
			</div>
			
			
			<div data-role="fieldcontain" class="ui-hide-label" id="description">
				<label for="ActivityDescription" class="select">Description</label><br>
				<input type="text" name="ActivityDescription"  value="" placeholder="ActivityDescription"/>
			</div>
			
			<div id="pageSlider">
				<label for="amountOfPages">Amount of pages:</label>
				<input type="range" name="amountOfPages" id="amountOfPages" value="pages" min="0" max="100" data-highlight="true"/>
			</div>	
			
			<div data-role="fieldcontain" id="courses">
			<label for="select-choice-0" class="select">Course</label><br>
			<select name="courses">
			<%
				String[] courseNames = (String[])request.getAttribute("studentCourses");
				int i = 0;
				if( courseNames != null){
				while(i<courseNames.length) {%>
   			<option value = <%out.println(courseNames[i]);%>> <%out.println(courseNames[i]);%> </option>
   			<%i++;}}%>
			</select>
			</div>
   					
			<fieldset class="ui-grid-a">
				<div class="ui-block-a" id="stop"><button type="submit" name="stop" data-theme="b" value="stop">Stop</button></div>
				<div class="ui-block-b" id="cancel"><button type="submit"  name="cancel" data-theme="c" value="cancel" >Cancel</button></div>	   
			</fieldset>
			
			
			
		</form>  
        </div>
        
		<div data-role="footer" id="footer"> 
			<div id="demo" class="center-align"></div>
		</div>
 

</div>


</body>
</html>