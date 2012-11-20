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
	public static String[] arr = { "TESTPROGRAM1", "TESTPROGRAM2", "TESTPROGRAM3", "TESTPROGRAM4", "TESTPROGRAM5", "TESTPROGRAM6"};
	
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
//	public boolean putStudent(StudyProgram studyProgram){
//		if(studyProgram != null){
//		getObjectify().put(studyProgram);
//		return true;
//		}
//		else{
//			return false;
//		}
//	}
//	
//	/**
//	 * 
//	 */
//	public StudyProgram getCourse(Key<StudyProgram> studyProgramKey){
//		return getObjectify().get(studyProgramKey);
//	}
//		
//	public StudyProgram getStudyProgram(Long studyProgramID){
//		return getObjectify().get(StudyProgram.class, studyProgramID);
//	}
//	public ArrayList<StudyProgram> getStudyProgramList(){
//		return studyPrograms;
//	}
//	
//	public StudyProgram getCourse(Long studyProgramID){
//		for (StudyProgram studyProgram: studyPrograms){
//			if (studyProgram.getStudyProgramID() == studyProgramID){
//				return studyProgram;
//			}
//	
//		}
//		return null;
//		// should NEVER happen
//		// THIS CANNOT HAPPEN DO YOU HEAR ME
//	}
//	
	public String[] getStudyProgamNames(){
		return arr;
	}
//	public StudyProgram getStudyProgram(long studyprogramNumber){
//		return getStudyProgramList().get((int) studyprogramNumber);
//	}
}
