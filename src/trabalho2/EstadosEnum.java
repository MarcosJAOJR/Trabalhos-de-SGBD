package trabalho2;

public enum EstadosEnum {
	TR_Iniciada(1),
	Ativa(2),
	Processo_Cancelamento(3),
	Processo_Efetivacao(4),
	Efetivada(5),
	TR_Finalizada(6);
	
	private final int ordem;
	
	EstadosEnum(int ordemEstado){
		ordem = ordemEstado;
	}
	
	public int getValor(){
		return ordem;
	}
}
