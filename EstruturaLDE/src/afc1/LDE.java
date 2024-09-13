package afc1;

public class LDE {

	private Nodo inicio;

	public LDE() {
		super();
		this.inicio = null;
	}

	public void imprimeLDE() {
		int pos = 1;
		if (this.inicio == null)
			System.out.println("Lista vazia!");
		else {
			Nodo aux = this.inicio;
			while (aux != null) {
				System.out.printf("Valor: %f %f ", aux.getValor(), pos);
				pos++;
				aux = aux.getProx();
			}
		}
	}

	
	// Insere os valores em ordem crescente na LDE
	public void insereCrescente(int valor) {
	    Nodo novo = new Nodo();
	    novo.setValor(valor);

	    if (this.inicio == null) {
	        this.inicio = novo;
	    } else if (valor <= this.inicio.getValor()) {
	        novo.setProx(this.inicio);
	        this.inicio.setAnt(novo);
	        this.inicio = novo;
	    } else {
	        Nodo atual = this.inicio;
	        while (atual.getProx() != null && valor > atual.getProx().getValor()) {
	            atual = atual.getProx();
	        }
	        novo.setProx(atual.getProx());
	        if (atual.getProx() != null) {
	            atual.getProx().setAnt(novo);
	        }
	        novo.setAnt(atual);
	        atual.setProx(novo);
	    }
	}

	// Pesquisa um valor na lista e devolve um ponteiro para este)
	public Nodo Pesquisa(int valor) {
		Nodo aux = this.inicio;
		if (this.inicio != null) {
			while (aux != null && aux.getValor() != valor)
				aux = aux.getProx();
		}
		return aux;
	}

	// Remove nodo por valor
	public void removePorValor(int valor) {
		Nodo aux = Pesquisa(valor);

		if (aux == null)
			System.out.println("Valor não encontrado!");
		else {
			if (aux.getAnt() != null)
				aux.getAnt().setProx(aux.getProx());
			else
				this.inicio = aux.getProx();
			if (aux.getProx() != null)
				aux.getProx().setAnt(aux.getAnt());
			aux = null;

		}
	}
}