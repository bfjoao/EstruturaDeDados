package afc1;

import java.util.Scanner;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        // Cria lista
        LDE lde = new LDE();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção: \n"
                    + "1) Inserir um valor na LDE \n"
                    + "2) Remover um valor da LDE \n"
                    + "3) Imprimir todos os valores da LDE \n"
                    + "4) Pesquisar um valor na LDE, indicando se está presente ou não \n"
                    + "0) Sair\n");
            

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nDigite o valor a ser inserido:");
                    int inserirValor = sc.nextInt();
                    lde.insereCrescente(inserirValor);
                    break;
                case 2:
                    System.out.println("\nDigite o valor a ser removido:");
                    int removerValor = sc.nextInt();
                    lde.removePorValor(removerValor);
                    break;
                case 3:
                    System.out.println("\nValores na LDE:");
                    lde.imprimeLDE();
                    break;
                case 4:
                    System.out.println("\nDigite o valor a ser pesquisado:");
                    int pesquisarValor = sc.nextInt();
                    Nodo resultadoPesquisa = lde.Pesquisa(pesquisarValor);
                    if (resultadoPesquisa != null)
                        System.out.println("O valor está presente na LDE.");
                    else
                        System.out.println("O valor não está presente na LDE.");
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 0);

        sc.close();
    }

}