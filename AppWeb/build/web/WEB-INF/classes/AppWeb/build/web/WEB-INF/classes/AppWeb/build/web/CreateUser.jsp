<%-- 
    Document   : CreateUser
    Created on : 17-jul-2015, 13:19:46
    Author     : Eliel David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="fonts/style.css">
        <%@include file="metasBootstrap.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Usuario</title>
    </head>
    <div>
        <%@include file="Menu.jsp" %>
    </div>
    <body >
       <section >
          
            <h1></h1>


            <form class="form-horizontal" action="User" method="post" accept-charset="ISO-8859-1">
                        <input type="hidden" name="action" value="crear" />

               

                    <fieldset>

                        <!-- Form Name -->
                   
                       <h1>Crear Usuario</h1>
                        <!-- Text input-->
                        
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtNombre">Nombre</label>  
                            <div class="col-md-4">
                                <input id="txtNombre" name="txtNombre" type="text" placeholder="Nombre Usuario" class="form-control input-md" required="">
                                <span class="help-block">Coloca aquí el nombre del usuario</span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtApe1">Primer Apellido</label>  
                            <div class="col-md-4">
                                <input id="txtApe1" name="txtApe1" type="text" placeholder="Apellido Paterno" class="form-control input-md" required="">
                                <span class="help-block">Coloca aquí el primer apellido</span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtApe2">Segundo Apellido</label>  
                            <div class="col-md-4">
                                <input id="txtApe2" name="txtApe2" type="text" placeholder="Apellido Materno" class="form-control input-md">
                                <span class="help-block">help</span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtCorreo">Correo:</label>  
                            <div class="col-md-4">
                                <input id="txtCorreo" name="txtCorreo" type="email" placeholder="E-Mail" class="form-control input-md" required="">
                                <span class="help-block">Correo obligatorio </span>  
                            </div>
                        </div>

                       
        
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtContrasena">Contraseña</label>  
                            <div class="col-md-4">
                                <input id="txtContraseña" name="txtContraseña" type="text"  placeholder="Contraseña" class="form-control input-md" required="">
                                <span class="help-block">Contraseña obligatoria</span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtDireccion">Dirección </label>  
                            <div class="col-md-6">
                                <input id="txtDireccion" name="txtDireccion" type="text" placeholder="Direccion" class="form-control input-md">
                                <span class="help-block">help</span>  
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
                         
                         
                         
                           <!-- Multiple Radios -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="rdAdmin">Admin</label>
                    <div class="col-md-4">
                        <div class="radio">
                            <label for="rdAdmin-0">
                                <input type="radio" name="rdAdmin" id="rdAlta-0" value="si" checked="checked">
                                Activo
                            </label>
                        </div>
                        <div class="radio">
                            <label for="rdAdmin-1">
                                <input type="radio" name="rdAdmin" id="rdAlta-1" value="no" >
                                Inactivo
                            </label>
                        </div>
                    </div>
                </div>
                         
                         

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="txtTelefono">Teléfono </label>  
                            <div class="col-md-4">
                                <input id="txtTelefono" name="txtTelefono" type="text" placeholder="Teléfono" class="form-control input-md">
                                <span class="help-block">help</span>  
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
