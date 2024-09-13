package aplicacao;

import java.util.Scanner;

import entidades.ArvoreAvl;
import entidades.Nodo;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        
    	Scanner sc = new Scanner(System.in);
        ArvoreAvl avl = new ArvoreAvl();
        int opcao;

        do {
            System.out.println("\nEscolha uma opção: \n"
            		+ "1) Inserir valor \n"
            		+ "2) Remover valor \n"
            		+ "3) Imprimir valores \n"
            		+ "4) Pesquisar valor \n"
            		+ "5) Informar maior valor \n"
            		+ "6) Informar menor valor \n"
            		+ "0) Sair\n");
            
           opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Insira o valor a ser inserido: ");
                    int valorInserir = sc.nextInt();
                    avl.insere(avl.getRaiz(), valorInserir);
                    break;
                case 2:
                    System.out.print("Insira o valor a ser removido: ");
                    int valorRemover = sc.nextInt();
                    avl.remove(avl.getRaiz(), valorRemover);
                    break;
                case 3:
                    System.out.println("Imprimindo valores da árvore:");
                    avl.imprime(avl.getRaiz());
                    break;
                case 4:
                    System.out.print("Insira o valor a ser pesquisado: ");
                    int valorPesquisar = sc.nextInt();
                    avl.pesquisa(avl.getRaiz(), valorPesquisar);
                    break;
                case 5:
                    Nodo maior = avl.getRaiz();
                    if (maior == null) {
                        System.out.println("A árvore está vazia.");
                    } else {
                        while (maior.getDireita() != null) {
                            maior = maior.getDireita();
                        }
                        System.out.println("Maior valor na árvore: " + maior.getValor());
                    }
                    break;
                case 6:
                    Nodo menor = avl.getRaiz();
                    if (menor == null) {
                        System.out.println("A árvore está vazia.");
                    } else {
                        while (menor.getEsquerda() != null) {
                            menor = menor.getEsquerda();
                        }
                        System.out.println("Menor valor na árvore: " + menor.getValor());
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}