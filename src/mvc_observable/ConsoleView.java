package mvc_observable;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ConsoleView implements Observer {

	private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();

	public void init() {
		
	}

	public void showModel(String name) {
		System.out.println(name);
	}

	public void registerListener(ActionListener listener) {
		this.listeners.add(listener);

	}

	@Override
	public void update(Observable o, Object arg) {
		StudentModel model = null;
		try {
			model = (StudentModel) o;
			showModel(model.getName());
		} catch (Exception e) {
			System.out.println("ERROR IN CASTING FOR Observable to T");
		}
		
		

	}

}
