package trabalho3;

public class DataItem {
	
	public String label;
	public String id;
	public Object value;
	public Wait_Q waitQ;
	
	DataItem(String pLabel, Object pValue) {
		this.label = pLabel;
		this.value = pValue;
	}
	
	public boolean pushQueue(Object item) {
		// TODO: Use queue mehod to push a new item to the queue
		return true;
	}
	
	public Object removeQueue() {
		// TODO: Should return the item in the queue
		
		return true;
	}
}
