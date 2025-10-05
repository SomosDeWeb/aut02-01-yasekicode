package mx.yasekicode.gestorestudiante;
import mx.yasekicode.gestorestudiante.models.Estudiante;
import mx.yasekicode.gestorestudiante.utils.AdminEstudiante;
import java.util.Scanner;

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
            System.out.println("6. Salir");
            System.out.println("================================");
            System.out.print("Selecciona una opción: ");

            //int numSelect=entrada.nextInt();
            numSelect = entrada.nextInt();

            switch (numSelect) {
                case 1:
                    addEstudiante(entrada);
                    break;

                case 2:
                    System.out.println("Lista de estudiantes: ");
                    break;

                case 3:
                    System.out.println("Buscar estudiante por nombre: ");
                    break;

                case 4:
                    System.out.println("Calcular la media de todas las notas: ");
                    break;

                case 5:
                    System.out.println("Estudiante con la mejor calificación: ");
                    break;

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

    private static void addEstudiante(Scanner entrada) {
        System.out.println("\n--- AÑADIR NUEVO ESTUDIANTE ---");
        entrada.nextLine();

        Estudiante nuevoEstudiante = new Estudiante(); //OBJETO ESTUDIANTE VACIO!!
        boolean datosValidos = true;

        System.out.println("Nombre: ");
        String nombre = entrada.nextLine();
        if (!nuevoEstudiante.setNombre(nombre)){
            System.out.println("❌ Error: Nombre no válido");
            datosValidos = false;
        }

        System.out.println("Edad: ");
        if (entrada.hasNextInt()) {
            int edad = entrada.nextInt();
            if (!nuevoEstudiante.setEdad(edad)) {
                System.out.println("❌ Error: Edad debe ser entre 5 y 80");
                datosValidos = false;
            }
        } else {
            System.out.println("❌ Error: La edad debe ser un número");
            entrada.next();
            datosValidos = false;
        }

        System.out.println("Nota media: ");
        if (entrada.hasNextDouble()) {
            double notaMedia = entrada.nextDouble();
            if (!nuevoEstudiante.setNotaMedia(notaMedia)) {
                System.out.println("❌ Error: Nota debe ser entre 0 y 10");
                datosValidos = false;
            }
        } else {
                System.out.println("❌ Error: La nota debe ser un número");
                entrada.next();
                datosValidos = false;
        }

        entrada.nextLine();
        System.out.println("¿Esta matriculado? (true/false): ");
        boolean matricula = entrada.nextBoolean();
        nuevoEstudiante.setMatricula(matricula);

        //llamar clase AdminEstudiante para añadir
        if (datosValidos) {
            AdminEstudiante.agregarEstudiante(nuevoEstudiante);
            System.out.println("¡Estudiante añadido exitosamente!");
        } else {
            System.out.println("❌ No se pudo agregar el estudiante - Verifica los datos");
        }

//tessssst
//boolean seAgrego = AdminEstudiante.agregarEstudiante(nombre, edad, notaMedia, matricula);
// if (seAgrego) {
//    System.out.println("¡Estudiante añadido exitosamente!");
// } else {
   // System.out.println("❌ No se pudo agregar el estudiante - Verifica los datos");
// }
// return true;
    }
}