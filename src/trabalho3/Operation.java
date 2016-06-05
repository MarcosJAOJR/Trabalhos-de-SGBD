package trabalho3;

import trabalho2.Transacao;

public class Operation {
	
	private String kind;
	private Transacao transaction;
	private DataItem item;
	
	public Operation() {
	}
	
	public Operation(String pKind) {
		this.kind = pKind;
	}
	
	public String getKind() {
		return this.kind;
	}
	
	public void setKind(String pKind) {
		this.kind = pKind;
	}
	
	public Transacao getTransaction() {
		return this.transaction;
	}
	
	public void setTransaction(Transacao pTransacao) {
		this.transaction = pTransacao;
	}
	
	public DataItem getItem() {
		return this.item;
	}
	
	public void setItem(DataItem pItem) {
		this.item = pItem;
	}

}
