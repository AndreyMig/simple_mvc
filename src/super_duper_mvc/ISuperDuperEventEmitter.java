package super_duper_mvc;

//a general interface for any subclass to 
//allow listeners on it's changes (if their are any)
public interface ISuperDuperEventEmitter {


	//a method that allows an implementing class to call the events
	//on an ISuperDuperListener instance
	void registerListener(ISuperDuperListener listener);

	
}
