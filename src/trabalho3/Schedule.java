package trabalho3;

import java.util.LinkedList;
import java.util.regex.Pattern;

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
		/*String[] operations = schedule.replace(")",")#").split("#");
		for (String item : operations) {
			String kind = "";
			int transaction = 0;
			String dataItem = null;
			
			String parenthesesValue = item.split("[\\(\\)]")[1];
			if (Character.isDigit(parenthesesValue.toCharArray()[0])) {
				kind = item.split("\\(")[0];
				transaction = Integer.parseInt(parenthesesValue);
				dataItem = null;
			}
			else {
				String outter = item.split("\\(")[0];
				kind = outter.substring(-1);
				dataItem = parenthesesValue;
			}
			
			Operation op = new Operation(kind,transaction,dataItem);
			result.add(op);
		}*/
		
		// Mockup
		
		LinkedList<Operation> result = new LinkedList<Operation>();
		result.add(new Operation("BT",1,null));
		result.add(new Operation("BT",2,null));
		result.add(new Operation("BT",3,null));
		result.add(new Operation("w",2,"x"));
		result.add(new Operation("w",2,"y"));
		result.add(new Operation("w",3,"x"));
		result.add(new Operation("w",1,"y"));
		result.add(new Operation("C",2,null));
		result.add(new Operation("C",1,null));
		result.add(new Operation("C",3,null));
		
		return result;
	}
}
