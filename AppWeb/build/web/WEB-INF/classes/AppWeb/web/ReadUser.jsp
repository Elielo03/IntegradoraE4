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
        <title>Lista Usuarios</title>
    </head>
    <body>
        <%@include file="Menu.jsp" %>
<script type="text/javascript">
        $(document).ready( function () {
    $('#tabla-user').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json"
            }
        } );
} );
</script>
        <h1>Lista Usuarios</h1>

        <div class="container">

            <table id="tabla-user" class="table table-responsive table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>   
                        <th>Primer Apellido</th> 
                        <th>Segundo Apellido</th> 
                        <th>Correo</th> 
                        <th>Admin</th> 
                        <th>Status</th>
                        <th>Pass</th> 
                        <th>Dirección</th>
                        <th>Telefono</th> 
                        <th>Editar</th>
                        <th>Eliminar</th>

                    </tr>                                
                </thead>
                <tbody>
                    <c:forEach items="${attUser}" var="elem">
                        <tr>             <%-- ${bean.variable} --%>     
                            <th><c:out value="${elem.id_usuario}" /></th>
                            <th><c:out value="${elem.nombre}" /></th>
                            <th><c:out value="${elem.primer_apellido}" /></th>
                            <th><c:out value="${elem.segundo_apellido}" /></th>
                            <th><c:out value="${elem.correo}" /></th>
                            <th><c:out value="${elem.es_admi}" /></th>
                            <th><c:out value="${elem.alta}" /></th>
                            <th><c:out value="${elem.pass}" /></th>
                            <th><c:out value="${elem.direccion}" /></th>
                            <th><c:out value="${elem.telefono}" /></th>                    
                            <th>
                    <form action="User" method="post" >
                        <input type="hidden" name="action" value="formEdit" />
                        <input type="hidden" name="id" value="<c:out value="${elem.id_usuario}" />" />
                        <button type="submit" >Editar</button>                                        
                    </form>
                    </th> 

                    <th>
                    <form action="User" method="post" >
                        <input type="hidden" name="action" value="eliminar" />
                        <input type="hidden" name="id" value="<c:out value="${elem.id_usuario}" />" />
                        <button type="submit" class="eliminar" >Eliminar</button>                                        
                    </form> 
                    </th>  

                    </tr>
                </c:forEach>                        
                </tbody>
            </table>


           

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
