package binyamin_mvc;

import java.util.ArrayList;

public class BinyaminModel implements IBinyaminRegistrable, IBinyaminModel {

	private ArrayList<IBinyaminListener> listeners = new ArrayList<IBinyaminListener>();

	// private String prefix;

	private String[] wordsDb = { "andrey", "binyamin", "guy", "yuval", "haim",
			"ronen" };

	@Override
	public void registerListener(IBinyaminListener iBinyaminListener) {
		listeners.add(iBinyaminListener);
	}

	@Override
	public void setPrefix(String prefix) {
		ArrayList<String> newList = new ArrayList<String>();
		for (String word : wordsDb) {
			if (word.startsWith(prefix)) {
				newList.add(word);
			}
		}

		String[] wordsDb2 = new String[newList.size()];
		newList.toArray(wordsDb2);

		// update all listeners (if there are any)
		fireWordDbChangedEvent(wordsDb2);
	}

	public void fireWordDbChangedEvent(String[] newDb) {
		System.out.println("model fireWordDbChangedEvent " + newDb.length);
		for (IBinyaminListener listener : listeners) {
			listener.onWordDbChanged(newDb);
		}
	}

}
