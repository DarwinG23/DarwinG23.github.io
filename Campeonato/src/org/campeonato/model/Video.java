package org.campeonato.model;

public class Video {
    //Attributes
    private String nombre;
    private String descripcion;

    //Relaciones
    private Usuario usuario;


    private class Comentario{
        private String texto;
        private Usuario usuario;

        //Constructor
        public Comentario(String texto, Usuario usuario) {
            this.texto = texto;
            this.usuario = usuario;
        }


    }

    //Constructor
    public Video(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    //Metodos
    public void comentar(String texto, Usuario usuario){
        Comentario comentario = new Comentario(texto, usuario);
    }
    //Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
