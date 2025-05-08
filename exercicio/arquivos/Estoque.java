package exercicio.arquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Estoque {
    private Produto[] produtos;

    public Estoque(String nomeArquivo){
        preencheEstoque(nomeArquivo);
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void preencheEstoque(String nomeArquivo){
        try {
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);

            int quantProdutos = 0;

            String linha = br.readLine();
            while (linha != null) {
                quantProdutos++;
                linha = br.readLine();
            }

            br.close();
            produtos = new Produto[quantProdutos-1];

            System.out.println("Quantidade de produtos:" + quantProdutos);

            fr = new FileReader(nomeArquivo);
            br = new BufferedReader(fr);

            br.readLine();

            for(int i=0; i<produtos.length; i++){
                linha = br.readLine();
                String[] dados = linha.split("\\s\\*\\s");

                String produto = dados[0];
                String descricao = dados[1];
                double preco = Double.parseDouble(dados[2]);

                if(dados[3].equalsIgnoreCase("Alimmento")){
                    String dataValidade = dados[4];
                    produtos[i] = new Alimento(produto, descricao, preco, dataValidade);
                }
                if(dados[3].equalsIgnoreCase("Eletrodomestico")){
                    double ipi = Double.parseDouble(dados[4]);
                    produtos[i] = new Eletrodomestico(produto, descricao, preco, ipi);
                }
                if(dados[3].equalsIgnoreCase("Vestuario")){
                    int quantEstoque = Integer.parseInt(dados[4]);
                    produtos[i] = new Vestuario(produto, descricao, preco, quantEstoque);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
