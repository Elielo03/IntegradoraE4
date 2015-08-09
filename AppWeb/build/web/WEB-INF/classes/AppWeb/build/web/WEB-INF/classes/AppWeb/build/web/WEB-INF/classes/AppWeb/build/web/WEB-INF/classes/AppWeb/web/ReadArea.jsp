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
        <title>Listas Áreas</title>
        
        
        
       
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
        <h1>Lista Áreas</h1>

        <div class="container">
            
                <table id="tabla1" class="table table-responsive table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>                            
                            <th>Alta</th>
                             <th>Editar</th>
                              <th>Eliminar</th>
                            
                        </tr>                                
                    </thead>
                    <tbody>
                        <c:forEach items="${attArea}" var="elem">
                            <tr>             <%-- ${bean.variable} --%>     
                                <th><c:out value="${elem.id_area}" /></th>
                                 <th><c:out value="${elem.nombre}" /></th>
                                <th><c:out value="${elem.alta}" /></th>
                                                      
                                <th>
                        <form action="Area" method="post" >
                            <input type="hidden" name="action" value="formEdit" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_area}" />" />
                            <button type="submit" >Editar</button>                                        
</form>
                            </th> 
                        
                        <th>
                        <form action="Area" method="post" >
                            <input type="hidden" name="action" value="eliminar" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_area}" />" />
                            <button type="submit" class="eliminar">Eliminar</button>                                        
 </form> 
                            </th>  
                       
                        </tr>
                    </c:forEach>                        
                    </tbody>
                </table>
            
                <form action="Area" method="post" >
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
