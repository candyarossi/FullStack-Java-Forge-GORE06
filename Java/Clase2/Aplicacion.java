import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Aplicacion {
    public static void main(String[] args) {

        // Arreglos Estáticos
        int[] numeros = new int[5];

        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;

        System.out.println(numeros[0]);
        System.out.println(numeros[2]);
        System.out.println("Cantidad: " + numeros.length);

        int[] numeros2 = { 1, 2, 3, 4, 5 };

        System.out.println(numeros2[3]);
        System.out.println("Cantidad de numeros2: " + numeros2.length);
        System.out.println(numeros2[8]);

        // Arreglos Dinámicos
        ArrayList<String> colores = new ArrayList<String>();

        colores.add("Rojo");
        colores.add("Verde");
        colores.add("Azul");

        System.out.println(colores);

        colores.remove(1);
        System.out.println(colores);

        System.out.println("Indice 0: " + colores.get(0));
        System.out.println("Cantidad: " + colores.size());

        // CICLOS
        for (int i = 0; i < colores.size(); i++) {
            System.out.println(colores.get(i));
        }

        int i = 0;
        while (i < colores.size()) {
            System.out.println(colores.get(i));
            i++;
        }

        i = 0;
        do {
            System.out.println(colores.get(i));
            i++;
        } while (i < colores.size());

        // For-each
        for (String elemento : colores) {
            System.out.println("For: " + elemento);
        }

        // HASHMAPS
        HashMap<String, Integer> personas = new HashMap<String, Integer>();

        personas.put("Juan", 35);
        personas.put("María", 65);
        personas.put("Jose", 25);

        System.out.println(personas);

        System.out.println(personas.get("María"));

        personas.remove("María");
        System.out.println("Después de borrar: " + personas);

        System.out.println("Tamaño: " + personas.size());

        // Iterar HashMap
        Set<String> claves = personas.keySet();
        System.out.println("Claves: " + claves);

        for (String clave : claves) {
            System.out.println(clave + ": " + personas.get(clave));
        }

        System.out.println(personas.get("Dani"));

        // EXCEPCIONES
        try {
            System.out.println("Indice 2: " + numeros[2]);
            System.out.println("Indice 8: " + numeros[8]);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Estas intentando acceder a un índice no válido");
        }
    }
}