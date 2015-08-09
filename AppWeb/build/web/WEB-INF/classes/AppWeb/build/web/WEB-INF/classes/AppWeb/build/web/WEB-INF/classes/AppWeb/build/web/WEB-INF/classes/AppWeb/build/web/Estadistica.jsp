<%-- 
    Document   : Estadistica
    Created on : 04-ago-2015, 18:42:11
    Author     : Eric
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Util.ConexionSQLServer"%>
<%@page import="java.sql.Connection"%>
<%@page import="app.model.BeanEditorial"%>
<%@page import="app.model.BeanAutor"%>
<%@page import="app.model.BeanArea"%>
<%@page import="java.util.List"%>
<%@page import="app.Daos.DaoEditorial"%>
<%@page import="app.Daos.DaoAutor"%>
<%@page import="app.Daos.DaoArea"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
          <link rel="stylesheet" href="fonts/style.css">
        <%@include file="metasBootstrap.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
    </head>
    <body>
        <%@include file="Menu.jsp" %>



        <div class="container">
            <form class="form-horizontal" action="Ejemplar" method="post" accept-charset="ISO-8859-1">
                <input type="hidden" name="action" value="crear" />
                <fieldset>

                    <!-- Form Name -->
                    <legend>Crear Ejemplar</legend>





                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="cmbLibro">Libro Con Más Existencias</label>
                        <div class="col-md-4">
                            <select id="cmbLibro" name="cmbLibro" class="form-control">
                                 <c:forEach items="${libro}" var="elem">
                                <option value="${elem.titulo}"><c:out value="${elem.titulo}" /></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    
                     <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="cmbEstante">Editorial Con Menos Libros</label>
                        <div class="col-md-4">
                            
                            <select id="cmbLibro" name="cmbEstante" class="form-control">
                                 <c:forEach items="${editorial}" var="elem">
                                <option value="${elem.nombre}"><c:out value="${elem.nombre}" /></option>
                               
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                  
                </fieldset>
            </form>
        </div>
    </body>
</html>
