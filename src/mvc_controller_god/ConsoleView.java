package mvc_controller_god;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {

	private static final String END_COMMAND = "-1";
	private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();
	private String currentSetName = "";

	public void init() {

		Scanner s = new Scanner(System.in);
		String op = "";
		while (op != END_COMMAND) {
			
			System.out.println("choose option:");
			System.out.println("1: set name");
			op = s.nextLine();
			switch (op) {
			case Controller.SET_NAME_EVENT:
				System.out.println("enter name: ");
				String name = s.nextLine();
				this.currentSetName = name;
				proccessEvent(Controller.SET_NAME_EVENT);
				break;

			default:
				break;
			}
		}
		s.close();
	}

	private void proccessEvent(String command) {
		for (ActionListener actionListener : listeners) {
			actionListener.actionPerformed(new ActionEvent(this, -1, command));
		}

	}

	public void showModel(String name) {
		System.out.println("MODEL CHANGED - NEW NAME = ");
		System.out.println(name);
	}

	public void registerListener(ActionListener listener) {
		this.listeners.add(listener);

	}

	public String getCurrentValueOfNameField() {
		// TODO Auto-generated method stub
		return this.currentSetName;
	}

}
