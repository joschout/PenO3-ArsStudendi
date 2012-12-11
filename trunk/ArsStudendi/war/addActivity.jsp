<!DOCTYPE html> 
<html> 
<head> 
	<title>ArsStudendi</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css" />
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
	
	function disableB(){
				$("#warningMessage").text("Dates Invalid");
				$('[type="submit"]').button('disable');
				$('[type="submit"]').button('refresh');	
	
	}
	function enableB(){
				$("#warningMessage").text("");
				$('[type="submit"]').button('enable');
				$('[type="submit"]').button('refresh');	
	}
	function testDates(){
		var starty = parseInt($("#select-start-year option:selected").val());
		var startm = parseInt($("#select-start-month option:selected").val());
		var startd = parseInt($("#select-start-day option:selected").val());
		var starth = parseInt($("#select-start-hour option:selected").val());
		var starts = parseInt($("#select-start-minute option:selected").val());
	
	
		var stopy = parseInt($("#select-stop-year option:selected").val());
		var stopm = parseInt($("#select-stop-month option:selected").val());
		var stopd = parseInt($("#select-stop-day option:selected").val());
		var stoph = parseInt($("#select-stop-hour option:selected").val());
		var stops = parseInt($("#select-stop-minute option:selected").val());
		
		if((stopy-starty)<0)
		{
			disableB();
		}
		else if((stopm-startm)<0)
		{
			disableB();
		}		
		else if((stopd-startd)<0)
		{
			disableB();
		}	
		else if((stoph-starth)<0)
		{
			disableB();
		}	
		else if((stops-starts)<0)
		{
			disableB();
		}
		else if((stopy-starty) == 0)
		{
			if((stopm-startm)== 0){
				if((stopd-startd) == 0){
					if((stoph-starth) == 0){
						if((stops-starts) <= 0){
								disableB();
						}
						else{ enableB();}
					}
					else if((stoph-starth)<0){
						disableB();
					}
					else{
						enableB();
					}	
				}
				else if((stopd-startd)<0){
				disableB();
				}
				else{
				enableB();
				}
			}
			else if((stopm-startm)<0){
				disableB();
			}
			else {
			enableB();
			}
		}			
		else
		{
			$("#warningMessage").text("");
			$('[type="submit"]').button('enable');
			$('[type="submit"]').button('refresh');		
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
	
	
	
	
	
	function myLiveEventHandler(event)
	{
  	if(event.handled !== true)
  	{
  	testDates();
  	hideList2();
  	changeStop();
	changeStart();
    event.handled = true;
 	 }
  	return false;
	}
	$(document).bind("pageinit", myLiveEventHandler);
	</script>
		


	<div data-role="header" data-theme="b">
		<h1><%out.println("header"); %></h1>
		 <a href="/index" data-role="button" data-icon="home" data-iconpos="notext" data-ajax="false">Home</a> 
		<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>
	</div>


	
	
		<div data-role="content" >
		<form action="/addActivity" method="POST" data-ajax="false">
	
		<div data-role="fieldcontain">
		<legend>StartTime</legend>
		<fieldset data-role="controlgroup" data-type="horizontal">
		<legend>(Day, Month, Year)</legend>
		
		<select name="select-start-day" id="select-start-day" onChange="testDates();">           
        <% int k1 = 1;
           while(k1<32){%>
         <option id=<%out.println(k1);%> value=<%out.println(k1);%>><%if(k1<10){out.println("0" + k1);} else{out.println(k1);}%></option>
        <% k1++;}%>
        </select>
        
       	<select name="select-start-month" id="select-start-month" onChange="changeStart();testDates();">           
        <% int k2 = 1;
           while(k2<13){%>
         <option value=<%out.println(k2);%>><%if(k2<10){out.println("0" + k2);} else{out.println(k2);}%></option>
        <% k2++;}%>
        </select>
        
		<select name="select-start-year" id="select-start-year" onChange="testDates();">           
        <% int k3 = 2010;
           while(k3<2030){%>
         <option value=<%out.println(k3);%>><%out.println(k3);%></option>
        <% k3++;}%>
        </select> 
        </fieldset>
        </div>
        
        <div data-role="fieldcontain">
        <fieldset data-role="controlgroup" data-type="horizontal">
		<legend>(Hours, Minutes)</legend>
        <select name="select-start-hour" id="select-start-hour" onChange="testDates();">           
            <% int k4 = 0;
           		while(k4<24){%>
            <option value=<%out.println(k4);%>><%if(k4<10){out.println("0" + k4);} else{out.println(k4);}%></option>
            <% k4++;}%>
        </select>
        <select name="select-start-minute" id="select-start-minute" onChange="testDates();">
            <% int k5 = 0;
            	while(k5<60){%>
            <option value=<%out.println(k5);%>><%if(k5<10){out.println("0" + k5);} else{out.println(k5);}%></option>
			<% k5++;}%>
        </select>
        </fieldset>
        </div>
		
		
		<div data-role="fieldcontain">
		<legend>StopTime</legend>
		<fieldset data-role="controlgroup" data-type="horizontal">
		<legend>(Day, Month, Year)</legend>
		
		<select name="select-stop-day" id="select-stop-day" onChange="testDates();">           
        <% int j1 = 1;
           while(j1<32){%>
         <option id=<%out.println(j1);%> value=<%out.println(j1);%>><%if(j1<10){out.println("0" + j1);} else{out.println(j1);}%></option>
        <% j1++;}%>
        </select>
        
       	<select name="select-stop-month" id="select-stop-month" onChange="changeStop();testDates();">           
        <% int j2 = 1;
           while(j2<13){%>
         <option value=<%out.println(j2);%>><%if(j2<10){out.println("0" + j2);} else{out.println(j2);}%></option>
        <% j2++;}%>
        </select>
        
		<select name="select-stop-year" id="select-stop-year" onChange="testDates();">           
        <% int j3 = 2010;
           while(j3<2030){%>
         <option value=<%out.println(j3);%>><%out.println(j3);%></option>
        <% j3++;}%>
        </select> 
        </fieldset>
        </div>
        
        <div data-role="fieldcontain">
        <fieldset data-role="controlgroup" data-type="horizontal">
		<legend>(Hours, Minutes)</legend>
        <select name="select-stop-hour" id="select-stop-hour" onChange="testDates();">           
            <% int j4 = 0;
           		while(j4<24){%>
            <option value=<%out.println(j4);%>><%if(j4<10){out.println("0" + j4);} else{out.println(j4);}%></option>
            <% j4++;}%>
        </select>
        <select name="select-stop-minute" id="select-stop-minute" onChange="testDates();">
            <% int j5 = 0;
            	while(j5<60){%>
            <option value=<%out.println(j5);%>><%if(j5<10){out.println("0" + j5);} else{out.println(j5);}%></option>
			<% j5++;}%>
        </select>
        </fieldset>
        </div>
		
		
		

		
		
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
				<div class="ui-block-a" id="stop"><button type="submit" name="stop" data-theme="b" value="stop">Add</button></div>	   
			</fieldset>
		
			<div id="warningMessage" class="center-align"></div>
		
		
		
		
		
		</form>
		</div>

        


	
	
	
	

</div>


</body>
</html>
		