package trabalho2;

import java.util.LinkedList;

public abstract class Evento {
	
	public static void TR_Begin(Grafo grafo) {
		
		Transacao newTransacao = new Transacao(grafo.transacoes.size());
		
		grafo.adicionaTransacao(newTransacao);
		
		grafo.noRaiz.adicionaTransacao(newTransacao);
		
	}
	
	public static boolean READ(Grafo grafo, Transacao pTransacao) {
		
		No noOrigem;
		No noDestino = buscarNo(grafo.noRaiz, EstadosEnum.Ativa);
		
		if(pTransacao.estadoAtual == EstadosEnum.TR_Iniciada) {
			noOrigem = grafo.noRaiz;
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}
		
		if(pTransacao.estadoAtual == EstadosEnum.Ativa) {
			return true;
		}
		
		return false;
		
	}
	
	public static boolean WRITE(Grafo grafo, Transacao pTransacao) {
		
		No noOrigem;
		No noDestino = buscarNo(grafo.noRaiz, EstadosEnum.Ativa);
		
		if(pTransacao.estadoAtual == EstadosEnum.TR_Iniciada) {
			noOrigem = grafo.noRaiz;
			noOrigem.transferirTransacao(noDestino, pTransacao);
			return true;
		}
		
		if(pTransacao.estadoAtual == EstadosEnum.Ativa) {
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
		
		if(pTransacao.estadoAtual == EstadosEnum.Processo_Cancelamento) {
			noOrigem = buscarNo(grafo.noRaiz, EstadosEnum.Processo_Cancelamento);
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
		
		No retorno = null;
		LinkedList<No> fila = new LinkedList<No>();

		   noRaiz.cor  = true;
		   fila.add(noRaiz);
		   while(!fila.isEmpty()){
			   No v = (No) fila.peek();
			   for(No w : v.lstVizinhos){
				   if(w.ordemEstado == estadoDesejado){
					   retorno = w;
				   } else if(!w.cor){
					   fila.add(w);
				   }
			   }
			   v.cor = true;
			   fila.remove(v);
		   }
		   
		Grafo.inicializarCor(noRaiz);
		
		if(retorno == null)
			retorno = new No(estadoDesejado);
		   
		return retorno;
	}

}
