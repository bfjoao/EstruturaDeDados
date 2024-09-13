package aplicacao;

import java.util.Scanner;

import entidades.Fila;
import entidades.ListaCircular;
import entidades.Pilha;

public class ProgramaPrincipal {
	
	public static void main(String[] args)  {
			
		
		Pilha pilha = new Pilha();
		Fila fila = new Fila();
		ListaCircular lc = new ListaCircular();
		
		System.out.println("Escolha uma opcao: \n"
				+ "1) Inserir valores na pilha \n"
				+ "2) Inserir valores na fila \n"
				+ "3) Inserir valores na lista circular \n"
				+ "4) Remover um valor da pilha e inseri-lo na fila \n"
				+ "5) Remover um valor da fila e inseri-lo na lista circular \n"
				+ "6) Remover um valor da lista circular e inseri-lo na pilha \n"
				+ "7) Imprimir todos os valores da pilha \n"
				+ "8) Imprimir todos os valores da fila \n"
				+ "9) Imprimir todos os valores da lista circular");
		
		
		
		int resp;
		int inserirpilha;
		Scanner sc = new Scanner(System.in);
		
		int valor;
		
		do
		{
			resp = sc.nextInt();
			switch (resp) 
			
			{
				case 1:
				{
					System.out.println("Insira um valor para pilha: ");
					valor = sc.nextInt();
					inserirpilha = valor;
					pilha.inserePilha(inserirpilha);
					break;
				
				}
				case 2:
				{
					System.out.println("Insira um valor para fila: ");
					valor = sc.nextInt();
					int inserefila = valor;
					fila.insereFila(inserefila);
					break;
				}
				case 3:
				{
					System.out.println("Insira um valor para lista circular: ");
					valor = sc.nextInt();
					int inserelc = valor;
					lc.insereLista(inserelc);
					break;
				}
				case 4:
				{
					System.out.println("Remova um valor da pilha e insira na fila. ");
					pilha.removePilha(fila);
					break;
				}
				case 5:
				{
					System.out.println("Remova um valor da fila e insira na lista circular. ");
					fila.removeFila(lc);
					break;
				}
				case 6:
				{
					System.out.println("Remova um valor da lista circular e insira na pilha. ");
					lc.removeFinal(pilha);
					break;
				}
				case 7:
				{
					System.out.println("Itens da pilha: ");
					pilha.imprimePilha();
					break;
				}
				case 8:
				{
					System.out.println("Itens da fila: ");
					fila.imprimeFila();
					break;
				}
				case 9:
				{
					System.out.println("Itens da lista circular: ");
					lc.imprimeLista();
					break;
				}
				
			default:	
				System.out.println("Escolha um item do menu!");
			}
		} while(resp > 0);
	}		
}

