package arsstudendi;

import Controllers.*;
import java.io.IOException;
import java.util.*;
import java.text.*;

import DomainModel.*;

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
		
		String milestoneDate = req.getParameter("milestoneDate");
		Calendar cal = Calendar.getInstance();
		int year = Integer.parseInt(milestoneDate.substring(0,4));
		int month = Integer.parseInt(milestoneDate.substring(5,7));
		int day = Integer.parseInt(milestoneDate.substring(8,10));
		cal.set(year, month-1, day, 23, 59, 59);
		
		
		//String startTime = req.getParameter("start");
		//String stopTime = req.getParameter("end");
		
		String milestoneType = req.getParameter("milestoneType");
		int goal;
			if(milestoneType.equals("Study")) {
				String milestoneSort = req.getParameter("milestoneSort");
				if(milestoneSort.equals("Page")) {
					String amountOfPages = req.getParameter("amountOfPages");
					goal = Integer.parseInt(amountOfPages);
					
				}
				else if(milestoneSort.equals("Time")) {
					String time = req.getParameter("time");
					int hour = Integer.parseInt(time.substring(0,2));
					int min = Integer.parseInt(time.substring(3,5));
					goal = 60*hour+min;
					
				}
			}
			else if(milestoneType.equals("Sports")) {
					String time = req.getParameter("sportsTime");
					int hour = Integer.parseInt(time.substring(0,2));
					int min = Integer.parseInt(time.substring(3,5));
					goal = 60*hour+min;
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