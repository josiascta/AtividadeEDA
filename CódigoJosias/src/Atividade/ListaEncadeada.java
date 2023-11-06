package Atividade;

public class ListaEncadeada implements Lista {

	private TipoNo inicio;
	private int quantidade;
	private TipoNo cabeca;

	public ListaEncadeada() {
		this.cabeca = new TipoNo(-99);
		this.inicio = cabeca;
	}

	public void addFinal(int e) {
		TipoNo novo = new TipoNo(e);

		TipoNo aux = inicio;
		while (aux.proximo != null) {
			aux = aux.proximo;
		}

		aux.proximo = novo;
		quantidade++;
	}

	public void addInicio(int e) {
		TipoNo novo = new TipoNo(e);
		novo.proximo = inicio.proximo; 
		inicio.proximo = novo;
		quantidade++;
	}

	public void addIndice(int e, int i) throws IndiceNaoExistenteException {
		TipoNo novo = new TipoNo(e);

		TipoNo aux = inicio;
		for (int j = 0; j < i; j++) {
			aux = aux.proximo;
		}

		novo.proximo = aux.proximo;
		aux.proximo = novo;
		quantidade++;
	}

	public int removerFinal() throws ListaVaziaException {
		if (inicio.proximo == null) {
			throw new ListaVaziaException();
		}

		TipoNo aux = inicio;
		while (aux.proximo.proximo != null) {
			aux = aux.proximo;
		}

		int lixo = aux.proximo.dado;
		aux.proximo = null;
		quantidade--;
		return lixo;
	}

	public int removerInicio() throws ListaVaziaException {
		if (inicio.proximo == null) {
			throw new ListaVaziaException();
		}

		TipoNo lixo = inicio.proximo;
		inicio.proximo = lixo.proximo;
		lixo.proximo = null;
		quantidade--;
		return lixo.dado;
	}

	public int removerIndice(int i) throws IndiceNaoExistenteException, ListaVaziaException {
		if (isVazia()) {
			throw new ListaVaziaException();
		}

		if (i < 0 || i >= quantidade) {
			throw new IndiceNaoExistenteException();
		}

		if (i == 0) {
			return removerInicio();
		} else {
			TipoNo aux = inicio;
			for (int j = 0; j < i; j++) {
				aux = aux.proximo;
			}

			TipoNo lixo = aux.proximo;
			aux.proximo = lixo.proximo;
			lixo.proximo = null;
			quantidade--;
			return lixo.dado;
		}
	}

	public boolean isVazia() {
		return inicio.proximo == null;
	}

	public boolean isCheia() {
		return false;
	}

	public void imprimir() {
		System.out.print("Início -> ");
		TipoNo aux = inicio.proximo;

		while (aux != null) {
			System.out.print(aux.dado + " -> ");
			aux = aux.proximo;
		}
		System.out.print("Fim.");
	}

	public int quantidade() {
		return quantidade;
	}

	public static void main(String[] args) throws Exception {
		// [20, 60, 3, 13, 28, 32]

		ListaEncadeada lista = new ListaEncadeada();

		System.out.println("-----Adicionando valores na lista-----");
		lista.addFinal(20); // 20
		lista.addInicio(60); // 60 -> 20
		lista.addFinal(3); // 60 -> 20 -> 3
		lista.addFinal(13); // 60 -> 20 -> 3 -> 13
		lista.addFinal(28); // 60 -> 20 -> 3 -> 13 -> 28
		lista.addIndice(32, 5); // 60 -> 20 -> 3 -> 13 -> 28 -> 32
		lista.imprimir();
		System.out.println();

		System.out.println("-----Removendo valores na lista-----");
		lista.removerIndice(0); // 20 -> 3 -> 13 -> 28 -> 32
		lista.removerIndice(2); // 20 -> 3 -> 28 -> 32
		lista.removerInicio(); // 3 -> 28 -> 32
		lista.removerFinal(); // 3 -> 28
		lista.imprimir();

	}
}
