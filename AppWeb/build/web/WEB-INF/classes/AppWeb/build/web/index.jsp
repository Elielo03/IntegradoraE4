<%-- 
    Document   : index
    Created on : 16-jun-2015, 23:12:20
    Author     : Eliel David
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
        <link rel="stylesheet" href="css/main.css" />
        <link rel="stylesheet" href="fonts/style.css">
        <!-- SLIDE SHOW -->
    <link rel="stylesheet" href="theme/default.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="theme/light.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="theme/dark.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="theme/bar.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="theme/nivo-slider.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="theme/style.css" type="text/css" media="screen" />
        <!--END SLIDESHOW -->
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">


        <title>LYA</title>

    </head>
   
    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
        <%@include file="MenuAdmin2.jsp" %> 




        <!-- Intro Header -->
        <header class="intro">
            <div class="intro-body">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <h1 class="brand-heading">Lee y Aprende</h1>
                            <h4>B i b l i o t e c a</h4>
                            <a href="#banner" class="btn btn-circle page-scroll">
                                <i class="fa fa-angle-double-down animated"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <section id="banner">
            <header>
                <h2>Bienvenido a la biblioteca <strong>Lee &amp; Aprende</strong>.</h2>
                <h3>
                    Busca , Encuentra , Pide &amp; Disfruta leyendo
                </h3>
            </header>
        </section>
       
           
                 <!--<img src="images/libreria_blanconegro.jpg" width="100%">-->
                <div id="wrapper">
       

        <div class="slider-wrapper theme-default">
            <div id="slider" class="nivoSlider">
                <img src="images/biblio (1).jpg" data-thumb="images/biblio (1).jpg" alt="" />
              
                <img src="images/biblio (2).jpg" data-thumb="images/biblio (2).jpg" alt="" data-transition="slideInLeft" />
                <img src="images/biblio (3).jpg" data-thumb="images/biblio (3).jpg" alt="" title="#htmlcaption" />
            </div>
            <div id="htmlcaption" class="nivo-html-caption">
                <strong>Biblioteca</strong> Lee <em>&AMP;</em> Aprende 
            </div>
        </div>
            
                </div>

        <!-- Features -->
        <div class="wrapper style1">

            <section id="features" class="container special">
                <header>
                    <h2>Acerca De : </h2>

                </header>
                <div class="row">
                    <article class="4u 12u(mobile) special">
                        <img src="images/Komodo IDE 9.jpg" alt="" /></a>
                        <header>
                            <h3><a href="#">Contáctanos </a></h3>
                        </header>
                        <p>
                            En nuestro correo electrónico e interactua con nosotros. Brindanos sugerencias , dudas y lo que desee saber hacerca de esta su página.
                        </p>
                    </article>
                    <article class="4u 12u(mobile) special">
                        <img src="images/Java%20logo%20good.jpg" alt="" /></a>
                        <header>
                            <h3><a href="#">Servicios </a></h3>
                        </header>
                        <p>

                            Horarios de Lunes a Sábado de 8am a 7pm.
                        </p>
                    </article>
                    <article class="4u 12u(mobile) special">
                        <img src="images/logos.jpg" alt="" /></a>
                        <header>
                            <h3>Sobre Nosotros</h3>
                        </header>
                        <p>
                            Somos una biblioteca brindando calidad en libros y diferentes géneros
                            para que encuentres lo que buscas.
                        </p>
                    </article>
                </div>
            </section>

        </div>

        <!-- Footer -->
        <div id="footer">
           

                <hr />
                <div class="row">
                    <div class="12u">

                        <!-- Contact -->
                        <section class="contact">
                            <header>
                                <h3>Biblioteca Lee &amp; Aprende</h3>
                            </header>
                            <p>Av. El Olvido,Palo Escrito, 62765 Emiliano Zapata, Mor.</p>
                            <img src="images/icon1.png">
                        </section>

                        <!-- Copyright -->
                        <div class="copyright">
                            <ul class="menu">
                                <li>&copy; 2015 </li><li>Equipo 4</a></li>
                            </ul>
                        </div>

                    </div>

                </div>
            </div>
        

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="js/jquery.easing.min.js"></script>

        <!-- Custom Theme JavaScript -->
         <script src="js/grayscale.js"></script>
         <script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
    <script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
    </script>
        <script src="js/grayscale.js"></script>

    </body>
</html>




