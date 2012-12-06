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
//voor te deleten: geef een volledig nieuwe lijst met courses door
	public void removeCourses(Student student, Course course) {
		student.removeCourse(course);
	}
//voor toe te voegen: geef een object door
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
