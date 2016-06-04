package trabalho3;

import java.util.LinkedList;

import trabalho2.Transacao;

public class Wait_Q {
	
	private LinkedList<Wait_Q_Item> queue;
	
	Wait_Q() {
		this.queue = new LinkedList<Wait_Q_Item>();
	}
	
	public boolean add(Transacao newTransaction, String lockType) {
		Wait_Q_Item item = new Wait_Q_Item(newTransaction, lockType);
		return this.queue.add(item);
	}
	
	public boolean add(Wait_Q_Item item) {
		return this.queue.add(item);
	}
	
	public Wait_Q_Item remove() {
		return this.queue.removeFirst();
	}
	
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

}
