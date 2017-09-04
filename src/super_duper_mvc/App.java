package super_duper_mvc;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		ISuperDuperModel cm = new CalculatorModel();
		ISuperDuperView vfx = new ViewJFX(primaryStage);
		Controller c = new Controller(cm);
		c.addView(vfx);

	}

}
