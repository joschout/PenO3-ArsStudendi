<!DOCTYPE html> 
<html> 
<head> 
	<title>ArsStudendi</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>
	
<script>

$(document).ready(function() {
		$("#stop").hide();
		$("#cancel").hide();
});

function TestFunction(){
	if($("#start").is(':visible')){
	$("#start").hide();
	$("#stop").show();
	$("#cancel").show();
	}
	else{
	$("#start").show();
	$("#stop").hide();
	$("#cancel").hide();
	}
}


function HideList2(){
	if($("#option1").val() != "STUDY"){
	$("#option2").hide();
	}
	else{$("#option2").show();}
	}




</script>

	
</head> 
<body> 

<div data-role="page">

	<form action="/tracking" method="Post">
	<div data-role="header" data-theme="b">
		<%String header = (String)request.getAttribute("studentName") + " Tracking";%>
		<h1><%out.println(header); %></h1>
		 <a href="../index.html" data-role="button" data-icon="home" data-iconpos="notext">Home</a> 
	</form>

	</div>
	
		<div data-role="content" >
		<form action="/tracking" method="Post">

		
			<div class="ui-block-a" id="start"><button type="submit" name="start" data-theme="b" value="start" onClick="TestFunction()">Start</button></div>
			
			<div data-role="fieldcontain">
   			<fieldset data-role="controlgroup">
   			
   			<div id="option1">
			<label for="option1" class="select"></label>
			<select name="option1" id="option1" onChange="HideList2();">
			<option value=STUDY>STUDY</option>
			<option value=SPORT>SPORT</option>
   			<option value=SOCIAL>SOCIAL</option>
   			<option value=SLEEP>SLEEP</option>
   			</select>
   			</div>
   			
   			<div id="option2">
   			<label for="option2" class="select"></label>
			<select name="option2">
			<option value=Lecture>Lecture</option>
   			<option value=SelfTeaching>SelfTeaching</option>
   			<option value=TeamWork>TeamWork</option>
   			<option value=Practice>Practice</option>
   			</select>
   			</div>
   			
   			</fieldset>
			</div>
   			
   			
   			
   			
   			
			<div class="ui-block-a" id="stop"><button type="submit"  name="stop" data-theme="b" value="stop" onClick="TestFunction()">Stop</button></div>
			<div class="ui-block-a" id="cancel"><button type="submit"  name="cancel" data-theme="b" value="cancel" onClick="TestFunction()">Stop</button></div>   
		</form>
		

        
        </div>

        


	
	
	
	

</div>

</body>
</html>