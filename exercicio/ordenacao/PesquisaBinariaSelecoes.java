package exercicio.ordenacao;

import java.util.Scanner;

public class PesquisaBinariaSelecoes {
    public static void pesquisaBinariaSelecoes(Selecao[] selecoes) {
        OrdenacaoSelecoes.ordenaSelecoesPorNome(selecoes);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do pais a ser pesquisado: ");
        String nomePesquisado = scanner.nextLine();

        int posicao = pesquisaBinaria(selecoes, nomePesquisado);

        System.out.println("\n===== Resultados da Pesquisa =====\n");
        System.out.println(posicao);
    }

    public static int pesquisaBinaria(Selecao[] selecoes, String nomePesquisado) {
        int inicio = 0;
        int fim = selecoes.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = selecoes[meio].getNomePais().compareToIgnoreCase(nomePesquisado);

            if (comparacao == 0) {
                return meio;
            } else if (comparacao < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }
}
