package arsstudendi;

import DomainModel.Student;
import Controllers.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LogInServlet extends HttpServlet 
{
	LogController controller = new LogController();
	Student student = null;
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException 
	{

		
		String emailAdress = req.getParameter("emailAdress");
		String password = req.getParameter("password");

		Student student = controller.logIn(password, emailAdress);
		if(controller.testLogin(student)==false){
			resp.sendRedirect("/home.jsp");
			
		}
		

		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws IOException
		{
	    	
			HttpSession session = req.getSession();
			
			req.setAttribute("student", student);
			session.setAttribute("currentUser", student);
			try {
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
		
}
