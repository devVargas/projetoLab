package exercicio.recursao;

public class Exercicio_lista2 {
    
    public static boolean exercicio1(int[] array, int n) throws IllegalArgumentException {
        if(array == null) throw new IllegalArgumentException();
        return exercicio1(array, n, 0);
    }

    private static boolean exercicio1(int[] array, int n, int index) {
        if(index >= array.length) return false;
        if(array[index] == n) return true;
        return exercicio1(array, n, index + 1);
    }

    public static boolean exercicio2(int n) throws IllegalArgumentException {
        if(n <= 1) throw new IllegalArgumentException();
        return exercicio2(n, 2);
    }

    private static boolean exercicio2(int n, int i) {
        if(i > n/2) return true;
        if(n % i == 0) return false;
        return exercicio2(n, i + 1);
    }

    public static String exercicio3(String a) throws IllegalArgumentException {
        if(a == null) throw new IllegalArgumentException();
        return exercicio3(a, 0, "");
    }

    private static String exercicio3(String a, int i, String b) {
        if(i >= a.length()) return b;
        b = a.charAt(i) + b;
        return exercicio3(a, i+1, b);
    }

    public static double exercicio4(int n) throws IllegalArgumentException {
        if(n <= 0) throw new IllegalArgumentException();
        return exercicio4(n, 1);
    }

    private static double exercicio4(int n, double i) {
        if(i >= n) return 1/i;
		return 1/i + exercicio4(n, i+1);
    }

    public static boolean exercicio5(String txt) throws IllegalArgumentException {
        if(txt == null) throw new IllegalArgumentException();
        txt = txt.replaceAll("[\\\\,.?!@(){}\\[\\] \\/]", "").toUpperCase();
        return exercicio5(txt, 0);
    }

    private static boolean exercicio5(String txt, int index) {
        if(index >= txt.length()/2) return true;
        return txt.charAt(index) == txt.charAt(txt.length() - 1 - index) ? exercicio5(txt, index + 1) : false;
    }

    public static int exercicio6(String[] array) throws IllegalArgumentException {
        if(array == null) throw new IllegalArgumentException();
        return exercicio6(array, 0);
    }

    private static int exercicio6(String[] array, int index) {
        if(index >= array.length) return 0;
        return exercicio5(array[index]) ? 1 + exercicio6(array, index + 1) : exercicio6(array, index + 1);
    }

    public static int exercicio7(int d, int n) throws IllegalArgumentException{
		if(d < 0 || n < 0 || d > 9) throw new IllegalArgumentException();
		return exercicio7r(d, n);
	}
	
	private static int exercicio7r(int d, int n){
		if(n == 0) return 0;
		return n % 10 == d ? 1 + exercicio7r(d, n/10) : exercicio7r(d, n/10);
	}
	
	public static double exercicio8(int n) throws IllegalArgumentException{
		if(n <= 0) throw new IllegalArgumentException();
		return exercicio8(n, 0, 0);
	}
	
	private static double exercicio8(int n, double soma, int quantDigitos){
		if(n == 0) return soma/quantDigitos;
		return exercicio8(n/10, soma + (n%10), quantDigitos+1);
	}
	
	public static boolean exercicio9(int n) throws IllegalArgumentException{
		if(n <= 0) throw new IllegalArgumentException();
		return exercicio9(n, 0, 1);
	}
	
	private static boolean exercicio9(int n, int soma, int i){
		if(i > n/2) return soma == n;
		return n % i == 0 ? exercicio9(n, soma + i, i+1) : exercicio9(n, soma, i+1);
	}

    public static void main(String[] args) {
        
        int[] array = {1, 2, 3, 4, 5};
        String[] array2 = {"abba", "abba", "abba"};
        System.out.println(exercicio1(array, 3));
        System.out.println(exercicio2(3));
        System.out.println(exercicio3("abc"));
        System.out.println(exercicio4(3));
        System.out.println(exercicio5("abba"));
        System.out.println(exercicio6(array2));
        System.out.println(exercicio7(3, 123));
        System.out.println(exercicio8(123));
        System.out.println(exercicio9(123));

    } 
}
