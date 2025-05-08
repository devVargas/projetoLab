package exercicio.arquivos;

public class Alimento extends Produto{
    private String dataValidade;

    public Alimento(String nome, String descricao, double preco, String dataValidade) {
        super(nome, descricao, preco);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

}
