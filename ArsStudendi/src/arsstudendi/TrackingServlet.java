package arsstudendi;

import Controllers.*;
import DomainModel.Student;

import java.util.*;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;


public class TrackingServlet extends HttpServlet 
{
	TimerController controller = new TimerController();
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession session = req.getSession();
		Long currentID = (Long)session.getAttribute("currentID");
		Student student = controller.getStudent(currentID);
		String aCheck = controller.checkActivity(student);
		String[] studentCourses = controller.getCourseNames(student);
		req.setAttribute("studentCourses", studentCourses);
		req.setAttribute("aCheck", aCheck);
		if(aCheck != null){
		long timePassed = controller.getTimePassed(controller.getActivity(student));
		req.setAttribute("timePassed", timePassed);
		}
		else
		{	int i=-1;
			String s = Integer.toString(i);
			req.setAttribute("timePassed", i);}
		
		String start = req.getParameter("start");
		String stop = req.getParameter("stop");
		String cancel = req.getParameter("cancel");
		String add = req.getParameter("addActivity");
		String option1 = req.getParameter("option1");
		String option2 = req.getParameter("option2");
		String option3 = req.getParameter("option3");
		if( start != null){
			controller.startActivity(student);
			long timePassed = controller.getTimePassed(controller.getActivity(student));
			req.setAttribute("timePassed", timePassed); 
		}
		if (stop != null){
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
			controller.stopActivity(student, description, courseStudied, activityType, amountOfPages);
			int i=-1;
			String s = Integer.toString(i);
			req.setAttribute("timePassed", s);
			
		}
		if(cancel != null){
			controller.cancelActivity(student);
			int i=-1;
			String s = Integer.toString(i);
			req.setAttribute("timePassed", s);
		}
		if(add != null){
			resp.sendRedirect("/addActivity");
		}
		aCheck = controller.checkActivity(student);
		req.setAttribute("aCheck", aCheck);
//		resp.sendRedirect("/tracking.jsp");
		try {
				req.getRequestDispatcher("/tracking.jsp").forward(req, resp);
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




