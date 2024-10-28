package com.proyectoclase5;

import java.util.ArrayList;

import com.proyectoclase5.clases.Estudiante;
import com.proyectoclase5.clases.Instructor;
import com.proyectoclase5.clases.Persona;
import com.proyectoclase5.interfaces.CalculosMatematicos;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Instructor instructor1 = new Instructor("Candela", "1996-10-08", "cyarossi@codingdojo.la");
		Instructor instructor2 = new Instructor("Nestor", "1996-10-01", "nribero@codingdojo.la");

		// System.out.println(instructor1.toString());
		// System.out.println(instructor1.getNombre());

		Estudiante estudiante1 = new Estudiante("Natalia", "2001-08-10", "hola@gmail.com", "JAVA", "GORE-06");
		Estudiante estudiante2 = new Estudiante("Cristian", "2001-08-10", "hola@gmail.com", "JAVA", "GORE-06");
		Estudiante estudiante3 = new Estudiante("Simon", "2001-08-10", "hola@gmail.com", "JAVA", "GORE-06");

		// System.out.println(estudiante1);

		instructor2.agregarBootcamp("Java");
		instructor2.agregarBootcamp("MERN");

		instructor2.agregarEstudiante(estudiante1);
		instructor2.agregarEstudiante(estudiante2);
		instructor2.agregarEstudiante(estudiante3);

		// System.out.println(instructor2);

		Persona instructor3 = new Instructor("Candela", "1996-10-08", "cyarossi@codingdojo.la");
		Persona estudiante4 = new Estudiante("Natalia", "2001-08-10", "hola@gmail.com", "JAVA", "GORE-06");

		// System.out.println(instructor3);
		// System.out.println("");
		// System.out.println(estudiante4);

		ArrayList<Persona> personas = new ArrayList<>();

		personas.add(estudiante4);
		personas.add(instructor3);

		// System.out.println(personas);

		ArrayList<Integer> calificaciones = new ArrayList<>();
		calificaciones.add(8);
		calificaciones.add(10);
		calificaciones.add(9);

		estudiante1.setCalificaciones(calificaciones);
		System.out.println("Promedio: " + estudiante1.calcularPromedio());
		System.out.println(estudiante1.verCalificaciones());

		estudiante2.setCalificaciones(calificaciones);
		estudiante3.setCalificaciones(calificaciones);

		System.out.println(instructor2.verCalificaciones());

		// Persona persona1 = new Persona();

		CalculosMatematicos calculos = new Estudiante(null, null, null, null, null);
	}

}