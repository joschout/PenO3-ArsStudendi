package arsstudendi;

import DomainModel.Student;
import Controllers.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogOutServlet extends HttpServlet 
{
	LogController controller = new LogController();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException 
	{
		LogController controller = new LogController();
		HttpSession session = req.getSession();
		
		long ID = (Long)session.getAttribute("currentID");
		Student student = controller.getStudent(ID);
		
		if(student!= null){
		controller.logOut(student);
		session.setAttribute("currentID", "null");
   	 	session.invalidate();
		}
		
		
		resp.sendRedirect("/home.jsp");

		}


		
}