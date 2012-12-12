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
			String v = "test" + courseNames[i];
			s = req.getParameter(v);
			if (s != null){
				System.out.println(v);
				courses.add(courseNames[i]);
			}
			i++;
		}
		ArrayList<String> removeCourses = new ArrayList<String>();
		int i2 =0;
		String[] removeNames = registerController.getCourseNames();
		int length2 = removeNames.length;
		while(i2 < length2){
			String s = new String();
			String v = removeNames[i2];
			s = req.getParameter(v);
			if (s != null){
				System.out.println(v);
				removeCourses.add(removeNames[i2]);
			}
			i2++;
		}
		
		String[] studyProgramNames = registerController.getStudyProgramNames();
		int j = 0;
		while (j < studyProgramNames.length)
		{
			String[] programCourseNames = registerController.getProgramCourseNames(studyProgramNames[j]);
			String set = studyProgramNames[j];
			req.setAttribute(set, programCourseNames);
			j++;
		}
		req.setAttribute("studyProgramNames", studyProgramNames);
		req.setAttribute("courseNames", courseNames);
		String nStudyProgram = req.getParameter("studyProgram");
		
//		Gson gson = new Gson();
//	    String json = gson.toJson(studyProgramNames);
//		String json = gson.toJson("TESTAZERTY");
//	    System.out.println(json);
//	    resp.getWriter().write(json);
		
		// vreemde code voor: if(getObjectify().query(Student.class).filter("emailAdress", emailAdress).get() == null)
		// DUS: als er nog geen gebruiker met dit emailadres in de datastore zit
		if(emailAdress != null){
		if(registerController.isEmailAvailable(emailAdress)){
		Student student = registerController.makeStudent(nStudyProgram, studentFirstName,studentLastName , password, courses, removeCourses, emailAdress);
		if(student != null){
			System.out.println("the student has been made");
		}
		logController.logIn(password, emailAdress);
		
		Long ID = student.getStudentID();
		session.setAttribute("currentID", ID);
		resp.sendRedirect("/index");
		}
		else{
			req.setAttribute("inUse", emailAdress);
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