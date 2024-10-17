package clases;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {
    
    // ATRIBUTOS
    private String nombre;
    private LocalDate fechaNacimiento;
    private int edad;

    // Métodos CONSTRUCTORES
    public Persona() {
        this.nombre = "";
        this.fechaNacimiento = LocalDate.now();
        this.edad = 0;
    }

    public Persona(String nombre, String fechaNacimiento) {
        this.nombre = nombre;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fechaNacimiento, formatter);
        this.fechaNacimiento = date;
        this.edad = calcularEdad();
    }

    // Métodos GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.toString();
    }

    public int getEdad() {
        return edad;
    }

    // Métodos SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fechaNacimiento, formatter);
        this.fechaNacimiento = date;
        this.edad = calcularEdad();
    }

    // public void setEdad(int edad){
    // this.edad = edad;
    // }

    // Métodos de Instancia
    private int calcularEdad() {
        Period diferencia = Period.between(this.fechaNacimiento, LocalDate.now());
        int edadCalculada = diferencia.getYears();
        return edadCalculada;
    }

    // Métodos Heredados
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Fecha de Nacimiento: " + this.fechaNacimiento + ", Edad: " + this.edad;
    }

}
