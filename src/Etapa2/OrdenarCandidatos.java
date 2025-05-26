package Etapa2;

public class OrdenarCandidatos {
    public static void ordenaCandidatosPorNome(Candidato[] array) {
        for(int i = 1; i<array.length; i++){
            int j = i - 1;
            Candidato candidatoAtual = array[i];

            while (j >= 0 && array[j].getNome().compareTo(candidatoAtual.getNome()) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = candidatoAtual;
        }
    }

    public static void ordenaCandidatosPorVotos(Candidato[] array) {
        for(int i = 0; i < array.length - 1; i++){
            int min_idx = i;

            for(int j = i + 1; j < array.length; j++)
                if(array[j].getIntencoesVotos() > array[min_idx].getIntencoesVotos())
                    min_idx = j;
            
            Candidato temp = array[i];
            array[i] = array[min_idx];
            array[min_idx] = temp;
        }
    }

    public static void ordenaCandidatosPorPartido(Candidato[] array) {
        for(int i = 1; i<array.length; i++){
            int j = i - 1;
            Candidato partidoAtual = array[i];

            while (j >= 0 && array[j].getPartido().compareTo(partidoAtual.getPartido()) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = partidoAtual;
        }
    }

    public static int pesquisaBinariaCandidatos(Candidato[] array, String nome) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = array[meio].getNome().compareToIgnoreCase(nome);

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
