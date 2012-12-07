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
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script>

      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();

        
		data.addColumn('string', 'Keys');
		data.addColumn('number', 'Values');
		
		<% String[] pieChartKeysArray = (String[])request.getAttribute("pieChartKeysArray");
       	String[] pieChartValuesArray = (String[])request.getAttribute("pieChartValuesArray");
        int i =0;
        if(pieChartKeysArray!= null && pieChartValuesArray != null){
        	while(i<=pieChartKeysArray.length-1){%>		
        data.addRows([
        	 ['<%out.print(pieChartKeysArray[i]);%>', <%out.print(pieChartValuesArray[i]);%>]	
        ]);
 	 <%	
        i++;
        	}
        }        
        %>
        
		
        // Set chart options
        var options = {'title':'How Much Pizza I Ate Last Night',
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
      </script>
</head>
<body> 

<div data-role="page">
	


	<div data-role="header" data-theme="b">
	 	<a href="/index" data-role="button" data-icon="home" data-iconpos="notext">Home</a>
		<h1>Statistics</h1>
		<a href="logout.jsp" data-role="button" data-icon="delete">LogOut</a>
	</div><!-- /header -->
	
	<div>
	<a href="#popupBasic" data-rel="popup">Recorded Activities</a>

	<div data-role="popup" id="popupBasic">
	<% 	String[] names = (String[])request.getAttribute("names");
	String[] startT = (String[])request.getAttribute("startT");
	String[] stopT = (String[])request.getAttribute("stopT"); 
	int j = 0;
	while(j<names.length) {
	%>
	<p><%out.println(names[j] + " " + startT[j] + " " + stopT[j]); %><p>
	<%j++;}%>

	</div>


	<div id="chart_div"></div>
</div><!-- /page -->

</body>
</html>