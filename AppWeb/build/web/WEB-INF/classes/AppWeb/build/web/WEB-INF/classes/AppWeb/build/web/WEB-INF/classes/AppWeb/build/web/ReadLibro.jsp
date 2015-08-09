<%-- 
    Document   : ReadLibro
    Created on : 23-jul-2015, 10:13:59
    Author     : Eric
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="app.model.BeanLibro"%>
<%@page import="Controladores.Autor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>


       
        

          
           <link href="css/grayscale.css" rel="stylesheet">
        <%@include file="metasBootstrap.jsp" %>
        <title>Listas Libros</title>
    </head>
    <body>

           <link rel="stylesheet" href="fonts/style.css">
         

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
        <h1>Lista Libros</h1>
        
        
        

        <div class="container">

            <table id="tabla-user" class="table table-responsive table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>ID Libro</th>
                            <th>Título</th>                            
                            <th>ISBN</th>
                            <th>Páginas</th>
                            <th>Área</th>
                            <th>Editorial</th>
                            <th>Autores</th>
                           
                             <th>Editar</th>
                            <th>Eliminar</th>
                        
                    </tr>                                
                </thead>
                <tbody>
                   <c:forEach items="${attLibro}" var="elem">
                       <c:set var="autor" value="${elem.autores}"></c:set>
                            <tr>             <%-- ${bean.variable} --%>     
                                <th><c:out value="${elem.id_libro}" /></th>
                                 <th><c:out value="${elem.titulo}" /></th>
                                <th><c:out value="${elem.ISBN}" /></th>
                                <th><c:out value="${elem.paginas}" /></th>
                                <th><c:out value="${elem.area.nombre}" /></th>        
                                    <th><c:out value="${elem.editorial.nombre}" /></th> 
                                    
                                    <th>
                                        <c:forEach items="${autor}" var="elem1">
                                            
                                            <br> <c:out  value="${elem1.nombre} ${elem1.primer_apellido} "></c:out> </br>
                                       
                                         </c:forEach>   
                                    </th> 
                                  
                                   
                                     
                                       
                                <th>
                        <form action="Libro1" method="post" >
                            <input type="hidden" name="action" value="formEdit" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_libro}" />" />
                            <button type="submit" >Editar</button>                                        
</form>
                            </th> 
                        
                        <th>
                        <form action="Libro1" method="post" >
                            <input type="hidden" name="action" value="eliminar" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_libro}" />" />
                            <button type="submit" name="eliminar" >Eliminar</button>                                        
 </form> 
                            </th>  
                       
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

