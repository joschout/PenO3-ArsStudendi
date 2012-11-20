package DomainModel;

public class Milestone {

	private String name;
	private Activity activity;
	private boolean isAchieved;
	private MilestoneType milestoneType;
	
	public Milestone(String name, Activity activity){
		this.name = name;
		this.activity = activity;
	}
public String getMilestoneName(){
	return name;
}
public MilestoneType milestoneType(){
	return milestoneType;
}
public boolean isAchieved(){
	return isAchieved;
}
public void setMilestoneName(String name){
	this.name=name;
}
public Activity getActivity(){
	return activity;
}
public void setActivity(Activity activity){
this.activity = activity;

}
}