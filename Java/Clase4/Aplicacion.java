import clases.Persona;

public class Aplicacion {
    public static void main(String[] args) {
        Persona persona1 = new Persona();

        Persona persona2 = new Persona("Candela", "1996-10-08");
        persona2.setEmail("cyarossi@codingdojo.la");

        Persona persona3 = new Persona("Usuario3", "1998-10-23", "email@gmail.com");

        // int ultimoId = persona3.getId();
        // Persona persona4 = new Persona(ultimoId, ...);

        // System.out.println(persona2.getNombre());
        // persona2.setFechaNacimiento("2002-12-03");
        // System.out.println(persona2.getFechaNacimiento());
        // System.out.println(persona2.getEdad());

        System.out.println(persona1.toString());
        System.out.println(persona2.toString());
        System.out.println(persona3.toString());
        System.out.println("Siguiente ID: " + Persona.getIncrementId());
    }
}