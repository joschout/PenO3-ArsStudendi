package Controllers;

import DomainModel.*;

import java.util.*;

public class Milestonecontroller {

	public void makeNewMilestone(String name, Calendar startTime,
			Calendar stopTime, Course course, MilestoneType milestoneType,
			int goal) {
		Milestone milestone = new Milestone(name, course, milestoneType, goal);
		if (startTime != null) {
			milestone.setStartTime(startTime);
		}
		if (stopTime != null) {
			milestone.setStopTime(stopTime);
		}

	}

	// milestone aanmaken
	// 2 servlets

	/**
	 * deze methode moet aangeroepen worden na het stoppen van een activity,
	 * zodat de milestone geupdate wordt
	 * 
	 * @param milestone
	 *            milestone die geupdate moet worden
	 * @param progress
	 *            de tijd/aantal blz die je geleerd hebt voor de milestone
	 */
	public boolean updateMilestone(Milestone milestone, int progress) {

		milestone.setProgress(progress);
		boolean isFinished = milestoneCompleted(milestone);
		return isFinished;
	}

	private boolean milestoneCompleted(Milestone milestone) {
		boolean isFinished = false;
		if (milestone.getProgress() >= milestone.getGoal())
			isFinished = true;
		return isFinished;
	}
}
