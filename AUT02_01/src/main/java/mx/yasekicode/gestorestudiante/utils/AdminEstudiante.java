package mx.yasekicode.gestorestudiante.utils;
import mx.yasekicode.gestorestudiante.models.Estudiante;
import java.util.ArrayList;

public class AdminEstudiante {
    private static final ArrayList<Estudiante> listadoEstudiantes = new ArrayList<>(); //creando la lista

//AÑADIR ESTUDIANTE
    public static void agregarEstudiante(Estudiante estudiante) {
        listadoEstudiantes.add(estudiante);
    }

//MOSTRARLOS 4to commit
    public static String mostrarEstudiantes() {
        if (listadoEstudiantes.isEmpty()) {
            return "USERS NOT FUND\n";
        }

        StringBuilder lista = new StringBuilder();
        for (Estudiante L: listadoEstudiantes) {
            lista.append(L.getNombre() + " (" + L.getEdad() + " años)" + " - Nota media: " + L.getNotaMedia() + " - Matriculada: " + L.getMatricula() +"\n");
        }

        return lista.toString(); //imprimir metodo mostrarEstudiantes.
    }

}




