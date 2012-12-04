package arsstudendi;

import java.io.IOException;
import java.util.AbstractMap;

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
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
		HttpSession session = req.getSession();
		Long currentID = (Long)session.getAttribute("currentID");
		Student student = StudentRegistry.getSingletonObject().getStudent(currentID);
		
		Graph pieChart = controller.makePieChartOfCourses(student, "Dit is een test.");
		String rawData =((PieChart)pieChart).getPieChartMap().toString();
		String chartData = parse(rawData);
		
		req.setAttribute("pieChartData", chartData);
		req.setAttribute("pieChartTitle", "Dit is een test.");
		
		
	}
	
	private String parse(String inPutString){
		String tempString = inPutString.replaceAll("{","['");
		tempString = tempString.replaceAll("=", "', ");
		tempString = tempString.replaceAll("}", "]");
		return tempString;
		
		
	}
	
}
