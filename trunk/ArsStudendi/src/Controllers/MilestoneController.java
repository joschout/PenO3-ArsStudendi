package Controllers;

import DomainModel.*;

import java.util.*;

import arsstudendi.StudentRegistry;

public class MilestoneController {

	public void makeNewMilestone(Student student, String name, Calendar startTime,Calendar stopTime, Course course, MilestoneType milestoneType,int goal) {
		Milestone milestone = new Milestone(name, course, milestoneType, goal);
		if (startTime != null) {
			milestone.setStartTime(startTime);
		}
		if (stopTime != null) {
			milestone.setStopTime(stopTime);
		}
		student.addMilestone(milestone);
		StudentRegistry.getSingletonObject().putStudent(student);

	}
	public void removeMileStone(Student student, Milestone milestone)
	{
		student.removeMilestone(milestone);
		StudentRegistry.getSingletonObject().putStudent(student);
	}

	
	public void changeName(Milestone milestone, String name)
	{
		milestone.setName(name);
	}
	public void changeStartTime(Milestone milestone, Calendar startTime)
	{
		milestone.setStartTime(startTime);
	}
	public void changeStopTime(Milestone milestone, Calendar stopTime)
	{
		milestone.setStopTime(stopTime);
	}
	public void changeGoal(Milestone milestone, int goal)
	{
		milestone.setGoal(goal);
	}
	/**
	 * deze methode moet aangeroepen worden na het stoppen van een activity,
	 * zodat de milestone geupdate wordt. Als de methode true teruggeeft wil 
	 * dit zeggen dat er een milestone gecomplete wordt.
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
		if (milestone.getProgress() >= milestone.getGoal()){
			isFinished = true;
			milestone.setIsAchieved(true);
		}
		return isFinished;
	}
	public String [] getCourseNames(Student student)
	{
		int size = student.getCourses().size();
		String [] courseNames = new String[size];
		int i = 0;
		while(i<size){
			courseNames[i] = student.getCourses().get(i).getCourseName();
		}   	
		return courseNames;
	}
	
	public Student getStudent(long ID){
		Student student = StudentRegistry.getSingletonObject().getStudent(ID);
		return student;
	}
}
