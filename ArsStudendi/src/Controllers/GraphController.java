package Controllers;



import DomainModel.*;
import graphPackage.*;
import graphPackage.Graph;
import graphPackage.GraphType;



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
	
	
	

}
