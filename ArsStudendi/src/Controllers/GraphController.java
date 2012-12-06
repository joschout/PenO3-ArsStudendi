package Controllers;



import DomainModel.*;
import graphPackage.*;
import graphPackage.Graph;
import graphPackage.GraphType;
import java.text.SimpleDateFormat;


import java.util.*;

import activityTypePackage.*;

public class GraphController {

	/**
	 * PIE-chart
	 * One student
	 * All courses
	 * shows time spend on "selfteaching", "lecture", "practice" and "teamwork"
	 * @param student
	 * @param graphName
	 * @return
	 */
	public Graph makePieChartOfStudyActivity(Student student, String graphName) {
		return GraphBuilder.makeChartOfStudyActivity(student, graphName, GraphType.PIECHART);
	}
	
	
	/**
	 * Bar-chart
	 * One student
	 * All courses
	 * shows time spend on "selfteaching", "lecture", "practice" and "teamwork"
	 * @param student
	 * @param graphName
	 * @return
	 */
	public Graph makeBarChartOfStudyActivity(Student student, String graphName) {
		return GraphBuilder.makeChartOfStudyActivity(student, graphName, GraphType.BARCHART);
	}
	/**
	 * PIEchart
	 * One student
	 * All courses
	 * shows time spend on each course
	 * @param student
	 * @param graphName
	 * @return
	 */
	public Graph makePieChartOfCourses(Student student, String graphName){
		return GraphBuilder.makeChartOfCourses(student, graphName, GraphType.PIECHART);
	}
	/**
	 * BARchart
	 * One student
	 * All courses
	 * shows time spend on each course
	 * @param student
	 * @param graphName
	 * @return
	 */
	public Graph makeBarChartOfCourses(Student student, String graphName){
		return GraphBuilder.makeChartOfCourses(student, graphName, GraphType.BARCHART);
	}
	
	/**
	 * returns PIEchart
	 * One student 
	 * All activities 
	 * shows time spend on "Study", "FreeTime" and "Sleep
	 * 
	 * @param student
	 * @param graphName
	 * @return
	 */
	public Graph makePieChartOfActivities(Student student, String graphName){
		return GraphBuilder.makeChartOfActivities(student, graphName, GraphType.PIECHART);
	}
	
	/**
	 * returns BARchart
	 * One student 
	 * All activities 
	 * shows time spend on "Study", "FreeTime" and "Sleep
	 * 
	 * @param student
	 * @param graphName
	 * @return
	 */
	public Graph makeBarChartOfActivities(Student student, String graphName){
		return GraphBuilder.makeChartOfActivities(student, graphName, GraphType.BARCHART);
	}
	
	public List<Activity> getOldActivityList(Student student){
		return student.getOldActivityList();
	}
	
	public String[] getOldActivityNames(Student student){
		List<Activity> oldActivityList = getOldActivityList(student);
		int size = oldActivityList.size();
		ArrayList<String> nameList = new ArrayList<String>();
		for(Activity activity: oldActivityList){
			String name = activity.getActivityName();
					nameList.add(name);
		}
		String [] nameString = nameList.toArray(new String[size]);
		return nameString;
	}
	
	public String[] getOldActivityStartDates(Student student){
		List<Activity> oldActivityList = getOldActivityList(student);
		int size = oldActivityList.size();
		ArrayList<String> startList = new ArrayList<String>();
		for(Activity activity: oldActivityList){
			Calendar startDate = activity.getStartTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		    String start = sdf.format(startDate.getTime());
					startList.add(start);
		}
		String [] startString = startList.toArray(new String[size]);
		return startString;
	}
	
	public String[] getOldActivityStopDates(Student student){
		List<Activity> oldActivityList = getOldActivityList(student);
		int size = oldActivityList.size();
		ArrayList<String> stopList = new ArrayList<String>();
		for(Activity activity: oldActivityList){
			Calendar stopDate = activity.getStopTime();
			
			//@ Nils, ik heb hier een test ingevuld die checht of stopDate null is. 
			// DIt lijkt bij mij de oplossing te zijn voor een nullpointer exception
			if(stopDate != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		    String stop = sdf.format(stopDate.getTime());
					stopList.add(stop);
			}
		}
		String [] stopString = stopList.toArray(new String[size]);
		return stopString;
	}
	
	

}
