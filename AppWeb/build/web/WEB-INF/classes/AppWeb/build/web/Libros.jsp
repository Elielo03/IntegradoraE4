<%-- 
    Document   : Libros
    Created on : 27-jul-2015, 22:23:56
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
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Menu2.jsp" %>
       
        <h1>Listas Libros</h1>

        <div class="container">
            
                <table id="tabla1" class="table table-responsive table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>ID Libro</th>
                            <th>Titulo</th>                            
                            <th>ISBN</th>
                            <th>Páginas</th>
                            <th>Área</th>
                            <th>Editorial</th>
                            <th>Autor</th>
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
                                        <th><c:out value="${elem.autor}" /></th>   
                                <th>
                        <form action="Autor" method="post" >
                            <input type="hidden" name="action" value="formEdit" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_libro}" />" />
                            <button type="submit" >editar</button>                                        
</form>
                            </th> 
                        
                        <th>
                        <form action="Autor" method="post" >
                            <input type="hidden" name="action" value="eliminar" />
                            <input type="hidden" name="id" value="<c:out value="${elem.id_libro}" />" />
                            <button type="submit" >eliminar</button>                                        
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



    </body>
</html>

