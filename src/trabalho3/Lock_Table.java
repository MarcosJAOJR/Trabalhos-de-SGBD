package trabalho3;

import java.util.HashMap;
import java.util.Map.Entry;

import trabalho2.Transacao;

public class Lock_Table {
	
	private HashMap<Transacao,HashMap<DataItem,String>> lockTable = new HashMap<Transacao,HashMap<DataItem, String>>();
	
	public String getLock(DataItem item) {
		for (Entry<Transacao, HashMap<DataItem, String>> entry : this.lockTable.entrySet()) {
			if(entry.getValue().containsKey(item))
				return entry.getValue().get(item);
			
		}
		
		return null;
	}
	
	public String addLock(Transacao transaction, DataItem item, String lock) {
		HashMap<DataItem,String> transactionLocks = this.lockTable.get(transaction);
		return transactionLocks.put(item, lock);
	}

}
