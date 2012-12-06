package DomainModel;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Id;

import com.googlecode.objectify.*;

import activityTypePackage.*;



public class Activity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calendar startTime;
	private Calendar stopTime;
	private int amountOfPages;
	private long studentID;
	private String activityName;
	private ActivityType activityType;


	
//	public Activity(Calendar startTime, Key<Student> studentKey, String activityName) {
//		setStartTime(startTime);
//		this.studentKey=studentKey;
//		setName(activityName);
//
//	}
	public void setAmountOfPages(int pages){
		amountOfPages=pages;
	}
	public int getAmountOfPages(){
		return amountOfPages;
	}
	public Activity(Calendar startTime, long studentID) {
		setStartTime(startTime);
		setStudentID(studentID);
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}

	public long getStudentID() {
		return studentID;
	}

	/**
	 * @return startTime: de starttijd van de activiteit wordt geretourneerd
	 */
	public Calendar getStartTime() {
		return startTime;
	}

	/**
	 * verander de startTime van de activity
	 * 
	 * @param startTime
	 *            : het tijdstip waarop de activiteit gestart is
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	/**
	 * 
	 * @return stopTime: de stoptijd wordt geretourneerd
	 */
	public Calendar getStopTime() {
		return stopTime;
	}

	/**
	 * verander de stoptijd
	 * 
	 * @param stoptime
	 *            : het tijdstip waarop de activieit gestopt is.
	 */
	public void setStopTime(Calendar stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 * @return now.getTimeInMillis() - startTime.getTimeInMillis(): geeft de
	 *         tijd die gepasseerd is sinds de activiteit gestart is, of de duur
	 *         van de activiteit
	 */
	public long getDurationActivity() {
		if (stopTime == null) {
			Calendar now = Calendar.getInstance();
			long milisec = now.getTimeInMillis() - startTime.getTimeInMillis();
			long sec = milisec/1000;
			return sec;
		}
		long milisec = stopTime.getTimeInMillis() - startTime.getTimeInMillis();
		long sec = milisec/1000;
		return sec;
		// voorlopig hier, later zie timeconvertion
	}

	/**
	 * @return de naam van de activiteit
	 */
	public String getName() {
		return activityName;
	}

	/**
	 * verander de naam van de activiteit
	 * 
	 * @param de
	 *            nieuwe naam voor de activiteit
	 */
	public void setName(String newName) {
		activityName = newName;
	}

	/**
	 * verander het type van de activiteit
	 * 
	 * @param activityType
	 *            : het type van de activiteit
	 */
	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	/**
	 * @return activityType: het type van de activiteit.
	 */

	public ActivityType getActivityType() {
		return activityType;
	}
}
