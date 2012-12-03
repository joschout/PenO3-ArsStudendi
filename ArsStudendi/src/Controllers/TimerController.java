package Controllers;
//
import java.util.ArrayList;
import java.util.Calendar;

import arsstudendi.StudentRegistry;
import DomainModel.Activity;
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

/**
 *
 */
public static long getTimePassed(Activity activity){
	return activity.getDurationActivity();
}

public long getTimePassedCurrentActivity(Student student){
	/*if(student != null && student.getCurrentActivity() !=null){
	return getTimePassed(student.getCurrentActivity());
	}
	else return -1;*/
	return 1;
}
public static long getTotalTimeOfActivityList(ArrayList<Activity> activityList){
	long totalTime = 0;
	for(Activity activity: activityList){
		totalTime += getTimePassed(activity);
	}
	return totalTime;
}
 
}