package trabalho3;

public class DataItem {
	
	public String id;
	public String label;
	public Wait_Q waitQ;
	
	private String lockKind;
	private int currentLockingTr = 0;
	
	DataItem(String pLabel) {
		this.label = pLabel;
	}
	
	public boolean pushQueue(Object item) {
		// TODO: Use queue mehod to push a new item to the queue
		return true;
	}
	
	public Object removeQueue() {
		// TODO: Should return the item in the queue
		
		return true;
	}
	
	public void addLock(String pLockKind) {
		this.lockKind = pLockKind;
		this.currentLockingTr++; 
	}
	
	public void unlock() {
		this.lockKind = "";
		this.currentLockingTr--;
		if(!isQueueEmpty()){
			// TODO: Chama proximo bloqueio [T,LS]
		}
	}
	
	public int getCurrentLockingTr() {
		return this.currentLockingTr;
	}
	
	public boolean isQueueEmpty() {
		return this.waitQ.isEmpty();
	}
	
	public boolean isExclusivelyLock() {
		return this.lockKind == "X";
	}
	
	public boolean isSharedLock() {
		return this.lockKind == "S";
	}
}
