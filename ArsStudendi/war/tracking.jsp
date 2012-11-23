<!DOCTYPE html> 
<html> 
<head> 
	<title>ArsStudendi</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js"></script>
	
<script>
function TestFunction(){
	if($("#start").is(':visible')){
	$("#start").hide();
	$("#stop").show();
	}
	else{
	$("#start").show();
	$("#stop").hide();
	}
}


</script>

	
</head> 
<body> 

<div data-role="page">

	<div data-role="header" data-theme="b">
		<h1>Tracking</h1>
		 <a href="../index.html" data-role="button" data-icon="home" data-iconpos="notext">Home</a> 

	</div>
	
		<div data-role="content" >
		<form action="/tracking" method="Post">
		<fieldset class="ui-grid-a">
			<div class="ui-block-a" id="start"><button type="submit" name="start" data-theme="b" value="start" onClick="TestFunction()">Start</button></div>
			<div class="ui-block-a" id="stop"><button type="button"  name="stop" data-theme="b" value="stop" onClick="TestFunction()">Stop</button></div>   
		</fieldset>
		</form>
		

        
        </div>

        


	
	
	
	

</div>

</body>
</html>