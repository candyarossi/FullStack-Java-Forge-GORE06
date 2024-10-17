package clases;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {

    // Atributos de Instancia
    private String nombre;
    private LocalDate fechaNacimiento;
    private int edad;
    private String email;
    private int id;

    // Atributos de Clase / Estáticos
    public static int incrementId = 1;

    // Métodos CONSTRUCTORES
    public Persona() {
        // Referencia al Objeto Instanciado
        // this;
        // Referencia al atributo de un objeto instanciado
        // this.nombre;
        // Referencia a los métodos de un objeto instanciado
        // this.getNombre();
        // this.calcularEdad();
        // this.toString();

        // Referencia al método constructor = Persona();
        this("", LocalDate.now().toString(), "");
    }

    public Persona(String nombre, String fechaNacimiento) {
        this(nombre, fechaNacimiento, "");
    }

    public Persona(String nombre, String fechaNacimiento, String email) {
        this.nombre = nombre;
        this.fechaNacimiento = formatearFecha(fechaNacimiento);
        this.edad = calcularEdad();
        this.email = email;
        this.id = Persona.incrementId++;
    }

    // Métodos GETTERS
    public static int getIncrementId() {
        return incrementId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.toString();
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    // Métodos SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = formatearFecha(fechaNacimiento);
        this.edad = calcularEdad();
    }

    // public void setEdad(int edad){
    // this.edad = edad;
    // }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos de Instancia
    private int calcularEdad() {
        Period diferencia = Period.between(this.fechaNacimiento, LocalDate.now());
        int edadCalculada = diferencia.getYears();
        return edadCalculada;
    }

    // Métodos de Clase / Estáticos
    public static LocalDate formatearFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fecha, formatter);
        return date;
    }

    // Métodos Heredados
    @Override
    public String toString() {
        return "ID: " + this.getId() + ", Nombre: " + this.getNombre() + ", Fecha de Nacimiento: "
                + this.getFechaNacimiento() + ", Edad: "
                + this.getEdad() + ", Email: " + this.getEmail();
    }

}
