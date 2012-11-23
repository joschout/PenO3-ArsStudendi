package arsstudendi;

import Controllers.*;
import java.io.IOException;
import DomainModel.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class MilestoneServlet extends HttpServlet {
	MilestoneController milestoneController = new MilestoneController();

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String milestoneName = req.getParameter("milestoneName");
		
		HttpSession session = req.getSession();
		Student student = (Student)session.getAttribute("currentUser");
		
		
		
		// start en stopTime die calender object teruggeven?
		// courses moeten op het
		// scherm komen, aanvinken. Deze course moet doorgegeven worden
		// tick: amount of pages of time. 
		//hoeveel page's en hoeveel tijd moet
		// aangegeven worden
		//submit: aanmaken van milestone
milestoneController.makeNewMilestone(student, milestoneName, startTime, stopTime, course, milestoneType, goal)
	}
}
