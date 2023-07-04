package org.campeonato.model;

import java.util.HashMap;

public class Horario {
    //Atributos
    private HashMap<String, Fecha> fechaList = new HashMap<String, Fecha>();

    //Relaciones
    private HashMap<Integer, Encuentro> encuentroList = new HashMap<Integer, Encuentro>();

    private Deporte deporte;

    //Constructor
    public Horario(Deporte deporte) {
        this.deporte = deporte;
    }


    //Metodos
    public void crearFecha(int cantidadEncuentro){
        int cantidadFecha = 0;
        int dia = deporte.getTemporada().getFechaInicio().getDia();
        int mes = deporte.getTemporada().getFechaInicio().getMes();
        int anio = deporte.getTemporada().getFechaInicio().getAnio();
        int contarDias = 0;
        if (cantidadEncuentro % 2 == 0) {
            cantidadFecha = cantidadEncuentro / 2;
        } else {
            cantidadFecha = (cantidadEncuentro + 1) / 2;
        }
        for (int i = 0; i < cantidadFecha; i++) {
            Fecha fecha = new Fecha(dia, mes, anio);
            fechaList.put("Fecha " + (i + 1), fecha);
            dia ++;
            contarDias ++;
        }
        generarHorario(contarDias, cantidadEncuentro, cantidadFecha);

    }

    public void generarHorario(int duracionDias, int cantidadEncuentro, int cantidadFecha){
        int numeroEncuentro = 0;
        int numeroFecha = 0;
        int dia = deporte.getTemporada().getFechaInicio().getDia();
        int mes = deporte.getTemporada().getFechaInicio().getMes();
        int anio = deporte.getTemporada().getFechaInicio().getAnio();
        for (int i = 0; i < duracionDias; i++) {
            for (int j = 0; j < cantidadEncuentro; j++) {
                if (numeroEncuentro == cantidadEncuentro) {
                    numeroEncuentro = 0;
                }
                if (numeroFecha == cantidadFecha) {
                    numeroFecha = 0;
                }
                Encuentro encuentro = encuentroList.get(numeroEncuentro);
                Fecha fecha = fechaList.get(numeroFecha);
                encuentro.setFecha(fecha);
                numeroEncuentro ++;
                numeroFecha ++;
            }
            dia ++;
        }
        //Imprimir el horario
        for (int i = 0; i < cantidadEncuentro; i++) {
            Encuentro encuentro = encuentroList.get(i);//Obtener el encuentro
            System.out.println(encuentro.toString()); //Imprimir el encuentro
        }


    }
    public void crearEncuentroEquipo(HashMap<String, Equipo> equipoList,Modalidad modalidad){
        int cantidadEncuentros = 0;
        if (modalidad.getTipoModalidad() == "Eliminacion") { //Eliminacion
            if (equipoList.size() % 2 == 0) {
                for (int i = 0; i < equipoList.size(); i += 2) {
                    int numeroEncuentro = i / 2;
                    cantidadEncuentros = numeroEncuentro;
                    Encuentro encuentro = new Encuentro(equipoList.get(i).getNombre(), equipoList.get(i + 1).getNombre(), numeroEncuentro);
                    encuentroList.put(numeroEncuentro, encuentro);
                }
            } else {
                equipoList.put("Descansa", null);
                for (int i = 0; i < equipoList.size() - 1; i += 2) {
                    int numeroEncuentro = i / 2;
                    cantidadEncuentros = numeroEncuentro;
                    Encuentro encuentro = new Encuentro(equipoList.get(i).getNombre(), equipoList.get(i + 1).getNombre(), numeroEncuentro);
                    encuentroList.put(numeroEncuentro, encuentro);
                }
            }
        }
        if (modalidad.getTipoModalidad() == "Liga") { //Liga
            for (int i = 0; i < equipoList.size(); i++) {
                for (int j = 0; j < equipoList.size(); j++) {
                    if (i != j) {
                        int numeroEncuentro = i * equipoList.size() + j;
                        cantidadEncuentros = numeroEncuentro;
                        Encuentro encuentro = new Encuentro(equipoList.get(i).getNombre(), equipoList.get(j).getNombre(), numeroEncuentro);
                        encuentroList.put(numeroEncuentro, encuentro);
                    }
                }
            }
        }
        crearFecha(cantidadEncuentros);
    }

    //ToString
    @Override
    public String toString() {
        return "Horario(" +
                "fechaList:" + fechaList +
                ", encuentroList:" + encuentroList +
                ", deporte:" + deporte +
                ')';
    }

}
