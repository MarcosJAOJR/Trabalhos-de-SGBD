package trabalho2;

public class Transacao {
	
	int TS;
	String nome;
	EstadosEnum estadoAtual;
	
	public Transacao(int i, int timestamp) {
		this.nome = "T"+i;
		this.TS = timestamp;
		estadoAtual = EstadosEnum.TR_Iniciada;
	}
	
	public int getTimestamp() {
		return this.TS;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null) return false;
		Transacao o = (Transacao) obj; 
		return this.nome.equals(o.nome);
	}

}
