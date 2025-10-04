package mx.yasekicode.gestorestudiante;

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
                    System.out.println("¡Estudiante añadido correctamente!");
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

    }
}