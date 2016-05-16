package trabalho2;

public class Transacao {
	
	String nome;
	EstadosEnum estadoAtual;
	
	Transacao(int i) {
		this.nome = "T"+i;
		estadoAtual = EstadosEnum.TR_Iniciada;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null) return false;
		Transacao o = (Transacao) obj; 
		return this.nome.equals(o.nome);
	}

}
