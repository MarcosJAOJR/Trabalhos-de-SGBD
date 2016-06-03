package trabalho3;

import trabalho2.Grafo;

public class Tr_Manager {
	
	private int TS = 0;
	private Grafo grafo = new Grafo();
	
	// All new transaction must use this method to get it's timestamp
	public int getTS() {
		this.TS += 1;
		
		return this.TS;
	}
	
}
