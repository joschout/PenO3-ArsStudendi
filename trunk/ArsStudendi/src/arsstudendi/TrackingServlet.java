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
		req.setAttribute("aCheck", aCheck);
		String start = req.getParameter("start");
		String stop = req.getParameter("stop");
		String cancel = req.getParameter("cancel");
		String option1 = req.getParameter("option1");
		String option2 = req.getParameter("option2");		
		if( start != null){
			controller.startActivity(student, option2);
		}
		if (stop != null){
			controller.stopActivity(student);
		}
		if(cancel != null){
			controller.cancelActivity(student);
		}
		aCheck = controller.checkActivity(student);
		if (aCheck != null ){
			req.setAttribute("aCheck", aCheck);
		}
		else{
			req.setAttribute("aCheck", null);
		}

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




