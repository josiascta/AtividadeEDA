package Eda2;




public class EDALista {
	
	
	private int tamanho;
	private EDANo inicio; 
	private EDANo Final;
	private EDANo cabeca;
	private int mediaPrimeiroUltimo;
	
	 public EDALista() {
	     	cabeca= new EDANo(-1);
	     	tamanho = 0;
	        inicio =null;
	        Final =inicio;
	      
	    }

	 public void inserirNoInicio(int dado) {
	        EDANo novoNo = new EDANo(dado);
	        if (inicio == null) {
	            inicio = novoNo;
	            Final = novoNo;
	        } else {
	            novoNo.proximo = inicio;
	            inicio = novoNo;
	        }
	        tamanho++;
	       
	    }
	

	    public void inserirNoFinal(int dado) {
	        EDANo novoNo = new EDANo(dado);
	        if (Final == inicio) {
	            inicio.proximo = novoNo;
	            Final = novoNo;
	        } else {
	            Final.proximo = novoNo;
	            Final = novoNo;
	        }
	        tamanho++;
	    }
	  
	    public void inserirNaPosicao(int dado, int posicao) {
	        if (posicao < 0 || posicao > tamanho) {
	            throw new IndexOutOfBoundsException("Posição inválida");
	        }

	        EDANo novoNo = new EDANo(dado);
	        EDANo atual = inicio;
	        for (int i = 0; i < posicao; i++) {
	            atual = atual.proximo;
	        }

	        novoNo.proximo = atual.proximo;
	        atual.proximo = novoNo;
	        tamanho++;
	    }

	   
	    public void removerDoInicio() {
	        if (inicio != null) {
	            inicio = inicio.proximo;
	            tamanho--;
	        }
	    }

	 
	    public void removerDoFinal() {
	        if (!isVazia()) {
	            if (tamanho == 1) {
	                inicio.proximo = null;
	                inicio = null;
	                Final = inicio;
	            } else {
	            	EDANo atual = inicio;
	                while (atual.proximo != Final) {
	                    atual = atual.proximo;
	                }

	                atual.proximo = null;
	                Final = atual;
	            }
	            tamanho--;
	        }
	    }
	   
	    
	   
	    public void removerDaPosicao(int posicao) {
	        if (posicao < 0 || posicao >= tamanho) {
	            throw new IndexOutOfBoundsException("Posição inválida");
	        }

	        EDANo atual = inicio;
	        for (int i = 0; i < posicao; i++) {
	            atual = atual.proximo;
	        }

	        atual.proximo = atual.proximo.proximo;
	        tamanho--;
	    }

	   
	    public void exibir() {
	        if (isVazia()) {
	            System.out.println("A lista está vazia.");
	        } else {
	        	mediaPrimeiroUltimo =  (inicio.dado + Final.dado) / 2;
	            EDANo atual = inicio;
	            while (atual != null) {
	                System.out.print(atual.dado + " -> ");
	                atual = atual.proximo;
	            }
	            System.out.println("null");
	            System.out.println("Tamanho= "+tamanho);
	           System.out.println("PIVO= "+mediaPrimeiroUltimo);
	        }
	    }
	    public boolean isVazia() {
	        return tamanho == 0;
	    }
	   

	    public static void main(String[] args) {
	        EDALista lista = new EDALista();

	        lista.inserirNoInicio(46);
	        lista.inserirNoFinal(17);
	        lista.inserirNoFinal(8);
	        lista.inserirNoFinal(5);
	        lista.inserirNoFinal(11);
	       lista.inserirNoFinal(33);

	       lista.removerDoFinal();
	       lista.removerDoInicio();
	       lista.removerDoInicio();
	       lista.removerDoInicio();
	       lista.exibir();
	    }

}
