package org.campeonato.model;

import java.util.HashMap;
import java.util.Scanner;

public class Deporte {
    //Atributos
    private String nombre;
    private String descripcion;
    private boolean esPorEquipos;
    private int cantidadJugadores;
    private int cantidadEquipo;
    private boolean esPorPuntos;
    private int duracionPartido;
    private int puntoLimite;

    //Relaciones
    private Temporada temporada;
    private HashMap<String, Regla> reglaList = new HashMap<String, Regla>();
    private HashMap<String, Competidor> competidorList = new HashMap<String, Competidor>();
    private HashMap<String, Equipo> equipoList = new HashMap<String, Equipo>();
    private HashMap<String, Inscripcion> inscripcionList = new HashMap<String, Inscripcion>();
    private HashMap<String, Encuentro> EncuentroList = new HashMap<String, Encuentro>();
    private Horario horario;
    //Constructor
    public Deporte(String nombre, String descripcion, boolean esDeEquipo, boolean esPorPuntos, int cantidadJugadores, int cantidadEquipos, Temporada temporada, int puntosParaGanar, int tiempoDeJuego) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esPorEquipos = esPorEquipos;
        this.cantidadJugadores = cantidadJugadores;
        this.cantidadEquipo = cantidadEquipo;
        this.esPorPuntos = esPorPuntos;
        this.temporada = temporada;
        reglaList = new HashMap<String, Regla>();
        this.duracionPartido = duracionPartido;
        this.puntoLimite = puntoLimite;
        this.competidorList = new HashMap<String, Competidor>();
    }
    public Deporte(String nombre,String descripcion,boolean esDeEquipo,boolean esPorPuntos, int cantidadJugadores, Temporada temporada, int puntosParaGanar, int tiempoDeJuego){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esPorEquipos = esDeEquipo;
        this.cantidadJugadores = cantidadJugadores;
        this.esPorPuntos = esPorPuntos;
        this.temporada = temporada;
        reglaList = new HashMap<String, Regla>();
        this.duracionPartido = tiempoDeJuego;
        this.puntoLimite = puntosParaGanar;
        this.competidorList = new HashMap<String, Competidor>();
    }
    //Metodos
    public void agregarRegla(Deporte deporte){
        Scanner sc = new Scanner(System.in);
        int numReglas = 1;
        System.out.println("POR FAVOR INGRESE LAS REGLAS DEL DEPORTE");
        do {
            System.out.println("Ingrese el nombre de la regla: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese la descripcion de la regla: ");
            String descripcion = sc.nextLine();
            Regla regla = new Regla(numReglas, descripcion, nombre, deporte);
            System.out.println("Desea agregar otra regla? (S/N)");
            String respuesta = sc.nextLine();
            reglaList.put(regla.getNombre(), regla);
            if (respuesta.equals("S") || respuesta.equals("s")){
                numReglas++;
            }else {
                break;
            }
        } while (false);
    }

    public void inscribirCompetidor(Competidor competidor){
        if (competidorList.containsKey(competidor.getNombre())){
            System.out.println("El competidor ya esta inscrito al deporte " + this.nombre);
        }else {
            competidorList.put(competidor.getNombre(), competidor);
            System.out.println("Se ha inscrito el competidor: " + competidor.getNombre() + " al deporte: " + this.nombre);
        }
    }
    public void inscribirEquipo(Equipo equipo){
        if (equipoList.containsKey(equipo.getNombre())){
            System.out.println("El equipo ya esta inscrito al deporte " + this.nombre);
        }else {
            equipoList.put(equipo.getNombre(), equipo);
            System.out.println("Se ha inscrito el equipo: " + equipo.getNombre() + "al deporte: " + this.nombre);
        }
    }
    public boolean verificarEquipo(String nombreDeporte, Competidor competidor){
        if (equipoList.containsKey(nombreDeporte)){
            equipoList.get(nombreDeporte).inscribirCompetidor(competidor);
            return true;
        }else {
            System.out.println("El equipo no esta inscrito");
            return false;
        }
    }

    public void crearHorarioEquipo(Modalidad modalidad){
        Horario horario = new Horario(this);
        this.horario = horario;
        horario.crearEncuentroEquipo(equipoList, modalidad);
    }

    public void crearHorarioCompetidor(Modalidad modalidad){
        Horario horario = new Horario(this);
        this.horario = horario;
        boolean sonPares;
        if (competidorList.size() % 2 == 0){
            sonPares = true;
        }else {
            sonPares = false;
        }


    }
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsPorEquipos() {
        return esPorEquipos;
    }

    public void setEsPorEquipos(boolean esPorEquipos) {
        this.esPorEquipos = esPorEquipos;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    //ToString
    @Override
    public String toString() {
        return "\nDeporte(" +
                "nombre:" + nombre +
                ", descripcion: " + descripcion +
                ", esPorEquipos: " + esPorEquipos +
                ", cantidad Jugadores: " + cantidadJugadores +
                ", cantidad Equipos:" + cantidadEquipo +
                ", esPorPuntos=" + esPorPuntos +
                ", Tiempo de Juego: " + duracionPartido +
                ", Puntos para ganar: " + puntoLimite +
                ", Lista de Reglas: " + reglaList +
                ", Lista de Competidores: " + competidorList +
                ')';
    }


}
