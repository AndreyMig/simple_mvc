package mvc_controller_god;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentModel {

	private String name;
	private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();

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
		for (ActionListener actionListener : listeners) {
			actionListener.actionPerformed(new ActionEvent(this, -1, command));
		}

	}

	public void registerListener(ActionListener listener) {
		this.listeners.add(listener);

	}

}
