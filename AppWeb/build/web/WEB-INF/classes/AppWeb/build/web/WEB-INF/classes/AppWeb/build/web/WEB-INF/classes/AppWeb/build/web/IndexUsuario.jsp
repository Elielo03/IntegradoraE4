<%-- 
    Document   : IndexUsuario
    Created on : 27-jul-2015, 10:51:25
    Author     : Eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

 <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        
         <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/grayscale.css" rel="stylesheet">
         <link rel="stylesheet" href="fonts/style.css">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

        
        <title>LYA</title>

    </head>
    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
       <%@include file="menuAdmin.jsp" %> 
        
        
        

        <!-- Intro Header -->
        <header class="intro">
            <div class="intro-body">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <h1 class="brand-heading">Lee y Aprende</h1>
                            <p class="intro-text">B i b l i o t e c a</p>
                            <a href=".download-section" class="btn btn-circle page-scroll">
                                <i class="fa fa-angle-double-down animated"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <!-- About Section -->
  

        <!-- Download Section -->
        
            <div class="download-section">
                <div class="container">
                    <div class="col-lg-8 col-lg-offset-2">
                        <h2>Administrador</h2>
                        <p>Bienvenido</p>

                        
                        <%@include file="buttons/buttons.jsp" %>
                    </div>

                </div>
            </div>
      

        <!-- Contact Section -->
       <!--
        <section id="contact" class="container content-section text-center">
          
                <div class="col-lg-8 col-lg-offset-2">
                    <h2>Contactanos</h2>
                    <p>Envianos un mail para sugerencias</p>
                    <p><a href="#">elielorgz03@gmail.com</a>
                    </p>
                    <ul class="list-inline banner-social-buttons">
                        <li>
                            <a href="#" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a>
                        </li>
                        <li>
                            <a href="#" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>
                        </li>
                        <li>
                            <a href="#" class="btn btn-default btn-lg"><i class="fa fa-google-plus fa-fw"></i> <span class="network-name">Google+</span></a>
                        </li>
                    </ul>
               
            </div>
        </section>

        <!-- Map Section -->
        

        <!-- Footer -->
  

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="js/jquery.easing.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="js/grayscale.js"></script>

    </body>
</html>
