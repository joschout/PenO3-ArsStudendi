package DomainModel;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
//import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Serialized;

@Entity

public class Student{

	private String studentFirstName;
	private String studentLastName;
	@Id
	private Long studentID;
	private String password;
	//private List<String> courses;
	@Serialized private List<Course> courses;

	@Serialized private List<Milestone> milestoneList;
	@Serialized private List<Activity> oldActivityList;
	@Serialized private Activity currentActivity;
	private String emailAdress;
	@Serialized private StudyProgram studyProgram;
		
	public Student(){}
	
	//Misschien is het teveel om zowel een studyprogram als een lijst van courses mee te geven
	public Student(StudyProgram studyProgram, String studentFirstName,
			String studentLastName, String password, List<Course> courses,
			String newEmailAdress) {
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studyProgram = studyProgram;
		this.password = password;
		this.courses = courses;
		this.emailAdress = newEmailAdress;
		currentActivity = null;
		oldActivityList = null;
		milestoneList = null;
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course course) {
		if (course != null) {
			getCourses().add(course);
		}
	}

	public void removeCourse(Course course) {
		if (course != null && getCourses().contains(course)) {
			getCourses().remove(course);
		}
	}

	public StudyProgram getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(StudyProgram studyProgram) {
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

	public List<Milestone> getMilestones() {
		return milestoneList;
	}

	public void addMilestone(Milestone newMilestone) {
		milestoneList.add(newMilestone);
	}

	public void removeMilestone(Milestone delMilestone) {

		if (milestoneList.contains(delMilestone)) {
			milestoneList.remove(delMilestone);
		}
	}

	public Activity getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(Activity currentActivity) {
		this.currentActivity = currentActivity;
	}


	public List<Activity> getOldActivityList() {
		return oldActivityList;
	}

	public void setOldActivityList(List<Activity> oldActivityList) {
		this.oldActivityList = oldActivityList;
	}

	public void addActivityToOldActivityList(Activity activity) {
		getOldActivityList().add(activity);
	}

	public void removeFromOldActivityList(Activity activity) {
		if (getOldActivityList().contains(activity)) {
			getOldActivityList().remove(activity);
		}
	}

}
