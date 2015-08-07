<%-- 
    Document   : ReadPrestamo
    Created on : 25-jul-2015, 14:05:09
    Author     : Eric
--%>

%@page import="java.sql.Connection" %>
<%@page import="Controladores.Autor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        
          <link rel="stylesheet" href="fonts/style.css">
        <%@include file="metasBootstrap.jsp" %>
        <title>JSP</title>
    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <script type="text/javascript">
        $(document).ready( function () {
    $('#tabla1').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json"
            }
        } );
} );
</script>
       
        <h1>Listas Prestamos</h1>

        <div class="container">
            
                <table id="tabla1" class="table table-responsive table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>ID Usuario</th>                            
                            <th>ID Ejemplar</th>
                            <th>Fecha De Salida</th>
                            <th>Fecha De Entrega</th>
                             <th>Editar</th>
                             <th>Eliminar</th>
                        </tr>                                
                    </thead>
                    <tbody>
                        <c:forEach items="${attPrestamo}" var="elem">
                            <tr>             <%-- ${bean.variable} --%>     
                                <th><c:out value="${elem.id_prestamo}" /></th>
                                <th><c:out value="${elem.id_usuario}" /></th>
                                <th><c:out value="${elem.id_ejemplar}" /></th>
                                 <th><c:out value="${elem.fecha_salida}" /></th>
                                <th><c:out value="${elem.fecha_entrega}" /></th>
                                
                                  
                                <th>
                        <form action="Prestamo" method="post" >
                            <input type="hidden" name="action" value="formEdit" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_prestamo}" />" />
                            <button type="submit" >Editar</button>                                        
</form>
                            </th> 
                        
                        <th>
                        <form action="Prestamo" method="post" >
                            <input type="hidden" name="action" value="eliminar" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_prestamo}" />" />
                            <button type="submit" >Eliminar</button>                                        
 </form> 
                            </th>  
                       
                        </tr>
                    </c:forEach>                        
                    </tbody>
                </table>
                <form action="Prestamo" method="post" >
                    <input type="hidden" name="action" value="consultar" />

                </form>
            
        </div>



    </body>
</html>


