package exercicio.classesAbstratas;
import java.util.Scanner;

public abstract class ContaBancaria {
    private String senha;
    private int numero;
    private double saldo;

    public ContaBancaria(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public abstract double saca(double valor);
    public abstract double deposita(double valor);
    public abstract void tiraExtrato();

    @Override
    public String toString() {
        return "ContaBancaria [senha=" + senha + ", numero=" + numero
                + ", saldo=" + saldo + "]";
    }

    public boolean alteraSenha(String senha){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a senha anterior:");
        if(sc.nextLine().equals(this.senha)){
            this.senha = senha;
            return true;
        }
        return false;
    } 
}
