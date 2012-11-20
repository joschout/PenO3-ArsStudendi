package arsstudendi;

import DomainModel.Student;
import Controllers.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogOutServlet extends HttpServlet 
{
	LogController logController = new LogController();
	Student student = ;
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException 
	{
		
		
		
		logController.logOut(student);
		resp.sendRedirect("/home.jsp");
//
//		String emailAdress = req.getParameter("emailAdress");
//		String password = req.getParameter("password");
//
//		Student student = controller.logIn(password, emailAdress);
//		if(controller.testLogin(student)){
//			resp.sendRedirect("/index.html");
//			
//		}
//		else
//		{
//			resp.sendRedirect("/home.jsp");
		}


//
//	}
//	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws IOException
		{
//			req.setAttribute("student", student);
//			try {
//				req.getRequestDispatcher("/register.jsp").forward(req, resp);
//			} catch (ServletException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//		}
		}
		
}