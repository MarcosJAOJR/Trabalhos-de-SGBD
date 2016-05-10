package trabalho2;

public class Transacao {
	
	String nome;
	EstadosEnum estadoAtual;
	
	Transacao(int i) {
		this.nome = "T"+i;
		estadoAtual = EstadosEnum.TR_Iniciada;
	}	

}
