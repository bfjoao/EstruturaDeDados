package entidades;

import entidades.Nodo;

public class Nodo {
	
		private int valor;
		
		private Nodo proximo;
		
		public Nodo() {
			this.valor = 0;
			this.proximo = null;
		}
	
		public int getValor() {
			return valor;
		}
	
		public void setValor(int valor) {
			this.valor = valor;
		}
	
		public Nodo getProximo() {
			return proximo;
		}
	
		public void setProximo(Nodo proximo) {
			this.proximo = proximo;
		}
}
