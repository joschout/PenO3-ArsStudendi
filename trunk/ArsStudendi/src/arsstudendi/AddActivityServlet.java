package arsstudendi;

import java.io.IOException;

import Controllers.*;
import DomainModel.Student;

import java.util.*;

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
		String activityName = (String)req.getAttribute("courses");
		String[] studentCourses = controller.getCourseNames(student);
		req.setAttribute("studentCourses", studentCourses);
		
		String add= req.getParameter("AddActivity");
		System.out.println(add);
		if(add != null){
		String start = req.getParameter("startDate");
		System.out.println(start);
//		Calendar startTime = Calendar.getInstance();
//		int startyear = Integer.parseInt(start.substring(0,4));
//		int startmonth = Integer.parseInt(start.substring(5,7));
//		int startday = Integer.parseInt(start.substring(8,10));
//		startTime.set(startyear, startmonth-1, startday, 23, 59, 59);
//		
		String stop = req.getParameter("stopDate");
		System.out.println(stop);
//		Calendar stopTime = Calendar.getInstance();
//		int stopyear = Integer.parseInt(stop.substring(0,4));
//		int stopmonth = Integer.parseInt(stop.substring(5,7));
//		int stopday = Integer.parseInt(stop.substring(8,10));
//		stopTime.set(stopyear, stopmonth-1, stopday, 23, 59, 59);
//		controller.addActivity(student, currentID, startTime, stopTime, activityName);
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
