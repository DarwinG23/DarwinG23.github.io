package org.campeonato.model;

import java.util.HashMap;
import java.util.Scanner;

public class Campeonato {
    //Atributos
    String nombre;
    String descripcion;

    //Relaciones
    private HashMap<String, Temporada> temporadaList;
    private Registro registro;

    //Constructor
    public Campeonato(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.temporadaList = new HashMap<>();
    }
    public Campeonato(String nombre){
        this.nombre = nombre;
        this.temporadaList = new HashMap<>();
        this.descripcion = "No hay descripcion";
    }
    //Metodos
    public void agregarTemporada(){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("POR FAVOR INGRESE LOS DATOS DEL CAMPEONATO " + this.nombre);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre de la temporada");
        String nombre = sc.nextLine();
        System.out.println("Fecha de inicio de la temporada");
        System.out.println("Dia: ");
        int diaInicio = sc.nextInt();
        System.out.println("Mes: ");
        int mesInicio = sc.nextInt();
        System.out.println("Año: ");
        int anioInicio = sc.nextInt();
        Fecha fechaInicio = new Fecha(diaInicio, mesInicio, anioInicio);
        System.out.println("Fecha de fin de la temporada");
        System.out.println("Dia: ");
        int diaFin = sc.nextInt();
        System.out.println("Mes: ");
        int mesFin = sc.nextInt();
        System.out.println("Año: ");
        int anioFin = sc.nextInt();
        Fecha fechaFin = new Fecha(diaFin, mesFin, anioFin);
        System.out.println("Descripcion de la temporada");
        sc.nextLine();
        String descripcion = sc.nextLine();
        System.out.println("-------------------------------------------------------------------------------");
        Temporada temporada = new Temporada(nombre, descripcion, this, fechaInicio, fechaFin);
        this.temporadaList.put(nombre, temporada);
        generarModalidad(temporada);
        System.out.println("POR FAVOR INGRESE LOS DEPORTES DE LA TEMPORADA " + temporada.getNombre());
        do {
            temporada.agregarDeporte(temporada);
            System.out.println("Desea agregar otro deporte? (S/N)");
            String respuesta = sc.nextLine();
            if(respuesta.equals("s") || respuesta.equals("s")){
                continue;
            }else {
                break;
            }
        } while (true);
        temporada.crearCompetidor();
    }
    //Metodos
    public void crearRegistro(){
        Registro registro = new Registro(this);
        this.setRegistro(registro);//Agrega el registro al campeonato
        System.out.println("REGISTRE LOS USUARIOS DEL CAMPEONATO " + this.nombre);
        registro.crearUsuario();
    }

    public void generarModalidad(Temporada temporada){
        String nombreModalidad;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("SELECCIONE EL TIPO DE MODALIDAD PARA LA TEMPORADA " + temporada.getNombre());
            System.out.println("> Liga");
            System.out.println("> Eliminacion");
            System.out.println("Nombre de la modalidad");
            nombreModalidad = sc.nextLine();
            if(nombreModalidad.equals("Liga") || nombreModalidad.equals("liga")){
                break;
            }else if(nombreModalidad.equals("Eliminacion") || nombreModalidad.equals("eliminacion")){
                break;
            }
            System.out.println("Modalidad no valida, por favor intente de nuevo");
        } while (true);
        Modalidad modalidad = new Modalidad(nombreModalidad, temporada);
        temporada.setModalidad(modalidad);
        System.out.println("Se ha creado la modalidad " + nombreModalidad + " para la temporada " + temporada.getNombre());

    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public HashMap<String, Temporada> getTemporadaList() {
        return temporadaList;
    }

    public void setTemporadaList(HashMap<String, Temporada> temporadaList) {
        this.temporadaList = temporadaList;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    //ToString
    @Override
    public String toString() {
        return "Campeonato[\n" +
                "nombre: " + nombre + '\n' +
                "descripcion: " + descripcion + '\n' +
                "Registro: " + registro + '\n' +
                "temporadaList:" + temporadaList + '\n' +
                ']';
    }
}
