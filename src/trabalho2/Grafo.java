package trabalho2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Grafo {
	
	public No noRaiz;
	static ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
	
	Grafo() {
		this.noRaiz = new No(EstadosEnum.TR_Iniciada);
	}
	
	public void adicionaTransacao(Transacao newTransacao) {
		
		this.transacoes.add(newTransacao);
		
	}

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		Scanner reader = new Scanner(System.in);
		
		telaInicial(grafo, reader);
		
	}
	
	public void imprimeTudo(){
		
		Queue fila = new LinkedList();

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
		Queue fila = new LinkedList();

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
	
	public static void telaInicial(Grafo grafo, Scanner reader){
		Transacao transacao = new Transacao(0);
		System.out.println("\n---------------------------");
		System.out.println("Escolha a opção desejada:\n"
				+ "1 - TR_Begin\n"
				+ "2 - READ\n"
				+ "3 - WRITE\n"
				+ "4 - TR_Terminate\n"
				+ "5 - TR_Rollback\n"
				+ "6 - TR_Commit\n"
				+ "7 - TR_Finish\n");
		
		int n = reader.nextInt();
		
		if(n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7) {
			
			System.out.println("Digite o número da transação desejada.(Ex.: 0 ou 1 ou 2 ou ...)\n");
			int nTransacao = reader.nextInt();
			
			if(nTransacao >= transacoes.size())
				n = 0;
			else
				transacao = transacoes.get(nTransacao);
		}
		
		switch(n){
			case 1:
				Evento.TR_Begin(grafo);
				grafo.imprimeTudo();
				telaInicial(grafo, reader);
			case 2:
				Evento.READ(grafo, transacao);
				grafo.imprimeTudo();
				telaInicial(grafo, reader);
			case 3:
				Evento.WRITE(grafo, transacao);
				grafo.imprimeTudo();
				telaInicial(grafo, reader);
			case 4:
				Evento.TR_Terminate(grafo, transacao);
				grafo.imprimeTudo();
				telaInicial(grafo, reader);
			case 5:
				Evento.TR_Rollback(grafo, transacao);
				grafo.imprimeTudo();
				telaInicial(grafo, reader);
			case 6:
				Evento.TR_Commit(grafo, transacao);
				grafo.imprimeTudo();
				telaInicial(grafo, reader);
			case 7:
				Evento.TR_Finish(grafo, transacao);
				grafo.imprimeTudo();
				telaInicial(grafo, reader);
			default:
				System.out.println("> Opção ou transação inválida\n");
				telaInicial(grafo, reader);
				
		}
		
	}

}
