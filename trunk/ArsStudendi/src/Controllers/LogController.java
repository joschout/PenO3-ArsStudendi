package Controllers;

import arsstudendi.*;
import DomainModel.*;

public class LogController {

	public LogController() {

	}

	public Student logIn(String passWord, String emailAdress) {

		return StudentRegistry.getSingletonObject().getStudent(emailAdress,
				passWord);

	}
	
	public boolean testLogin(Student student){
		if(student != null){
			return true;
		}
		return false;
	}

	public void logOut(Student student) {
		StudentRegistry.getSingletonObject().putStudent(student);
	}

}
