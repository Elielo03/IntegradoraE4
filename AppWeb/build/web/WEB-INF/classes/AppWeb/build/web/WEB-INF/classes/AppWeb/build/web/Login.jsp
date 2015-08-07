<%-- 
    Document   : Login
    Created on : 27-jul-2015, 9:56:51
    Author     : Eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Iniciar Sesión</title>
	<link rel="stylesheet" href="css/bootstrap.css">
         <%@include file="metasBootstrap.jsp" %>
	<script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>
 <!-- <script src="js/bootstrapValidator.min.js"></script>-->
  <script src="js/noty.js"></script>
  <!--<script src="js/app.js"></script>-->
</head>
<body>
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

    <div id="login-overlay" class="modal-dialog">
      <div class="modal-content">
          <div class="modal-header">
              <h4 class="modal-title" id="myModalLabel">Lee &AMP; Aprende - Biblioteca</h4>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-xs-6">
                      <div class="well">
                          
                          <form id="form-login" action="User" method="post">
                              <div class="form-group">
                                  <label for="usuario" class="control-label">Correo Electrónico</label>
                                  <input type="hidden" name="action" value="entrar" />
                                  <input type="email" class="form-control" id="usuario" name="usuario" value=""  placeholder="example@gmail.com">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="password" class="control-label">Contraseña</label>
                                     <input type="hidden" name="action" value="entrar" />
                                  <input type="password" class="form-control" id="password" name="password" value="">
                                  <span class="help-block"></span>
                              </div>
                            <!--
                              <div class="checkbox">
                                  <label>
                                      <input type="checkbox" name="remember" id="remember"> Recordarme
                                  </label>
                              </div>
                            -->
                              <button type="submit" id="btnlogin">Entrar</button>
                          </form>
                      </div>
                  </div>
                  <div class="col-xs-6">
                      <p class="lead">Ingresa correo y contraseña<span class="text-success"></span></p>
                   
                      <img src="images/icon1.png" width="200px"> 
                      
                  </div>
              </div>
          </div>
      </div>
  </div>
</body>
</html>