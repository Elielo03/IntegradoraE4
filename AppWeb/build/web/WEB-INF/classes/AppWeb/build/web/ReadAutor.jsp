<%-- 
    Document   : ReadAutor
    Created on : 20-jun-2015, 19:53:08
    Author     : Eliel David
--%>
<%@page import="java.sql.Connection" %>
<%@page import="Controladores.Autor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        
          <link rel="stylesheet" href="fonts/style.css">
        <%@include file="metasBootstrap.jsp" %>
        <title>Litas Autor</title>
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
        <h1>Tabla Autores</h1>

        <div class="container">
            
                <table id="tabla1" class="table table-responsive table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>                            
                            <th>Primer Apellido</th>
                            <th>Segundo Apellido</th>
                            <th>Nacionalidad</th>
                            <th>EDITAR</th>
                            <th>ELIMINAR</th>
                        </tr>                                
                    </thead>
                    <tbody>
                        <c:forEach items="${attAutores}" var="elem">
                            <tr>             <%-- ${bean.variable} --%>     
                                <th><c:out value="${elem.id_autor}" /></th>
                                 <th><c:out value="${elem.nombre}" /></th>
                                <th><c:out value="${elem.primer_apellido}" /></th>
                                <th><c:out value="${elem.segundo_apellido}" /></th>
                                <th><c:out value="${elem.pais}" /></th>                        
                                <th>
                        <form action="Autor" method="post" >
                            <input type="hidden" name="action" value="formEdit" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_autor}" />" />
                            <button type="submit" >Editar</button>                                        
</form>
                            </th> 
                        
                        <th>
                        <form action="Autor" method="post" >
                            <input type="hidden" name="action" value="eliminar" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_autor}" />" />
                            <button type="submit" name="eliminar" >Eliminar</button>                                        
 </form> 
                            </th>  
                       
                        </tr>
                    </c:forEach>                        
                    </tbody>
                </table>
                <form action="Autor" method="post" >
                    <input type="hidden" name="action" value="consultar" />

                </form>
            
        </div>

  <script type="text/javascript">
		    $(document).ready(function (){
			    $(".eliminar").click(function(){
				if(!confirm("Seguro que desea eliminarla?")){
					return false;
				}
			    });
		    });
	    </script>

    </body>
</html>
