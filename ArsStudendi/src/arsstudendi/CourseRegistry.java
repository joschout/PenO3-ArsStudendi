package arsstudendi;

import Controllers.Objectifiable;
import DomainModel.*;

import java.util.*;

public class CourseRegistry extends Objectifiable {

	private static CourseRegistry _singletonObject;
	//	public static ArrayList<Course> courses;
	public static String[] courseNames = { "Analyse1", "Analyse2", "Analyse3",
			"Mechanica1", "Mechanica2", "Organische_Scheikunde", "Toegepaste_Lineaire_Algebra", "Elektrische_Netwerken", "Informatica", "Wijsbegeerte", "Materiaalkunde", "Economie", "Informatie_Overdracht_en_Verwerking", "Toegepaste_Scheikunde", "Statistiek", "PENO1", "PENO2", "PENO3", "Algemene_Natuurkunde", "Thermodynamica","Inleiding_tot_de_Rechtswetenschap", "Geschiedenis_van_het_publiek_recht", "Romeins_Recht", "Francais_juridique", 
			"Fysiochemische_Processen_1", "Fysiochemische_Processen_2", "Medisch_Wetenschappelijk_Onderzoek", "Anatomie", "Metabolismen", "Spijsvertering", "Celfunctie", "Celstructuur"};

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
	
	
	
	
	
	
	
	public ArrayList<Course> makeCourses() {
		
		String[] arr = getCourseNames();
		ArrayList<Course> courses = new ArrayList<Course>();
		int length = arr.length;
		int i = 0;
		while (i < length) {
			Course course = new Course(arr[i], (long) i);
			courses.add(course);
			i++;
		}
		return courses;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Course> getCourseList() {
		ArrayList<Course> courses = makeCourses();
		return courses;
	}
	public Course getCourse(String courseN) {
		ArrayList<Course> courses = makeCourses();
		
		for (Course course : courses) {
			
			String name = course.getCourseName();
			System.out.println(name);
			System.out.println(courseN);
			boolean b = courseN.equals(name);
			if (b) {
				System.out.println("Ok");
				return course;
			}

		}
		return null;
	}

	public String getCourseNameWithLong(long i) {
		ArrayList<Course> courses = makeCourses();
		for (Course course : courses) {
			if (course.getCourseID() == i) {
				return course.getCourseName();
			}

		}
		return null;
	}
	
	public String[] getCourseNames() {
		return courseNames;
	}

	//	static {
	//		int length = 6;
	//		int i = 1;
	//		while (i < length + 1) {
	//			Course course = new Course(arr[i], (long) i);
	//			courses.add(course);
	//			i++;
	//		}
	//	}
	
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

	
}
