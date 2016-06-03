package components;

import java.util.Scanner;

import trabalho2.Evento;
import trabalho2.Grafo;
import trabalho2.Transacao;

public class Tela_Inicial {

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		Scanner reader = new Scanner(System.in);
		
		telaInicial(grafo, reader);

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
			
			if(nTransacao >= grafo.transacoes.size())
				n = 0;
			else
				transacao = grafo.transacoes.get(nTransacao);
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
