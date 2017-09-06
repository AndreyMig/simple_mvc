package binyamin_mvc;

import java.util.ArrayList;

import javafx.scene.control.TextField;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BinyaminJFX implements IBinyaminRegistrable, IBinyaminView {

	private static final int TEXT_SPACING = 10;

	private ArrayList<IBinyaminListener> listeners = new ArrayList<IBinyaminListener>();

	private TextField searchField;
	private BorderPane pane;

	public BinyaminJFX(Stage primaryStage) {
		pane = new BorderPane();

		// b.getChildren().add();

		searchField = new TextField();
		searchField.onKeyReleasedProperty().set((Event event) -> {

			fireOnSearchChangeEvent();

		});

		pane.setTop(new Label("SEARCH"));

		pane.setCenter(searchField);
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		primaryStage.setAlwaysOnTop(true);
	}

	private void fireOnSearchChangeEvent() {
		System.out.println("view fireOnSearchChangeEvent: "
				+ searchField.getText());
		for (IBinyaminListener listener : listeners) {
			listener.onSearchChanged(searchField.getText());
		}

	}

	@Override
	public void registerListener(IBinyaminListener iBinyaminListener) {
		listeners.add(iBinyaminListener);
	}

	@Override
	public void showWordList(String[] words) {
		VBox vobx = new VBox(TEXT_SPACING);
		for (String string : words) {
			Text t = new Text(string);
			vobx.getChildren().add(t);
		}

		pane.setBottom(vobx);
	}
}
