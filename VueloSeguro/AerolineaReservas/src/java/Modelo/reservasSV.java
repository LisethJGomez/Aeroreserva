package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns =
{
    "/reservasSV"
})
public class reservasSV extends HttpServlet {

    
    // Lista de vuelos simulada
    private static List<Vuelo> vuelos = new ArrayList<>();
    
    static {
        // Inicialización de vuelos de ejemplo
        vuelos.add(new Vuelo("V123", "Bogotá", "Medellin", 1));
        vuelos.add(new Vuelo("V456", "Bogota", "Cali", 1));
        vuelos.add(new Vuelo("V789", "Cali", "Medellin", 1));
        vuelos.add(new Vuelo("V101", "Medellin", "Barranquilla", 1));
        vuelos.add(new Vuelo("V112", "Barranquilla", "Pereira", 1));
        vuelos.add(new Vuelo("V131", "Pereira", "Cartagena", 1));
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Eliminar reserva
        String mensaje = "";
        String id = request.getParameter("id");
        String numeroVuelo = request.getParameter("numeroVuelo");
        Vuelo vuelo = encontrarNumeroVuelo(numeroVuelo);
        Pasajero pasajero = new Pasajero();
        
        Reservacion reservacion = new Reservacion(id, pasajero, vuelo, 0);
        vuelo.getReservaciones().remove(reservacion);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("msg", mensaje);
        response.sendRedirect("Reservar.jsp");//Reenviar a JSP
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String numeroVuelo = request.getParameter("numeroVuelo");
        String nombre = request.getParameter("nombre");
        String documento = request.getParameter("documento");

        // Aquí buscarías el vuelo en una lista de vuelos y harías la reserva
        // Ejemplo simplificado:
        Vuelo vuelo = encontrarNumeroVuelo(numeroVuelo);
        String mensaje,id="";
        if (vuelo != null) {
            int asientoDisponible = encontrarAsientosDisponibles(vuelo);
            if (asientoDisponible != -1){
                Pasajero pasajero = new Pasajero(nombre,documento);
                Reservacion reservacion = new Reservacion(generarIdReservacion(), pasajero, vuelo, encontrarAsientosDisponibles(vuelo));
                vuelo.getReservaciones().add(reservacion);
                vuelo.getAsientos()[asientoDisponible] = true;
                mensaje = "Reserva exitosa";
                id=reservacion.getId();
            }else{
                mensaje = "No hay asientos disponibles";
            }
        } else {
            mensaje = "Vuelo no encontrado.";
        }
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaUsuarios", mensaje);
        miSesion.setAttribute("id", id);
        miSesion.setAttribute("vuelos",vuelos);
        response.sendRedirect("Reservar.jsp");//Reenviar a JSP
    }
    
///////////////////////////////////////////////////
    private Vuelo encontrarNumeroVuelo(String numeroVuelo) {
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getNumeroVuelo().equals(numeroVuelo)) {
                return vuelo;
            }
        }
        return null; // Vuelo no encontrado
    }

    private String generarIdReservacion() { 
        return "RES" + new Random().nextInt(10000); // Generar ID aleatorio
    }

    private int encontrarAsientosDisponibles(Vuelo vuelo) {
        for (int i = 0; i < vuelo.getAsientos().length; i++) {
            if (!vuelo.getAsientos()[i]) {
                return i; // Retorna el primer asiento disponible
            }
        }
        return -1; // No hay asientos disponibles
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
