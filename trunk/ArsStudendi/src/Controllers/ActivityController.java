package Controllers;

import java.util.Calendar;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import DomainModel.*;
import activityTypePackage.ActivityType;


public class ActivityController {

public boolean startActivity(Student student, String activityName){
	boolean succeed = false;
		if(student != null && student.getCurrentActivity() == null){
		
		//no idea if this works
	Calendar startTime = Calendar.getInstance();
	Activity newActivity = new Activity(startTime, student.getStudentID(), activityName);
	student.setCurrentActivity(newActivity);
	succeed = true;
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
			if (activityType instanceof activityTypePackage.Study) {
				((activityTypePackage.Study) activityType).setCourse(course);
			}
			student.addActivityToOldActivityList(tempActivity);
			student.setCurrentActivity(null);
			succeed = true;

		}
		return succeed;
	}

public boolean cancelActivity(Student student){
	boolean succeed = false;
	if(student != null && student.getCurrentActivity() !=null){
		student.setCurrentActivity(null);
		succeed = true;
	}
return succeed;
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

public void changeCurrentActivityName(Student student, String newActivityName)
{
if(student.getCurrentActivity() != null){
	student.getCurrentActivity().setActivityName(newActivityName);
}
}



}