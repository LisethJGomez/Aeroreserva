package Modelo;

// @author camil
public class Pasajero {
    private String nombre;
    private String documento;

    public Pasajero(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public Pasajero() {
    }
    

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
}