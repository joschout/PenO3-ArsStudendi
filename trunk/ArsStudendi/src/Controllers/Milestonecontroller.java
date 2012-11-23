package Controllers;

import DomainModel.Activity;
import DomainModel.Course;
import DomainModel.MileStonetype;
import DomainModel.Milestonetype;

public class Milestonecontroller {

}
public void makeNewMilestone(String name, Calender startTime, Calender stopTime, Course course, MilestoneType milestoneType, int goal)
//goal: int: aantal pagina's of aantal seconden
{
	Milestone milestone = new milestone(name, course,milestoneType,goal);
	if (startTime !=null){
		milestone.setStartTime(startTime);
	}
	if(stopTime!=null){
		milestone.stopTime(stopTime);
	}
	
}

//milestone aanmaken
//2 servlets

//wat moet ingegeven worden bij het aanmaken van een milestone..
//naam, activiteit, #paginas of #tijd

//methodes: 





update milestone?
		
		
		delete milestone, 