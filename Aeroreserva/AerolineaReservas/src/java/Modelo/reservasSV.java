package Modelo;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns =
{
    "/reservasSV"
})
public class reservasSV extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    // Lista de vuelos simulada
    private static List<Vuelo> vuelos = new ArrayList<>();
    
    static {
        // Inicialización de vuelos de ejemplo
        vuelos.add(new Vuelo("V123", "Origen1", "Destino1", 100));
        vuelos.add(new Vuelo("V456", "Origen2", "Destino2", 150));
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Reservas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Reserva Exitosa: Id(" + ")</h1>");
            out.println("<a href='Reservar.jsp'> Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        String message;
        if (vuelo != null) {
            int asientoDisponible = encontrarAsientosDisponibles(vuelo);
            if (asientoDisponible != -1){
                Pasajero pasajero = new Pasajero(nombre,documento);
                Reservacion reservacion = new Reservacion(generarIdReservacion(), pasajero, vuelo, encontrarAsientosDisponibles(vuelo));
                vuelo.getReservaciones().add(reservacion);
                vuelo.getAsientos()[asientoDisponible] = true;
                message = "Reserva exitosa";
            }else{
                message = "No hay asientos disponibles";
            }
        } else {
            message = "Vuelo no encontrado.";
        }
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Reservar.jsp");
        dispatcher.forward(request, response);
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
