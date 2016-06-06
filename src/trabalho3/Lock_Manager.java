package trabalho3;

import java.util.HashMap;

import trabalho2.Transacao;

public class Lock_Manager {
	
	private HashMap<String, DataItem> activeItens = new HashMap<String, DataItem>();
	
	// This class will manager the Lock_Table
	private Lock_Table lockTable = new Lock_Table();	
	
	public boolean LS(Transacao Tr, String itemId) {
		DataItem D = getDataItem(itemId);
		if (D.isQueueEmpty()) {
			if(!D.isExclusivelyLock()) {
				lockTable.addLock(Tr, D, "S");
				return true;
			}			
		}
		D.pushQueue(Tr,"LS");
		// TODO: Suspende a transação
		return false;
	};
	
	public boolean LX(Transacao Tr, String itemId) {
		DataItem D = getDataItem(itemId);
		if (D.isQueueEmpty()) {
			this.lockTable.addLock(Tr, D, "X");
			return true;
		}
		D.pushQueue(Tr,"LX");
		// TODO: Suspende a transação
		return false;		
	};
	
	public void U(Transacao Tr, String itemId) {
		DataItem D = getDataItem(itemId);
		if(D.isLocked()) {
			this.lockTable.removeLock(Tr, D);
			if(!D.isQueueEmpty()){
				// Chama proximo bloqueio [T,LS]
				Wait_Q_Item nextTrLock = D.getNextTransaction();
				lockTable.addLock(nextTrLock.transaction, D, nextTrLock.lockType);
			}
			else
				if(D.getCurrentLockingTr() == 0)
					activeItens.remove(itemId);
		}
	};
	
	public DataItem getDataItem(String itemId) {
		
		if(activeItens.get(itemId) == null)
			activeItens.put(itemId, new DataItem(itemId));
			
		return activeItens.get(itemId); 
		
	}
}
