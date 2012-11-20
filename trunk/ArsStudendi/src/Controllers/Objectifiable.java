package Controllers;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class Objectifiable {


	/**
	 * 
	 * @return
	 */
	public Objectify getObjectify(){
		Objectify ofy = ObjectifyService.begin();
		return ofy;
	}
}
