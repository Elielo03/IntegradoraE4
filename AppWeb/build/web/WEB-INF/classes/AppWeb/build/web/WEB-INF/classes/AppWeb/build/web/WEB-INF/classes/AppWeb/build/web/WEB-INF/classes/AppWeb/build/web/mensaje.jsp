<%-- 
    Document   : mensaje
    Created on : 3/08/2014, 02:04:17 PM
    Author     : AdrianCruz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <title>mensaje</title>
        <%@include file="metasBootstrap.jsp" %>
        <link rel="stylesheet" type="text/css" href="b3.1.1/css/bootstrap.min.css">                
    </head>
<body>
    <%@include file="Menu.jsp" %>
    <div class="container">
        <div class="jumbotron">
            <br />
             <% out.print(request.getAttribute("mensaje")); %>
        </div>
    </div>
  </body>    
    </html>
