package trabalho3;

import java.util.LinkedList;

import trabalho2.Evento;
import trabalho2.Grafo;
import trabalho2.Transacao;

public class Tr_Manager {
	
	static final String TIPO_OPERACAO_BEGIN = "BT";
	static final String TIPO_OPERACAO_COMMIT = "C";
	static final String TIPO_OPERACAO_WRITE = "w";
	static final String TIPO_OPERACAO_READ = "r";
	
	private int TS = 0;
	private Grafo grafo = new Grafo();
	private Lock_Manager lockManager = new Lock_Manager();
	
	public void init(String operations) {
		
		Schedule schedule = new Schedule(operations);
		executeOperations(schedule.operations);
		
	}
	
	// All new transaction must use this method to get it's timestamp
	public int getTS() {
		this.TS += 1;
		
		return this.TS;
	}
	
	private void executeOperations(LinkedList<Operation> operations) {
		for (Operation operation : operations) {
			switch (operation.getKind()) {
			case TIPO_OPERACAO_BEGIN:
				beginTransaction(operation.getTransaction());
				break;
			case TIPO_OPERACAO_COMMIT:
				commit(operation.getTransaction());
				break;
			case TIPO_OPERACAO_WRITE:
				write(operation.getTransaction(), operation.getItem());
				break;
			case TIPO_OPERACAO_READ:
				read(operation.getTransaction(), operation.getItem());
				break;
			default:
				System.out.println("Operação inválida");
				break;
			}
			grafo.imprimeTudo();
			System.out.println("-----------------------");
		}
	}
	
	public void beginTransaction(int transactionId) {
		Evento.TR_Begin(grafo, transactionId, getTS());
	}
	
	public void commit(int transactionId) {
		if(grafo.transacoes.get(transactionId) != null) {
			Transacao transaction = grafo.transacoes.get(transactionId);
			// TODO: Remover todo tipo de bloqueio que essa transação tenha
			lockManager.unlockAll(transaction);
			Evento.TR_Terminate(grafo, transaction);
			Evento.TR_Commit(grafo, transaction);
		}
		else
			System.out.println("Transação inválida");
		}
	
	public void read(int transactionId, String itemId) {
		if(grafo.transacoes.get(transactionId) != null) {
			Transacao transaction = grafo.transacoes.get(transactionId);
			lockManager.LS(transaction, itemId);
			Evento.READ(grafo, transaction);
			// lockManager.U(transaction, itemId);
		}
		else
			System.out.println("Transação inválida");
	}
	
	public void write(int transactionId, String itemId) {
		if(grafo.transacoes.get(transactionId) != null) {
			Transacao transaction = grafo.transacoes.get(transactionId); 
			lockManager.LX(transaction, itemId);
			Evento.WRITE(grafo, transaction);
			// lockManager.U(transaction, itemId);
		}
		else
			System.out.println("Transação inválida");
	}
	
	public void rollback(Transacao transaction) {
		Evento.TR_Rollback(grafo, transaction);
		lockManager.unlockAll(transaction);
	}
	
}
