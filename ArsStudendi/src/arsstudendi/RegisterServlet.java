package arsstudendi;

import Controllers.*;
import DomainModel.Student;
import DomainModel.StudyProgram;


import java.util.*;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;




@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	RegisterController registerController = new RegisterController();
	LogController logController = new LogController();
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		HttpSession session = req.getSession();
		
		String studentFirstName = req.getParameter("studentFirstName");
		String studentLastName = req.getParameter("studentLastName");
		String password = req.getParameter("password");
		String emailAdress = req.getParameter("emailAdress");
			
		//String StrStudentID = req.getParameter ("studentID");
		//Long studentID = Long.valueOf(StrStudentID);
//		long l = Long.valueOf(nStudyProgram).longValue();
//		String studyProgram = controller.getProgramNameWithLong(l);
		
		ArrayList<String> courses = new ArrayList<String>();
		int i =0;
		String[] courseNames = registerController.getCourseNames();
		int length = courseNames.length;
		while(i < length){
			String s = new String();
			s = req.getParameter("" + courseNames[i]);
			if (s != null){
				courses.add(courseNames[i]);
			}
			i++;
		}
		String[] studyProgramNames = registerController.getStudyProgramNames();
		req.setAttribute("studyProgramNames", studyProgramNames);
		req.setAttribute("courseNames", courseNames);
		String nStudyProgram = req.getParameter("studyProgram");
		
		// vreemde code voor: if(getObjectify().query(Student.class).filter("emailAdress", emailAdress).get() == null)
		// DUS: als er nog geen gebruiker met dit emailadres in de datastore zit
		if(emailAdress != null){
		if(registerController.isEmailAvailable(emailAdress)){
		boolean newStudentSucceeded = registerController.makeStudent(nStudyProgram, studentFirstName,studentLastName , password, courses, emailAdress);
		if(newStudentSucceeded){
			System.out.println("the student has been made");
		}
		
		Student student = logController.logIn(password, emailAdress);
		if(student == null){
			System.out.println("the student is a null reference");
		}
		
		
		Long ID = student.getStudentID();
		session.setAttribute("currentID", ID);
		resp.sendRedirect("/index");
		}
		try {
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR DETECTED");
			e.printStackTrace();}
		
		}
		else{
			
			
			try {
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				System.out.println("ERROR DETECTED");
				e.printStackTrace();
		}}
		

	}
		
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			doPost(req,resp);
	}		
	}