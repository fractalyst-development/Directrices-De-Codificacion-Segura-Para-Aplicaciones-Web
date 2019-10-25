<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>A10 - Insufficient Logging & Monitoring</title>
    </head>
    <body>

        <h1>Recuperaci&oacute;n de contrase&ntilde;a</h1>
        <div id="mensaje">${mensaje}</div>
        <form  action="cambiaPwd.do" method="POST">
            Nueva Contrase&ntilde;a: <input type="password" name="password"><br>
            Confirma Contrase&ntilde;a: <input type="password" name="nuevoPassword"><br>
            <input type="hidden" name="email" value="${email}"><br>
            <input type="submit" value="Submit">
        </form>

    </body>
</html>
