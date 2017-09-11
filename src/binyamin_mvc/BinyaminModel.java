package binyamin_mvc;

import java.util.ArrayList;

public class BinyaminModel implements IBinyaminRegistrable, IBinyaminModel {

	private ArrayList<IBinyaminListener> listeners = new ArrayList<IBinyaminListener>();

	// private String prefix;

	private String[] wordsDb = { "andrey", "binyamin", "guy", "yuval", "haim",
			"ronen" };

	private String prefix = "";

	@Override
	public void registerListener(IBinyaminListener iBinyaminListener) {
		listeners.add(iBinyaminListener);
	}

	@Override
	public void setPrefix(String prefix) {
		this.prefix = prefix;
		// update all listeners (if there are any)
		fireWordDbChangedEvent(filterDb());
	}

	private String[] filterDb() {
		ArrayList<String> newList = new ArrayList<String>();
		for (String word : wordsDb) {
			if (word.startsWith(this.prefix)) {
				newList.add(word);
			}
		}

		String[] wordsDb2 = new String[newList.size()];
		newList.toArray(wordsDb2);

		return wordsDb2;
	}

	public void fireWordDbChangedEvent(String[] newDb) {
		System.out.println("model fireWordDbChangedEvent " + newDb.length);
		for (IBinyaminListener listener : listeners) {
			listener.onWordDbChanged(newDb);
		}
	}

	@Override
	public void addSuffix(String string) {
		ArrayList<String> newList = new ArrayList<String>();
		String[] filtered = filterDb();
		for (String word : filtered) {
			newList.add(word + string);
		}
		String[] wordsDb2 = new String[newList.size()];
		newList.toArray(wordsDb2);
		fireWordDbChangedEvent(wordsDb2);
	}

}
