package trabalho3;

import trabalho2.Transacao;

public class DataItem {
	
	public String id;
	public String label;
	
	private Wait_Q waitQ = new Wait_Q();
	private String lockKind = "";
	private int currentLockingTr = 0;
	
	DataItem(String pId) {
		this.id = pId;
	}
	
	public boolean pushQueue(Transacao newTransaction, String lockType) {
		this.waitQ.add(newTransaction, lockType);
		return true;
	}
	
	public Wait_Q_Item getNextTransaction() {
		return this.waitQ.remove();
	}
	
	public void lock(String pLockKind) {
		this.lockKind = pLockKind;
		this.currentLockingTr++; 
	}
	
	public void unlock() {
		this.lockKind = "";
		this.currentLockingTr--;
	}
	
	public int getCurrentLockingTr() {
		return this.currentLockingTr;
	}
	
	public boolean isQueueEmpty() {
		return this.waitQ.isEmpty();
	}
	
	public boolean isLocked() {
		return this.lockKind != "";
	}
	
	public boolean isExclusivelyLock() {
		return this.lockKind == "X";
	}
	
	public boolean isSharedLock() {
		return this.lockKind == "S";
	}
}
