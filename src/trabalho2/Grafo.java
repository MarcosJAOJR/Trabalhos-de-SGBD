package trabalho2;

import java.util.ArrayList;

public class Grafo {
	
	No noRaiz;
	ArrayList<Transacao> transacoes;
	
	Grafo() {
		this.noRaiz = new No(EstadosEnum.TR_Iniciada);
	}
	
	public void adicionaTransacao(Transacao newTransacao) {
		
		this.transacoes.add(newTransacao);
		
	}

	public static void main(String[] args) {
		

	}

}
