package trabalho3;

import java.util.HashMap;

public class Lock_Table {
	
	private HashMap<String,String> lockTable = new HashMap<String,String>();
    
	public Lock_Table() {
		// Adicionar DataItem
		this.lockTable.put("x","LS");
		this.lockTable.put("y","LX");
		this.lockTable.put("z","U");
	}
	
	public String getLock(String item) {
		return this.lockTable.get(item);
	}
	
	public String addLock(String item, String lock) {
		return this.lockTable.put(item, lock);
	}

}
