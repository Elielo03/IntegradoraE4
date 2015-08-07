<%-- 
    Document   : CreateUser
    Created on : 17-jul-2015, 13:19:46
    Author     : Eliel David
--%>

<%@page import="app.model.BeanUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="metasBootstrap.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Usuario</title>
    </head>
    <body>
<%@include file="Menu.jsp" %>
         <form class="form-horizontal" action="User" method="post" accept-charset="ISO-8859-1">
             <input type="hidden" name="action" value="modificar" />
            <fieldset>
                <!-- Form Name -->
                <legend>Form Name</legend>
                <%
                    BeanUsuario bean= new BeanUsuario();
                    bean= (BeanUsuario) request.getAttribute("attUser");
                    %>
                <!-- Text input-->
                <input id="id" name="id" value="<%=bean.getId_usuario()%>" class="hidden">
                
                     <div class="form-group">
                    <label class="col-md-4 control-label" for="txtNombre">Nombre</label>  
                    <div class="col-md-4">
                        <input id="txtNombre" name="txtNombre" value="<%=bean.getNombre()%>" type="text" placeholder="Nombre Usuario" class="form-control input-md" required="">
                        <span class="help-block">Coloca aquí el nombre del usuario</span>  
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtApe1">Primer Apellido</label>  
                    <div class="col-md-4">
                        <input id="txtApe1" name="txtApe1" type="text" value="<%=bean.getPrimer_apellido()%>" placeholder="Primer Apellido" class="form-control input-md" required="">
                        <span class="help-block">Coloca aquí el primer apellido</span>  
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtApe2">Segundo Apellido</label>  
                    <div class="col-md-4">
                        <input id="txtApe2" name="txtApe2" value="<%=bean.getSegundo_apellido()%>" type="text" placeholder="placeholder" class="form-control input-md">
                        <span class="help-block">help</span>  
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtCorreo">Correo:</label>  
                    <div class="col-md-4">
                        <input id="txtCorreo" name="txtCorreo" value="<%=bean.getCorreo()%>" type="text" placeholder="placeholder" class="form-control input-md" required="">
                        <span class="help-block">Correo obligatorio </span>  
                    </div>
                </div>

                

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label"    for="txtContraseña">Contraseña</label>  
                    <div class="col-md-4">
                        <input id="txtContraseña" name="txtContraseña" value="<%=bean.getPass()%>" type="text" placeholder="placeholder" class="form-control input-md" >
                        <span class="help-block">Contraseña obligatoria</span>  
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
                    <label class="col-md-4 control-label" for="txtDireccion">Dirección </label>  
                    <div class="col-md-8">
                        <input id="txtDireccion" value="<%=bean.getDireccion()%>" name="txtDireccion" type="text" placeholder="placeholder" class="form-control input-md">
                        <span class="help-block">help</span>  
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" value="<%=bean.getTelefono()%>" for="txtTelefono">Teléfono </label>  
                    <div class="col-md-4">
                        <input id="txtTelefono" name="txtTelefono" type="text" placeholder="placeholder" class="form-control input-md">
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

    </body>
</html>
