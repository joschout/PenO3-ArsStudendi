package Controllers;

import java.util.*;
import arsstudendi.*;
import DomainModel.*;

public class LogController {

	public LogController() {

	}

	public Student logIn(String passWord, String emailAdress) {

		Student student = StudentRegistry.getSingletonObject().getStudent(emailAdress,
				passWord);

		
		return student;
		

	}

	public boolean testLogin(Student student) {
		if (student != null) {
			return true;
		}
		return false;
	}
	
	public Student getStudent(long ID){
		Student student = StudentRegistry.getSingletonObject().getStudent(ID);
		return student;
	}

	public void logOut(Student student) {
		StudentRegistry.getSingletonObject().putStudent(student);
		Calendar now = Calendar.getInstance();
		student.setLastLogin (now);
	}

	public List<Milestone> checkMilestone(Student student) {
		List<Milestone> passedMilestones = new ArrayList<Milestone>();
	
		Date now = new Date();
		for (Milestone milestone : student.getMilestones()) {
			Date milestoneGoal = milestone.getStopTime().getTime();
			if (milestoneGoal.before(now) && milestoneGoal.after(student.getLastLogin().getTime()) ) {
				passedMilestones.add(milestone);
			}

		}
		return passedMilestones;
	}
}
