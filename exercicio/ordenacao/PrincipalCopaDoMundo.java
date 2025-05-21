package exercicio.ordenacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrincipalCopaDoMundo {
    public static void main(String[] args) {
        String[] arquivo = lerPaisesDeArquivo("exercicio/ordenacao/paises.txt");
        Selecao[] paises = new Selecao[arquivo.length];

        for(int i=0; i<arquivo.length; i++){
            int numParticipacoes = (int)(Math.random() * 22);
            int numTitulos = (int)(Math.random() * 6);

            paises[i] = new Selecao(arquivo[i], numParticipacoes, numTitulos);
        }

        imprimirSelecoes(paises);  
        PesquisaBinariaSelecoes.pesquisaBinariaSelecoes(paises);       
    }

    public static String[] lerPaisesDeArquivo(String arquivo) {
        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            int quantPaises = 0;
            String linha = br.readLine();
            while (linha != null) {
                quantPaises++;
                linha = br.readLine();
            }

            br.close();
            String[] paises = new String[quantPaises];

            fr = new FileReader(arquivo);
            br = new BufferedReader(fr);

            for(int i=0; i<paises.length; i++){
                linha = br.readLine();
                paises[i] = linha;
            }

            br.close();
            return paises;
            
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Arquivo não encontrado" + arquivo, e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao ler o arquivo " + arquivo, e);
        }
    }

    public static void imprimirSelecoes(Selecao[] selecoes) {
        for(Selecao s: selecoes){
            System.out.println(s);
        }
    }
 
}
