package Controllers;

import DomainModel.*;
import java.util.*;

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

	public boolean addCourse(Student student, Course course) {
		boolean succeed = true;
		if (student.getCourses().contains(course)) {
			succeed = false;
		} else {
			student.addCourse(course);
		}
		return succeed;
	}

	public boolean changePassword(Student student, String password) {
		boolean succeed = false;
		if (password.length() >= 4) {
			student.setPassword(password);
			succeed = true;
		}
		return succeed;
	}

}
