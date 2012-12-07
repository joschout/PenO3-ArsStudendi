package arsstudendi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controllers.ProfileController;
import Controllers.RegisterController;
import DomainModel.Student;

public class ProfileServlet  extends HttpServlet{

	ProfileController profileController = new ProfileController();
	RegisterController registerController = new RegisterController();
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
		
		
		String newFirstName = (String)req.getParameter("changedFirstName");
		if (newFirstName != null){
		profileController.changeFirstName(student, newFirstName);
		req.setAttribute("studentFirstName", newFirstName);
		System.out.println(newFirstName);
		}
		String newLastName = (String)req.getParameter("changedLastName");
		if (newLastName != null){
		profileController.changeLastName(student, newLastName);
		req.setAttribute("studentLastName", newLastName);
		System.out.println(newLastName);
		}
		
		String newEmailAdress = (String)req.getParameter("changedEmailAdress");
		if(newEmailAdress != null && registerController.isEmailAvailable(newEmailAdress)){
			
			
			profileController.changeEmail(student, newEmailAdress);
			req.setAttribute("email", newEmailAdress);
			System.out.print(newEmailAdress);
		}
		
		
		String newPassword1 =(String)req.getParameter("changedPassword1");
		String newPassword2 = (String)req.getParameter("changedPassword2");
		

		
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
