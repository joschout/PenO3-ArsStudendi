package Controllers;

import java.util.*;
import arsstudendi.*;
import DomainModel.*;

public class RegisterController {

	public RegisterController (){
		
	}
	public Student makeStudent(String program, String studentFirstName, String studentLastName, String password, List<String> strCourses, String newEmailAdress)
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
	if(studyProgram != null){
	List<Course> programCourses = studyProgram.getCourses();
	for(Course programCourse: programCourses){
		boolean nameCheck = true;
		for(Course course: courses){
			String name1 = programCourse.getCourseName();	
			String name2 = course.getCourseName();		
			if(name2.equals(name1)){
				nameCheck = false;			
			}
		}
		if(nameCheck){
			courses.add(programCourse);
		}
	}}
	Student student = new Student(studyProgram, studentFirstName, studentLastName, password, courses, newEmailAdress);
	StudentRegistry.getSingletonObject().putStudent(student);
	succeed = StudentRegistry.getSingletonObject().putStudent(student);

	return student;
	}
	
	public boolean isEmailAvailable(String emailAdress){
		boolean test = StudentRegistry.getSingletonObject().isEmailAvailable(emailAdress);
		return test;
	}
	

	
	public String[] getCourseNames(){
		return CourseRegistry.getSingletonObject().getCourseNames();
	}
	public String[] getStudyProgramNames(){
		return StudyProgramRegistry.getSingletonObject().getStudyProgamNames();
	}
	public String[] getProgramCourseNames(String program){
		StudyProgram studyProgram = StudyProgramRegistry.getSingletonObject().getStudyProgram(program);
		List<Course> programCourses = studyProgram.getCourses();
		String[] programCourseNames = new String[programCourses.size()];
		int i = 0;
		while(i<programCourses.size()){
			programCourseNames[i] = programCourses.get(i).getCourseName();
			i++;
		}
		return programCourseNames;
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
