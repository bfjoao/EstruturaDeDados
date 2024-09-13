package entidades;

import entidades.Fila;
import entidades.Nodo;

public class Pilha {
	
	private Nodo inicio;
	
	public Pilha() {
		super();
		this.inicio = inicio;
	}

	public void inserePilha(int valor) {
		Nodo novo = new Nodo();
		novo.setValor(valor);
		novo.setProximo(this.inicio);
		
		this.inicio = novo;
		
	}
	
	public void imprimePilha() {
		Nodo aux = this.inicio;
		int cont = 0;
		while(aux != null) {
			System.out.println(aux.getValor());
			cont++;
			aux = aux.getProximo();
		}
		System.out.println("Total de nodos: "+cont);
		
	}
	
	public void removePilha(Fila fila) {
		if(this.inicio == null)
			System.out.println("Lista vazia!");
		else {
			Nodo aux =  this.inicio;
			this.inicio = this.inicio.getProximo();
			aux.setProximo(null);
			fila.insereNodoFila(aux);
		}
	}

	public void insereNodoPilha(Nodo novo) {
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