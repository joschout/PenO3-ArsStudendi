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
		HttpSession session = req.getSession();
		
		Student student = (Student)session.getAttribute("currentUser");		
		
		if(student!= null){
		controller.logOut(student);
   	 	session.invalidate();
		}
		
		resp.sendRedirect("/home.jsp");

		}


		
}