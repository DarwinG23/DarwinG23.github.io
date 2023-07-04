package org.campeonato.model;

public class Modalidad {
    //Atributos
    private String tipoModalidad;

    //Relaciones
    private Temporada temporada;

    //Constructor
    public Modalidad(String tipoModalidad, Temporada temporada) {
        this.tipoModalidad = tipoModalidad;
        this.temporada = temporada;

    }

    public String getTipoModalidad() {
        return tipoModalidad;
    }

    public void setTipoModalidad(String tipoModalidad) {
        this.tipoModalidad = tipoModalidad;
    }
}
