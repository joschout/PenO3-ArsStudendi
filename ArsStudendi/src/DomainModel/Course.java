package DomainModel;

public class Course {
	
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
