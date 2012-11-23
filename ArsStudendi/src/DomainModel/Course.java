package DomainModel;

import java.io.Serializable;

public class Course implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courseName;
	private Long courseID;

	public Course(String courseName, Long courseID) {
		this.courseName = courseName;
		this.courseID = courseID;
	}

	public Long getCourseID() {
		return courseID;
	}

	public String getCourseName() {
		return courseName;
	}
}
