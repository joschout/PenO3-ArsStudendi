package DomainModel;

import java.io.Serializable;
import java.util.*;
import activityTypePackage.*;
public class Milestone implements Serializable{

	private String name;
	private Calendar stopTime;
	private boolean isAchieved;
	private ActivityType activityType;
	private int goal;
	private int progress;
	private MilestoneType milestoneType;

	public Milestone(String name, ActivityType activityType,MilestoneType milestoneType,
			int goal, Calendar stopTime) {

		this.name = name;
		this.goal = goal;
		this.activityType = activityType;
		this.stopTime = stopTime;
		this.milestoneType=milestoneType;
	}
	public MilestoneType getMilestoneType()
	{
		return milestoneType;
	}
	public void setCourse(Course course){
		((activityTypePackage.Study) activityType).setCourse(course);
	}

	public void setIsAchieved(boolean isAchieved) {
		this.isAchieved = isAchieved;
	}

	public void setProgress(int newProgress) {
		progress += newProgress;
	}

	public void setGoal(int newGoal) {
		goal = newGoal;
	}

	public int getProgress() {
		return progress;
	}

	public int getGoal() {
		return goal;
	}

	public void setStopTime(Calendar stopTime) {
		this.stopTime = stopTime;
	}

	public String getMilestoneName() {
		return name;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public boolean isAchieved() {
		return isAchieved;
	}

	public void setMilestoneName(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getStopTime() {
		return stopTime;
	}
}