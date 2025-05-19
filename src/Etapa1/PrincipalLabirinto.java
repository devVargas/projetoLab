package Etapa1;

public class PrincipalLabirinto {
    public static void main(String[] args) {
        Labirinto lab = new Labirinto();
        lab.criaLabirinto("src/Etapa1/labirinto.txt");

        System.out.println("Labirinto inicial:");
        lab.imprimeLabirinto();

        boolean encontrou = lab.percorreLabirinto();

        if(encontrou) {
            System.out.println("Solução encontrada");
        } 

        System.out.println("Labirinto final:");
        lab.imprimeLabirinto();
    }
}
