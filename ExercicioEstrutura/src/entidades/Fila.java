package entidades;

import entidades.ListaCircular;
import entidades.Nodo;

public class Fila {
	
	private Nodo inicio;

	public Fila() {
		super();
		this.inicio = inicio;
	}
	
	public void insereFila(int valor) {
		Nodo novo = new Nodo();
		novo.setValor(valor);
		novo.setProximo(null);
		
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
	
	public void removeFila(ListaCircular lc) {
		if(this.inicio == null)
			System.out.println("Lista vazia!");
		else {
			Nodo aux =  this.inicio;
			this.inicio = this.inicio.getProximo();
			aux.setProximo(null);
			lc.insereNodolc(aux);
		}
	}
		
		public void imprimeFila() {
			Nodo aux = this.inicio;
			int cont = 0;
			while(aux != null) {
				System.out.println(aux.getValor());
				cont++;
				aux = aux.getProximo();
			}
			System.out.println("Total de nodos: "+cont);
			
		}

		public void insereNodoFila(Nodo novo) {
			// TODO Auto-generated method stub
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
