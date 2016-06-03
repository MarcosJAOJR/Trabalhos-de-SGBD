package trabalho3;

import java.util.LinkedList;

public class Schedule {
	
	LinkedList<Operation> operations;
	
	Schedule(String schedule) {
		this.operations = this.parser(schedule);
	}
	
	public LinkedList<Operation> parser(String schedule) {
		
		// TODO: Converter uma string em uma fila de comandos e retornar
		
		/*
		 *Variações possíveis:
		 *  - BT(1): Iniciar transação 1
		 *  - r1(x): Ler transação 1
		 *  - w1(x): Escrever transação 1
		 *  - C(1): Commitar transação 1
		 * */
		
		return new LinkedList<Operation>();
	}
}
