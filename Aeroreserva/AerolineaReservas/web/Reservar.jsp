<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservar Vuelo</title>
    </head>
    <body>
        <header>
            <nav>
                <input type="checkbox" />
                <span></span>
                <span></span>
                <div id="links">
                    <li><a href="#">Casa</a></li>
                    <li><a href="Reservar.jsp">Reservar</a></li>
                    <li><a href="Acerca-de.html">Acerca de</a></li>
                </div>
            </nav>
        </header>
        <main>
            <h1>Reservar Vuelo</h1>
            <form action="reservasSV" method="post">
                <label for="numeroVuelo">Número de Vuelo:</label>
                <input type="text" id="numeroVuelo" name="numeroVuelo"><br>
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre"><br>
                <label for="documento">Número de Pasaporte:</label>
                <input type="text" id="documento" name="documento"><br>
                <input type="submit" value="Reservar">
            </form>
            <!-- Mostrar mensaje si existe -->
            <%
                String message = (String) request.getAttribute("message");
                if (message != null)
                {
            %>
            <p><%= message%></p>
            <%
                }
            %>    
        </main>
        <footer>
            <p>Estructuras de Información 401<br />Universidad de Cundinamarca</p>
        </footer>
    </body>
</html>
