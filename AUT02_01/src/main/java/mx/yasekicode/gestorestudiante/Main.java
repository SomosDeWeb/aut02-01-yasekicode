package mx.yasekicode.gestorestudiante;
import mx.yasekicode.gestorestudiante.models.Estudiante;
import mx.yasekicode.gestorestudiante.utils.AdminEstudiante;
import static mx.yasekicode.gestorestudiante.utils.AdminEstudiante.*;
import java.util.Scanner;

//import static mx.yasekicode.gestorestudiante.utils.AdminEstudiante.mostrarEstudiantes;

public class Main {

    public static void main(String[] args) {

        int numSelect;
        Scanner entrada = new Scanner(System.in);
        do {
            //menu de opciones p/ la gestion del estudiant
            System.out.println("\n=== GESTIÓN DE ESTUDIANTES ===");
            System.out.println("1. Añadir estudiante");
            System.out.println("2. Lista de estudiantes");
            System.out.println("3. Buscar estudiante por nombre");
            System.out.println("4. Calcular media de notas");
            System.out.println("5. Estudiante con mejor calificación");
// ------------         SALIR DEL PROGRAMA
            System.out.println("6. Salir");
            System.out.println("================================");
            System.out.print("Selecciona una opción: ");

            while (!entrada.hasNextInt()) {
                System.out.println("¡ERROR! INGRESA UN NUMERO DEL 1-6");
                entrada.next();
                System.out.print("Selecciona una opción: ");
            }

            numSelect = entrada.nextInt();

            switch (numSelect) {
                case 1:
                    addEstudiante(entrada);
                    break;

                case 2:
                    System.out.println("\n--- LISTADO DE ESTUDIANTES ---");
                    System.out.printf(mostrarEstudiantes());
                    break;

                case 3:
                    buscarNombre(entrada);
                    break;

                case 4:
                    System.out.println("\n--- NOTA MEDIA GENERAL ---");
                    mostrarNotaMediaGral();
                    break;

                case 5:
                    notaMasAlta();
                    break;
// ------------         SALIR DEL PROGRAMA
                case 6:
                    System.out.println("¡Programa finalizado!");
                    break;

                default:
                    System.out.println("Elección del menú invalida");
                    break;
            }

        } while (numSelect != 6);
        entrada.close();
    }

// Añadir estudiante 3er commit
    private static void addEstudiante(Scanner entrada) {
        System.out.println("\n--- AÑADIR NUEVO ESTUDIANTE ---");
        entrada.nextLine();

        Estudiante nuevoEstudiante = new Estudiante(); //Se crea la instancia de la clase!
        boolean datosValidos = true;

        System.out.println("Nombre: ");
        String nombre = entrada.nextLine();
        if (!nuevoEstudiante.setNombre(nombre)){
            System.out.println("Error: Nombre no valido");
            datosValidos = false;
        }

        System.out.println("Edad: ");
        if (entrada.hasNextInt()) {
            int edad = entrada.nextInt();
            if (!nuevoEstudiante.setEdad(edad)) {
                System.out.println("Error: Edad debe ser entre 5 y 80");
                datosValidos = false;
            }
        } else {
            System.out.println("Error: La edad debe ser un numero");
            entrada.next();
            datosValidos = false;
        }

        System.out.println("Nota media: ");
        if (entrada.hasNextDouble()) {
            double notaMedia = entrada.nextDouble();
            if (!nuevoEstudiante.setNotaMedia(notaMedia)) {
                System.out.println("Error: Nota debe ser entre 0 y 10");
                datosValidos = false;
            }
        } else {
                System.out.println("Error: La nota debe ser un numero");
                entrada.next();
                datosValidos = false;
        }

        entrada.nextLine();
        System.out.println("¿Esta matriculado? (true/false): ");

        if (entrada.hasNextBoolean()) {
            boolean matricula = entrada.nextBoolean();
            nuevoEstudiante.setMatricula(matricula);
        } else {
            String entradaMal = entrada.next();
            System.out.println("Error: escribir  'true' o 'false'");
            datosValidos = false;
        }

        //llamar clase AdminEstudiante para añadir
        if (datosValidos) {
            AdminEstudiante.agregarEstudiante(nuevoEstudiante);
            System.out.println("¡Estudiante añadido exitosamente!");
        } else {
            System.out.println("Estudiante NO AGREGADO - Verifica los datos");
        }
    }


// -------      BUSCA DE ESTUDIANTE POR NOMBRE.. -------------

    private static void buscarNombre(Scanner entrada) {
        System.out.println("\n--- BUSCAR ESTUDIANTE POR NOMBRE ---");
        entrada.nextLine();

        System.out.println("Ingrese el nombre: ");
        String nombre = entrada.nextLine(); //captura

        Estudiante estudianteEncontrado = AdminEstudiante.buscarNombreEstudiante(nombre);
        //si existe
        if (estudianteEncontrado !=null) {
            System.out.println("Datos del estudiante:");
            System.out.println("Nombre: " + estudianteEncontrado.getNombre());
            System.out.println("Edad: " + estudianteEncontrado.getEdad());
            System.out.println("Nota media: " + estudianteEncontrado.getNotaMedia());
            System.out.println("Matriculado: " + estudianteEncontrado.getMatricula());

        }else {
            System.out.println("USER NOT FUND: " + nombre);
        }
    }


// ----------- Nota media General de todos los estudiantes --------
    private static void mostrarNotaMediaGral() {
        Double promedio = AdminEstudiante.obtenerNotaMGral(); //return promedio de la clase AdEstud relacionado con metodo..

        if (promedio == null) {
            System.out.println("USERS NOT FUND:\n");
        } else {
            System.out.println("> " + promedio + " <");
        }
    }


// ------- Estudiante cn la nota mas alta ----------
    private static void notaMasAlta() {
        //Double mejorNota = AdminEstudiante.obtenerMejorNota();
        Estudiante estudiante = AdminEstudiante.obtenerMejorNota(); //retorn al alumno con la nota+

        System.out.println("\n--- ESTUDIANTE CON LA NOTA + ALTA ---");
        if (estudiante == null) {
            System.out.println("USERS NOT FUND:\n");

        } else {
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Edad: " + estudiante.getEdad());
            System.out.println("Nota: " + estudiante.getNotaMedia());
            System.out.println("Matricula: " + estudiante.getMatricula());
        }
    }

}