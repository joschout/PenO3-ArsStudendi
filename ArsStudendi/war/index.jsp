<!DOCTYPE html> 
<html> 
<head> 
	<title>ArsStudendi</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>
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
		<%
		}
		else
		{
		%>
		check= "started"; 
		<%}
 		%>
 		}
	
	var timePassed = "<%= request.getAttribute("timePassed")%>";
	timePassed = parseInt(timePassed);
	alert(timePassed)
	var localTP;
	
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
	
	
	function myLiveEventHandler(event)
	{
  	if(event.handled !== true)
  	{
  	reNew();
  	localTime();
  	display();
    event.handled = true;
  	}
  	return false;
	}
	$(document).bind("pageinit", myLiveEventHandler);
	</script>

	<div data-role="header" data-theme="b">
		<h1>Ars Studendi</h1>
	<a href="logout.jsp" data-role="button" data-icon="delete" class="ui-btn-right">Log Out</a>
	</div><!-- /header -->
	<br>	
	<a href="/tracking" data-role="button" data-ajax="false">Tracking</a> <br>
	<a href="milestones.jsp" data-role="button">Milestones</a> <br>
	<a href="/statistics" data-role="button" data-ajax="false">Statistics</a> <br>
	<a href="settings.jsp" data-role="button">Settings</a>
	

	
	<div data-role="footer" id="footer"> 
	<div id="demo"></div>
	</div>


</div><!-- /page -->

</body>
</html>
