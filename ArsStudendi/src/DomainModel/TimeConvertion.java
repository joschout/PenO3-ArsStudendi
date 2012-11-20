package DomainModel;

public class TimeConvertion {


	public String timeConvertion(long TimePassed){
	// return string with the time elapsed
	long TimeP = TimePassed;
	long secondM = 1000;
	long minuteM = secondM * 60;
	long hourM = minuteM * 60;
	long dayM = hourM * 24;
	long weekM = dayM *7;
	long yearM = weekM * 52;
	
	Long elapsedYears = TimeP / yearM;
	TimeP = TimeP % yearM;
	Long elapsedWeeks = TimeP / weekM;
	TimeP = TimeP % yearM;
	Long elapsedDays = TimeP / dayM;
	TimeP = TimeP % dayM;
	Long elapsedHours = TimeP / hourM;
	TimeP = TimeP % hourM;
	Long elapsedMinutes = TimeP / minuteM;
	TimeP = TimeP % minuteM;
	Long elapsedSeconds = TimeP / secondM;
	
	String sElapsedYears = elapsedYears.toString();
	String sElapsedWeeks = elapsedWeeks.toString();
	String sElapsedDays = elapsedDays.toString();
	String sElapsedHours = elapsedHours.toString();
	String sElapsedMinutes = elapsedMinutes.toString();
	String sElapsedSeconds = elapsedSeconds.toString();
	String s = null;
	
	if (elapsedYears != 0){
		s = sElapsedYears + " year(s) ago";
		return s;
	}
	if (elapsedWeeks != 0){
		s = s + sElapsedWeeks + " week(s) ago";
		return s;
	}
	if (elapsedDays != 0 && elapsedYears == 0){
		s = s + sElapsedDays + " day(s) ago";
	}
	if (elapsedHours != 0 && elapsedWeeks == 0 && elapsedYears == 0){
		s = s + sElapsedHours + " hour(s) ago";
		return s;
	}
	if (elapsedMinutes !=0 && elapsedYears == 0 && elapsedWeeks ==0 && elapsedDays ==0){
		s = s + sElapsedMinutes + " minutes(s) ago";
		return s;
	}
	if (elapsedSeconds !=0 && elapsedYears == 0 && elapsedWeeks ==0 && elapsedDays == 0 && elapsedHours == 0){
		s = s + sElapsedSeconds + " seconds(s) ago";
		return s;
	}
	
	return "1 second ago"; // should normally never happen

	}

}
