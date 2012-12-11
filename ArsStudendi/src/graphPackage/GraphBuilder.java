package graphPackage;

import java.text.SimpleDateFormat;
import java.util.*;

import Controllers.GraphController;
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

	// public static Graph buildGraph() {
	//
	// }

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
	 * PIEchart or BARchart One student All courses shows time spend one each
	 * course
	 * 
	 * @param student
	 * @param graphName
	 * @return
	 */
	public static Graph makeChartOfCourses(Student student, String graphName,
			GraphType graphType) {
		if (graphType == GraphType.PIECHART || graphType == GraphType.BARCHART) {

			java.util.List<Activity> oldActivityList = student
					.getOldActivityList();

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
	 * PIE-chart or BARchart One student All courses shows time spend on
	 * "selfteaching", "lecture", "practice" and "teamwork"
	 * 
	 * @param student
	 * @param graphName
	 * @return
	 */
	public static Graph makeChartOfStudyActivity(Student student,
			String graphName, GraphType graphType) {
		if (graphType == GraphType.PIECHART || graphType == GraphType.BARCHART) {
			java.util.List<Activity> oldActivityList = student
					.getOldActivityList();

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
			long totalSelfTeachingTime = TimerController
					.getTotalTimeOfActivityList(selfTeachingActivities);
			long totalLectureTime = TimerController
					.getTotalTimeOfActivityList(lectureActivities);
			long totalPracticeTime = TimerController
					.getTotalTimeOfActivityList(practiceActivities);
			long totalTeamworkTime = TimerController
					.getTotalTimeOfActivityList(teamworkActivities);

			// long totalStudyTime = totalSelfTeachingTime +
			// totalLectureTime+totalPracticeTime+totalTeamworkTime;

			HashMap<String, Long> chartMap = new HashMap<String, Long>();
			chartMap.put("Self Teaching", totalSelfTeachingTime);
			chartMap.put("Lecture", totalLectureTime);
			chartMap.put("Practice", totalPracticeTime);
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

	public static Graph makeChartOfAllStudyActivity(Student student,
			String graphName, GraphType graphType) {
		if (graphType == GraphType.PIECHART || graphType == GraphType.BARCHART) {
			GraphController controller = new GraphController();
			java.util.List<Activity> oldActivityList = controller
					.getAllOldActivityList(student);

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
			long totalSelfTeachingTime = TimerController
					.getTotalTimeOfActivityList(selfTeachingActivities);
			long totalLectureTime = TimerController
					.getTotalTimeOfActivityList(lectureActivities);
			long totalPracticeTime = TimerController
					.getTotalTimeOfActivityList(practiceActivities);
			long totalTeamworkTime = TimerController
					.getTotalTimeOfActivityList(teamworkActivities);

			// long totalStudyTime = totalSelfTeachingTime +
			// totalLectureTime+totalPracticeTime+totalTeamworkTime;

			HashMap<String, Long> chartMap = new HashMap<String, Long>();
			chartMap.put("Self Teaching", totalSelfTeachingTime);
			chartMap.put("Lecture", totalLectureTime);
			chartMap.put("Practice", totalPracticeTime);
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

	public static Graph makeChartOfAllCourses(Student student,
			String graphName, GraphType graphType) {
		if (graphType == GraphType.PIECHART || graphType == GraphType.BARCHART) {
			GraphController controller = new GraphController();
			java.util.List<Activity> oldActivityList = controller
					.getAllOldActivityList(student);

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

	public static Graph makeChartOfAllActivities(Student student,
			String graphName, GraphType graphType) {
		if (graphType == GraphType.PIECHART || graphType == GraphType.BARCHART) {
			GraphController controller = new GraphController();
			java.util.List<Activity> oldActivityList = controller
					.getAllOldActivityList(student);

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

//	public static Graph makeLineChart(Student student, String graphName) {
//		GraphController controller = new GraphController();
//		java.util.List<Activity> oldActivityList = controller
//				.getAllOldActivityList(student);
//
//		// het maken van eem map
//		// met als Keys de courses van een student
//		// en als Values een List<Activity> van alle Activities behorende bij de
//		// course.
//		// =>bundeling van de activiteiten per course
//		Map<String, List<Activity>> courseMapOfActivities = new HashMap<String, List<Activity>>();
//
//		Calendar now = Calendar.getInstance();
//
//		//een lijst met de afgelopen 7 dagen
//		List<String> lastWeek = new ArrayList<String>();
//		int i = 6;
//		while (i >= 0) {
//			Calendar tempDate = Calendar.getInstance();
//
//			tempDate.set(Calendar.DAY_OF_MONTH, -i);
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//			String tempDateString = sdf.format(now.getTime());
//			lastWeek.add(tempDateString);
//
//		}
//
//		// alle activiteiten die de afgelopen week gestart zijn worden toegevoegd aan een lijst behorende bij
//		for (Activity activity : oldActivityList) {
//			if (activity.getActivityType() instanceof Study) {
//				String course = ((Study) activity.getActivityType())
//						.getCourse().getCourseName();
//				Calendar tempStartTime = activity.getStartTime();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String start = sdf.format(tempStartTime.getTime());
//				if (lastWeek.contains(start)) {
//					if (!courseMapOfActivities.containsKey(course)) {
//						List<Activity> tempList = new ArrayList<Activity>();
//						tempList.add(activity);
//						courseMapOfActivities.put(course, tempList);
//					} else {
//						List<Activity> tempList = courseMapOfActivities
//								.get(course);
//						tempList.add(activity);
//						courseMapOfActivities.put(course, tempList);
//					}
//				}
//			}
//		}
//
//		List<LineGraphDataSeries> lineGraphDataSeries = new ArrayList<LineGraphDataSeries>();
//
//		for (String courseName : courseMapOfActivities.keySet()) {
//			Map<String, Long> hoursPerDayForThisCourse = getMapOfHoursPerDay(courseMapOfActivities
//					.get(courseName));
//
//			for (String string : lastWeek) {
//
//				if (!hoursPerDayForThisCourse.containsKey(string)) {
//					hoursPerDayForThisCourse.put(string, Long.valueOf(0));
//				}
//			}
//			LineGraphDataSeries tempDataSeries = new LineGraphDataSeries(
//					courseName, hoursPerDayForThisCourse);
//			lineGraphDataSeries.add(tempDataSeries);
//
//		}
//
//		LineChart lineChart = new LineChart(graphName, lineGraphDataSeries,
//				lastWeek);
//
//		return (Graph) lineChart;
//	}
//
//	public static Map<String, Long> getMapOfHoursPerDay(
//			List<Activity> activityList) {
//		Map<String, Long> hoursPerDay = new HashMap<String, Long>();
//
//		for (Activity activity : activityList) {
//			Calendar activityStartTime = activity.getStartTime();
//			Calendar activityStopTime = activity.getStopTime();
//
//			long durationInMillis = activityStopTime.getTimeInMillis()
//					- activityStartTime.getTimeInMillis();
//			long durationInHours = durationInMillis / (1000 * 60 * 60);
//
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String activityStartDate = sdf.format(activityStartTime.getTime());
//
//			if (hoursPerDay.keySet().contains(activityStartDate)) {
//				Long oldAmountOfHours = hoursPerDay.get(activityStartDate);
//				Long newAmountOfHours = oldAmountOfHours + durationInHours;
//				hoursPerDay.put(activityStartDate, newAmountOfHours);
//			} else {
//				hoursPerDay.put(activityStartDate, durationInHours);
//			}
//
//		}
//		// / er moet nog gecheckt worden of hoursPerDay < 24
//		return hoursPerDay;
//
//	}

	// int dayOfMonth = Calendar.DAY_OF_MONTH;
	// int month = Calendar.MONTH; // gaat van 0 tot 11
	// int realMonth = month +1;
	// int year = Calendar.YEAR;
	// String currentDate = "" + dayOfMonth + "/" + realMonth + "/" + year;
	// List<String> lastWeek = new ArrayList<String>();
	// int i=6;
	// while(i>=0){
	// Calendar tempDate =Calendar.getInstance();
	// tempDate.set(Calendar.DAY_OF_MONTH, -i);
	// int tempDay = tempDate.DAY_OF_MONTH;
	// int tempMonth = tempDate.MONTH +1;
	// int tempYear = tempDate.YEAR;
	// String tempDateString = "" + tempDay + "/" + tempMonth + "/" + tempYear;
	// lastWeek.add(tempDateString);
	// }
	//
	//
	//
	// ////////////////////////////////////////////////////////////////////////////////
	//
	//
	//
	// Map<String, Map<Calendar, Long>> mapOfCoursesWithDatesAndHoursADay=new
	// HashMap<String, Map<Calendar, Long>>();
	// for(String course: courseMapOfActivities.keySet()){
	//
	// List<Activity> activityListForThisCourse =
	// courseMapOfActivities.get(course);
	//
	// Map<Calendar, Long> hoursPerDay = new HashMap<Calendar, Long>();
	//
	// for(Activity activity: activityListForThisCourse){
	// Calendar activityStartTime =activity.getStartTime();
	// Calendar activityStopTime = activity.getStopTime();
	//
	// long durationInMillis = activityStopTime.getTimeInMillis() -
	// activityStartTime.getTimeInMillis();
	// long durationInHours = durationInMillis/(1000*60*60);
	//
	//
	//
	// long hoursBetween =0;
	// while(activityStartTime.before(activityStopTime)){
	// activityStartTime.add(Calendar.HOUR, 1);
	// hoursBetween++;
	// }
	//
	//
	//
	//
	//
	//
	//
	// boolean hoursPerDayContainsThisDay = false;
	// for(Calendar calendar:hoursPerDay.keySet()){
	//
	// if(calendar.get(Calendar.YEAR)==activityStartTime.get(Calendar.YEAR)
	// && calendar.get(Calendar.MONTH)==activityStartTime.get(Calendar.MONTH)
	// &&
	// calendar.get(Calendar.DAY_OF_MONTH)==activityStartTime.get(Calendar.DAY_OF_MONTH)){
	// Long oldAmountOfHours = hoursPerDay.get(calendar);
	// Long newAmountOfHours = oldAmountOfHours + hoursBetween;
	// hoursPerDay.put(calendar, newAmountOfHours);
	// hoursPerDayContainsThisDay = true;
	// }
	// }
	// if(hoursPerDayContainsThisDay == false){
	// hoursPerDay.put(activityStartTime, Long.valueOf(hoursBetween));
	// }
	// }
	// mapOfCoursesWithDatesAndHoursADay.put(course, hoursPerDay);
	// }
	//
	//
	//
	//

	// int dayOfMonth = Calendar.DAY_OF_MONTH;
	// int month = Calendar.MONTH; // gaat van 0 tot 11
	// int realMonth = month +1;
	// int year = Calendar.YEAR;
	// String currentDate = "" + dayOfMonth + "/" + realMonth + "/" + year;
	// List<String> lastWeek = new ArrayList<String>();
	// int i=6;
	// while(i>=0){
	// Calendar tempDate =Calendar.getInstance();
	// tempDate.set(Calendar.DAY_OF_MONTH, -i);
	// int tempDay = tempDate.DAY_OF_MONTH;
	// int tempMonth = tempDate.MONTH +1;
	// int tempYear = tempDate.YEAR;
	// String tempDateString = "" + tempDay + "/" + tempMonth + "/" + tempYear;
	// lastWeek.add(tempDateString);
	// }
	//
	//
	//
	// ////////////////////////////////////////////////////////////////////////////////
	//
	//
	//
	// Map<String, Map<Calendar, Long>> mapOfCoursesWithDatesAndHoursADay=new
	// HashMap<String, Map<Calendar, Long>>();
	// for(String course: courseMapOfActivities.keySet()){
	//
	// List<Activity> activityListForThisCourse =
	// courseMapOfActivities.get(course);
	//
	// Map<Calendar, Long> hoursPerDay = new HashMap<Calendar, Long>();
	//
	// for(Activity activity: activityListForThisCourse){
	// Calendar activityStartTime =activity.getStartTime();
	// Calendar activityStopTime = activity.getStopTime();
	//
	// long durationInMillis = activityStopTime.getTimeInMillis() -
	// activityStartTime.getTimeInMillis();
	// long durationInHours = durationInMillis/(1000*60*60);
	//
	//
	//
	// long hoursBetween =0;
	// while(activityStartTime.before(activityStopTime)){
	// activityStartTime.add(Calendar.HOUR, 1);
	// hoursBetween++;
	// }
	//
	//
	//
	//
	//
	//
	//
	// boolean hoursPerDayContainsThisDay = false;
	// for(Calendar calendar:hoursPerDay.keySet()){
	//
	// if(calendar.get(Calendar.YEAR)==activityStartTime.get(Calendar.YEAR)
	// && calendar.get(Calendar.MONTH)==activityStartTime.get(Calendar.MONTH)
	// &&
	// calendar.get(Calendar.DAY_OF_MONTH)==activityStartTime.get(Calendar.DAY_OF_MONTH)){
	// Long oldAmountOfHours = hoursPerDay.get(calendar);
	// Long newAmountOfHours = oldAmountOfHours + hoursBetween;
	// hoursPerDay.put(calendar, newAmountOfHours);
	// hoursPerDayContainsThisDay = true;
	// }
	// }
	// if(hoursPerDayContainsThisDay == false){
	// hoursPerDay.put(activityStartTime, Long.valueOf(hoursBetween));
	// }
	// }
	// mapOfCoursesWithDatesAndHoursADay.put(course, hoursPerDay);
	// }
	//
	//
	//
	//

	// /**
	// * per dag deze week
	// * @param student
	// * @return
	// */
	// public static Graph makeLineChartOfCourses(Student student){
	// List<String> XAxis = new ArrayList<String>();
	//
	//
	//
	// return null;
	// }
}
