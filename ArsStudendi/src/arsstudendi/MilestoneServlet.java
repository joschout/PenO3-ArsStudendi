package arsstudendi;
import Controllers.*
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controllers.RegisterController;
@SuppressWarnings("serial")
public class MilestoneServlet extends HttpServlet {
	MilestoneController milestoneController = new MilestoneController();

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	}
}
