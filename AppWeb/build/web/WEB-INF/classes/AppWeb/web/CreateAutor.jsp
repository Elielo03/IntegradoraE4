<%-- 
    Document   : CreateAutor
    Created on : 27-jul-2015, 9:27:15
    Author     : Eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <link rel="stylesheet" href="fonts/style.css">
  <%@include file="metasBootstrap.jsp" %>
        <title>Crear Autor</title>
    </head>
   
    <body>
         
         <header class="cu">
             <%@include file="Menu.jsp" %>
    
    </header> 
        

       <form class="form-horizontal" action="Autor" method="post" accept-charset="ISO-8859-1">
           <input type="hidden" name="action" value="crear" />
            <fieldset>

                <!-- Form Name -->
    
                <legend>Crear Autor</legend>
                <div>
                <h1>Crear Autor</h1>
                </div>
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtNombre">Nombre:</label>  
                    <div class="col-md-4">
                        <input id="txtNombre" name="txtNombre" type="text" required="" placeholder="Nombre Autor" class="form-control input-md" required="" >
                        
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtApellido1">Primer Apellido:</label>  
                    <div class="col-md-4">
                        <input id="txtApellido1" name="txtApellido1" required="" type="text" placeholder="Primer Apellido" class="form-control input-md" required="">
                        
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtApellido2">Segundo Apellido: </label>  
                    <div class="col-md-4">
                        <input id="txtApellido2" name="txtApellido2" type="text" placeholder="Segundo Apellido" class="form-control input-md">
                       
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtPais">Nacionalidad</label>  
                    <div class="col-md-4">
                        <input id="txtPais" name="txtPais" type="text" placeholder="Pais de origen" class="form-control input-md">
                        
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
