package super_duper_mvc;

public interface ISuperDuperListener {

	public final String A_WAS_UPDATED = "A_WAS_UPDATED";
	public final String B_WAS_UPDATED = "B_WAS_UPDATED";
	public final String CALCULATED = "CALCULATED";

	void update(String eventName, Object data, String className);

//	void aValueChanged(Object value,  String className);
	
}
