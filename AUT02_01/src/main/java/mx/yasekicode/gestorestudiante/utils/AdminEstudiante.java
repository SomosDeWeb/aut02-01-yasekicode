package mx.yasekicode.gestorestudiante.utils;
import mx.yasekicode.gestorestudiante.models.Estudiante;
import java.util.ArrayList;

public class AdminEstudiante {
   private static ArrayList <Estudiante> listadoEstudiantes = new ArrayList<>(); //creando la lista

    public static void agregarEstudiante(Estudiante estudiante) {
        listadoEstudiantes.add(estudiante);
    }

//public static boolean agregarEstudiante(String nombre, int edad, double nota, boolean matricula) {
//Estudiante estudiante = new Estudiante(nombre, edad, nota, matricula);
//listadoEstudiantes.add(estudiante);
//return true;

}

