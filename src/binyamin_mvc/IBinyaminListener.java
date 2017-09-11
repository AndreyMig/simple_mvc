package binyamin_mvc;

import java.util.ArrayList;

import javafx.event.ActionEvent;

public interface IBinyaminListener {

	
	void onSearchChanged(String prefix);

	void onWordDbChanged(String[] newDb);

	void addTimeStampClicked(String string);
	
//	void onListOfWordsChanged(ArrayList<String> word);
	
}
