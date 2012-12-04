package Controllers;
//
import java.util.ArrayList;
import java.util.Calendar;

import activityTypePackage.ActivityType;
import arsstudendi.StudentRegistry;
import DomainModel.Activity;
import DomainModel.Course;
import DomainModel.Student;

public class TimerController {

public boolean startActivity(Student student, String activityName){
	boolean succeed = false;
		if(student != null && student.getCurrentActivity() == null){
		
	Calendar startTime = Calendar.getInstance();
	Activity newActivity = new Activity(startTime, student.getStudentID(), activityName);
	student.setCurrentActivity(newActivity);
	succeed = true;
	StudentRegistry.getSingletonObject().putStudent(student);
	}
return succeed;	
}

/**
 * Stops the current activity of the given student (if he has one) and gives this activity an instance of the class ActivityType.
 * The current activity will be added to the list of the old activities of the student. 
 * Afterwards, the current activity of the student will be set to null.
 * 
 * @param student the student whose current activity, if any, has to be
 * @param activityType
 * @return true if (student != null && activityType != null && student.getCurrentActivity() !=null)
 */
	public boolean stopActivity(Student student, ActivityType activityType,
			Course course) {
		boolean succeed = false;
		if (student != null && activityType != null
				&& student.getCurrentActivity() != null) {

			Activity tempActivity = student.getCurrentActivity();
			tempActivity.setActivityType(activityType);
			tempActivity.setStopTime(Calendar.getInstance());
			if (activityType instanceof activityTypePackage.Study) {
				((activityTypePackage.Study) activityType).setCourse(course);
			}
			student.addActivityToOldActivityList(tempActivity);
			student.setCurrentActivity(null);
			StudentRegistry.getSingletonObject().putStudent(student);
			succeed = true;

		}
		return succeed;
	}


public boolean stopActivity(Student student){
	boolean succeed = false;
	if(student != null && student.getCurrentActivity() !=null){
		Activity tempActivity = student.getCurrentActivity();
		student.addActivityToOldActivityList(tempActivity);
		student.setCurrentActivity(null);
		succeed = true;
		StudentRegistry.getSingletonObject().putStudent(student);
	}
return succeed;
}

public boolean cancelActivity(Student student){
	boolean succeed = false;
	if(student != null && student.getCurrentActivity() !=null){
		student.setCurrentActivity(null);
		succeed = true;
		StudentRegistry.getSingletonObject().putStudent(student);
	}
return succeed;
}

public Student getStudent(long ID){
	Student student = StudentRegistry.getSingletonObject().getStudent(ID);
	return student;
}

public Activity getActivity(Student student){
	Activity currentActivity = student.getCurrentActivity();
	return currentActivity;
}

public String checkActivity(Student student){
	Activity activity = student.getCurrentActivity();
	if ( activity != null){
		String name = activity.getName();
		return name;
	}
	return null;
}

public String [] getCourseNames(Student student)
{
	int size = student.getCourses().size();
	String [] courseNames = new String[size];
	int i = 0;
	while(i<size){
		courseNames[i] = student.getCourses().get(i).getCourseName();
		i++;
	}   	
	return courseNames;

}
/**
 *
 */
public static long getTimePassed(Activity activity){
	return activity.getDurationActivity();
}




public long getTimePassedCurrentActivity(Student student){
	if(student != null && student.getCurrentActivity() !=null){
	return getTimePassed(student.getCurrentActivity());
	}
	else return -1;
}


public static long getTotalTimeOfActivityList(ArrayList<Activity> activityList){
	long totalTime = 0;
	for(Activity activity: activityList){
		totalTime += getTimePassed(activity);
	}
	return totalTime;
}
public void changeCurrentActivityName(Student student, String newActivityName)
{
if(student.getCurrentActivity() != null){
	student.getCurrentActivity().setActivityName(newActivityName);
	StudentRegistry.getSingletonObject().putStudent(student);
}
}
}