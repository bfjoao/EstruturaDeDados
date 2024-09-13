package entidades;


public class ListaCircular {
	
	private Nodo inicio;

	public ListaCircular() {
		super();
		this.inicio = inicio;
	}
	
	public void insereLista(int valor) {
		Nodo novo = new Nodo();
		novo.setValor(valor);
		
		if(this.inicio == null) {
			this.inicio = novo;
			novo.setProximo(novo);
		}
		else {
			Nodo aux = this.inicio;
			while(aux.getProximo() != this.inicio) {
				aux = aux.getProximo();
			}
			aux.setProximo(novo);
			novo.setProximo(this.inicio);
		}
	}
	
	public void removeFinal(Pilha pilha) {
		if(this.inicio == null)
			System.out.println("Lista vazia!");
		else {
			Nodo aux =  this.inicio;
			Nodo aux2 = this.inicio;
			while (aux.getProximo().getProximo() != this.inicio) {
				aux=aux.getProximo();
			}
			aux.setProximo(this.inicio);
			aux2.setProximo(null);
			pilha.insereNodoPilha(aux2);
		}
	}
	
	public void imprimeLista() {
		if (this.inicio == null) {
			System.out.println("Lista vazia!");
		}
		else {
				System.out.println(this.inicio.getValor());
			if (this.inicio.getProximo()!=this.inicio) {
				Nodo aux = this.inicio.getProximo();
				while (aux != this.inicio) {
					System.out.println(aux.getValor());
					aux= aux.getProximo();
				}
			}
		}
	}

	public void insereNodolc(Nodo novo) {
			if(this.inicio == null)
				this.inicio = novo;
			else {
				Nodo aux = this.inicio;
				while(aux.getProximo() != null) {
					aux = aux.getProximo();
				}
				aux.setProximo(novo);
			}
	}
	
}
