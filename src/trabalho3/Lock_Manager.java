package trabalho3;

import trabalho2.Transacao;

public class Lock_Manager {
	
	// This class will manager the Lock_Table
	private Lock_Table lockTable = new Lock_Table();	
	
	public boolean LS(Transacao Tr, DataItem D) {
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
	
	public boolean LX(Transacao Tr, DataItem D) {
		if (D.isQueueEmpty()) {
			this.lockTable.addLock(Tr, D, "X");
			return true;
		}
		D.pushQueue(Tr,"LX");
		// TODO: Suspende a transação
		return false;		
	};
	
	public void U(Transacao Tr, DataItem D) {
		if(D.isLocked()) {
			this.lockTable.removeLock(Tr, D);			
		}
	};
}
