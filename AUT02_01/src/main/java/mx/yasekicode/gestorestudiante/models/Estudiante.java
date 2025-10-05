package mx.yasekicode.gestorestudiante.models;

public class Estudiante {
    //atributos
    private String nombre;
    private int edad;
    private double notaMedia;
    private boolean matricula ;

    //constructor
    //public Estudiante(String nombre, int edad, double notaMedia, boolean matricula) {
    public Estudiante() {
        this.nombre = "";
        this.edad = 0;
        this.notaMedia = 0.0;
        this.matricula = false;

//testeando funcionamiento
//this.nombre = nombre;
//this.edad = edad;
//this.notaMedia = notaMedia;
//this.matricula = matricula;
//setNombre(nombre);
//setEdad(edad);
//setNotaMedia(notaMedia);
//setMatricula(matricula);
    }

    //metodos de acceso GETTERS Y SETTERS
    //Nombre del alumno
    public String getNombre() { //obteniendo variable privada a public
        return nombre;
    }
    public boolean setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    //edad del alumno
    public int getEdad() {
        return edad;
    }
    public boolean setEdad(int edad) {
        if (edad >= 5 && edad <= 80) {
            this.edad = edad;
            return true;
        }
        return false;
    }

    //nota del alumno
    public double getNotaMedia(){
        return notaMedia;
    }
    public boolean setNotaMedia(double notaMedia) {
        if (notaMedia >= 0 && notaMedia <= 10) {
            this.notaMedia = notaMedia;
            return true;
        }
        return false;
    }

    //matricula del alumno
   public boolean getMatricula(){
        return matricula;
   }
   public void setMatricula(boolean matricula) {
        this.matricula = matricula;
   }
}
