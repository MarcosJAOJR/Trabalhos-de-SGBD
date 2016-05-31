package trabalho3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map.Entry;

import trabalho2.Transacao;

public class Lock_Manager {
	
	public ArrayList<ArrayList<Entry<DataItem,String>>> Lock_Table; // a posição 0 é relativa a T0, 1 -> T1 ... 
	public ArrayList<LinkedList<Entry<Transacao,String>>> Wait_Q; // a posição 0 é relativa a P0, 1 -> P1 ...
	
	public void LS(Transacao Tr, Object D) {
		
	};
	
	public void LX(Transacao Tr, Object D) {
		
	};
	
	public void U(Transacao Tr, Object D) {
		
	};
}
