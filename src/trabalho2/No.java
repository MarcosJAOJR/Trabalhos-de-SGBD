package trabalho2;

import java.util.ArrayList;

public class No {
	
	ArrayList<Transacao> lstTransacoes;
	EstadosEnum ordemEstado;
	ArrayList<No> lstVizinhos;
	
	No(EstadosEnum estado) {
		this.ordemEstado = estado;
	}
	
	public void adicionaVizinho(No newNo) {
		
		this.lstVizinhos.add(newNo);
		
	}
	
	public void adicionaTransacao(Transacao newTransacao) {
		
		this.lstTransacoes.add(newTransacao);
		
		// Atualiza estado da transação
		newTransacao.estadoAtual = this.ordemEstado;		
	}
	
	public void removeTransacao(Transacao oldTransacao) {
		
		this.lstTransacoes.remove(oldTransacao);
		
		// Atualiza estado da transação
		oldTransacao.estadoAtual = null;
	}
	
	public void transferirTransacao(No noDestino, Transacao pTransacao) {
		
		this.removeTransacao(pTransacao);
		noDestino.adicionaTransacao(pTransacao);
		
		// Atualiza estado da transação
		pTransacao.estadoAtual = noDestino.ordemEstado;
		
		// Atualiza nó atual
		if(!this.lstVizinhos.contains(noDestino))
			this.adicionaVizinho(noDestino);
	}

}
