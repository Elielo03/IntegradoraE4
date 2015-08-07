<%-- 
    Document   : Menu
    Created on : 14-jul-2015, 9:07:18
    Author     : Eliel David
--%>

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">

        <style>
            .icon-home{
                padding: 7px;
            }

            .icon-users{
                padding: 7px;
            }
            .icon-drive{
                padding: 7px;
            }
            .icon-book{
                padding: 7px;
            }
            .icon-bookmarks{
                padding: 7px;
            }
            .icon-user{
                padding: 7px;
            }
            .icon-shopping-bag{
                padding: 7px;
            }
            .icon-layers{
                padding: 7px;
            }
             .icon-line-graph{
                padding: 7px;
            }
            #submenu{
                border: coral;
            }
            .nav li ul{
                display: none;
                position: absolute;
                min-width: 140px;
                background-color: grey;
                color: white;
                padding: 10px 15px;
            }
            .nav li ul a{

                color: white;
                text-decoration: none;
            }
            .nav li ul:hover{

                background-color: teal;
                color: white;
                padding: 10px 15px;
            }

            .nav li:hover > ul{
                display: block;
            }
            ul, ol{
                list-style: none;
            }

        </style>
       <!-- <a class="navbar-brand" href="IndexUsuario.jsp">LYA</a>-->

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="IndexUsuario.jsp"><span class="icon-home"></span>Inicio</a></li>
                <li><a href="User?action=consultar"><span class="icon-users"></span>Usuarios</a>
                    <ul>

                        <li><a href="CreateUser.jsp">Crear</a></li>

                    </ul>
                </li>
                <li><a href="Autor?action=consultar"><span class="icon-user"></span>Autores</a>
                    <ul>

                        <li><a href="CreateAutor.jsp">Crear</a></li>

                    </ul>
                </li>
                <li><a href="Editorial1?action=consultar"><span class="icon-bookmarks"></span>Editoriales</a>
                    <ul>

                        <li><a href="CreateEditorial.jsp">Crear</a></li>

                    </ul>
                </li>
                <li><a href="Estante?action=consultar"><span class="icon-drive"></span>Estantes</a>
                    <ul>

                        <li><a href="CreateEstante.jsp">Crear</a></li>

                    </ul>
                </li>
                  <li><a href="Area?action=consultar"><span class="icon-drive"></span>Áreas</a>
                    <ul>

                        <li><a href="CreateArea.jsp">Crear</a></li>

                    </ul>
                </li>
                <li><a href="Libro1?action=consultar"><span class="icon-book"></span>Libros</a> 
                    <ul>

                        <li><a href="Libro1?action=combos">Crear</a></li>

                    </ul>
                </li>
            


                <li><a href="Ejemplar?action=consultar"><span class="icon-layers"></span>Ejemplares</a>
                    <ul>

                        <li><a href="Ejemplar?action=combos">Crear</a></li>

                    </ul>
                </li>
                  <li><a href="Ejemplar?action=combos2"><span class="icon-line-graph"></span>Estadísticas</a>
                   
                </li>
                
                 </li>
                  <li><a href="index.jsp"><span class="icon-log-out"></span>Cerrar Sesión</a>
                   
                </li>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>