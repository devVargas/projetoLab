package exercicio.ordenacao;

public class OrdenacaoSelecoes {
    public static void ordenaSelecoesPorNome(Selecao[] selecoes) {
        for(int i = 1; i < selecoes.length; i++) {
            Selecao selecaoFrente = selecoes[i];
            int selecaoAtras = i - 1;
            while(selecaoAtras >= 0 && selecoes[selecaoAtras].getNomePais().compareTo(selecaoFrente.getNomePais()) > 0) {
                selecoes[selecaoAtras + 1] = selecoes[selecaoAtras];
                selecaoAtras--;
            }
            selecoes[selecaoAtras + 1] = selecaoFrente;
        }     
    }
}
