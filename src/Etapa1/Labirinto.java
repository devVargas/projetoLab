package Etapa1;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Labirinto {
    
    private static final char PAREDE = 'X';
    private static final char CAMINHO_ABERTO = ' ';
    private static final char SAIDA = 'D';
    private static final char CAMINHO_SOLUCAO = '#';
    private static char[][] labirinto;

    public void criaLabirinto(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            int linhas = 0;
            int colunas = linha.length();
            while (linha != null) {
                linhas++;
                linha = br.readLine();
            }

            br.close();

            labirinto = new char[linhas][colunas];

            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            for (int i = 0; i < linhas; i++) {
                linha = br.readLine();
                for (int j = 0; j < linha.length(); j++) {
                    labirinto[i][j] = linha.charAt(j);
                }
            }

            br.close();

        } catch (FileNotFoundException e){
            throw new IllegalArgumentException("Arquivo não encontrado: " + filename, e);
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Arquivo não encontrado: " + filename, e);
        }
    }

    public boolean percorreLabirinto() throws IllegalArgumentException {
        if(labirinto == null) throw new IllegalArgumentException();
        return resolverLabirinto(0, 0);
    }

    private boolean resolverLabirinto(int linha, int coluna) {
        if(linha < 0 ||linha >= labirinto.length || coluna < 0 || coluna >= labirinto[0].length) return false;
        if(labirinto[linha][coluna] == PAREDE || labirinto[linha][coluna] == CAMINHO_SOLUCAO) return false;
        if(labirinto[linha][coluna] == SAIDA) return true;

        labirinto[linha][coluna] = CAMINHO_SOLUCAO;
        
        if(resolverLabirinto(linha + 1, coluna)) return true;
        if(resolverLabirinto(linha, coluna + 1)) return true;
        if(resolverLabirinto(linha - 1, coluna)) return true;
        if(resolverLabirinto(linha, coluna - 1)) return true;
        
        labirinto[linha][coluna] = CAMINHO_ABERTO;
        return false;
    }

    public void imprimeLabirinto() {
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
    }

}
