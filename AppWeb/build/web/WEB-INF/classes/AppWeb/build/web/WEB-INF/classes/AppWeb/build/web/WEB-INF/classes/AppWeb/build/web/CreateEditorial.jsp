<%-- 
    Document   : CreateEditorial
    Created on : 09-jul-2015, 11:30:19
    Author     : Eliel David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="fonts/style.css">
        <%@include file="metasBootstrap.jsp" %>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Editorial</title>
    </head>

  
    
       

    <body>
       <%@include file="Menu.jsp" %>


 <section class="usu">

        <form class="form-horizontal" action="Editorial1" method="post" accept-charset="ISO-8859-1">
            <input type="hidden" name="action" value="crear" />
            <fieldset>

                <!-- Form Name -->
                <legend></legend>
                  <h1>Crear Editorial</h1>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtNombre">Nombre Editorial:</label>  
                    <div class="col-md-4">
                        <input id="txtNombre" name="txtNombre" type="text" placeholder="" class="form-control input-md" required="">
                        <span class="help-block">Escribe aquí el nombre de la editorial</span>  
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
                

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtDireccion">Direccion</label>  
                    <div class="col-md-6">
                        <input id="txtDireccion" name="txtDireccion" type="text" placeholder="" class="form-control input-md">
                        <span class="help-block">Escribe aquí la dirección de la Editorial</span>  
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
 </section>
    </body>
</html>
