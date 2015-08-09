<%-- 
    Document   : ReadLibro2
    Created on : 29-jul-2015, 23:26:25
    Author     : Eric
--%>
%@page import="java.sql.Connection" %>
<%@page import="Controladores.Autor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        
       
        <%@include file="metasBootstrap.jsp" %>
        <title>Lista Libros</title>
    </head>
    <body>
        <script type="text/javascript">
        $(document).ready( function () {
    $('#tabla-user').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json"
            }
        } );
} );
</script>
	    </script>
        <%@include file="Menu2.jsp" %>
       
        <h1>Lista Libros</h1>

        <div class="container">
            
                <table id="tabla-user" class="table table-responsive table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Título</th>                            
                            <th>ISBN</th>
                            <th>Páginas</th>
                            <th>Área</th>
                            <th>Editorial</th>
                           
                        </tr>                                
                    </thead>
                    <tbody>
                        <c:forEach items="${attLibro}" var="elem">
                            <tr>             <%-- ${bean.variable} --%>     
                                <th><c:out value="${elem.id_libro}" /></th>
                                 <th><c:out value="${elem.titulo}" /></th>
                                <th><c:out value="${elem.ISBN}" /></th>
                                <th><c:out value="${elem.paginas}" /></th>
                                <th><c:out value="${elem.area}" /></th>        
                                    <th><c:out value="${elem.editorial}" /></th> 
                             
                       
                        </tr>
                    </c:forEach>                        
                    </tbody>
                </table>
                <form action="Libro1" method="post" >
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

