<%-- 
    Document   : CreateLibro
    Created on : 22-jul-2015, 9:55:52
    Author     : Eric
--%>

<%@page import="app.model.BeanLibro"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Util.ConexionSQLServer"%>
<%@page import="java.sql.Connection"%>
<%@page import="app.model.BeanEditorial"%>
<%@page import="app.model.BeanAutor"%>
<%@page import="app.model.BeanArea"%>
<%@page import="java.util.List"%>
<%@page import="app.Daos.DaoEditorial"%>
<%@page import="app.Daos.DaoAutor"%>
<%@page import="app.Daos.DaoArea"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="fonts/style.css">
        <%@include file="metasBootstrap.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="sumoselect.css" rel="stylesheet" />


        <title>Actualizar Libro</title>
    </head>
    <div>
        <%@include file="Menu.jsp" %>
        <% BeanLibro bean = new BeanLibro();
            bean = (BeanLibro)  request.getAttribute("attLibro");
            
            

        %>

    </div>
        <body class="container">


      

        <form class="form-horizontal" action="Libro1" method="post" accept-charset="ISO-8859-1">
            <input type="hidden" name="action" value="modificar" />


            <fieldset>
                <input type="hidden" name ="id" value="<%=bean.getId_libro()%>">
                <!-- Form Name -->
                <legend></legend>
  <h1>Crear Libro</h1>
                <!-- Text input-->

                <div class="form-group">
                    
                    <label class="col-md-4 control-label" for="txtNombre">Nombre</label>  
                    <div class="col-md-4">
                        <input id="txtNombre" value="<%=bean.getTitulo()%>" name="txtTitulo" type="text" placeholder="Titulo" class="form-control input-md" required="">
                        <span class="help-block">Coloca aquí el nombre del Libro</span>  
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtISBN">ISBN</label>  
                    <div class="col-md-4">
                        <input id="txtApe1" value="<%=bean.getISBN()%>" name="txtISBN" type="text" placeholder="ISBN" class="form-control input-md" required="">
                        <span class="help-block">Coloca aquí el ISBN del libro</span>  
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="txtPaginas">Páginas</label>  
                    <div class="col-md-4">
                        <input id="txtApe2" value="<%=bean.getPaginas()%>" name="txtPaginas" type="text" placeholder="Número de Páginas" class="form-control input-md">
                        <span class="help-block">Coloca aquí el número de páginas</span>  
                    </div>
                </div>

                <!-- Text input-->


                <div class="form-group">

                    <label class="col-md-4 control-label" for="txtArea">Área</label>  
                    <div class="col-md-4">
                        <select class="form-control" name="cmbArea" requiered="">
                            <c:forEach items="${attArea}" var="elem">

                                <option selected="<%=bean.getArea().getNombre()%>"> <c:out value="${elem.nombre}" /> </option>

                            </c:forEach>
                        </select>

                        <span class="help-block">Coloca aquí el área del libro </span>  
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-md-4 control-label" for="txtEditorial">Editorial</label>  
                    <div class="col-md-4">
                        <select class="form-control" name="cmbEditorial" requiered="" >
                            <c:forEach items="${attEditorial}" var="elem">

                                <option selected="<%=bean.getEditorial().getNombre()%>"> <c:out value="${elem.nombre}" /> </option>

                            </c:forEach>
                        </select>

                        <span class="help-block">Coloca aquí la Editorial del libro </span>  
                    </div>
                </div>


                <div class="container">
                    <div class="row">
                        <div class="col-xs-5">
                            <select name="from" id="undo_redo" class="form-control" size="13" multiple="multiple" name="listAutores">
                                <c:forEach items="${attAutor}" var="elem">
                                     <option name="autor"  value="${elem.nombre}"><c:out value="${elem.nombre}" /></option>
                                    
                                    </c:forEach>
                                </form>
                            </select>
                        </div>

                        <div class="col-xs-2">
                            
                            <button type="button" id="undo_redo_rightAll" class="btn btn-default btn-block"><i class="glyphicon glyphicon-forward"></i></button>
                            <button type="button" id="undo_redo_rightSelected" class="btn btn-default btn-block"><i class="glyphicon glyphicon-chevron-right"></i></button>
                            <button type="button" id="undo_redo_leftSelected" class="btn btn-default btn-block"><i class="glyphicon glyphicon-chevron-left"></i></button>
                            <button type="button" id="undo_redo_leftAll" class="btn btn-default btn-block"><i class="glyphicon glyphicon-backward"></i></button>
                            
                        </div>

                        <div class="col-xs-5">
                            <select name="to" selected  id="undo_redo_to" class="form-control" size="13" multiple="multiple"></select>
                        </div>
                    </div>
                </div>
                </div>

                

                <div class="container">

                    <!-- Button (Double) -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="btnGuardar"></label>
                        <div class="col-md-8">
                            <button id="btnGuardar" name="btnGuardar" class="btn btn-success">Guardar</button>
                            <button id="btnCancelar" name="btnCancelar" class="btn btn-danger">Cancelar</button>
                        </div>
                    </div>
                </div>



                <script src="js/multiselect.js"></script>


                <script type="text/javascript">
    $(document).ready(function () {


        $('#undo_redo').multiselect();
    });

                </script>

                <script type="text/javascript">

                    var _gaq = _gaq || [];
                    _gaq.push(['_setAccount', 'UA-36251023-1']);
                    _gaq.push(['_setDomainName', 'jqueryscript.net']);
                    _gaq.push(['_trackPageview']);

                    (function () {
                        var ga = document.createElement('script');
                        ga.type = 'text/javascript';
                        ga.async = true;
                        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                        var s = document.getElementsByTagName('script')[0];
                        s.parentNode.insertBefore(ga, s);
                    })();

                </script>

                </body>




                </html>