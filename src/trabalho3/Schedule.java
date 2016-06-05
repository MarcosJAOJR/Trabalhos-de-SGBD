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
		
		// Mockup
		
		LinkedList<Operation> result = new LinkedList<Operation>();
		result.add(new Operation("BT",1,null));
		result.add(new Operation("r",1,"x"));
		result.add(new Operation("BT",2,null));
		result.add(new Operation("w",2,"x"));
		result.add(new Operation("r",2,"y"));
		result.add(new Operation("r",1,"y"));
		result.add(new Operation("C",1,null));
		result.add(new Operation("r",2,"z"));
		result.add(new Operation("C",2,null));
		
		return result;
	}
}
