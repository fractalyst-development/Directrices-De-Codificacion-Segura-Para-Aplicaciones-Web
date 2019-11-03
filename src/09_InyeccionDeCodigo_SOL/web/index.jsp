<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
 <title>A1 - Inyecci&oacute;n de C&oacute;digo</title>
    </head>
    <body onload="limpiaElemento()">
        <h3>A1 - SQL INJECTION</h3>
        <ul>
            <li>usuario1@testmail.com</li>
        </ul>
        <br>
        <div id="mensaje">${mensaje}</div>

        <p>Correo del usuario a mostrar detalle</p>
        <form id="formRecuperacion" action="detalleUsuario.do" method="POST">
            <input type="text" name="email" placeholder="E-mail" />
            <br>
            <input value="Mostrar detalles" type="submit" />
        </form>

        <script>
            function limpiaElemento() {
                document.getElementById("mensaje").innerHTML = "";
            }
        </script>
    </body>
</html>
