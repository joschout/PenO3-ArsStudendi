package arsstudendi;

import java.io.IOException;

import Controllers.*;
import DomainModel.Student;

import java.util.*;
import java.text.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddActivityServlet extends HttpServlet{
	TimerController controller = new TimerController();
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		Long currentID = (Long)session.getAttribute("currentID");
		Student student = controller.getStudent(currentID);
		String activityName = (String)req.getParameter("courses");
		String[] studentCourses = controller.getCourseNames(student);
		req.setAttribute("studentCourses", studentCourses);
		
		String stop= req.getParameter("stop");
		System.out.println(stop);
		if(stop != null){
		Calendar startTime = Calendar.getInstance();	
		int startyear = Integer.parseInt(req.getParameter("select-start-year"));
		int startmonth = Integer.parseInt(req.getParameter("select-start-month"));
		startmonth = startmonth - 1;
		int startday = Integer.parseInt(req.getParameter("select-start-day"));
		int starthour = Integer.parseInt(req.getParameter("select-start-hour"));
		int startminute = Integer.parseInt(req.getParameter("select-start-minute"));
		startTime.set(startyear, startmonth, startday, starthour, startminute);

		Calendar stopTime = Calendar.getInstance();
		int stopyear = Integer.parseInt(req.getParameter("select-stop-year"));
		int stopmonth = Integer.parseInt(req.getParameter("select-stop-month"));
		int stopday = Integer.parseInt(req.getParameter("select-stop-day"));
		int stophour = Integer.parseInt(req.getParameter("select-stop-hour"));
		int stopminute = Integer.parseInt(req.getParameter("select-stop-minute"));
		stopTime.set(stopyear, stopmonth, stopday, stophour, stopminute);
		
		String option1 = req.getParameter("option1");
		String option2 = req.getParameter("option2");
		String option3 = req.getParameter("option3");
		String description= req.getParameter("ActivityDescription");
		String courseStudied = new String();
		String activityType = new String();
		int amountOfPages = -1;
		if (option1.equals("STUDY")){
			activityType= option2;
			courseStudied = (String)req.getParameter("courses");
			if(option2.equals("Practice")){
				amountOfPages = Integer.parseInt(req.getParameter("amountOfPages"));
			}
		}
		else if(option1.equals("FREETIME")){
			activityType= option3;
		}
		else if(option1.equals("SLEEP")){
			activityType=option1;
		}
		controller.addActivity(student, currentID, startTime, stopTime, activityName, description, courseStudied, activityType, amountOfPages);
		resp.sendRedirect("/tracking");
		}
		try {
			req.getRequestDispatcher("/addActivity.jsp").forward(req, resp);
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
}
