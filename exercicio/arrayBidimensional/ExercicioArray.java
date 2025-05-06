package exercicio.arrayBidimensional;
import java.util.Scanner;

public class ExercicioArray {

    public int[][] exercicio1a(){
        int[][] array = new int[3][10];
        for(int i=0; i<array.length; i++)
            for(int j=0; j<array[i].length; j++)
                array[i][j] = j;
        return array;
    }

    public int[][] exercicio1b(){
        int[][] array = new int[5][10];
        for(int i=0; i<array.length; i++)
            for(int j=0; j<array[i].length; j++)
                array[i][j] = j * j;
        return array;
    }

    public int[][] exercicio1c(){
        int[][] array = new int[5][6];
        for(int i=0; i<array.length; i++)
            for(int j=0; j<array[i].length; j++)
                array[i][j] = i;
        return array;
    }

    public int[][] exercicio1d(){
        int[][] array = new int[9][6];
        for(int i=0; i<array.length; i++)
            for(int j=0; j<array[i].length; j++)
                array[i][j] = i % 2 == 0 ? -1 : 0;
        return array;
    }

    public int[][] exercicio2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantas linhas?");
        int linhas = Integer.parseInt(sc.next());
        System.out.println("Quantas colunas?");
        int colunas = Integer.parseInt(sc.next());
        int[][] array = new int[linhas][colunas];
        sc.close();

        for(int i=0; i<array.length; i++)
            for(int j=0; j<array[i].length; j++)
                array[i][j] = (int)(Math.random() * 100);
               
        return array;   
    }

    public double[][] exercicio3(){
        Scanner sc = new Scanner(System.in);
        double[][] arrayDouble = new double[2][5];

        for(int i=0; i<arrayDouble.length; i++)
            for(int j=0; j<arrayDouble[i].length; j++){
                System.out.println("Digite o próximo valor (double):");
                arrayDouble[i][j] = Double.parseDouble(sc.next());
            }
        sc.close();
        return arrayDouble;   
    }

    public int exercicio4_5(double[][] arrayDouble){
        int quantElementos = 0;

        for(int i = 0; i<arrayDouble.length; i++)
            for(int j=0; j<arrayDouble[i].length; j++)
                quantElementos++;
        return quantElementos;
    }

    public String exercicio6(double[][] arrayDouble){
        String retorno = "";
        for(int i = 0; i<arrayDouble.length; i++)
            for(int j=0; j<arrayDouble[i].length; j++)
                if(j < arrayDouble[i].length-1)
                    retorno += arrayDouble[i][j] + " - ";
                else
                    retorno += arrayDouble[i][j] + "\n";
            
        return retorno;
    }

    public double exercicio7(double[][] arrayDouble){
        double maior = arrayDouble[0][0];
        for(int i = 0; i<arrayDouble.length; i++)
            for(int j=0; j<arrayDouble[i].length; j++)
                if(arrayDouble[i][j] > maior)
                    maior = arrayDouble[i][j];

        return maior;
    }

    public int exercicio8(int[][] arrayInt){
        int soma = 0;
        for(int i = 0; i<arrayInt.length; i++)
            for(int j=0; j<arrayInt[i].length; j++)
                soma += arrayInt[i][j];  
        return soma;
    }

    public double exercicio9(double[][] arrayDouble){
        double soma = 0;
        int quantElementos = 0;
        for(int i = 0; i<arrayDouble.length; i++)
            for(int j=0; j<arrayDouble[i].length; j++)
                soma += arrayDouble[i][j];
                quantElementos++;

        return soma/quantElementos;
    }

    public char[][] exercicio10(){
        Scanner sc = new Scanner(System.in);

        int linhas = (int)(Math.random()*5+1);
        int colunas = (int)(Math.random()*3+1);

        char[][] arrayChar = new char[linhas][colunas];
        for(int i = 0; i<arrayChar.length; i++)
            for(int j=0; j<arrayChar[i].length; j++){
                System.out.println("Digite o próximo valor (char):");
                arrayChar[i][j] = sc.next().charAt(0);
            }
        sc.close();
        return arrayChar;
    }

    public int[] exercicio11(int[][] arrayInt){
        int[] arrayUni = new int[arrayInt.length * arrayInt[0].length];
        int cont = 0;
        for(int i = 0; i<arrayInt.length; i++)
            for(int j=0; j<arrayInt[i].length; j++)
                arrayUni[cont++] = arrayInt[i][j];

        return arrayUni;
    }
}