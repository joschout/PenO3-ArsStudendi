package graphPackage;

import java.util.Map;

public class LineGraphDataSeries {
	
	private String name;
	private Map<String,Long> hoursPerTime;
	public LineGraphDataSeries(String name, Map<String,Long> hoursPerTime ) {
		
	this.name = name;
	this.hoursPerTime = hoursPerTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Long> getHoursPerTime() {
		return hoursPerTime;
	}
	public void setHoursPerTime(Map<String, Long> hoursPerTime) {
		this.hoursPerTime = hoursPerTime;
	}
	
	

}
