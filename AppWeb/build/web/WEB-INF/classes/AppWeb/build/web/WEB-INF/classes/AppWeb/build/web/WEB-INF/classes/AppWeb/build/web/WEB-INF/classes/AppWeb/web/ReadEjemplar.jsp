<%-- 
    Document   : ReadAutor
    Created on : 20-jun-2015, 19:53:08
    Author     : Eliel David
--%>
<%@page import="java.sql.Connection" %>
<%@page import="Controladores.Autor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<!DOCTYPE html>
<html>
    <head>
        

             <link rel="stylesheet" href="fonts/style.css">
           <link href="css/grayscale.css" rel="stylesheet">
        <%@include file="metasBootstrap.jsp" %>
        <title>Listas Ejemplares</title>
        
        
        
       
    </head>
    <body>
        <script type="text/javascript">
        $(document).ready( function () {
    $('#tabla1').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json"
            }
        } );
} );
</script>
        <%@include file="Menu.jsp" %>
       
       
          
         <div class="container">
        <h1>Lista Ejemplares</h1>

        <div class="container">
            
                <table id="tabla1" class="table table-responsive table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Libro</th>                            
                            <th>Estante</th>
                             
                              <th>Eliminar</th>
                            
                        </tr>                                
                    </thead>
                    <tbody>
                        <c:forEach items="${attEjemplar}" var="elem">
                            <tr>             <%-- ${bean.variable} --%>     
                                <th><c:out value="${elem.id_ejemplar}" /></th>
                                 <th><c:out value="${elem.libro.titulo}" /></th>
                                <th><c:out value="${elem.estante.ubicacion}" /></th>
                                
                                                      
                          
                        
                        <th>
                        <form action="Ejemplar" method="post" >
                            <input type="hidden" name="action" value="eliminar" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_ejemplar}" />" />
                            <button type="submit" class="eliminar">Eliminar</button>                                        
 </form> 
                            </th>  
                       
                        </tr>
                    </c:forEach>                        
                    </tbody>
                </table>
            
                <form action="ejemplar1" method="post" >
                    <input type="hidden" name="action" value="consultar" />

                </form>
            
            
        </div>


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
