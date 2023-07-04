package org.campeonato.model;

import java.util.HashMap;
import java.util.Scanner;

public class Temporada {
    //Atributos
    String nombre;
    String descripcion;
    private Fecha fechaInicio;
    private Fecha fechaFin;

    //Relaciones
    private Campeonato campeonato;
    private HashMap<String, Deporte> deporteList = new HashMap<String, Deporte>();
    private Modalidad modalidad;
    HashMap<String, Competidor> competidorList = new HashMap<String, Competidor>();

    //Constructor
    public Temporada(String nombre, String descripcion, Campeonato campeonato, Fecha fechaInicio, Fecha fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.campeonato = campeonato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    //Metodos
    public void agregarDeporte(Temporada temporada){
        Deporte deporte;
        int puntosParaGanar = 0;
        int tiempoDeJuego = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del deporte");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la descripcion del deporte");
        String descripcion = sc.nextLine();
        System.out.println("Es un deporte de equipo? (S/N)");
        String respuesta = sc.nextLine();
        boolean esDeEquipo = false;
        if(respuesta.equals("S") || respuesta.equals("s")){
            esDeEquipo = true;
        }
        System.out.println("Es un deporte por puntos? (S/N)");
        respuesta = sc.nextLine();
        boolean esPorPuntos = false;
        if(respuesta.equals("S") || respuesta.equals("s")){
            esPorPuntos = true;
            System.out.println("Ingrese la cantidad de puntos para ganar");
            puntosParaGanar = sc.nextInt();
        }else {
            System.out.println("Ingrese la duracion del partido en minutos");
            tiempoDeJuego = sc.nextInt();
        }
        if (esDeEquipo == true){
            System.out.println("Ingrese la cantidad de jugadores por encuentro");
            int cantidadJugadores = sc.nextInt();
            System.out.println("Ingrese la cantidad de equipos por encuentro");
            int cantidadEquipos = sc.nextInt();
            deporte = new Deporte(nombre, descripcion, esDeEquipo, esPorPuntos, cantidadJugadores, cantidadEquipos, temporada, puntosParaGanar, tiempoDeJuego);
        }else {
            System.out.println("Ingrese la cantidad de jugadores por encuentro");
            int cantidadJugadores = sc.nextInt();
            deporte= new Deporte(nombre, descripcion, esDeEquipo, esPorPuntos, cantidadJugadores, temporada, puntosParaGanar, tiempoDeJuego);
        }
        System.out.println("-------------------------------------------------------------------------------");
        deporte.agregarRegla(deporte);
        deporteList.put(deporte.getNombre(), deporte);
    }

    public void crearCompetidor(){
        boolean inscribir = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("SE HA CREADO UNA TEMPORADA");
        System.out.println("Añada los correos de los usuarios que desee inscribir como competidores");
        do {
            for (String key : campeonato.getRegistro().getUsuarioList().keySet()) {
                System.out.println(">" + key);
            }
            System.out.println("Correo: ");
            String correo = sc.nextLine();
            inscribir = campeonato.getRegistro().getUsuarioList().get(correo).getRegistro().verificarUsuario(correo);
            if (inscribir){
                Competidor competidor = new Competidor(campeonato.getRegistro().getUsuarioList().get(correo).getNombre(), campeonato.getRegistro().getUsuarioList().get(correo).getApellido(), campeonato.getRegistro().getUsuarioList().get(correo).getCorreo(),campeonato.getRegistro().getUsuarioList().get(correo).getContrasenia() ,campeonato.getRegistro().getUsuarioList().get(correo).getRegistro());
                elegirDeporte(competidor);
            }
            System.out.println("Desea inscribir a otro competidor? (S/N)");
            String respuesta = sc.nextLine();
            if (respuesta.equals("N") || respuesta.equals("n")){
                crearHorario(modalidad);
                break;
            }
        } while (true);
    }
    public void elegirDeporte(Competidor competidor){
        System.out.println("LISTA DE DEPORTES DE LA TEMPORADA");
        for (String key : deporteList.keySet()) {
            System.out.println(">" + key);
        }
        do {
            System.out.println("Ingrese el nombre del deporte en el que desea inscribirse");
            Scanner sc = new Scanner(System.in);
            String nombreDeporte = sc.nextLine();
            if (deporteList.containsKey(nombreDeporte)){
                if(deporteList.get(nombreDeporte).isEsPorEquipos()){
                    System.out.println("Necesita un equipo para inscribirse a" + nombreDeporte);
                    System.out.println("Desea crear un equipo o inscribirse a uno que ya existe? (C/I)");
                    String respuesta = sc.nextLine();
                    if (respuesta.equals("C") || respuesta.equals("c")){
                        crearEquipo(nombreDeporte);
                    }else{
                        inscribirEquipo(nombreDeporte, competidor);
                    }
                }else {
                    competidor.inscribirCompetidorDeporte(deporteList.get(nombreDeporte));
                    competidorList.put(competidor.getCorreo(), competidor);
                }
            }else {
                System.out.println("El deporte ingresado no existe");
                System.out.println("Desea inscribirse en otro deporte? (S/N)");
                String respuesta = sc.nextLine();
                if (respuesta.equals("N") || respuesta.equals("n")){
                    break;
                }
                elegirDeporte(competidor);
                break;
            }
            System.out.println("Desea inscribirse en otro deporte? (S/N)");
            String respuesta = sc.nextLine();
            if (respuesta.equals("N") || respuesta.equals("n")){
                break;
            }
        }while (true);
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void crearEquipo(String nombreDeporte){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese el nombre del equipo");
            String nombreEquipo = sc.nextLine();
            System.out.println("Ingrese el lema del equipo");
            String descripcionEquipo = sc.nextLine();
            Equipo equipo = new Equipo(nombreEquipo, descripcionEquipo);
            System.out.println("Se ha creado el equipo " + nombreEquipo + " con éxito");
            equipo.inscribirEquipo(deporteList.get(nombreDeporte));
            System.out.println("Desea inscribir otro equipo? (S/N)");
            String respuesta = sc.nextLine();
            if (respuesta.equals("N") || respuesta.equals("n")){
                break;
            }
        }while (true);
    }
    public void inscribirEquipo(String nombreDeporte, Competidor competidor){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del equipo al que desea inscribirse");
        String nombreEquipo = sc.nextLine();
        boolean existe = false;
        existe = deporteList.get(nombreDeporte).verificarEquipo(nombreEquipo, competidor);
        if (existe){
            competidor.inscribirCompetidorDeporte(deporteList.get(nombreDeporte));
            competidorList.put(competidor.getCorreo(), competidor);
        }else {
            System.out.println("El equipo ingresado no esta registrado");
            System.out.println("Desea inscribirse en otro deporte? (S/N)");
            String respuesta = sc.nextLine();
            if (respuesta.equals("N") || respuesta.equals("n")){
                return;
            }
            elegirDeporte(competidor);
            return;
        }
    }
    public void crearHorario(Modalidad modalidadList){
        for (String key : deporteList.keySet()) {
            if (deporteList.get(key).isEsPorEquipos()){
                deporteList.get(key).crearHorarioEquipo(modalidad); //Crea el horario de cada deporte por equipos
            }else {
                deporteList.get(key).crearHorarioCompetidor(modalidad); //Crea el horario de cada deporte individual
            }
        }
    }
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    //ToString
    @Override
    public String toString() {
        return "Temporada{\n" +
                "nombre: " + nombre + '\n' +
                "descripcion: " + descripcion + '\n' +
                "fechaInicio: " + fechaInicio + '\n' +
                "fechaFin: " + fechaFin +  '\n' +
                "Lista de deportes:\n" + deporteList + '\n';
    }

}
