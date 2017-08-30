package mvc_controller_god;

public class App {

	
	
	
	public static void main(String[] args) {
		

		StudentModel student = new StudentModel("andrey");
		Controller c = new Controller(student);
		ConsoleView cv = new ConsoleView();
		c.addView(cv);
		
		

	}

}
