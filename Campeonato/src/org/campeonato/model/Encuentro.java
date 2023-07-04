package org.campeonato.model;

public class Encuentro {
    private String local;
    private String visitante;
    private int numeroEncuentro;
    private Fecha fecha;

    //Relaciones
    private class Marcador {
        //Atributos
        private int puntosLocal;
        private int puntosVisitante;

        //Constructor
        public Marcador(int puntosLocal, int puntosVisitante) {
            this.puntosLocal = puntosLocal;
            this.puntosVisitante = puntosVisitante;
        }
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    //Constructor
    public Encuentro(String local, String visitante,int numeroEncuentro) {
        this.local = local;
        this.visitante = visitante;
        this.numeroEncuentro = numeroEncuentro;

    }


    //ToString
    @Override
    public String toString() {
        return "Encuentro(" +
                ",numeroEncuentro:" + numeroEncuentro +
                "local:" + local +
                ",visitante:" + visitante +
                ')';
    }

}
