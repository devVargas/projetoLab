package exercicio.classesAbstratas;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int quantContas = 0;

       while (quantContas <= 0) {
           System.out.println("quantas contas o usuário deseja criar?");
           quantContas = Integer.parseInt(sc.nextLine());
       }

       ContaBancaria[] contas = new ContaBancaria[quantContas];

       for(int i=0; i<contas.length; i++){
        System.out.println("Digite 1 para CC ou 2 CP");
        if(Integer.parseInt(sc.nextLine()) == 1){
            System.out.println("Digite a senha:");
            contas[i] = new ContaCorrente(sc.nextLine());
        } else {
            System.out.println("Digite a senha:");
            contas[i] = new ContaPoupanca(sc.nextLine());
        }
       }

       for(ContaBancaria cb: contas){
        cb.setNumero((int)(Math.random()*10000+1));
       }

       for(ContaBancaria cb: contas){
        if(cb instanceof ContaPoupanca){
            System.out.println("Digite a taxa de rendimento:");
            ((ContaPoupanca) cb).setTaxaRendimento(Double.parseDouble(sc.nextLine()));
        }
       }

       for(ContaBancaria cb: contas){
        cb.deposita(Math.random() * 100);
        cb.saca(Math.random() * 50);
        cb.tiraExtrato();
       }

       for(ContaBancaria cb: contas){
        if(cb instanceof ContaCorrente){
            System.out.println("Quantidade de transações:" + cb.getNumero() + ((ContaCorrente) cb).getQuantidadeTransacoes());
        } 
        if(cb instanceof ContaPoupanca){
            System.out.println("Taxa de rendimento:" + cb.getNumero() + ((ContaPoupanca) cb).getTaxaRendimento());
        } 
       }
    }
}
