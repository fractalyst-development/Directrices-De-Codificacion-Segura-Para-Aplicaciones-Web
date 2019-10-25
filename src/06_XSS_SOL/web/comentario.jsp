<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>A7 - Cross-Site Scripting (XSS)</title>
    </head>
    <body>
        <h2>A7 - Cross-Site Scripting (XSS)</h2>

        <h2>¡Gracias!</h2>
        <p><strong>${nombre}</strong> tus opiniones son muy importantes para nosotros</p>
        <em>${comentario}</em><br>
        <a href="index.jsp">inicio</a>

    </body>
</html>