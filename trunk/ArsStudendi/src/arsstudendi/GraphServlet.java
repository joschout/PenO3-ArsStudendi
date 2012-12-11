package arsstudendi;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import Controllers.*;
import graphPackage.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controllers.LogController;
import DomainModel.Student;


public class GraphServlet extends HttpServlet {

	GraphController controller = new GraphController();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
		HttpSession session = req.getSession();
		Long currentID = (Long)session.getAttribute("currentID");
		Student student = StudentRegistry.getSingletonObject().getStudent(currentID);
		Graph pieChart = controller.makePieChartOfCourses(student, "Dit is een test.");
		Graph pieChart2 = controller.makePieChartOfAllCourses(student, "Dit is een test.");
		String[] activityNames = controller.getOldActivityNames(student);
		String[] startTimes = controller.getOldActivityStartDates(student);
		String[] stopTimes = controller.getOldActivityStopDates(student);
		String[] allactivityNames = controller.getAllOldActivityNames(student);
		String[] allstartTimes = controller.getAllOldActivityStartDates(student);
		String[] allstopTimes = controller.getAllOldActivityStopDates(student);
		req.setAttribute("names", activityNames);
		req.setAttribute("startT", startTimes);
		req.setAttribute("stopT", stopTimes);
		req.setAttribute("allnames", activityNames);
		req.setAttribute("allstartT", startTimes);
		req.setAttribute("allstopT", stopTimes);
		Set<Entry<String,Long>> pieChartSet = ((PieChart)pieChart).getPieChartMap().entrySet();
		Set<Entry<String,Long>> pieChartSet2 = ((PieChart)pieChart2).getPieChartMap().entrySet();
		
		List<String> pieChartKeys = new ArrayList<String>();
		List<String> pieChartValues = new ArrayList<String>();
		List<String> allpieChartKeys = new ArrayList<String>();
		List<String> allpieChartValues = new ArrayList<String>();
		
		for(Entry entry: pieChartSet){
			pieChartKeys.add((String)entry.getKey());
			pieChartValues.add(((Long)entry.getValue()).toString());
		}
		for(Entry entry: pieChartSet2){
			allpieChartKeys.add((String)entry.getKey());
			allpieChartValues.add(((Long)entry.getValue()).toString());
		}
		
		String[] pieChartKeysArray = pieChartKeys.toArray(new String[pieChartKeys.size()]);
		String[] pieChartValuesArray =  pieChartValues.toArray(new String[pieChartValues.size()]);
		String[] allpieChartKeysArray = allpieChartKeys.toArray(new String[allpieChartKeys.size()]);
		String[] allpieChartValuesArray =  allpieChartValues.toArray(new String[allpieChartValues.size()]);

		
		
//		Set<String> pieChartKeysSet= ((PieChart)pieChart).getPieChartMap().keySet();
//		
//		
//		HashMappieChartValues =((PieChart)pieChart).getPieChartMap().values();		
//		
////		String rawData =((PieChart)pieChart).getPieChartMap().toString();
////		String chartData = parse(rawData);
		
		req.setAttribute("pieChartKeysArray", pieChartKeysArray);
		req.setAttribute("pieChartValuesArray", pieChartValuesArray);
		req.setAttribute("pieChartTitle", "Dit is een test.");
		req.setAttribute("allpieChartKeysArray", allpieChartKeysArray);
		req.setAttribute("allpieChartValuesArray", allpieChartValuesArray);
		req.setAttribute("allpieChartTitle", "Dit is een test.");
		
		
		
//		Graph lineChart = controller.makeLineChartOfCourse(student, "Dit is een test.");
//		List<String> lineChartCourseNames= ((LineChart)lineChart).getNamesOfAllDataSeries();
//		String[] lineChartCourseNamesArray = lineChartCourseNames.toArray(new String[lineChartCourseNames.size()]);
//		req.setAttribute("lineChartCourseNamesArray", lineChartCourseNamesArray);
//		
//		List<String> lastWeek= ((LineChart)lineChart).getXAxis();
//		String[] lastWeekArray= lastWeek.toArray(new String[lastWeek.size()]);
//		req.setAttribute("lastWeekArray", lastWeekArray);
//		
//		int j=0;
//		while(j<= ((LineChart)lineChart).getData().size()-1){
//			List<String> tempList = ((LineChart)lineChart).getData().get(0).getHoursPerTime().get(lastWeek.get(j));
//		}
		
		

		try {
			req.getRequestDispatcher("/statistics.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR DETECTED");
			e.printStackTrace();
	}
		
	}
	
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
    	doPost(req, resp);
    }  
//	
//	private String parse(String inPutString){
//		String tempString = inPutString.replaceAll("{","['");
//		tempString = tempString.replaceAll("=", "', ");
//		tempString = tempString.replaceAll("}", "]");
//		return tempString;
//		
//		
//	}
//	
    
    
//    private void prepareLineChart(Student student, String graphName){
//    	Graph graph= controller.makeLineChartOfCourse(student, graphName);
//    	LineChart lineChart = (LineChart)graph;
//		int dayOfMonth = Calendar.DAY_OF_MONTH;
//		int month = Calendar.MONTH;  // gaat van 0 tot 11
//		int realMonth = month +1;
//		int year = Calendar.YEAR;
//		String currentDate = "" + dayOfMonth + "/" + realMonth + "/" + year;
//		List<String> lastWeek = new ArrayList<String>();
//		int i=6;
//		while(i>=0){
//			Calendar tempDate =Calendar.getInstance();
//			tempDate.set(Calendar.DAY_OF_MONTH, -i);
//			int tempDay = tempDate.DAY_OF_MONTH;
//			int tempMonth = tempDate.MONTH +1;
//			int tempYear = tempDate.YEAR;
//			String tempDateString = "" + tempDay + "/" + tempMonth + "/" + tempYear;		
//			lastWeek.add(tempDateString);
//		}
//		List<ArrayList<String>> columns = new ArrayList<ArrayList<String>>();
//		
//		ArrayList<String> columnOne = new ArrayList<String>();
//		columnOne.add("day");
//		columnOne.addAll(lastWeek);
//		columns.add(columnOne);
//		
//		for( LineGraphDataSeries data: lineChart.getData()){
//			String courseName = data.getName();
//			
//		}
//    	
//    	
//    }
    
    
    
    
    
    
}
