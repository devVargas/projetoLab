package exercicio.arquivosLeitura;

public class Vestuario extends Produto {
    private int quantEstoque;
    
    public Vestuario(String nome, String descricao, double preco, int quantEstoque) {
        super(nome, descricao, preco);
        this.quantEstoque = quantEstoque;
    }
    
    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

}
