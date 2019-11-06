<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project"%>

<!DOCTYPE HTML>
<html>
    <head>
        <title>A7 - Cross-Site Scripting (XSS)</title>
    </head>
    <body>
        <h2>A7 - Cross-Site Scripting (XSS)</h2>

        <h2>¡Gracias!</h2>
        <!--<p><strong>${e:forHtmlContent(nombre)}</strong> tus opiniones son muy importantes para nosotros</p>-->
        <p><strong><e:forHtmlContent value="${nombre}"/></strong> tus opiniones son muy importantes para nosotros</p>
        <div>${comentario}</div><br>
        <a href="index.jsp">inicio</a>

    </body>
</html>