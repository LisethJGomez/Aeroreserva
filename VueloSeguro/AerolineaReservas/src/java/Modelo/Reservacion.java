package Modelo;

// @author camil
public class Reservacion {
    private String id;
    private Pasajero pasajero;
    private Vuelo vuelo;
    private int numeroAsiento;

    public Reservacion(String id, Pasajero pasajero, Vuelo vuelo, int numeroAsiento) {
        this.id = id;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.numeroAsiento = numeroAsiento;
    }

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }
    
}