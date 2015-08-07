<%-- 
    Document   : CreatePrestamo
    Created on : 25-jul-2015, 13:14:38
    Author     : Eric
--%>

<%@page import="app.model.BeanUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="fonts/style.css">
        <%@include file="metasBootstrap.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Préstamo</title>
    </head>
    <div>
        <%@include file="Menu.jsp" %>
    </div>
    <body>
        <section class="usu">

           


            <form class="form-horizontal" action="Prestamo" method="post" accept-charset="ISO-8859-1">
                <input type="hidden" name="action" value="crear" />




                <fieldset>

                    <!-- Form Name -->
                    <legend></legend>
                   <h1>Crear Préstamo</h1>
                    <!-- Text input-->
                    
                   <div class="form-group">

                    <label class="col-md-4 control-label" for="cmbUsuario">Usuario</label>  
                    <div class="col-md-4">
                        <select class="form-control" name="cmbUsuario" requiered="">
                            <c:forEach items="${attUsuario}" var="elem">

                                <option> <c:out value="${elem.nombre} ${elem.primer_apellido}" /> </option>

                            </c:forEach>
                        </select>

                        <span class="help-block">Seleccionar el Usuario </span>  
                    </div>
                </div>
                                
                                
                          <div class="form-group">

                    <label class="col-md-4 control-label" for="cmbEjemplar">Libro</label>  
                    <div class="col-md-4">
                        <select class="form-control" name="cmbEjemplar" requiered="">
                            <c:forEach items="${attEjemplar}" var="elem">

                                <option value="${elem.id_ejemplar}"> <c:out value="${elem.id_ejemplar}" /> </option>

                            </c:forEach>
                        </select>

                        <span class="help-block">Selecciona el Libro</span>  
                    </div>
                </div>
                                

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="txtFechaSalida">Fecha Salida</label>  
                        <div class="col-md-4">
                            <input id="txtApe1" name="txtFechSalida" type="date" min="2015-08-01" max="2020-01-01" step="1" value="2015-08-01" class="form-control input-md" required="">
                           
                        </div>
                    </div>

                    <!-- Text input-->
                   <div class="form-group">
                        <label class="col-md-4 control-label" for="txtFechaEntrega">Fecha Entrega</label>  
                        <div class="col-md-4">
                            <input id="txtApe1" name="txtFechaEntrega" type="date" min="2015-08-01" max="2020-01-01" step="1" value="2015-08-01" class="form-control input-md" required="">
                           
                        </div>
                    </div>
                       
                   
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="btnGuardar"></label>
                        <div class="col-md-8">
                            <button id="btnGuardar" name="btnGuardar" class="btn btn-success">Guardar</button>
                            <button id="btnCancelar" name="btnCancelar" class="btn btn-danger">Cancelar</button>
                        </div>
                    </div>

                </fieldset>
            </form>
        </section>
    </body>
</html>