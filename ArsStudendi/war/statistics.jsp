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
      google.setOnLoadCallback(drawChart2);

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
        var options = {'title':'Your Lessons Pie Chart',
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div1'));
        chart.draw(data, options);
        var chart2 = new google.visualization.BarChart(document.getElementById('chart_div2'));
        chart2.draw(data, options);
      }
      
      function drawChart2() {

        // Create the data table.
        var data2 = new google.visualization.DataTable();

        
		data2.addColumn('string', 'Keys');
		data2.addColumn('number', 'Values');
		
		<% String[] allpieChartKeysArray = (String[])request.getAttribute("allpieChartKeysArray");
       	String[] allpieChartValuesArray = (String[])request.getAttribute("allpieChartValuesArray");
        int k =0;
        if(allpieChartKeysArray!= null && allpieChartValuesArray != null){
        	while(k<=allpieChartKeysArray.length-1){%>		
        data2.addRows([
        	 ['<%out.print(allpieChartKeysArray[k]);%>', <%out.print(allpieChartValuesArray[k]);%>]	
        ]);
 	 <%	
        k++;
        	}
        }        
        %>
        
		
        // Set chart options
        var options3 = {'title':'All Students Pie Chart',
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart3 = new google.visualization.PieChart(document.getElementById('chart_div3'));
        chart3.draw(data2, options3);
        var chart4 = new google.visualization.BarChart(document.getElementById('chart_div4'));
        chart4.draw(data2, options3);
      }
      
      
      
      
      
      </script>
</head>
<body> 

<div data-role="page">
	


	<div data-role="header" data-theme="b">
	 	<a href="/index" data-role="button" data-icon="home" data-iconpos="notext">Home</a>
		<h1>Statistics</h1>
		<a href="logout.jsp" data-role="button" data-icon="delete">Log Out</a>
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


	<div id="chart_div1"></div>
	<div id="chart_div2"></div>

	<div id="chart_div3"></div>
	<div id="chart_div4"></div>

</div><!-- /page -->

</body>
</html>