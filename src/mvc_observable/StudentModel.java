package mvc_observable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import java.util.Observable;

public class StudentModel  extends Observable {

	private String name;
	private ArrayList<InvalidationListener> listeners = new ArrayList<InvalidationListener>();

	public StudentModel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		proccessEvent(Controller.MODEL_NAME_CHANGED_EVENT);
	}

	@Override
	public String toString() {

		return name;
	}

	private void proccessEvent(String command) {
		notifyObservers(command);
	}

}
