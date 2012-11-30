package Controllers;

import DomainModel.*;

public class SettingsController {

	public void changeFirstName(Student student, String firstName) {
		student.setFirstName(firstName);
	}

	public void changeLastName(Student student, String lastName) {
		student.setLastName(lastName);
	}

	public void changeCourses(Student student, List<Course> courses) {
		student.setCourses(courses);
	}

	public void addCourse(Student student, Course course) {
		student.addCourse(course);
	}

	//changeTheme
	
	
}
