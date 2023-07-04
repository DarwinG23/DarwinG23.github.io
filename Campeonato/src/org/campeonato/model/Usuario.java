package org.campeonato.model;

import java.util.HashMap;
import java.util.Scanner;

public class Usuario {
    //Attributos
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    //Relaciones
    protected Registro registro;
    HashMap<String, Video> videoList = new HashMap<String, Video>();

    //Constructor
    public Usuario(String nombre, String apellido, String correo, String contrasenia, Registro registro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.registro = registro;
    }
    //Metodos
    public void subirVideo(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del video: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese la descripcion del video: ");
        String descripcion = entrada.nextLine();
        Video video = new Video(nombre, descripcion);
        videoList.put(video.getNombre(), video);
    }

    public void  comentarVideo(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del video: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el comentario: ");
        String comentario = entrada.nextLine();
        Video video = videoList.get(nombre);
        video.comentar(comentario, this);
    }

    //Getters & Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //ToString
    @Override
    public String toString() {
        return "\nUsuario{" +
                "nombre: " + nombre +
                ", apellido: " + apellido +
                ", correo: " + correo +
                '}';
    }
}
