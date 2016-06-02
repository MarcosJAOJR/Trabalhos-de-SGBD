package trabalho3;

import trabalho2.Transacao;

public class Wait_Q_Item {
	
	public Transacao transaction;
	public String lockType;
	
	public Wait_Q_Item(Transacao pTransaction, String pLockType) {
		this.transaction = pTransaction;
		this.lockType = pLockType;
	}
}
