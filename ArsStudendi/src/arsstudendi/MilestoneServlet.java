package arsstudendi;

import Controllers.*;
import java.io.IOException;
import java.util.*;
import java.text.*;

import DomainModel.*;
import activityTypePackage.*;
import arsstudendi.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class MilestoneServlet extends HttpServlet {
	MilestoneController milestoneController = new MilestoneController();
	
	

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		HttpSession session = req.getSession();
		Long currentID = (Long)session.getAttribute("currentID");
		Student student = milestoneController.getStudent(currentID);

		String milestoneName = req.getParameter("nameMilestone");
		
		Calendar stopTime = Calendar.getInstance();
		int stopyear = Integer.parseInt(req.getParameter("select-stop-year"));
		int stopmonth = Integer.parseInt(req.getParameter("select-stop-month"));
		stopmonth = stopmonth -1;
		int stopday = Integer.parseInt(req.getParameter("select-stop-day"));
		stopTime.set(stopyear, stopmonth, stopday, 00, 01);
		
		
		//String startTime = req.getParameter("start");
		//String stopTime = req.getParameter("end");
		
		String milestoneType = req.getParameter("milestoneType");
		int goal = 0;
			if(milestoneType.equals("Study")) {
				String courseString = req.getParameter("select-choice-0");
				String milestoneSort = req.getParameter("milestoneSort");
				if(milestoneSort.equals("Page")) {
					String amountOfPages = req.getParameter("amountOfPages");
					goal = Integer.parseInt(amountOfPages);
					
				}
				else if(milestoneSort.equals("Time")) {
					int studyHour = Integer.parseInt(req.getParameter("studyHour"));
					int studyMinute = Integer.parseInt(req.getParameter("studyMinute"));
					goal = 60*studyHour+studyMinute;	
				}
			milestoneController.makeNewMilestone(student, milestoneName, stopTime, courseString, milestoneType, goal);
			}
			else if(milestoneType.equals("Sports")) {
					int sportsHour = Integer.parseInt(req.getParameter("sportsHour"));
					int sportsMinute = Integer.parseInt(req.getParameter("sportsMinute"));
					goal = 60*sportsHour+sportsMinute;
				}
			
			
			//milestoneController.makeNewMilestone(student, milestoneName, startTime, stopTime, course, milestoneType, goal);
			
		
		resp.sendRedirect("milestones.jsp");
		
		// start en stopTime die calender object teruggeven?
		// courses moeten op het scherm komen (dropdown), aanvinken. Deze course moet doorgegeven worden
		// tickbox:amount of pages of time. 
		//hoeveel page's en hoeveel tijd moet aangegeven worden
		//submit: aanmaken van milestone
		// milestoneController.makeNewMilestone(student, milestoneName, startTime, stopTime, course, milestoneType, goal);
		
		//ArrayList<String> courses = new ArrayList<String>();
		//int i =0;
		String[] courseNames = milestoneController.getCourseNames(student);
		//System.out.println("courses"+courseNames);
		/*int length = courseNames.length;
		while(i < length){
			String s = new String();
			s = req.getParameter("" + courseNames[i]);
			if (s != null){
				courses.add(courseNames[i]);
			}
			i++;
		}*/
		req.setAttribute("courseNames", courseNames);
		try {
			req.getRequestDispatcher("/newMilestone.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR DETECTED");
			e.printStackTrace();
	}
	
	}
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
    	
    	HttpSession session = req.getSession();
		Long currentID = (Long)session.getAttribute("currentID");
		Student student = milestoneController.getStudent(currentID);
		
    	String[] courseNames = milestoneController.getCourseNames(student);
    	req.setAttribute("courseNames", courseNames);
		try {
			req.getRequestDispatcher("/newMilestone.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR DETECTED");
			e.printStackTrace();
	}
    	
    }  
}