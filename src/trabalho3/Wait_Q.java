package trabalho3;

import java.util.LinkedList;

import trabalho2.Transacao;

public class Wait_Q {
	
	private LinkedList<Transacao> queue;
	
	Wait_Q() {
		this.queue = new LinkedList<Transacao>();
	}
	
	public boolean add(Transacao newTransaction) {
		
		return this.queue.add(newTransaction);
	}
	
	public Transacao remove() {
		return this.queue.removeFirst();
	}

}
