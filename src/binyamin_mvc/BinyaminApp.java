package binyamin_mvc;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.stage.Stage;

public class BinyaminApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	
	public static void justSwing(){
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		IBinyaminModel model = new BinyaminModel();
		IBinyaminView view = new BinyaminJFX(primaryStage);
		BinyaminController bc = new BinyaminController();
		justSwing();
		bc.setModel(model);
		bc.addView(view);

	}

}
