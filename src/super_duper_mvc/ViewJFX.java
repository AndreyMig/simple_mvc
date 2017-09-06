package super_duper_mvc;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewJFX implements ISuperDuperView {

	private Label resultLabel;
	private Label result2;

	public ViewJFX(Stage primaryStage) {
		BorderPane pane = new BorderPane();

		resultLabel = new Label("-1");
		pane.setLeft(resultLabel);
//		pane.setRight(result2);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowGridPane"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		primaryStage.setAlwaysOnTop(true);

	}

	@Override
	public void showResult(Number result) {
		resultLabel.setText(""+result);
	}

	
	
	
}
