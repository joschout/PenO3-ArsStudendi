package Controllers;

import arsstudendi.CourseRegistry;
import arsstudendi.StudentRegistry;
import DomainModel.*;
import java.util.*;

public class ProfileController {

	// we veronderstellen dat we het Studentobject vanuit de servlet krijgen
	
	public boolean changePassword(Student student, String newPassword){
		boolean succeed = false;
		if(newPassword != null && student != null){
		student.setPassword(newPassword);
		StudentRegistry.getSingletonObject().putStudent(student);
		succeed=true;
		}
		return succeed;
	}
	
	
	public boolean changeFirstName(Student student, String firstName){
	boolean succeed = false;
	if (firstName!= null && student != null){
		succeed = true;
		student.setFirstName(firstName);
		StudentRegistry.getSingletonObject().putStudent(student);
	}
	return succeed;
	}
	
	public boolean changeLastName(Student student, String lastName){
	boolean succeed = false;
	if ( lastName!= null && student != null){
		succeed = true;
		student.setLastName(lastName)	;
		StudentRegistry.getSingletonObject().putStudent(student);
	}
	return succeed;
	}
	public boolean addCourse(Student student, Course course){
		boolean succeed = false;
		if(course != null && student != null){
			student.addCourse(course);
			succeed = true;
			StudentRegistry.getSingletonObject().putStudent(student);
		}
		return succeed;
	}
	
	
	public boolean removeCourse(Student student, Course course){
		boolean succeed = false;
		if(student != null && course != null){
			student.removeCourse(course);
			StudentRegistry.getSingletonObject().putStudent(student);
			succeed = true;
		}
		return succeed;
	}
	 public boolean changeEmail(Student student, String newEmailAdress){
		 boolean succeed = false;
		 if(student != null && newEmailAdress != null){
			 student.setEmailAdress(newEmailAdress);
			 StudentRegistry.getSingletonObject().putStudent(student);
		 }
		 return succeed;
	 }
	 public String [] getCourseNames(Student student)
	 {
	 	int size = student.getCourses().size();
	 	String [] courseNames = new String[size];
	 	int i = 0;
	 	while(i<size){
	 		courseNames[i] = student.getCourses().get(i).getCourseName();
	 		i++;
	 	}   	
	 	return courseNames;

	 }
	 
	 public String [] getaddedCourseNames(Student student)
	 {
		 List<Course> studentCourses = student.getCourses();
		 List<Course> allCourses = CourseRegistry.getSingletonObject().getCourseList();
		 List<String> addedCourses = new ArrayList<String>();
		Collections.addAll(addedCourses, CourseRegistry.getSingletonObject().getCourseNames());
		 for(Course studentCourse: studentCourses){
			 String name1 = studentCourse.getCourseName();
			 for(Course course: allCourses){
				 Course nextCourse = course;
				 String name2 = nextCourse.getCourseName();
				 if (name1.equals(name2)){
					addedCourses.remove(name1);
				 }
			 }
		 }
		 	int size = addedCourses.size();
		 	String [] courseNames = new String[size];
		 	int i = 0;
		 	while(i<size){
		 		courseNames[i] = addedCourses.get(i);
		 		i++;
		 	}   	
		 	return courseNames;
		 

	 }
}
