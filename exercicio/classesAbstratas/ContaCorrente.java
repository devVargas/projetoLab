package exercicio.classesAbstratas;

public class ContaCorrente extends ContaBancaria {
    private int quantidadeTransacoes;

    public ContaCorrente(String senha) {
        super(senha);
    }

    public void setQuantidadeTransacoes(int quantidadeTransacoes) {
        this.quantidadeTransacoes = quantidadeTransacoes;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    @Override
    public double saca(double valor) {
        if(getSaldo() < valor){
            System.out.println("Saldo insuficiente");
            return getSaldo();
        }else{
            setSaldo(getSaldo() - valor);
            quantidadeTransacoes++;
            return getSaldo();
        }
    }

    @Override
    public double deposita(double valor) {
        if(valor < 0){
            System.out.println("Valor inválido");
            return getSaldo();
        }else{
            setSaldo(getSaldo() + valor);
            quantidadeTransacoes++;
            return getSaldo();
        }
    }

    @Override
    public void tiraExtrato() {
        System.out.println(this.toString());
        quantidadeTransacoes++;
    }

    @Override
	public String toString() {
		return "ContaCorrente [quantTransacoes=" + quantidadeTransacoes
				+ ", toString()=" + super.toString() + "]";
	}
}
