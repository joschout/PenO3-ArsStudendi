package arsstudendi;

import Controllers.*;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MilestoneServlet extends HttpServlet {
	MilestoneController milestoneController = new MilestoneController();

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String milestoneName = req.getParameter("milestoneName");
		//start en stopTime die calender object teruggeven? 

		ArrayList<String> courses = new ArrayList<String>();
		int i = 0;
		String[] courseNames = controller.getCourseNames();
		int length = courseNames.length;
		while (i < length) {
			String s = new String();
			s = req.getParameter("" + courseNames[i]);
			if (s != null) {
				courses.add(courseNames[i]);
			}
			i++;
		}
	}
}
