
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
        HttpSession session;

        public void doPost(HttpServletRequest req, HttpServletResponse resp)
                        throws IOException 
        {

                String emailAdress = req.getParameter("emailAdress");
                String password = req.getParameter("password");
                
                
                session = req.getSession();
                
                Student student = controller.logIn(password, emailAdress);
                if(controller.testLogin(student)){
                		 Long currentID = student.getStudentID();
                        session.setAttribute("currentID", currentID);
                        resp.sendRedirect("/index");
                }
                else
                {
            		try {
            			req.getRequestDispatcher("/home.jsp").forward(req, resp);
            		} catch (ServletException e) {
            			// TODO Auto-generated catch block
            			System.out.println("ERROR DETECTED");
            			e.printStackTrace();
            	}}
                }

        
        public void doGet(HttpServletRequest req, HttpServletResponse resp) 
                throws IOException
                {
        			doPost(req, resp);
                }
                
}