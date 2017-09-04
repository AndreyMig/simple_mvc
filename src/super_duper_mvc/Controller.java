package super_duper_mvc;

import java.util.ArrayList;

public class Controller implements ISuperDuperListener {

	private ArrayList<ISuperDuperView> views = new ArrayList<ISuperDuperView>();
	private ISuperDuperModel model;

	public Controller(ISuperDuperModel model) {
		this.model = model;
		registerEventsWhenPossible(model);
	}

	public void addView(ISuperDuperView view) {

		this.views.add(view);

		registerEventsWhenPossible(view);

	}

	private boolean registerEventsWhenPossible(Object o) {

		if (o instanceof ISuperDuperEventEmitter) {
			ISuperDuperEventEmitter eventEmitter = (ISuperDuperEventEmitter) o;
			eventEmitter.registerListener(this);
			return true;
		}
		return false;

	}

	@Override
	public void update(String eventName, Object data, String className) {
		System.out.println("event " + eventName + " was called ");

		switch (className.toLowerCase()) {
		case "number":
			Number n = (Number) data;
			updateViews(n);
			break;

		default:
			break;
		}

	}

	private void updateViews(Number n) {
		for (ISuperDuperView v : views) {
			v.showResult(n);
		}

	}

}
