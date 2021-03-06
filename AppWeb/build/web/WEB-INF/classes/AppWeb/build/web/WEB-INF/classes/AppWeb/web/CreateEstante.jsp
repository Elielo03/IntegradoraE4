<%-- 
    Document   : CreateEstante
    Created on : 21-jul-2015, 22:53:09
    Author     : Eliel David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="fonts/style.css">
        <%@include file="metasBootstrap.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Estante</title>
    </head>
    <body>
        <%@include file="Menu.jsp" %>
        
        
        
        <div class="container">
        <form class="form-horizontal" action="Estante" method="post" accept-charset="ISO-8859-1">
            <input type="hidden" name="action" value="crear" />
            <fieldset>
               
                <!-- Form Name -->
                <legend></legend>
                <h1>Crear Estante</h1>
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtNombre">Ubicación </label>  
                    <div class="col-md-6">
                        <input id="txtNombre" name="txtNombre" type="text" placeholder="Ubicación" class="form-control input-md" required="">
                        <span class="help-block">Coloca aquí la ubicación del Estante</span>  
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
</div>
    </body>
</html>
