package arsstudendi;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import Controllers.*;
import graphPackage.*;
import DomainModel.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controllers.LogController;
import DomainModel.Student;


public class CourseServlet extends HttpServlet {

	ProfileController controller = new ProfileController();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
		HttpSession session = req.getSession();
		Long currentID = (Long)session.getAttribute("currentID");
		Student student = StudentRegistry.getSingletonObject().getStudent(currentID);
		String[] studentCourses = controller.getCourseNames(student);
		String[] addCourses = controller.getaddedCourseNames(student);
		String[] removeCourses = controller.getCourseNames(student);
		req.setAttribute("studentCourses", studentCourses);
		req.setAttribute("removeCourses", studentCourses);
		req.setAttribute("addCourses", addCourses);
		
		int i =0;
		int j=0;
		
		int length1 = removeCourses.length;
		while(i < length1){
			String s = new String();
			String v = "test" + removeCourses[i];
			s = req.getParameter(v);
			if (s != null){
				String t = "" + removeCourses[i];
				Course deletedCourse = CourseRegistry.getSingletonObject().getCourse(t);
				student.removeCourse(deletedCourse);
			}
			i++;
		}
		int length2 = addCourses.length;
		while(j < length2){
			String s = new String();
			String v = "" + addCourses[j];
			s = req.getParameter(v);
			if (s != null){
				Course addedCourse = CourseRegistry.getSingletonObject().getCourse(v);
				student.addCourse(addedCourse);
			}
			j++;
		}
		StudentRegistry.getSingletonObject().putStudent(student);
		studentCourses = controller.getCourseNames(student);
		addCourses = controller.getaddedCourseNames(student);
		req.setAttribute("studentCourses", studentCourses);
		req.setAttribute("removeCourses", studentCourses);
		req.setAttribute("addCourses", addCourses);
		
		
		
		try {
			req.getRequestDispatcher("/courses.jsp").forward(req, resp);
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