package exercicio.classesAbstratas;

public class ContaPoupanca extends ContaBancaria implements Rentavel {
    private double taxaRendimento;

    public ContaPoupanca(String senha) {
        super(senha);
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    @Override
    public double saca(double valor) {
        if(getSaldo() < valor){
            System.out.println("Saldo insuficiente");
            return getSaldo();
        }else{
            setSaldo(getSaldo() - valor);
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
            return getSaldo();
        }
    }

    @Override
	public void tiraExtrato() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "ContaPoupanca [taxaRendimento=" + taxaRendimento
				+ ", toString()=" + super.toString() + "]";
	}
    
    @Override
	public double calculaRendimento() {
		return getSaldo() * this.taxaRendimento;
	}
}
