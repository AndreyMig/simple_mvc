package binyamin_mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BinyaminController implements IBinyaminListener {

	private ArrayList<IBinyaminView> views = new ArrayList<IBinyaminView>();
	private IBinyaminModel model;

	// private IBinyaminModel model;
	public void setModel(IBinyaminModel model) {
		this.model = model;
		registerIfPossible(this.model);
	}

	public void registerIfPossible(Object o) {
		if (o instanceof IBinyaminRegistrable) {
			IBinyaminRegistrable registrable = (IBinyaminRegistrable) o;
			registrable.registerListener(this);
		}

	}

	public void addView(IBinyaminView view) {
		this.views.add(view);
		registerIfPossible(view);
	}

	@Override
	public void onSearchChanged(String prefix) {
		System.out.println("controller onSearchChanged");
		this.model.setPrefix(prefix);

	}

	@Override
	public void onWordDbChanged(String[] newDb) {

		for (IBinyaminView view : views) {
			view.showWordList(newDb);
		}

	}

}
