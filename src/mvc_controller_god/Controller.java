package mvc_controller_god;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {

	public final static String MODEL_NAME_CHANGED_EVENT = "STUDENT_NAME_WAS_SET_EVENT";

	private ArrayList<ConsoleView> views = new ArrayList<ConsoleView>();
	private StudentModel student;

	public Controller(StudentModel student) {
		this.student = student;
		this.student.registerListener(this);
	}

	public void addView(ConsoleView view) {
		this.views.add(view);
		view.registerListener(this);
		view.init();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getActionCommand());
		switch (event.getActionCommand()) {
		case MODEL_NAME_CHANGED_EVENT:
			String name = student.getName();
			
			for (ConsoleView consoleView : views) {
				consoleView.showModel(name);
			}

			break;

		default:
			break;
		}

	}

}
