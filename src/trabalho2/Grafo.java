package trabalho2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Grafo {
	
	public static No noRaiz;
	public static No n1;
	public static No n2;
	public static No n3;
	public static No n4;
	public static No n5;
	ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
	
	Grafo() {
		this.noRaiz = new No(EstadosEnum.TR_Iniciada);
		n1 = new No(EstadosEnum.Ativa);
		n2 = new No(EstadosEnum.Processo_Efetivacao);
		n3 = new No(EstadosEnum.Processo_Cancelamento);
		n4 = new No(EstadosEnum.Efetivada);
		n5 = new No(EstadosEnum.TR_Finalizada);
		
		noRaiz.adicionaVizinho(n1);
		n1.adicionaVizinho(n2);
		n1.adicionaVizinho(n3);
		n2.adicionaVizinho(n3);
		n2.adicionaVizinho(n4);
		n3.adicionaVizinho(n5);
		n4.adicionaVizinho(n5);	
	}
	
	public void adicionaTransacao(Transacao newTransacao) {
		
		this.transacoes.add(newTransacao);
		
	}

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		Scanner reader = new Scanner(System.in);
		
		telaInicial(grafo, reader);
		
	}
	
	public static void imprimeTudo(Grafo grafo){
		
		Queue fila = new LinkedList();

		   noRaiz.cor  = true;
		   fila.add(noRaiz);
		   
		   for(Transacao trans : noRaiz.lstTransacoes){
				System.out.println(""+ trans.nome + " = " + trans.estadoAtual +";");
			}
		   
		   while(!fila.isEmpty()){
			   No v = (No) fila.peek();
			   for(No w : noRaiz.lstVizinhos){
				   if(!w.cor){
					   for(Transacao trans : w.lstTransacoes){
							System.out.println(""+ trans.nome + " = " + trans.estadoAtual +";");
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
		   while(fila.isEmpty()){
			   No v = (No) fila.peek();
			   for(No w : noRaiz.lstVizinhos){
				   if(w.cor){
					  fila.add(w);
				   }
			   }
			   v.cor = false;
			   fila.remove(v);
		   }
	}
	
	public static void telaInicial(Grafo grafo, Scanner reader){
		Transacao transacao;
		System.out.println("Escolha a opção desejada:\n"
				+ "1 - TR_Begin\n"
				+ "2 - READ\n"
				+ "3 - WRITE\n"
				+ "4 - TR_Terminate\n"
				+ "5 - TR_Rollback\n"
				+ "6 - TR_Commit\n"
				+ "7 - TR_Finish\n");
		
		int n = reader.nextInt();
		
		switch(n){
			case 1:
				Evento.TR_Begin(grafo);
				
				imprimeTudo(grafo);
				telaInicial(grafo, reader);			
				
			case 2:
				System.out.println("Digite o número da transação desejada.(Ex.: 1 ou 12)\n");
				n = reader.nextInt();
				transacao = new Transacao(n);
				Evento.READ(grafo, transacao);
				imprimeTudo(grafo);
				telaInicial(grafo, reader);
				//Grafo.noRaiz;
			case 3:
				System.out.println("Digite o número da transação desejada.(Ex.: 1 ou 12)\n");
				n = reader.nextInt();
				transacao = new Transacao(n);
				Evento.WRITE(grafo, transacao);
				imprimeTudo(grafo);
				telaInicial(grafo, reader);
			case 4:
				System.out.println("Digite o número da transação desejada.(Ex.: 1 ou 12)\n");
				n = reader.nextInt();
				transacao = new Transacao(n);
				Evento.TR_Terminate(grafo, transacao);
				imprimeTudo(grafo);
				telaInicial(grafo, reader);
			case 5:
				System.out.println("Digite o número da transação desejada.(Ex.: 1 ou 12)\n");
				n = reader.nextInt();
				transacao = new Transacao(n);
				Evento.TR_Rollback(grafo, transacao);
				imprimeTudo(grafo);
				telaInicial(grafo, reader);
			case 6:
				System.out.println("Digite o número da transação desejada.(Ex.: 1 ou 12)\n");
				n = reader.nextInt();
				transacao = new Transacao(n);
				Evento.TR_Commit(grafo, transacao);
				imprimeTudo(grafo);
				telaInicial(grafo, reader);
			case 7:
				System.out.println("Digite o número da transação desejada.(Ex.: 1 ou 12)\n");
				n = reader.nextInt();
				transacao = new Transacao(n);
				Evento.TR_Finish(grafo, transacao);
				imprimeTudo(grafo);
				telaInicial(grafo, reader);
		}
	}

}
