package org.campeonato.model;

import java.util.HashMap;

public class Competidor extends Usuario{
    //Atributos
    private int victoria;
    private int derrota;
    private int empate;
    private int anotacionesFavor;
    private boolean sancion;
    private int partidosJugados;

    //Relaciones
    private Temporada temporada;
    private HashMap<String, Inscripcion> inscripcionList = new HashMap<String, Inscripcion>();
    private Equipo equipo;

    //Constructor
    public Competidor(String nombre, String apellido, String correo, String contrasenia, Registro registro) {
        super(nombre, apellido, correo, contrasenia, registro);
    }
    //Metodos
    public void inscribirCompetidorDeporte(Deporte deporte){
        Inscripcion inscripcion = new Inscripcion(0, this, deporte);
        inscripcion.inscribirCompetidor();
    }
    //Getters y Setters
    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public HashMap<String, Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(HashMap<String, Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
    }

}
