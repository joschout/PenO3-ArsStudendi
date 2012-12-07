package arsstudendi;

import Controllers.*;
import java.io.IOException;
import java.util.*;
import java.text.*;

import DomainModel.*;
import activityTypePackage.*;
import arsstudendi.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ShowMilestoneServlet extends HttpServlet {
	MilestoneController milestoneController = new MilestoneController();
	
	

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
	
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession session = req.getSession();
		Long currentID = (Long)session.getAttribute("currentID");
		Student student = milestoneController.getStudent(currentID);
		
		String[] milestoneNames = milestoneController.getMilestoneNames(student);
		int[] milestoneProcents = milestoneController.getMilestoneProgress(student);
		
		req.setAttribute("milestoneProcents", milestoneProcents);
		req.setAttribute("milestoneNames", milestoneNames);
		
		try {
			req.getRequestDispatcher("/showMilestones.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR DETECTED");
			e.printStackTrace();
		}
	}
}

