package trabalho3;

import java.util.LinkedList;

import trabalho2.Transacao;

public class Wait_Q {
	
	private LinkedList<Wait_Q_Item> queue;
	
	Wait_Q() {
		this.queue = new LinkedList<Wait_Q_Item>();
	}
	
	public void add(Transacao newTransaction, String lockType) {
		Wait_Q_Item item = new Wait_Q_Item(newTransaction, lockType);
		this.queue.add(item);
	}
	
	public void add(Wait_Q_Item item) {
		this.queue.add(item);
	}
	
	public Wait_Q_Item remove() {
		return this.queue.removeFirst();
	}
	
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

}
