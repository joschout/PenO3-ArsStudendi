package DomainModel;

public class Milestone {

	private String name;
	private Calender startTime;
	private Calender stopTime;
	private boolean isAchieved;
	private Course course;
	private MilestoneType milestoneType;
	//goal = aantal bladzijden/aantal seconden men wilt leren
	private int goal;
	private int  progress;
	

	public Milestone(String name, Course course, Milestonetype milestoneType,int goal) {
		this.startTime=startTime;
		this.stopTime = stopTime;
		this.name = name;
		this.goal = goal;
		this.milestoneType = milestoneType;
	}
	public void setStartTime(Calender startTime)
	{
	this.startTime = startTime;	
	}
	public void setStopTime(Calender stopTime){
		this.stopTime=stopTime;
	}
	public String getMilestoneName() {
		return name;
	}

	public MilestoneType milestoneType() {
		return milestoneType;
	}

	public boolean isAchieved() {
		return isAchieved;
	}

	public void setMilestoneName(String name) {
		this.name = name;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;

	}
}