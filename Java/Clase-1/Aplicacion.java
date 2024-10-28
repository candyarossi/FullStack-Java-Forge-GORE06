import clases.Calculadora;
import java.util.Date;
import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {

        // Imprimir Valores
        System.out.println("¡Saludos desde Java!");

        // Algunos Datos Primitivos
        int edad = 20;
        double altura = 15.9;
        boolean esAlumno = true;
        char letra = 'b';

        // Algunas Clases Wrapper
        Integer edad2 = 20;
        String str = "Hola Mundo";
        String str2 = new String("Hola Mundo");

        // Métodos de Strings
        String saludo = "Hola" + " " + "Mundo";
        String saludo2 = saludo.concat("!");
        int cantidad = saludo2.length();
        int indice = saludo2.indexOf("Mundo");
        String mayusculas = saludo2.toUpperCase();
        String minusculas = saludo2.toLowerCase();
        String sinEspacios = saludo2.trim();

        // == -> Numeros/booleanos
        // .equals / .equalsIgnoreCase -> Strings

        String saludo3 = "hola mundo!";
        System.out.println(saludo2.equalsIgnoreCase(saludo3));

        // Casting
        double miDouble = 10.5;
        int miEntero = (int) miDouble;

        int miEntero2 = 10;
        double miDouble2 = miEntero2;

        System.out.println(miDouble2);

        // Condicionales
        int numero = -10;

        if (numero < 0 && numero > -20) {
            System.out.println("Menor a 0");
        } else {
            System.out.println("Mayor a 0");
        }

        // Operadores aritméticos: + - * / % ^
        // Operadores relacionales / de comparación: == != < <= > >=
        // Operadores lógicos: && || !

        // Operador ternario
        int numero2 = 10;
        String resultado = numero2 >= 20 ? "Mayor o igual a 20" : "Menor o igual a 20";

        System.out.println(resultado);

        // Switch (opción 1)
        int nroDelDia = 9;
        String nombreDelDia;

        switch (nroDelDia) {
            case 1:
                nombreDelDia = "Lunes";
                break;
            case 2:
                nombreDelDia = "Martes";
                break;
            case 3:
                nombreDelDia = "Miercoles";
                break;
            case 4:
                nombreDelDia = "Jueves";
                break;
            case 5:
                nombreDelDia = "Viernes";
                break;
            case 6:
                nombreDelDia = "Sabado";
                break;
            case 7:
                nombreDelDia = "Domingo";
                break;
            default:
                nombreDelDia = "Numero Invalido";
                break;
        }

        // Switch (opción 2)
        nombreDelDia = switch (nroDelDia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miercoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sabado";
            case 7 -> "Domingo";
            default -> "Numero Invalido";
        };

        System.out.println(nombreDelDia);

        // Capturar un INT por consola
        Scanner scanner = new Scanner(System.in);
        int entero = scanner.nextInt();

        System.out.println(entero);

        // Modularización y Métodos Estáticos
        System.out.println(Calculadora.sumar(2, 3));
        System.out.println(Calculadora.sumar(2, 3, 7));
        System.out.println(Calculadora.sumar(2, 3.5));

        Date fechaActual = new Date();
        System.out.println("La fecha actual es: " + fechaActual);
    }
}