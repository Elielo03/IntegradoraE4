<%-- 
    Document   : CreateEstante
    Created on : 21-jul-2015, 22:44:39
    Author     : Eliel David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="metasBootstrap.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <form class="form-horizontal" action="Estante" method="post" accept-charset="ISO-8859-1">
            <input type="hidden" name="action" value="crear" />
            <fieldset>

                <!-- Form Name -->
                <legend>Crear Estante</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtNombre">Ubicación </label>  
                    <div class="col-md-6">
                        <input id="txtNombre" name="txtNombre" type="text" placeholder="Ubicación" class="form-control input-md" required="">
                        <span class="help-block">Coloca aquí la ubicación del Estante</span>  
                    </div>
                </div>

            </fieldset>
        </form>

    </body>
</html>
