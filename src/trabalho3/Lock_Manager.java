package trabalho3;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

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
		// TODO: Só entra na fila se o timestamp de Tr for maior que o da transação bloqueante
		// TODO: E se várias transações estiverem exercendo bloqueios compartilhados sobre o msm item?
		
		D.pushQueue(Tr,"LS");
		// TODO: Suspende a transação
		return false;
	};
	
	public boolean LX(Transacao Tr, String itemId) {
		DataItem D = getDataItem(itemId);
		if (!D.isLocked() && D.isQueueEmpty()) {
			this.lockTable.addLock(Tr, D, "X");
			return true;
		}
		// TODO: Só entra na fila se o timestamp de Tr for maior que o da transação bloqueante
		// TODO: E se várias transações estiverem exercendo bloqueios compartilhados sobre o msm item?
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
				lockTable.addLock(nextTrLock.transaction, D, nextTrLock.lockType.substring(1));
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
		
	};
	
	public void unlockAll(Transacao transaction) {
		Set<Entry<DataItem, String>> listItens = lockTable.getAllLocksByTransaction(transaction);
		while (listItens.iterator().hasNext()) {
			Entry<DataItem, String> item = listItens.iterator().next();
			U(transaction, item.getKey().id);
		}
	};
}
