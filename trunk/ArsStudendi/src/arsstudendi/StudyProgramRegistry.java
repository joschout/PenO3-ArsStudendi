package arsstudendi;

import java.util.*;

import DomainModel.Course;
import DomainModel.StudyProgram;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import Controllers.Objectifiable;

public class StudyProgramRegistry extends Objectifiable {
	
	private static StudyProgramRegistry _singletonObject;
//	public ArrayList<StudyProgram> studyPrograms;
	public static String[] studyProgramNames = { "Eerste_Bach_Ingenieurswetenschappen_SEM1", "Tweede_Bach_Ingenieurswetenschappen_SEM1", "Eerste_Bach_Ingenieurswetenschappen_SEM2", "Eerste_Bach_Rechten_SEM1", "Eerste_Bach_Geneeskunde_SEM1", "Eerste_Bach_Geneeskunde_SEM2"};
	
	/**
	 * 
	 */
	private StudyProgramRegistry(){
	ObjectifyService.register(StudyProgram.class);
	}

	/**
	 * Dit is eigenlijk de getInstance() methode
	 * @return
	 */
	public static synchronized StudyProgramRegistry getSingletonObject(){
		if( _singletonObject == null){
			_singletonObject = new StudyProgramRegistry();
		}
		return _singletonObject;
	}
	/**
	 * 
	 * @return
	 */
	public String[] getStudyProgamNames(){
		return studyProgramNames;
	}
	
	/**
	 * 
	 * @param studyProgramName
	 * @return
	 */
	public StudyProgram getStudyProgram(String studyProgramName) {
		ArrayList<StudyProgram> studyPrograms = makeProgramList(CourseRegistry.getSingletonObject().makeCourses());
		for (StudyProgram studyProgram : studyPrograms) {
			if (studyProgram.getStudyProgramName().equals(studyProgramName)) {
				return studyProgram;
			}

		}
		return null;
		// should NEVER happen
		// THIS CANNOT HAPPEN DO YOU HEAR ME

	}
	
	public String getProgramNameWithLong(long i) {
		ArrayList<StudyProgram> programList = makeProgramList(CourseRegistry.getSingletonObject().makeCourses());
		for (StudyProgram studyProgram : programList) {
			if (studyProgram.getStudyProgramID() == i) {
				return studyProgram.getStudyProgramName();
			}

		}
		return null;
	}
	/**
	 * 
	 * @param givenCourseList
	 * @return
	 */
	private ArrayList<StudyProgram> makeProgramList(ArrayList<Course> givenCourseList) {
		
		ArrayList<Course> courses = givenCourseList;
		ArrayList<StudyProgram> studyPrograms = new ArrayList<StudyProgram>();
		
		int length = 6;
		int i = 0;
		String[] arr = getStudyProgamNames();
		
		while (i < length) {
			ArrayList<Course> courseList = new ArrayList<Course>();
			if (i == 0) {
				courseList.add(courses.get(0));
				courseList.add(courses.get(3));
				courseList.add(courses.get(6));
				courseList.add(courses.get(9));
				courseList.add(courses.get(13));
				courseList.add(courses.get(15));
			}
			if (i == 1) {
				courseList.add(courses.get(2));
				courseList.add(courses.get(4));
				courseList.add(courses.get(5));
				courseList.add(courses.get(11));
				courseList.add(courses.get(12));
				courseList.add(courses.get(14));
				courseList.add(courses.get(17));
			}
			if (i == 2) {
				courseList.add(courses.get(1));
				courseList.add(courses.get(7));
				courseList.add(courses.get(8));
				courseList.add(courses.get(10));
				courseList.add(courses.get(16));
				courseList.add(courses.get(18));
				courseList.add(courses.get(19));
			}
			if (i == 3) {
				courseList.add(courses.get(9));
				courseList.add(courses.get(20));
				courseList.add(courses.get(21));
				courseList.add(courses.get(22));
				courseList.add(courses.get(23));
			}
			if (i == 4) {
				courseList.add(courses.get(9));
				courseList.add(courses.get(24));
				courseList.add(courses.get(25));
				courseList.add(courses.get(26));
				courseList.add(courses.get(27));
			}
			if (i == 5) {
				courseList.add(courses.get(27));
				courseList.add(courses.get(28));
				courseList.add(courses.get(29));
				courseList.add(courses.get(30));
				courseList.add(courses.get(31));
			}
			StudyProgram studyProgram = new StudyProgram(courseList, arr[i], (long) i);
			studyPrograms.add(studyProgram);
			i++;
		}
		return studyPrograms;
	}
	
//	static{
//	ArrayList<Course> courses = CourseRegistry.getSingletonObject().getCourseList();
//	int length = 6 ;
//	int i =1;
//	while (i<length+1){
//		ArrayList<Course> courseList = new ArrayList<Course>();
//		if(i == 1){
//			courseList.add(courses.get(1)); 
//			courseList.add(courses.get(3)); 
//			courseList.add(courses.get(5)); 
//		}
//		if(i == 2){
//			courseList.add(courses.get(1)); 
//			courseList.add(courses.get(2)); 
//			courseList.add(courses.get(3)); 
//		}
//		if(i == 3){
//			courseList.add(courses.get(1)); 
//			courseList.add(courses.get(3)); 
//			courseList.add(courses.get(6)); 
//		}
//		if(i == 4){
//			courseList.add(courses.get(1)); 
//			courseList.add(courses.get(5)); 
//			courseList.add(courses.get(6)); 
//		}
//		if(i == 5){
//			courseList.add(courses.get(2)); 
//			courseList.add(courses.get(3)); 
//			courseList.add(courses.get(4)); 
//		}
//		if(i == 6){
//			courseList.add(courses.get(1)); 
//			courseList.add(courses.get(4)); 
//			courseList.add(courses.get(5)); 
//		}
//		StudyProgram studyProgram = new StudyProgram(courseList, arr[i], (long) i);
//		studyPrograms.add(studyProgram);
//		i++;
//	}
//	}	
//	public boolean putStudent(StudyProgram studyProgram){
//	if(studyProgram != null){
//	getObjectify().put(studyProgram);
//	return true;
//	}
//	else{
//		return false;
//	}
//}
//
///**
// * 
// */
//public StudyProgram getCourse(Key<StudyProgram> studyProgramKey){
//	return getObjectify().get(studyProgramKey);
//}
//	
//public StudyProgram getStudyProgram(Long studyProgramID){
//	return getObjectify().get(StudyProgram.class, studyProgramID);
//}
//public ArrayList<StudyProgram> getStudyProgramList(){
//	return studyPrograms;
//}
//
//public StudyProgram getCourse(Long studyProgramID){
//	for (StudyProgram studyProgram: studyPrograms){
//		if (studyProgram.getStudyProgramID() == studyProgramID){
//			return studyProgram;
//		}
//
//	}
//	return null;
//	// should NEVER happen
//	// THIS CANNOT HAPPEN DO YOU HEAR ME
//}
//
	
	
//	public StudyProgram getStudyProgram(long studyprogramNumber){
//		return getStudyProgramList().get((int) studyprogramNumber);
//	}
}
