package arsstudendi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DomainModel.Student;

public class ProfileServlet  extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		HttpSession session = req.getSession();
		Long currentID = (Long) session.getAttribute("currentID");
		Student student = StudentRegistry.getSingletonObject().getStudent(
				currentID);
		String firstName = student.getStudentFirstName();
		String lastName = student.getStudentLastName();
		String email = student.getEmailAdress();

		req.setAttribute("studentFirstName", firstName);
		req.setAttribute("studentLastName", lastName);
		req.setAttribute("email", email);
		try {
			req.getRequestDispatcher("/profile.jsp").forward(req, resp);
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
