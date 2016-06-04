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
				beginTransaction();
				break;
			case TIPO_OPERACAO_COMMIT:
				
				break;
			case TIPO_OPERACAO_WRITE:
				
				break;
			case TIPO_OPERACAO_READ:
				
				break;
			default:
				System.out.println("Operação inválida");
				break;
			}
		}
	}
	
	public void beginTransaction() {
		Evento.TR_Begin(grafo, getTS());
	}
	
	public void commit(Transacao transaction) {
		// TODO: Remover todo tipo de bloqueio que essa transação tenha
		Evento.TR_Terminate(grafo, transaction);
		Evento.TR_Commit(grafo, transaction);
	}
	
	public void read(Transacao transaction, DataItem d) {
		lockManager.LS(transaction, d);
		Evento.READ(grafo, transaction);
	}
	
	public void write(Transacao transaction, DataItem d) {
		lockManager.LX(transaction, d);
		Evento.WRITE(grafo, transaction);
	}
	
}
