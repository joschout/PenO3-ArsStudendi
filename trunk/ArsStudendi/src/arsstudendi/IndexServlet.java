
package arsstudendi;

import DomainModel.Student;
import Controllers.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class IndexServlet extends HttpServlet {
   
	TimerController controller = new TimerController();
   
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                    throws IOException 
    {
    	System.out.println("ITWORKS");
		HttpSession session = req.getSession();
		Long currentID = (Long)session.getAttribute("currentID");
		Student student = controller.getStudent(currentID);
		String aCheck = controller.checkActivity(student);
		req.setAttribute("aCheck", aCheck);
		if(aCheck != null){
		long timePassed = controller.getTimePassed(controller.getActivity(student));
		req.setAttribute("timePassed", timePassed);
		}
		else
		{	int i=-1;
			String s = Integer.toString(i);
			System.out.println(s + "test2");
			req.setAttribute("timePassed", i);}  
		try {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
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