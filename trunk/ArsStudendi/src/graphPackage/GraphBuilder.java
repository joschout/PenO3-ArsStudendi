package graphPackage;

import java.util.ArrayList;
import java.util.HashMap;

import Controllers.TimerController;
import DomainModel.Activity;
import DomainModel.Student;
import activityTypePackage.FreeTime;
import activityTypePackage.Lecture;
import activityTypePackage.Practice;
import activityTypePackage.SelfTeaching;
import activityTypePackage.Sleep;
import activityTypePackage.Study;
import activityTypePackage.Teamwork;

public class GraphBuilder {

//	public static Graph buildGraph() {
//
//	}

	/**
	 * returns PIEchart or BARchart One student All activities shows time spend
	 * on "Study", "FreeTime" and "Sleep
	 * 
	 * @param student
	 * @param graphName
	 * @return
	 */
	public static Graph makeChartOfActivities(Student student,
			String graphName, GraphType graphType) {
		if (graphType == GraphType.PIECHART || graphType == GraphType.BARCHART) {
			java.util.List<Activity> oldActivityList = student
					.getOldActivityList();

			HashMap<String, Long> chartMap = new HashMap<String, Long>();

			chartMap.put("Study", Long.valueOf(0));
			chartMap.put("FreeTime", Long.valueOf(0));
			chartMap.put("Sleep", Long.valueOf(0));

			for (Activity activity : oldActivityList) {
				if (activity.getActivityType() instanceof Study) {
					Long oldTotalTime = chartMap.get("Study");
					Long newTotalTime = oldTotalTime
							+ activity.getDurationActivity();
					chartMap.put("Study", newTotalTime);
				}
				if (activity.getActivityType() instanceof FreeTime) {
					Long oldTotalTime = chartMap.get("FreeTime");
					Long newTotalTime = oldTotalTime
							+ activity.getDurationActivity();
					chartMap.put("FreeTime", newTotalTime);
				}
				if (activity.getActivityType() instanceof Sleep) {
					Long oldTotalTime = chartMap.get("Sleep");
					Long newTotalTime = oldTotalTime
							+ activity.getDurationActivity();
					chartMap.put("Sleep", newTotalTime);
				}
			}

			if (graphType == GraphType.PIECHART) {
				PieChart pieChart = new PieChart(graphName, chartMap);
				return (Graph) pieChart;
			}
			if (graphType == GraphType.BARCHART) {
				BarChart barChart = new BarChart(graphName, chartMap);
				return (Graph) barChart;

			}
		}
		return null;
	}

	/**
	 * PIEchart or BARchart
	 *  One student All courses shows time spend one each
	 * course
	 * 
	 * @param student
	 * @param graphName
	 * @return
	 */
	public static Graph makeChartOfCourses(Student student,
			String graphName, GraphType graphType) {
		if (graphType == GraphType.PIECHART || graphType == GraphType.BARCHART) {
			
		java.util.List<Activity> oldActivityList = student.getOldActivityList();

		HashMap<String, Long> chartMap = new HashMap<String, Long>();
		for (Activity activity : oldActivityList) {
			if (activity.getActivityType() instanceof Study) {
				String course = ((Study) activity.getActivityType())
						.getCourse().getCourseName();
				if (!chartMap.containsKey(course)) {
					chartMap.put(course, activity.getDurationActivity());
				} else {
					Long oldTotalTime = chartMap.get(course);
					Long newTotalTime = oldTotalTime
							+ activity.getDurationActivity();
					chartMap.put(course, newTotalTime);
				}
			}
		}
		if (graphType == GraphType.PIECHART) {
			PieChart pieChart = new PieChart(graphName, chartMap);
			return (Graph) pieChart;
		}
		if (graphType == GraphType.BARCHART) {
			BarChart barChart = new BarChart(graphName, chartMap);
			return (Graph) barChart;

		}
	}
	return null;
	
	}
	

	
	
	
	
	
	
	
	
	
	/**
	 * PIE-chart or BARchart
	 * One student
	 * All courses
	 * shows time spend on "selfteaching", "lecture", "practice" and "teamwork"
	 * @param student
	 * @param graphName
	 * @return
	 */
	public static Graph makeChartOfStudyActivity(Student student, String graphName, GraphType graphType) {
		if (graphType == GraphType.PIECHART || graphType == GraphType.BARCHART) {
		java.util.List<Activity> oldActivityList = student.getOldActivityList();

		ArrayList<Activity> selfTeachingActivities = new ArrayList<Activity>();
		ArrayList<Activity> lectureActivities = new ArrayList<Activity>();
		ArrayList<Activity> practiceActivities = new ArrayList<Activity>();
		ArrayList<Activity> teamworkActivities = new ArrayList<Activity>();
		for (Activity activity : oldActivityList) {

			if (activity.getActivityType() instanceof SelfTeaching) {
				selfTeachingActivities.add(activity);
				if (activity.getActivityType() instanceof Lecture) {
					lectureActivities.add(activity);
				}
				if (activity.getActivityType() instanceof Practice) {
					practiceActivities.add(activity);
				}
				if (activity.getActivityType() instanceof Teamwork) {
					teamworkActivities.add(activity);
				}
			}			
		}
		long totalSelfTeachingTime = TimerController.getTotalTimeOfActivityList(selfTeachingActivities);
		long totalLectureTime = TimerController.getTotalTimeOfActivityList(lectureActivities);
		long totalPracticeTime =TimerController.getTotalTimeOfActivityList(practiceActivities);
		long totalTeamworkTime = TimerController.getTotalTimeOfActivityList(teamworkActivities);
		
		long totalStudyTime = totalSelfTeachingTime + totalLectureTime+totalPracticeTime+totalTeamworkTime;
		
		
		
		HashMap<String,Long> chartMap= new HashMap<String, Long>();
		chartMap.put("Self Teaching", totalSelfTeachingTime);
		chartMap.put("Lecture", totalLectureTime);
		chartMap.put("Practice", totalLectureTime);
		chartMap.put("Teamwork", totalTeamworkTime);
		
		
			if (graphType == GraphType.PIECHART) {
			PieChart pieChart = new PieChart(graphName, chartMap);
			return (Graph) pieChart;
			}
			if (graphType == GraphType.BARCHART) {
			BarChart barChart = new BarChart(graphName, chartMap);
			return (Graph) barChart;
			}
		}
		return null;
	}
	
	
//	/**
//	 * per dag deze week
//	 * @param student
//	 * @return
//	 */
//	public static Graph makeLineChartOfCourses(Student student){
//		List<String> XAxis = new ArrayList<String>();
//		
//		
//		
//		return null;
//	}
}
