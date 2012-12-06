package arsstudendi;

import activityTypePackage.ActivityType;
import activityTypePackage.FreeTime;
import activityTypePackage.Hobby;
import activityTypePackage.*;

public class Parser {

	public static ActivityType parseActivityType(String inputString) {
		if (inputString.equals(null)) {
			return null;
		}
		String tempParsString = inputString.replaceAll(" ", "").toLowerCase();
		tempParsString = tempParsString.replaceAll("\n", "").toLowerCase();

		if (tempParsString.equals("hobby")) {
			Hobby hobby = new Hobby();
			return hobby;
		}
		if (tempParsString.equals("lecture")) {
			Lecture lecture = new Lecture(null);
			return lecture;
		}

		if (tempParsString.equals("other")) {
			Other other = new Other();
			return other;
		}
		if (tempParsString.equals("sleep")) {
			Sleep sleep = new Sleep();
			return sleep;
		}
		if (tempParsString.equals("practice")) {
			Practice practice = new Practice(null);
			return practice;
		}
		if (tempParsString.equals("selfteaching") || tempParsString.equals("study")) {
			SelfTeaching selfTeaching = new SelfTeaching(null);
			return selfTeaching;
		}
		if (tempParsString.equals("social")) {
			Social social = new Social();
			return social;
		}
		if (tempParsString.equals("sport") || tempParsString.equals("sports")) {
			Sports sports = new Sports();
			return sports;
		}
		if (tempParsString.equals("teamwork")) {
			Teamwork teamwork = new Teamwork(null);
			return teamwork;
		}
		return null;
	}
}
