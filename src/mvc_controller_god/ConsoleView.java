package mvc_controller_god;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsoleView {

	private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();

	public void init() {

	}

	public void showModel(String name) {
		System.out.println(name);
	}

	public void registerListener(ActionListener listener) {
		this.listeners.add(listener);

	}

}
