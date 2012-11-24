package Controllers;

import java.util.*;
import arsstudendi.*;
import DomainModel.*;

public class RegisterController {

	public RegisterController (){
		
	}
	public boolean makeStudent(String program, String studentFirstName, String studentLastName, String password, List<String> strCourses, String newEmailAdress)
	{
		boolean succeed = false;
		// een boolean terug geven of het emailadres geldig is
		//Tijdelijk wegens niet static
		StudyProgram studyProgram = StudyProgramRegistry.getSingletonObject().getStudyProgram(program);
		List<Course> courses = new ArrayList<Course>();
		//Tijdelijk wegens niet static
		for(String strCourse: strCourses){
			if (strCourse != null){
			Course course = CourseRegistry.getSingletonObject().getCourse(strCourse);
			courses.add(course);	
			}
		}
	Student student = new Student(studyProgram, studentFirstName, studentLastName, password, courses, newEmailAdress);
	succeed = StudentRegistry.getSingletonObject().putStudent(student);

	return succeed;
	}
	
	public boolean testUser(String emailAdress){
		boolean test = StudentRegistry.getSingletonObject().testStudent(emailAdress);
		return test;
	}
	

	
	public String[] getCourseNames(){
		return CourseRegistry.getSingletonObject().getCourseNames();
	}
	public String getProgramNameWithLong(long i) {
		String s = StudyProgramRegistry.getSingletonObject().getProgramNameWithLong(i);
		return s;
	}

	
//	public boolean checkPassword(String password)
//	{
//		if(password==null){return false;}else{return true;}
//	}
//	public boolean checkUser(String userName){
//		if(userName==null){
//			return false;
//			}else{
//				return true;
//				}
//	}
//	public boolean checkEmail(String email)
//	{
//		if(email==null){return false;}else{return true;}
//	}
//	
	
//	public boolean checkList(List<String> courseList){
//		List<Course> courses = new ArrayList<Course>();
//		for(String strCourse: courseList){
//			Long courseID = Long.valueOf(strCourse);
////			Course course = CourseRegistry.getSingletonObject().getCourse(courseID);
////			courses.add(course);	
//		}
//		if(courses.size()==0){return false;}else{return true;}
//	}
}
