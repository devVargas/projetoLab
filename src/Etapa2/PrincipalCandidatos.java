package Etapa2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrincipalCandidatos {
    public static void main(String[] args) {
        int tamanho = (int) (Math.random() * 100) + 1;

        String[] arquivoCandidato = leitorDeArquivos("src/Etapa2/nomes.txt", tamanho);
        String[] arquivoPartido = leitorDeArquivos("src/Etapa2/partidos.txt", tamanho);

        Candidato candidatos[] = new Candidato[tamanho];

        for(int i=0; i<tamanho; i++){
            int intencoesVotos = (int)(Math.random() * (500 - 150 + 1)) + 150;
            candidatos[i] = new Candidato(arquivoCandidato[i], arquivoPartido[i], intencoesVotos);
        }

        System.out.println("===========================================================================\n"
        + "         RELATÓRIO DE VOTAÇÃO\n"
        + "===========================================================================\n"
        + "Nome                 Partido         Intenções de Votos\n"
        + "===========================================================================\n");

        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);
        imprimirArquivos(candidatos);

        Candidato primeiro = candidatos[0];
        Candidato ultimo = candidatos[candidatos.length - 1];

        System.out.println("===========================================================================");
        System.out.printf("Primeiro candidato: %-30s %-15s %d%n",
        primeiro.getNome(), primeiro.getPartido(), primeiro.getIntencoesVotos());

        System.out.printf("Último candidato:   %-30s %-15s %d%n",
        ultimo.getNome(), ultimo.getPartido(), ultimo.getIntencoesVotos());

        int indiceAleatorio = (int) (Math.random() * candidatos.length);
        String nomeBuscado = candidatos[indiceAleatorio].getNome();
        int posicao = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, nomeBuscado);
        Candidato encontrado = candidatos[posicao];
        System.out.printf("[OK] Candidato encontrado na posição %2d: %-10s %-10s %d%n",
            posicao, encontrado.getNome(), encontrado.getPartido(), encontrado.getIntencoesVotos());
        
        System.out.println("===========================================================================\n"
        + "         ORDENA POR VOTO\n"
        + "===========================================================================");
        OrdenarCandidatos.ordenaCandidatosPorVotos(candidatos);
        imprimirArquivos(candidatos);

        System.out.println("===========================================================================\n"
        + "         ORDENA POR PARTIDO\n"
        + "===========================================================================");
        OrdenarCandidatos.ordenaCandidatosPorPartido(candidatos);
        imprimirArquivos(candidatos);
        
    }

    public static String[] leitorDeArquivos(String arquivo, int tamanhoArray) {
        try {
            String[] arrayArquivo = new String[tamanhoArray];

            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            for(int i=0; i<tamanhoArray; i++) {
                String linha = br.readLine();
                arrayArquivo[i] = linha;
            }

            br.close();
            return arrayArquivo;
            
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Arquivo não encontrado " + arquivo);
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao ler o arquivo " + arquivo);
        }
    }

    public static void imprimirArquivos(Candidato[] arquivos) {
        for(Candidato a: arquivos){
            System.out.println(a);
        }
    }
}
