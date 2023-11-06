package Atividade;

public interface Lista {

	public void addFinal(int e) throws SemEspacoVazioException;
	
	public void addInicio(int e) throws SemEspacoVazioException;
	
	public void addIndice(int e, int i) throws IndiceNaoExistenteException, SemEspacoVazioException;
	
	public int removerFinal() throws ListaVaziaException;
	
	public int removerInicio() throws ListaVaziaException;
	
	public int removerIndice(int i) throws IndiceNaoExistenteException, ListaVaziaException;
	
	public boolean isVazia();
	
	public boolean isCheia();
	
	public void imprimir();
	
	public int quantidade();
	
}
