package exercicio.recursao;

public class Exercicio_lista1 {
    public static void imprimiReverso(int[] array) throws IllegalArgumentException {
        if(array == null) throw new IllegalArgumentException();
        imprimiReverso(array, array.length - 1);
    }

    private static void imprimiReverso(int[] array, int index){
        if(index >= 0){
            System.out.println(array[index]);
            imprimiReverso(array, index - 1);
        }
    }

    public static void imprimiNormal(int[] array) throws IllegalArgumentException {
        if(array == null) throw new IllegalArgumentException();
        imprimiNormal(array, 0);
    }

    private static void imprimiNormal(int[] array, int index){
        if(index < array.length){
            System.out.println(array[index]);
            imprimiNormal(array, index + 1);
        }
    }

    public static double soma(double[][] array) throws IllegalArgumentException {
        if(array == null) throw new IllegalArgumentException();
        return soma(array, 0, 0);
    }

    private static double soma(double[][] array, int linha, int coluna){
        if(linha >= array.length) return 0;
        if(coluna >= array[linha].length) return soma(array, linha + 1, 0);
        return array[linha][coluna] + soma(array, linha, coluna + 1);

    }

    public static int encontraPosicaoMenorValor(int[] array) throws IllegalArgumentException {
        if(array == null) throw new IllegalArgumentException();
        return encontraPosicaoMenorValor(array, 0, 0);
    }

    private static int encontraPosicaoMenorValor(int[] array, int index, int posicaoMenor){
        if(index >= array.length) return posicaoMenor;
        if(array[index] < array[posicaoMenor]) return posicaoMenor = index;
        return encontraPosicaoMenorValor(array, index + 1, posicaoMenor);
    }

    public static void printPrimaryDiagonal(double[][] array) throws IllegalArgumentException, MatrixNotPossibleException {
        if (array == null) throw new IllegalArgumentException();
        if (array.length != array[0].length) throw new MatrixNotPossibleException("Matriz não é quadrada");
        printPrimaryDiagonal(array, 0);
    }

    private static void printPrimaryDiagonal(double [][] array, int index) {
        if(index >= array.length) return;
        System.out.println(array[index][index]);
        printPrimaryDiagonal(array, index + 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        imprimiReverso(array);
        imprimiNormal(array);
        System.out.println(encontraPosicaoMenorValor(array));


        double[][] array2 = {{1.5, 2, 3}, {4, 5.9, 6}, {7, 8.6, 9}};
        System.out.println(soma(array2));
        printPrimaryDiagonal(array2);
    }
}
