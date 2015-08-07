<%-- 
    Document   : CreateAutor
    Created on : 18-jun-2015, 22:58:08
    Author     : Eliel David
--%>

<%@page import="app.model.BeanAutor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="metasBootstrap.jsp" %>

        <title>Actualizar Autor</title>
    </head>
    <body>
<%@include file="Menu.jsp" %>
        <h1></h1>

       <form class="form-horizontal" action="Autor" method="post" accept-charset="ISO-8859-1">
                    <input type="hidden" name="action" value="modificar" />
            

            <fieldset>

                <!-- Form Name -->
                <legend>Actualizar</legend>

                <%
                    BeanAutor beanAutor = new BeanAutor();
                    beanAutor = (BeanAutor) request.getAttribute("attAutor");
                    

                %>
                <input type="hidden" name ="id" value="<%=beanAutor.getId_autor()%>">
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtNombre">Nombre:</label>  
                    <div class="col-md-4">
                        <input value= "<%=beanAutor.getNombre() %>"
                               id="txtNombre" name="txtNombre" type="text" placeholder="" class="form-control input-md" >
                         
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtApellido1">Primer Apellido:</label>  
                    <div class="col-md-4">
                        <input value="<%=beanAutor.getPrimer_apellido() %>" id="txtApellido1" name="txtApellido1" type="text" placeholder="placeholder" class="form-control input-md">
                        
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtApellido2">Segundo Apellido: </label>  
                    <div class="col-md-4">
                        <input value="<%=beanAutor.getSegundo_apellido()  %>" id="txtApellido2" name="txtApellido2" type="text" placeholder="placeholder" class="form-control input-md">
                         
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtPais">Nacionalidad</label>  
                    <div class="col-md-4">
                        <input value="<%=beanAutor.getPais()%>" id="txtPais" name="txtPais" type="text" placeholder="" class="form-control input-md">
                        
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
