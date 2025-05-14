package exercicio.arquivosLeitura;

import java.io.FileWriter;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do arquivo:");
        String nomeArquivo = sc.nextLine();

        Estoque estoque = new Estoque(nomeArquivo);
        Produto[] produtos = estoque.getProdutos();

        Alimento alimentoCaro = null;
        Eletrodomestico eletroBarato = null;
        StringBuilder vestuario = new StringBuilder();

        for(Produto p: produtos){
            if(p instanceof Alimento){
                Alimento a = (Alimento) p;
                if(alimentoCaro == null || a.getPreco() > alimentoCaro.getPreco()){
                    alimentoCaro = a;
                }
            }
            else if(p instanceof Eletrodomestico){
                Eletrodomestico e = (Eletrodomestico) p;
                if(eletroBarato == null || e.getPreco() < eletroBarato.getPreco()){
                    eletroBarato = e;
                }
            }
            else if(p instanceof Vestuario){       
                Vestuario v = (Vestuario) p;
                vestuario.append("Nome: ").append(v.getNome())
                .append("Descrição: ").append(v.getDecricao())
                .append("Quantidade em estoque: ").append(v.getQuantEstoque());
            }
        }
        
        try {
            FileWriter fw = new FileWriter("info.txt");
            
            if(alimentoCaro != null){
                fw.write("Alimento mais caro: " + alimentoCaro.getNome() + "R$ " + alimentoCaro.getPreco());
            }
            if(eletroBarato != null){
                fw.write("Eletrodomestico mais barato: " + eletroBarato.getNome() + "R$ " + eletroBarato.getPreco());
            }

            fw.write("Vestuário: " + vestuario.toString());
            fw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
