<%-- 
    Document   : CreateArea
    Created on : 20-jul-2015, 23:03:22
    Author     : Eliel David
--%>

<%@page import="app.model.BeanArea"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="metasBootstrap.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Área</title>
    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <h1>Crear Área</h1>
        <form class="form-horizontal" action="Area" method="post" accept-charset="ISO-8859-1">
            <input type="hidden" name="action" value="modificar" />
            <fieldset>

                <!-- Form Name -->
                <legend>Form Name</legend>
                
                <% BeanArea bean = new BeanArea();
                bean=(BeanArea) request.getAttribute("attArea");
                
                %>
                

                <!-- Text input-->
                <input type="hidden" name ="id" value="<%=bean.getId_area()%>">
                <div class="form-group">
                    
                    <label class="col-md-4 control-label" for="txtNombre">Nombre</label>  
                    <div class="col-md-4">
                        <input id="txtNombre" name="txtNombre" value="<%=bean.getNombre()%>" type="text" placeholder="Nombre Área" class="form-control input-md" required="">
                        <span class="help-block">Coloca aqui el nombre del Area </span>  
                    </div>
                </div>
                        
                 <!-- Multiple Radios -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="rdAlta">Status</label>
                    <div class="col-md-4">
                        <div class="radio">
                            <label for="rdAlta-0">
                                <input type="radio" name="rdAlta" id="rdAlta-0" value="si" checked="checked">
                                Activo
                            </label>
                        </div>
                        <div class="radio">
                            <label for="rdAlta-1">
                                <input type="radio" name="rdAlta" id="rdAlta-1" value="no" >
                                Inactivo
                            </label>
                        </div>
                    </div>
                </div>


                <!-- Button (Double) -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="btnGuardar"></label>
                    <div class="col-md-8">
                        <button id="btnGuardar" name="btnGuardar" class="btn btn-success">Guardar</button>
                        <button id="btnCancelar" name="btnCancelar" class="btn btn-danger">Cancelar</button>
                    </div>
                </div>

            </fieldset>
        </form>

    </body>
</html>
