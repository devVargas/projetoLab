package exercicio.excecoes;

public class Principal {
    public static void main(String[] args) {
        ExercicioExcecoes ex = new ExercicioExcecoes();
        ex.aumentaTemperatura(-1);
        System.out.println(ex.getTemperatura());
        ex.diminuiTemperatura(5);
        System.out.println(ex.getTemperatura());
    }
}
