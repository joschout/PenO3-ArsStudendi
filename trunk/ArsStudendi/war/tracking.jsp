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


function hideList2(){
	if($("#option1 option:selected").val() != "STUDY"){
	$("#option2").hide();
	}
	else{
	$("#option2").show();
	}
	}
</script>

<% String aCheck = (String)request.getAttribute("aCheck");
	if(aCheck == null){
	%>
	<script>var check= "stopped"; </script>
	<%
	}
	else
	{
	%>
	<script>var check= "started"; </script>
	<%}
 %>

<script>
function testF(){
if(check == "started"){
	$("#start").hide();
	$("#option1").hide();
	$("#option2").hide();


}
else{
	$("#stop").hide();
	$("#cancel").hide();
}
}


function myLiveEventHandler(event)
{
  if(event.handled !== true)
  {
    testF();
    event.handled = true;
  }
  return false;
}
$(document).on("pageshow", myLiveEventHandler);

</script>


	<form action="/tracking" method="Post">
	<div data-role="header" data-theme="b">
		<h1><%out.println("header"); %></h1>
		 <a href="../index.jsp" data-role="button" data-icon="home" data-iconpos="notext">Home</a> 
	</div>
	</form>

	
	
		<div data-role="content" >
		<form action="/tracking" method="Post">


			<div id="start"><button type="submit" name="start" data-theme="b" value="start">Start</button></div>
			
			<div data-role="fieldcontain">
   			<fieldset data-role="controlgroup">
   			
   			<div id="option1">
			<label for="option1" class="select"></label>
			<select name="option1" id="option1" onChange="hideList2();">
			<option value=STUDY>STUDY</option>
			<option value=SPORT>SPORT</option>
   			<option value=SOCIAL>SOCIAL</option>
   			<option value=SLEEP>SLEEP</option>
   			</select>
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
   			
   			</fieldset>
			</div>
   			
   			<div
   			
   			
   			
   			<div data-role="controlgroup">
			<div id="stop"><button type="submit"  name="stop" data-theme="b" value="stop">Stop</button></div>
			<div id="cancel"><button type="submit"  name="cancel" data-theme="b" value="cancel" >Cancel</button></div> 
			</div>  
			

			
			
		
		</form>  
        </div>
		
		<script>
		var timePassed = '<%= request.getAttribute("timePassed")%>'
		</script>
		<div data-role="footer" id="timer">
		<h4><script>document.write(timePassed);</script></h4>
		</div><!-- /footer -->	

        


	
	
	
	

</div>

</body>
</html>