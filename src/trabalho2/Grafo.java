package trabalho2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo {
	
	public No noRaiz;
	public ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
	
	public Grafo() {
		this.noRaiz = new No(EstadosEnum.TR_Iniciada);
	}
	
	public void adicionaTransacao(Transacao newTransacao) {
		
		this.transacoes.add(newTransacao);
		
	}
	
	public void imprimeTudo(){
		
		LinkedList<No> fila = new LinkedList<No>();

		   this.noRaiz.cor  = true;
		   fila.add(this.noRaiz);
		   
		   for(Transacao trans : this.noRaiz.lstTransacoes){
				System.out.println(""+ trans.nome + " = " + trans.estadoAtual +";");
			}
		   
		   while(!fila.isEmpty()){
			   No v = (No) fila.peek();
			   for(No w : v.lstVizinhos){
				   if(!w.cor){
					   for(Transacao trans : w.lstTransacoes){
							System.out.println(""+ trans.nome + " = " + trans.estadoAtual +";");
							w.cor = true;
						}
					   fila.add(w);
				   }
			   }
			   v.cor = true;
			   fila.remove(v);
		   }
		   inicializarCor(noRaiz);
	}
	
	public static void inicializarCor(No noRaiz){
		LinkedList<No> fila = new LinkedList<No>();

		   noRaiz.cor  = false;
		   fila.add(noRaiz);
		   while(!fila.isEmpty()){
			   No v = (No) fila.peek();
			   for(No w : v.lstVizinhos){
				   if(w.cor){
					  fila.add(w);
				   }
			   }
			   v.cor = false;
			   fila.remove(v);
		   }
	}

}
