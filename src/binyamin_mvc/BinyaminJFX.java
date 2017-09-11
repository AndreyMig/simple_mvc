package binyamin_mvc;

import java.util.ArrayList;

import binyamin_mvc.IBinyaminFinals.MyEnum;
import javafx.scene.control.TextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BinyaminJFX implements IBinyaminRegistrable, IBinyaminView {

	private static final int TEXT_SPACING = 10;

	private MyEnum suffixState = MyEnum.SUFFIX_APPROVED;

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
		
//		suffixState.get

		// HBox

		// pane.setTop(new Label("SEARCH"));

		pane.setTop(searchField);

		Button b = new Button("add suffix");

		b.setOnAction(e -> fireAddTimeStampEvent());

		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000),
				e -> {
					double r = Math.random();
					if (r < 0.1) {
							suffixState = MyEnum.SUFFIX_APPROVED;
					} else if (r < 0.2) {
						suffixState = MyEnum.SUFFIX_CANCELED;
					} else if (r < 0.4) {
						suffixState = MyEnum.SUFFIX_INIT;
					} else if (r < 0.5) {
						suffixState = MyEnum.SUFFIX_PENDING;
					} else if (r < 0.7) {
						suffixState = MyEnum.SUFFIX_LOADED;
					} else if (r < 0.8) {
						suffixState = MyEnum.SUFFIX_CANCELED;
					} else {
						suffixState = MyEnum.SUFFIX_ENDED;
					}

				}));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play(); // Start animation

		pane.setBottom(b);

		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		primaryStage.setAlwaysOnTop(true);
	}

	private void fireAddTimeStampEvent() {

		for (IBinyaminListener iBinyaminListener : listeners) {
			iBinyaminListener
					.addTimeStampClicked("_" + suffixState.getSuffix());
		}
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

		pane.setCenter(vobx);
	}
}
