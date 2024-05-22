package Modelo;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Vuelo {

    private String numeroVuelo;
    private String origen;
    private String destino;
    private int totalAsientos;
    private boolean[] asientos;
    private List<Reservacion> reservaciones;
    private Queue<Reservacion> listaEspera;
    private Stack<Reservacion> cancelarReservacion;

    public Vuelo(String numeroVuelo, String origen, String destino, int totalAsientos) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.totalAsientos = totalAsientos;
        this.asientos = new boolean[totalAsientos];
        this.reservaciones = new ArrayList<>();
        this.listaEspera = new LinkedList<>();
        this.cancelarReservacion = new Stack<>();
    }

//    getters y setter

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTotalAsientos() {
        return totalAsientos;
    }

    public void setTotalAsientos(int totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    public boolean[] getAsientos() {
        return asientos;
    }

    public void setAsientos(boolean[] asientos) {
        this.asientos = asientos;
    }

    public List<Reservacion> getReservaciones() {
        return reservaciones;
    }

    public void setReservaciones(List<Reservacion> reservaciones) {
        this.reservaciones = reservaciones;
    }

    public Queue<Reservacion> getListaEspera() {
        return listaEspera;
    }

    public void setListaEspera(Queue<Reservacion> listaEspera) {
        this.listaEspera = listaEspera;
    }

    public Stack<Reservacion> getCancelarReservacion() {
        return cancelarReservacion;
    }

    public void setCancelarReservacion(Reservacion r) {
        this.cancelarReservacion.add(r);
    }
    
}