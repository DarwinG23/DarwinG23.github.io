package org.campeonato.model;

import java.util.HashMap;

public class Equipo {
    //Attributos
    private String nombre;
    private String lema;
    private int victorias;
    private int derrotas;
    private int empates;
    private int anotacionesFavor;
    //Relaciones
    private HashMap<String, Competidor> competidorList;
    private HashMap<String, Inscripcion> inscripcionList;

    //Constructor
    public Equipo(String nombre, String lema) {
        this.nombre = nombre;
        this.lema = lema;
        this.victorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.anotacionesFavor = 0;
        this.competidorList = new HashMap<>();
    }
    //Metodo
    public void inscribirEquipo(Deporte deporte){
        Inscripcion inscripcion = new Inscripcion(0, this, deporte);//numero, equipo, deporte
        inscripcion.inscribirEquipo(this);
    }
    public void inscribirCompetidor(Competidor competidor){
        this.competidorList.put(competidor.getCorreo(), competidor);
        System.out.println("Se ha inscrito el competidor: " + competidor.getNombre() + " " + competidor.getApellido() + " al equipo: " + this.nombre);
    }

    //Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}
