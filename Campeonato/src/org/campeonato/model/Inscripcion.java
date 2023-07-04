package org.campeonato.model;

public class Inscripcion {
    //Atributos
    private int numero;
    private String tipoInscripcion;
    //Relaciones
    private Competidor competidor;
    private Equipo equipo;
    private Deporte deporte;

    //Constructor
    public Inscripcion(int numero, Equipo equipo, Deporte deporte) {
        this.numero = numero;
        this.equipo = equipo;
        this.deporte = deporte;
        tipoInscripcion ="Deporte de equipo";
    }
    public Inscripcion(int numero, Competidor competidor, Deporte deporte) {
        this.numero = numero;
        this.competidor = competidor;
        this.deporte = deporte;
        tipoInscripcion ="Deporte individual";
    }

    //Metodos
    public void inscribirCompetidor(){
        deporte.inscribirCompetidor(this.competidor);
    }
    public void inscribirEquipo(Equipo equipo){
       deporte.inscribirEquipo(equipo);
    }
    //Getters y Setters

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }
}
