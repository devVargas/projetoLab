package exercicio.arrayBidimensional;
public class Principal {
    public static void main(String[] args) {
        ExercicioArray ex = new ExercicioArray();

        System.out.println("Exercicio 1a:");
        imprimirMatriz(ex.exercicio1a());

        System.out.println("Exercicio 1b:");
        imprimirMatriz(ex.exercicio1b());

        System.out.println("Exercicio 1c:");
        imprimirMatriz(ex.exercicio1c());

        System.out.println("Exercicio 1d:");
        imprimirMatriz(ex.exercicio1d());

        System.out.println("Exercicio 2:");
        imprimirMatriz(ex.exercicio2());

        System.out.println("Exercicio 3:");
        double[][] matDouble = ex.exercicio3();

        System.out.println("Exercicio 4/5 - Quantidade de elementos:");
        System.out.println(ex.exercicio4_5(matDouble));

        System.out.println("Exercicio 6 - Matriz formatada:");
        System.out.println(ex.exercicio6(matDouble));

        System.out.println("Exercicio 7 - Maior valor:");
        System.out.println(ex.exercicio7(matDouble));

        System.out.println("Exercicio 8 - Soma dos elementos:");
        System.out.println(ex.exercicio8(ex.exercicio1a()));

        System.out.println("Exercicio 9 - Média dos elementos:");
        System.out.println(ex.exercicio9(matDouble));

        System.out.println("Exercicio 10 - Matriz de caracteres:");
        char[][] matChar = ex.exercicio10();
        imprimirMatriz(matChar);

        System.out.println("Exercicio 11 - Array unidimensional com positivos:");
        int[] arrayPositivos = ex.exercicio11(ex.exercicio1b());
        for(int val : arrayPositivos) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }

    public static void imprimirMatriz(double[][] matriz) {
        for (double[] linha : matriz) {
            for (double valor : linha) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }

    public static void imprimirMatriz(char[][] matriz) {
        for (char[] linha : matriz) {
            for (char valor : linha) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}
