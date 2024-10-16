package clases;

public class Calculadora {
    public static int sumar(int a, int b) {
        System.out.println("Sumar 2 enteros");
        return a + b;
    }

    public static int sumar(int a, int b, int c) {
        System.out.println("Sumar 3 enteros");
        return a + b + c;
    }

    public static int sumar(int a, double b) {
        System.out.println("Sumar un entero y un double");
        return a + (int) b;
    }
}
