package DomainModel;

//import java.io.IOException;
import java.util.*;

import javax.persistence.*;
import com.googlecode.objectify.Key;

@Entity
public class Student {

	private String studentFirstName;
	private String studentLastName;
	@Id
	private Long studentID;
	private String password;
	private List<String> courses;
//	private List<Course> courses;
//	private List<Milestone> milestoneList;
//	private List<Activity> oldActivityList;
//	private Activity currentActivity;
	private String emailAdress;
	private String studyProgram;

	public Student(){}
	//Misschien is het teveel om zowel een studyprogram als een lijst van courses mee te geven
	public Student(String studyProgram, String studentFirstName,
			String studentLastName, String password, List<String> courses,
			String newEmailAdress) {
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studyProgram = studyProgram;
		this.password = password;
		this.courses = courses;
		this.emailAdress = newEmailAdress;
//		currentActivity = null;
//		oldActivityList = null;
//		milestoneList = null;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	
	public List<String> getCourses() {
	return courses;
}

public void setCourses(List<String> courses) {
	this.courses = courses;
}

//	public List<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}

	public void addCourse(String course) {
		if (course != null) {
			getCourses().add(course);
		}
	}

	public void removeCourse(String course) {
		if (course != null && getCourses().contains(course)) {
			getCourses().remove(course);
		}
	}

	public String getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(String studyProgram) {
		if (studyProgram != null) {
			this.studyProgram = studyProgram;
		}
	}
	
	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public void setPassword(String newPassword) {
		if(newPassword != null){
		this.password = newPassword;
		}
	}

	public String getPassword() {
		return password;
	}

	public long getStudentID() {
		return studentID;
	}

//	public List<Milestone> getMilestones() {
//		return milestoneList;
//	}
//
//	public void addMilestone(Milestone newMilestone) {
//		milestoneList.add(newMilestone);
//	}
//
//	public void removeMilestone(Milestone delMilestone) {
//
//		if (milestoneList.contains(delMilestone)) {
//			milestoneList.remove(delMilestone);
//		}
//	}

//	public Activity getCurrentActivity() {
//		return currentActivity;
//	}
//
//	public void setCurrentActivity(Activity currentActivity) {
//		this.currentActivity = currentActivity;
//	}


//	public List<Activity> getOldActivityList() {
//		return oldActivityList;
//	}
//
//	public void setOldActivityList(List<Activity> oldActivityList) {
//		this.oldActivityList = oldActivityList;
//	}
//
//	public void addActivityToOldActivityList(Activity activity) {
//		getOldActivityList().add(activity);
//	}
//
//	public void removeFromOldActivityList(Activity activity) {
//		if (getOldActivityList().contains(activity)) {
//			getOldActivityList().remove(activity);
//		}
//	}

}
