package Controllers;

import arsstudendi.StudentRegistry;
import DomainModel.*;

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
	public boolean changeName(Student student, String firstName, String lastName){
	boolean succeed = false;
	if (firstName!= null && lastName!= null && student != null){
		succeed = true;
		student.setLastName(lastName)	;
		student.setFirstName(firstName);
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
}
