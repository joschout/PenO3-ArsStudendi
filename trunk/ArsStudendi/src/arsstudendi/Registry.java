package arsstudendi;

import com.googlecode.objectify.ObjectifyService;
import DomainModel.*;
import Controllers.*;


public class Registry extends Objectifiable {
	private static Registry _singletonObject;
	
	private Registry(){
	ObjectifyService.register(Student.class);
	ObjectifyService.register(Course.class);
	}

	/**
	 * Dit is eigenlijk de getInstance() methode
	 * @return
	 */
	public static synchronized Registry getSingletonObject(){
		if( _singletonObject == null){
			_singletonObject = new Registry();
		}
		return _singletonObject;
	}
	public boolean put(Course course){
		if(course != null){
		getObjectify().put(course);
		return true;
		}
		else{
			return false;
		}
	}
}
