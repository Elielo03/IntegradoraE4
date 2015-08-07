<%-- 
    Document   : CreateEstante
    Created on : 21-jul-2015, 22:53:09
    Author     : Eliel David
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
        <title>Crear Ejemplar</title>
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
                        <label class="col-md-4 control-label" for="cmbLibro">Libros</label>
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
                        <label class="col-md-4 control-label" for="cmbEstante">Estante</label>
                        <div class="col-md-4">
                            
                            <select id="cmbLibro" name="cmbEstante" class="form-control">
                                 <c:forEach items="${estante}" var="elem">
                                <option value="${elem.ubicacion}"><c:out value="${elem.ubicacion}" /></option>
                               
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="txtNum">Cantidad de ejemplares</label>  
                        <div class="col-md-4">
                            <input id="txtApe2" name="txtNum" type="number"  required="" min="1" max="1000"  placeholder="Cantidad de ejemplares" class="form-control input-md">
                            <span class="help-block">Coloca aquí el número de Ejemplares a crear</span>  
                        </div>
                    </div>


                    <!-- Button (Double) -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="btnGuardar"></label>
                        <div class="col-md-8">
                            <button id="btnGuardar" name="btnGuardar" class="btn btn-success">Guardar</button>
                            <button  id="btnCancelar" name="btnCancelar" class="btn btn-danger ">Cancelar</button>
                        </div>
                    </div>

                </fieldset>
            </form>
        </div>
    </body>
</html>
