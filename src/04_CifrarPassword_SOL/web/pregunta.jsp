<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Almacenaje</title>
    </head>
    <body>

        <h1>Recuperaci&oacute;n de contrase&ntilde;a</h1>

        <div id="mensaje">${mensaje}</div>

        <form  action="validaPregunta.do" method="POST">
            Pregunta secreta: ${pregunta}
            <br>Respuesta: <input type="text" name="respuesta"><br>
            <input type="hidden" name="email" value="${email}"><br>
            <input type="submit" value="Submit">
        </form>

    </body>
</html>
