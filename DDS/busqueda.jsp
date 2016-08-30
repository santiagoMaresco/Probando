<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Búsqueda</title>
    </head>
    <body>
        <b> Criterio de búsqueda </b>
        <p/>
        <p/>
        <form action="busquedaAction.jsp" id="formularioBusqueda">
            Nombre <br>
            <input type="text" name="criterioUno">
            <input type="submit" value="Agregar" action="agregarCriterio.jsp">
            <input type="submit" value="Buscar"><br>
            <input type="text" name="criterioDos"><br>    
        </form>
        <br>
        <br>
        <b>Resultado</b>
        
    </body>
</html>
