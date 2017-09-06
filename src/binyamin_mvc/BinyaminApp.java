package binyamin_mvc;

import javafx.application.Application;
import javafx.stage.Stage;

public class BinyaminApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		IBinyaminModel model = new BinyaminModel();
		IBinyaminView view = new BinyaminJFX(primaryStage);
		BinyaminController bc = new BinyaminController();
		bc.setModel(model);
		bc.addView(view);

	}

}
