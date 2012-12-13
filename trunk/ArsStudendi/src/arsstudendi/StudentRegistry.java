package arsstudendi;

import com.googlecode.objectify.*;

import Controllers.Objectifiable;
import DomainModel.*;

import java.util.*;
/**
 * A class for registering instances of the class Student in Google's database,
 * the Google Datastore. To do this, this class extends the class Objectifiable,
 *  which delivers Objectify instances. For more information about Objectify, 
 *  its javadocs and source code, please visit https://code.google.com/p/objectify-appengine/.
 * The class follow a singleton pattern. Therefore only one instance of this class can exist at run time.
 
 * 
 * @author 	Team PenO CW-B1:
 * 		 	Jonas Schouterden, Nils Nijs, Thijs Peirelinck, Michiel Meertens, Lucas Vanlaer
 * @version 13-12-2012
 *
 */
public class StudentRegistry extends Objectifiable {

	/**
	 * Class variable with the class itself as its type.
	 */
	private static StudentRegistry _singletonObject;

	/**
	 * Constructor registering the Objectify Entity class "Student" with the ObjectifyService.
	 */
	private StudentRegistry() {
		ObjectifyService.register(Student.class);
	}

	/**
	 * Return the unique instance of this class.
	 * Another name for this method could be "getInstance()".
	 * @return StudentRegistry _singletonObject
	 */
	public static synchronized StudentRegistry getSingletonObject() {
		if (_singletonObject == null) {
			_singletonObject = new StudentRegistry();
		}
		return _singletonObject;
	}


	/**
	 * Return the instance of the class Student in the database uniquely associated with the given key.
	 * @param 	studentKey
	 * 			The key uniquely associated with an instance of the class Student in the database
	 * @return 	The Student stored in the database associated with the given key.
	 * 			| getObjectify().get(studentKey)
	 */
	public Student getStudent(Key<Student> studentKey) {
		return getObjectify().get(studentKey);
	}

	/**
	 * Check whether there already exists an object of the class Student with the given email address in the database.
	 * @param 	emailAddress
	 * 			The email address to check
	 * @return	true if there isn't an instance in the database with the given email address
	 * 			| result == (getObjectify().query(Student.class).filter("emailAdress", emailAdress).get() == null)
	 */
	public boolean isEmailAvailable(String emailAddress) {
		Student student = getObjectify().query(Student.class)
				.filter("emailAdress", emailAddress).get();
		if (student == null) {
			return true;
		}
		return false;
	}

	/**
	 * Put the given student in the Google Datastore.
	 * @param student
	 * 	The student to put in the Datastore
	 * @return result == (student != null)
	 */
	public boolean putStudent(Student student) {
		if (student != null) {
			getObjectify().put(student);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Return the object of the class Student associates with the given email address and password.
	 * 
	 * @param inLogEmailAddress
	 *        The email address (uniquely) associated with the Student to be returned.
	 * @param password
	 *        The password of the Student associated with the given email adress.
	 * @return  the student with the given email address and password. 
	 * 			|if (isEmailAddressAvailable || password==null || inLogEmailAdress == null ||
	 * 			|	(for all Student student  in { getObjectify().query(Student.class).get()} : Student.getPassword() != password ))
	 * 			|then	result == null
	 * 			|else result == getObjectify().query(Student.class)
	 * 			| 		.filter("emailAdress",   inLogEmailAdress).filter("password", password).get()
	 */
	public Student getStudent(String inLogEmailAddress, String password) {
		return getObjectify().query(Student.class).filter("emailAdress", inLogEmailAddress).filter("password", password).get();
	}

/**
 * Return the object of the class Student uniquely associated with the given ID.
 * @param 	studentID
 *			the id of the student to be returned
 * @return	the student with the given id. 
 * 			| result == getObjectify().get(Student.class, studentID)
 */
	public Student getStudent(Long studentID) {
		return getObjectify().get(Student.class, studentID);
	}
	/**
	 * Return all objects of the class Student stored in the Google Datastore.
	 * @return all objects of the class Student stored in the Google Datastore
	 * 			|result == getObjectify().query(Student.class).list()
	 */
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		students = getObjectify().query(Student.class).list();
		return students;
	}

}
