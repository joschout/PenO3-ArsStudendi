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
		String start = req.getParameter("start");
		String stop = req.getParameter("stop");
		String cancel = req.getParameter("cancel");
		String option1 = req.getParameter("option1");
		String option2 = req.getParameter("option2");
		HttpSession session = req.getSession();
		Student student = (Student)session.getAttribute("currentUser");
		if( start != null){
			controller.startActivity(student, option2);
		}
		if (stop != null){
			controller.stopActivity(student);
		}
//		if(cancel != null){
//			controller.cancelActivity(student);
//		}
		resp.sendRedirect("/tracking.jsp");
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	HttpSession session = req.getSession();
	Student student = (Student)session.getAttribute("currentUser");
	String studentName = student.getStudentFirstName() + " " + student.getStudentLastName();
	req.setAttribute("studentName", studentName);
	try {
		req.getRequestDispatcher("/tracking.jsp").forward(req, resp);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		System.out.println("ERROR DETECTED");
		e.printStackTrace();
}

}}


