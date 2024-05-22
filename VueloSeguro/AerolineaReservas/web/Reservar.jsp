<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Vuelo"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String mensaje = String.valueOf(request.getSession().getAttribute("listaUsuarios"));
    String id = String.valueOf(request.getSession().getAttribute("id"));
    String msg = String.valueOf(request.getSession().getAttribute("msg"));
    List<Vuelo> vuelos = (ArrayList<Vuelo>) request.getSession().getAttribute("vuelos");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilos/Reservar.css"/>
        <title>Reservar Vuelo</title>
    </head>
    <body>
        <header>
            <nav>
                <input type="checkbox" />
                <span></span>
                <span></span>
                <div id="links">
                    <li><a href="Home.html">Casa</a></li>
                    <li><a href="#">Reservar</a></li>
                    <li><a href="Acerca-de.html">Acerca de</a></li>
                </div>
            </nav>
        </header>
        <main>
            <section>
                <h1>Reservar Vuelo</h1>
                <form action="reservasSV" method="post">
                    <label for="numeroVuelo">Número de Vuelo:</label>
                    <input type="text" id="numeroVuelo" name="numeroVuelo"><br>
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre"><br>
                    <label for="documento">Número de Pasaporte:</label>
                    <input type="text" id="documento" name="documento"><br>
                    <button><input type="submit" value="Reservar" id="subir"></button>
                </form>
                <h1>Cancelar Reserva</h1>
                <form action="reservasSV" method="get">
                    <label for="id">Id de Vuelo:</label>
                    <input type="text" id="id" name="id"><br>
                    <label for="numeroVuelo">Numero de Vuelo:</label>
                    <input type="text" id="numeroVuelo" name="numeroVuelo"><br>
                    <button><input type="submit" value="Cancelar" id="subir"></button>
                </form>
                <!-- Mostrar mensaje -->
                <%if (!mensaje.equals(null)){%>
                    <h2><%=mensaje%></h2>
                <%}%>
                
                <%if (!msg.equals(null)){%>
                    <h2><%=msg%></h2>
                <%}%>
                
                <%if(!id.equals("")){%>
                    <h2>Id de Reserva: <%=id%></h2>
                <%}%>
            </section>
            <aside>
                <h2>Vuelos</h2>
                <ul>
                    <li>V123 | Bogotá --> Medellin</li>
                    <li>V456 | Bogota --> Cali</li>
                    <li>V789 | Cali --> Medellin</li>
                    <li>V101 | Medellin --> Barranquilla</li>
                    <li>V112 | Barranquilla --> Pereira</li>
                    <li>V131 | Pereira --> Cartagena</li>
                </ul>                
            </aside>
        </main>
        <footer>
            <p>Estructuras de Información 401<br />Universidad de Cundinamarca</p>
        </footer>
    </body>
</html>
