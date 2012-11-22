package Controllers;
//
import java.util.Calendar;
import DomainModel.Activity;
import DomainModel.Student;

public class TimerController {

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

public boolean stopActivity(Student student){
	boolean succeed = false;
	/*if(student != null && student.getCurrentActivity() !=null){
		Activity tempActivity = student.getCurrentActivity();
		student.addActivityToOldActivityList(tempActivity);
		student.setCurrentActivity(null);
		succeed = true;
	}*/
return succeed;
}

public boolean cancelActivity(Student student){
	boolean succeed = false;
	/*if(student != null && student.getCurrentActivity() !=null){
		student.setCurrentActivity(null);
		succeed = true;
	}*/
return succeed;
}

/**
 *
 */
public static long getTimePassed(Activity activity){
	return 1;//return activity.getTimePassed();
}

public long getTimePassedCurrentActivity(Student student){
	/*if(student != null && student.getCurrentActivity() !=null){
	return getTimePassed(student.getCurrentActivity());
	}
	else return -1;*/
	return 1;
}

 
}