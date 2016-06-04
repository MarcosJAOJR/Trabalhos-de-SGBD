package trabalho3;

import java.util.HashMap;
import java.util.Map.Entry;

import trabalho2.Transacao;

public class Lock_Table {
	
	private HashMap<Transacao,HashMap<DataItem,String>> lockTable = new HashMap<Transacao,HashMap<DataItem, String>>();
	
	public String getLock(DataItem item) {
		return this.getTransactionsLocksByItem(item).get(item);
	}
	
	public String addLock(Transacao transaction, DataItem item, String lock) {
		HashMap<DataItem,String> transactionsItensLocked = this.lockTable.get(transaction);
		item.lock(lock);
		return transactionsItensLocked.put(item, lock);
	}
	
	public String removeLock(Transacao transaction, DataItem item) {
		item.unlock();
		return this.getTransactionsLocksByItem(item).remove(item);
	}
	
	private HashMap<DataItem, String> getTransactionsLocksByItem(DataItem item) {
		for (Entry<Transacao, HashMap<DataItem, String>> entry : this.lockTable.entrySet())
			if(entry.getValue().containsKey(item))
				return entry.getValue();
		
		return null;
	}

}
