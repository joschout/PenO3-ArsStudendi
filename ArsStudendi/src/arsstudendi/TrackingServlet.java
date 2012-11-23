package arsstudendi;

import Controllers.*;

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
		if( start != null){
			controller.startActivity();
		}
		if (stop != null){

		}
		resp.sendRedirect("/tracking.jsp");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

	try {
		req.getRequestDispatcher("/tracking.jsp").forward(req, resp);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		System.out.println("ERROR DETECTED");
		e.printStackTrace();
}

}}


