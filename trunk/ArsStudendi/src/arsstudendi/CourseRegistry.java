package arsstudendi;

import Controllers.Objectifiable;
import DomainModel.*;
import java.util.*;

public class CourseRegistry extends Objectifiable {

	private static CourseRegistry _singletonObject;
//	public static ArrayList<Course> courses;
	public static String[] arr = { "TESTCOURSE1", "TESTCOURSE2", "TESTCOURSE3",
			"TESTCOURSE4", "TESTCOURSE5", "TESTCOURSE6" };
//	static {
//		int length = 6;
//		int i = 1;
//		while (i < length + 1) {
//			Course course = new Course(arr[i], (long) i);
//			courses.add(course);
//			i++;
//		}
//	}

	/**
	 * Dit is eigenlijk de getInstance() methode
	 * 
	 * @return
	 */
	public static synchronized CourseRegistry getSingletonObject() {
		if (_singletonObject == null) {
			_singletonObject = new CourseRegistry();
		}
		return _singletonObject;
	}

	// public boolean putCourse(Course course){
	// if(course != null){
	// getObjectify().put(course);
	// return true;
	// }
	// else{
	// return false;
	// }
	// }
	/**
	 * 
	 */
	// public Course getCourse(Key<Course> courseKey){
	// return getObjectify().get(courseKey);
	// }
	//
	// public Course getCourse(Long courseID){
	// return getObjectify().get(Course.class, courseID);
	// }
	//
//	public ArrayList<Course> getCourseList() {
//		return courses;
//	}
//
//	public Course getCourse(Long courseID) {
//		for (Course course : courses) {
//			if (course.getCourseID() == courseID) {
//				return course;
//			}
//
//		}
//		return null;
//		// should NEVER happen
//		// THIS CANNOT HAPPEN DO YOU HEAR ME
//	}

	public String[] getCourseNames() {
		return arr;
	}

}
