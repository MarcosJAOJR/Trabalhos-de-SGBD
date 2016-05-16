package trabalho2;

public abstract class Evento {
	
	public static void TR_Begin(Grafo grafo) {
		
		Transacao newTransacao = new Transacao(grafo.transacoes.size());
		
		grafo.adicionaTransacao(newTransacao);
		
		No noDestino = buscarNo(grafo.noRaiz, EstadosEnum.TR_Iniciada);
		noDestino.adicionaTransacao(newTransacao);
		
	}
	
	public static boolean READ(Grafo grafo, Transacao pTransacao) {
		
		No noOrigem;
		No noDestino = buscarNo(grafo.noRaiz, EstadosEnum.Ativa);
		
		if(pTransacao.estadoAtual == EstadosEnum.TR_Iniciada) {
			noOrigem = buscarNo(grafo.noRaiz, EstadosEnum.TR_Iniciada);
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}
		
		if(pTransacao.estadoAtual == EstadosEnum.Ativa) {
			noOrigem = buscarNo(grafo.noRaiz, EstadosEnum.Ativa);
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}
		
		return false;
		
	}
	
	public static boolean WRITE(Grafo grafo, Transacao pTransacao) {
		
		No noOrigem;
		No noDestino = buscarNo(grafo.noRaiz, EstadosEnum.Ativa);
		
		if(pTransacao.estadoAtual == EstadosEnum.TR_Iniciada) {
			noOrigem = buscarNo(grafo.noRaiz, EstadosEnum.TR_Iniciada);
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}
		
		if(pTransacao.estadoAtual == EstadosEnum.Ativa) {
			noOrigem = buscarNo(grafo.noRaiz, EstadosEnum.Ativa);
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}
		
		return false;
		
	}
	
	public static boolean TR_Terminate(Grafo grafo, Transacao pTransacao) {
		
		No noOrigem;
		No noDestino = buscarNo(grafo.noRaiz, EstadosEnum.Processo_Efetivacao);
		
		if(pTransacao.estadoAtual == EstadosEnum.Ativa) {
			noOrigem = buscarNo(grafo.noRaiz, EstadosEnum.Ativa);
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}
		
		return false;
		
	}
	
	public static boolean TR_Rollback(Grafo grafo, Transacao pTransacao) {
		
		No noOrigem;
		No noDestino = buscarNo(grafo.noRaiz, EstadosEnum.Processo_Cancelamento);
		
		if(pTransacao.estadoAtual == EstadosEnum.Ativa) {
			noOrigem = buscarNo(grafo.noRaiz, EstadosEnum.Ativa);
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}

		if(pTransacao.estadoAtual == EstadosEnum.Processo_Efetivacao) {
			noOrigem = buscarNo(grafo.noRaiz, EstadosEnum.Processo_Efetivacao);
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}
		
		return false;
		
	}
	
	public static boolean TR_Commit(Grafo grafo, Transacao pTransacao) {
		
		No noOrigem;
		No noDestino = buscarNo(grafo.noRaiz, EstadosEnum.Efetivada);

		if(pTransacao.estadoAtual == EstadosEnum.Processo_Efetivacao) {
			noOrigem = buscarNo(grafo.noRaiz, EstadosEnum.Processo_Efetivacao);
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}
		
		return false;
		
	}
	
	public static boolean TR_Finish(Grafo grafo, Transacao pTransacao) {
		
		No noOrigem;
		No noDestino = buscarNo(grafo.noRaiz, EstadosEnum.TR_Finalizada);
		
		if(pTransacao.estadoAtual == EstadosEnum.Processo_Efetivacao) {
			noOrigem = buscarNo(grafo.noRaiz, EstadosEnum.Processo_Efetivacao);
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}
		
		if(pTransacao.estadoAtual == EstadosEnum.Efetivada) {
			noOrigem = buscarNo(grafo.noRaiz, EstadosEnum.Efetivada);
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}
		
		return false;
		
	}
	
	private static No buscarNo(No noRaiz, EstadosEnum estadoDesejado) {
		
		No retorno = new No(estadoDesejado);
		
		// TODO: Se achou o nó desejado, retorna ele
		
		
		return retorno;
	}

}
