package org.campeonato.model;

public class Regla {
    //Attributes
    private int numero;
    private String descripcion;
    private String nombre;
    //Relaciones
    private Deporte deporte;

    //Constructor
    public Regla(int numero, String descripcion, String nombre, Deporte deporte) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.deporte = deporte;
    }
    //Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //ToString
    @Override
    public String toString() {
        return "\nRegla{" +
                "numero: " + numero +
                ", nombre: " + nombre +
                ", descripcion: " + descripcion +
                '}';
    }

}
