package trabalho3;

public class Operation {
	
	private String kind;
	private int transaction;
	private String item;
	
	public Operation(String pKind, int pTransactionl, String pItem) {
		this.kind = pKind;
		this.transaction = pTransactionl;
		this.item = pItem;
	}
	
	public String getKind() {
		return this.kind;
	}
	
	public void setKind(String pKind) {
		this.kind = pKind;
	}
	
	public int getTransaction() {
		return this.transaction;
	}
	
	public void setTransaction(int pTransacao) {
		this.transaction = pTransacao;
	}
	
	public String getItem() {
		return this.item;
	}
	
	public void setItem(String pItem) {
		this.item = pItem;
	}

}
