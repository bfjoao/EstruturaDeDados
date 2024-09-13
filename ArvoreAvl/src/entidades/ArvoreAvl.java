package entidades;

import entidades.Nodo;

public class ArvoreAvl {
	private Nodo raiz;
	
	public ArvoreAvl() {
		setRaiz(null);
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	//Cálculos de rotações: ----------------
	private void rotacaoEsquerda(Nodo aux) {
        // Obtém o filho à direita de aux
        Nodo filho = aux.getDireita();
        
        // Move a subárvore esquerda do filho para a subárvore direita de aux
        aux.setDireita(filho.getEsquerda());
        if (filho.getEsquerda() != null) {
            filho.getEsquerda().setPai(aux);
        }
        
        // Coloca aux como filho à esquerda de filho
        filho.setEsquerda(aux);
        
        // Atualiza o pai de filho para ser o pai original de aux
        filho.setPai(aux.getPai());
        
        // Atualiza o pai de aux para ser filho
        aux.setPai(filho);
        
        // Ajusta o ponteiro do pai original de aux para apontar para filho
        if (filho.getPai() != null) {
            if (filho.getPai().getEsquerda() == aux) {
                filho.getPai().setEsquerda(filho);
            } else {
                filho.getPai().setDireita(filho);
            }
        } else {
            // Se aux era a raiz, atualiza a raiz para ser filho
            setRaiz(filho);
        }
        
        // Recalcula as alturas dos nós afetados
        calculaAltura(aux);
        calculaAltura(filho);
    }

    // Rotação Simples à Direita
    private void rotacaoDireita(Nodo aux) {
        // Obtém o filho à esquerda de aux
        Nodo filho = aux.getEsquerda();
        
        // Move a subárvore direita do filho para a subárvore esquerda de aux
        aux.setEsquerda(filho.getDireita());
        if (filho.getDireita() != null) {
            filho.getDireita().setPai(aux);
        }
        
        // Coloca aux como filho à direita de filho
        filho.setDireita(aux);
        
        // Atualiza o pai de filho para ser o pai original de aux
        filho.setPai(aux.getPai());
        
        // Atualiza o pai de aux para ser filho
        aux.setPai(filho);
        
        // Ajusta o ponteiro do pai original de aux para apontar para filho
        if (filho.getPai() != null) {
            if (filho.getPai().getEsquerda() == aux) {
                filho.getPai().setEsquerda(filho);
            } else {
                filho.getPai().setDireita(filho);
            }
        } else {
            // Se aux era a raiz, atualiza a raiz para ser filho
            setRaiz(filho);
        }
        
        // Recalcula as alturas dos nós afetados
        calculaAltura(aux);
        calculaAltura(filho);
    }

    // Rotação Esquerda-Direita
    private void rotacaoEsquerdaDireita(Nodo aux) {
        // Primeiro, realiza uma rotação à esquerda no filho à esquerda de aux
        rotacaoEsquerda(aux.getEsquerda());
        
        // Em seguida, realiza uma rotação à direita em aux
        rotacaoDireita(aux);
    }

    // Rotação Direita-Esquerda
    private void rotacaoDireitaEsquerda(Nodo aux) {
        // Primeiro, realiza uma rotação à direita no filho à direita de aux
        rotacaoDireita(aux.getDireita());
        
        // Em seguida, realiza uma rotação à esquerda em aux
        rotacaoEsquerda(aux);
    }
	
	//Verifica os balanceamentos e chama as rotações se necessário
	private void verificaBalanceamento(Nodo aux) {
		if (aux.getBalanceamento() == -2) {
			//se FB = -2 (negativo), o filho à esquerda 
			//que deve ter o sinal do seu FB testado
			if(aux.getEsquerda().getBalanceamento() < 0)
				rotacaoDireita(aux);
			else 
				rotacaoEsquerdaDireita(aux);
		}
		else {
			if(aux.getBalanceamento() == 2) {
				//se FB = 2 (positivo), o filho à direita 
				//que deve ter o sinal do seu FB testado
				if(aux.getDireita().getBalanceamento() > 0)
					rotacaoEsquerda(aux);
				else 
					rotacaoDireitaEsquerda(aux);
			}
		}
	}
	
	//Calcula Altura-------------------
	private int calculaAltura(Nodo aux) {
		if(aux == null)
			return 0;
		else {
			int esq = calculaAltura(aux.getEsquerda());
			int dir = calculaAltura(aux.getDireita());
			aux.setBalanceamento(dir-esq);		
			if(esq > dir) {
				aux.setAltura(esq);
				return esq+1;
			}
			else  {
				aux.setAltura(dir);
				return dir+1;
			}
		}
	}
	
	//Inserção -----------------
	public void insere(Nodo aux, int valor) {
			//verifica se a raiz da árvore não é nula
			if (aux != null) {
				Nodo novo = new Nodo(valor);
			    //Verifica se o valor a ser inserido é menor que o nodo corrente da árvore, se sim, vai para subárvore esquerda
			    if (valor < aux.getValor()) {
			        //Se tiver elemento no nodo esquerdo, continua a busca
			        if (aux.getEsquerda() != null) 
			            insere(aux.getEsquerda(),valor);
			        else {
			            //Se nodo esquerdo vazio, insere o novo nodo aqui
			            System.out.println("Inserindo " + valor + " a esquerda de " + aux.getValor());
			            aux.setEsquerda(novo);
			        }
			    //Verifica se o valor a ser inserido é maior que o nodo corrente da árvore, se sim, vai para subárvore direita
			    } else if (valor > aux.getValor()) {
			        //Se tiver elemento no nodo direito, continua a busca
			        if (aux.getDireita() != null) {
			            insere(aux.getDireita(), valor);
			        } else {
			            //Se nodo direito vazio, insere o novo nodo aqui
			            System.out.println("Inserindo " + valor + " a direita de " + aux.getValor());
			            aux.setDireita(novo);
			        }
			    }
			    novo.setPai(aux);
			    calculaAltura(aux);
				System.out.println("*******Verifica balanc de  " + aux.getValor());
				verificaBalanceamento(aux);
			 }
			else{
				System.out.println("Inserindo " + valor + " na raiz");
				setRaiz(new Nodo(valor));
			}
	}
	
	//Remoção-------------------------------------------
	public void removeFolha(Nodo aux, int valor) {
			if(aux.getPai() != null) {
				if(aux.getValor() < aux.getPai().getValor()) 
					aux.getPai().setEsquerda(null);
				else
					aux.getPai().setDireita(null);
			}
			else
				setRaiz(null);
			aux = null;
			System.out.println("Nodo "+valor+" removido!");
	}
		
	public void removeNodoUmaSubarvoreDireita(Nodo aux, int valor) {
			if(aux.getPai() != null) {
				if(aux.getValor() < aux.getPai().getValor())	
					aux.getPai().setEsquerda(aux.getDireita());
				else
					aux.getPai().setDireita(aux.getDireita());
			}
			else
				setRaiz(aux.getDireita());
			aux = null;
			System.out.println("Nodo "+valor+" removido!");
	}
		
	public void removeNodoUmaSubarvoreEsquerda(Nodo aux,  int valor) {
			if(aux.getPai() != null) {
				if(aux.getValor() < aux.getPai().getValor())	
					aux.getPai().setEsquerda(aux.getEsquerda());
				else
					aux.getPai().setDireita(aux.getEsquerda());
			}
			else
				setRaiz(aux.getEsquerda());
			aux = null;
			System.out.println("Nodo "+valor+" removido!");
	}
		
	public void removeNodoDuasSubarvores(Nodo aux, int valor) {
			//testa se aux tem dois filhos
			Nodo aux2 = aux.getEsquerda();
			Nodo paiaux2 = aux.getEsquerda();
			while(aux2.getDireita() != null) {
				paiaux2 = aux2;
				aux2 = aux2.getDireita();
			}
			paiaux2.setDireita(aux2.getEsquerda());
			if(aux.getPai() != null) {
				if(aux.getValor() < aux.getPai().getValor())
					aux.getPai().setEsquerda(aux2);
				else
					aux.getPai().setDireita(aux2);
			}
			else
				setRaiz(aux2);
			aux2.setDireita(aux.getDireita());
			if(aux2 != aux.getEsquerda())
				aux2.setEsquerda(aux.getEsquerda());
			aux = null;
			System.out.println("Nodo "+valor+" removido!");
	}
		
	public void remove(Nodo aux, int valor) {
			if(aux != null) {
				Nodo pai = null;
				if(aux.getPai() != null) 
					pai = aux.getPai();
				if(valor == aux.getValor()) {
					//testa se aux é folha
					if(aux.getEsquerda() == null && aux.getDireita() == null) 
						removeFolha(aux, valor);
					else {
						//testa se aux só tem um filho a direita
						if(aux.getEsquerda() == null && aux.getDireita() != null) 
							removeNodoUmaSubarvoreDireita(aux, valor);
						else {
							//testa se aux só tem um filho a esquerda
							if(aux.getEsquerda() != null && aux.getDireita() == null) 
								removeNodoUmaSubarvoreEsquerda(aux, valor);
							else 
								//testa se aux tem dois filhos
								removeNodoDuasSubarvores(aux, valor);
						}
					}
				}
				else {
					if(valor < aux.getValor()) 
						remove(aux.getEsquerda(), valor);
					else
						if(valor > aux.getValor()) 
							remove(aux.getDireita(), valor);
				}
				//Apos remover aux, atualiza as alturas e os FBs dos demais nodos anteriores a este
				if(pai != null) {
					pai.setAltura(calculaAltura(pai)-1);
					verificaBalanceamento(pai);
				}
			}
			else
				System.out.println("Valor não encontrado!");
	}
	
	//Pesquisa--------------------
	public void pesquisa(Nodo aux, int valor) {
		while(aux != null && aux.getValor() != valor) {
			if(valor < aux.getValor())
		        aux = aux.getEsquerda();
		    else 
		        aux = aux.getDireita();
		}
		if(aux == null) 
		   System.out.println("Valor "+valor+" não encontrado!");
		else 
		    System.out.println("Valor "+aux.getValor()+" encontrado!");
	}

	//Impressão  com caminhamento pré-fixado à esquerda: raiz, esq, dir
	public void imprime(Nodo aux) {
		if(aux != null) {
			System.out.println("----- ");
			System.out.println(aux.getValor());
			if(aux.getPai() != null)
				System.out.println("pai: "+aux.getPai().getValor());
			System.out.println("altura: "+aux.getAltura());
			System.out.println("balanceamento: "+aux.getBalanceamento());
			imprime(aux.getEsquerda());
			imprime(aux.getDireita());
		}
	}
}

