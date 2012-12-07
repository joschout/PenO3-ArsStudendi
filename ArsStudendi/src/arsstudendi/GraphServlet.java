package arsstudendi;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
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
}
