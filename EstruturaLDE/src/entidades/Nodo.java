package entidades;

import entidades.Nodo;

public class Nodo {

	private int valor;
	private Nodo prox;
	private Nodo ant;

	public Nodo() {
		this.valor = 0;
		this.prox = null;
		this.ant = null;

	}

	public Nodo(int val, Nodo p, Nodo a) {
		this.valor = val;
		this.prox = p;
		this.ant = a;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Nodo getProx() {
		return prox;
	}

	public void setProx(Nodo prox) {
		this.prox = prox;
	}

	public Nodo getAnt() {
		return ant;
	}

	public void setAnt(Nodo ant) {
		this.ant = ant;
	}



}
