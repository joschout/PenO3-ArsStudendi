package DomainModel;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class StudyProgram implements Serializable {
	private List<Course> courseList;
	private String name;
	@Id private Long studyProgramID;

	public StudyProgram(List<Course> courseList, String name,Long studyProgramID) {
		this.courseList = courseList;
		this.name = name;
		this.studyProgramID = studyProgramID;
	}

	public void addCourse(Course newCourse) {
		if (!courseList.contains(newCourse)) {
			courseList.add(newCourse);
		}
	}

	public void removeCourse(Course oldCourse) {
		if (courseList.contains(oldCourse)){
			courseList.remove(oldCourse);
		}
	}

	public Long getStudyProgramID() {
		return studyProgramID;
	}
	
	public String getStudyProgramName() {
		return name;
	}

}
