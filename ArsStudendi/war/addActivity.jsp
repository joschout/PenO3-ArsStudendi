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
	function myLiveEventHandler(event)
	{
  	if(event.handled !== true)
  	{
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
		
		<select name="select-start-day" id="select-start-day">           
        <% int k1 = 1;
           while(k1<32){%>
         <option id=<%out.println(k1);%> value=<%out.println(k1);%>><%if(k1<10){out.println("0" + k1);} else{out.println(k1);}%></option>
        <% k1++;}%>
        </select>
        
       	<select name="select-start-month" id="select-start-month" onChange="changeStart();">           
        <% int k2 = 1;
           while(k2<13){%>
         <option value=<%out.println(k2);%>><%if(k2<10){out.println("0" + k2);} else{out.println(k2);}%></option>
        <% k2++;}%>
        </select>
        
		<select name="select-start-year" id="select-start-year">           
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
        <select name="select-start-hour" id="select-start-hour">           
            <% int k4 = 0;
           		while(k4<24){%>
            <option value=<%out.println(k4);%>><%if(k4<10){out.println("0" + k4);} else{out.println(k4);}%></option>
            <% k4++;}%>
        </select>
        <select name="select-start-minute" id="select-start-minute">
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
		
		<select name="select-stop-day" id="select-stop-day">           
        <% int j1 = 1;
           while(j1<32){%>
         <option id=<%out.println(j1);%> value=<%out.println(j1);%>><%if(j1<10){out.println("0" + j1);} else{out.println(j1);}%></option>
        <% j1++;}%>
        </select>
        
       	<select name="select-stop-month" id="select-stop-month" onChange="changeStop();">           
        <% int j2 = 1;
           while(j2<13){%>
         <option value=<%out.println(j2);%>><%if(j2<10){out.println("0" + j2);} else{out.println(j2);}%></option>
        <% j2++;}%>
        </select>
        
		<select name="select-stop-year" id="select-stop-year">           
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
        <select name="select-stop-hour" id="select-stop-hour">           
            <% int j4 = 0;
           		while(j4<24){%>
            <option value=<%out.println(k4);%>><%if(k4<10){out.println("0" + j4);} else{out.println(j4);}%></option>
            <% j4++;}%>
        </select>
        <select name="select-stop-minute" id="select-stop-minute">
            <% int j5 = 0;
            	while(j5<60){%>
            <option value=<%out.println(j5);%>><%if(j5<10){out.println("0" + j5);} else{out.println(j5);}%></option>
			<% j5++;}%>
        </select>
        </fieldset>
        </div>
		
		
		
		
		
		
		
		<div data-role="fieldcontain" id="courses">
			<label for="select-choice-0" class="select">courses</label>
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
		
		
		<div id="submit"><button type="submit"  name="AddActivity" data-theme="b" value="submit" >submit</button></div>
		
		
		
		
		
		
		
		</form>
		</div>

        


	
	
	
	

</div>


</body>
</html>
		