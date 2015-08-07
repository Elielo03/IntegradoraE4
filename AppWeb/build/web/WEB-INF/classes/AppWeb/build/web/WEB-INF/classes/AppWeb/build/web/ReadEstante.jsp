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
        <%@include file="metasBootstrap.jsp" %>
        <title>Listas Estantes</title>
    </head>
    <body>
           <link rel="stylesheet" href="fonts/style.css">
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
        <h1>Lista Estantes</h1>

        <div class="container">
            
                <table id="tabla1" class="table table-responsive table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Ubicación</th>                            
                           
                             <th>Editar</th>
                              <th>Eliminar</th>
                            
                        </tr>                                
                    </thead>
                    <tbody>
                        <c:forEach items="${attEstante}" var="elem">
                            <tr>             <%-- ${bean.variable} --%>     
                                <th><c:out value="${elem.id_estante}" /></th>
                                 <th><c:out value="${elem.ubicacion}" /></th>
                                
                                                      
                                <th>
                        <form action="Estante" method="post" >
                            <input type="hidden" name="action" value="formEdit" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_estante}" />" />
                            <button type="submit" >Editar</button>                                        
</form>
                            </th> 
                        
                        <th>
                        <form action="Estante" method="post" >
                            <input type="hidden" name="action" value="eliminar" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_estante}" />" />
                            <button type="submit" class="eliminar">Eliminar</button>                                        
 </form> 
                            </th>  
                       
                        </tr>
                    </c:forEach>                        
                    </tbody>
                </table>
            
                <form action="Estante" method="post" >
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
