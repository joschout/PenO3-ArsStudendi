package DomainModel;

import java.util.*;

public class Milestone {

	private String name;
	private Calendar startTime;
	private Calendar stopTime;
	private boolean isAchieved;
	private Course course;
	private MilestoneType milestoneType;
	// goal = aantal bladzijden/aantal seconden men wilt leren
	private int goal;
	private int progress;

	public Milestone(String name, Course course, MilestoneType milestoneType,
			int goal) {

		this.name = name;
		this.goal = goal;
		this.milestoneType = milestoneType;
	}
	public void setIsAchieved(boolean isAchieved){
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

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public void setStopTime(Calendar stopTime) {
		this.stopTime = stopTime;
	}

	public String getMilestoneName() {
		return name;
	}

	public MilestoneType milestoneType() {
		return milestoneType;
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
}