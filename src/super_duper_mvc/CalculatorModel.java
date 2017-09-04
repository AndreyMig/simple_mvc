package super_duper_mvc;

import java.util.ArrayList;

public class CalculatorModel implements ISuperDuperModel,
		ISuperDuperEventEmitter {

	private ArrayList<ISuperDuperListener> listeners = new ArrayList<ISuperDuperListener>();

	private Number a;
	private Number b;
	private Number result;

	@Override
	public void registerListener(ISuperDuperListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void setA(Number a) {
		this.a = a;
		processEvent(ISuperDuperListener.A_WAS_UPDATED, this.a);
	}

	@Override
	public void setB(Number b) {
		this.b = b;
		processEvent(ISuperDuperListener.B_WAS_UPDATED, this.b);
	}

	private void processEvent(String eventName, Number value) {
		for (ISuperDuperListener listener : listeners) {
			listener.update(eventName, value, "Number");
		}
	}

	@Override
	public void calculate() {
		this.result = a.doubleValue() + b.doubleValue();
		processEvent(ISuperDuperListener.CALCULATED, this.result);
	}

}
