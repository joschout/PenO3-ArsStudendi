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
		System.out.println(currentID);
		Student student = controller.getStudent(currentID);
		String aCheck = controller.checkActivity(student);
		String[] studentCourses = controller.getCourseNames(student);
		req.setAttribute("studentCourses", studentCourses);
		req.setAttribute("aCheck", aCheck);
		System.out.println(studentCourses);
		if(aCheck != null){
		long timePassed = controller.getTimePassed(controller.getActivity(student));
		req.setAttribute("timePassed", timePassed);
		}
		else
		{	int i=-1;
			String s = Integer.toString(i);
			System.out.println(s + "test2");
			req.setAttribute("timePassed", i);}
		
		String start = req.getParameter("start");
		String stop = req.getParameter("stop");
		String cancel = req.getParameter("cancel");
		String option1 = req.getParameter("option1");
		String option2 = req.getParameter("option2");		
		if( start != null){
			controller.startActivity(student, option1);
			long timePassed = controller.getTimePassed(controller.getActivity(student));
			req.setAttribute("timePassed", timePassed); 
		}
		if (stop != null){
			Long numPages = (Long)req.getAttribute("numPages");
			String courseStudied = (String)req.getAttribute("courses");
			controller.stopActivity(student);
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




