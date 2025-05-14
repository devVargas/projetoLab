package exercicio.arquivosLeitura;

public abstract class Produto {
    private String nome;
    private String decricao;
    private double preco;

    public Produto(String nome, String decricao, double preco) {
        this.nome = nome;
        this.decricao = decricao;
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getDecricao() {
        return decricao;
    }

    public double getPreco() {
        return preco;
    }
}
