package mvc_controller_god;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {

	public final static String MODEL_NAME_CHANGED_EVENT = "STUDENT_NAME_WAS_SET_EVENT";

	public static final String SET_NAME_EVENT = "SET_NAME_EVENT";

	private ArrayList<ConsoleView> views = new ArrayList<ConsoleView>();
	private StudentModel model;

	public Controller(StudentModel student) {
		this.model = student;
		this.model.registerListener(this);
	}

	public void addView(ConsoleView view) {
		this.views.add(view);
		view.registerListener(this);
		view.init();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
//		System.out.println(event.getActionCommand());
		switch (event.getActionCommand()) {
		case MODEL_NAME_CHANGED_EVENT:
			String name = model.getName();
			
			for (ConsoleView consoleView : views) {
				consoleView.showModel(name);
			}

			break;
		case SET_NAME_EVENT:
			
			ConsoleView cv = (ConsoleView) event.getSource();
			
//			String name = student.getName();
			this.model.setName(cv.getCurrentValueOfNameField());
//			for (ConsoleView consoleView : views) {
//				consoleView.showModel(name);
//			}

			break;

		default:
			break;
		}

	}

}
