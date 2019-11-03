<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>A10 - Insufficient Logging & Monitoring</title>
    </head>
    <body>
        <h3>Usuarios</h3>
        <ul>
            <li>usuario1@testmail.com</li>
            <li>usuario2@testmail.com</li>
        </ul>
        <br>
        <div id="mensaje">${mensaje}</div>
        <div id="login">
            <p>Inicio de sesi&oacute;n</p>
            <form id="formLogin" action="loginA2.do" method="POST">
                <input type="text" name="email" placeholder="E-mail" />
                <input type="password" name="password" placeholder="Contrase&ntilde;a" />
                <br>
                <input type="submit" value="Iniciar Sesi&oacute;n" /><input type="button" onclick="recuperaPwdForm();" value="Recuperar Contrase&ntilde;a" />
            </form>
        </div>
        <div id="recuperacion" style="display:none">
            <p>Recuperar Contrase&ntilde;a</p>
            <form id="formRecuperacion" action="recuperaPwd.do" method="POST">
                <input type="text" name="email" placeholder="E-mail" />
                <input type="hidden" name="action" value="1"/>
                <br>
                <input value="Recuperar Contrase&ntilde;a" type="submit" /><input type="button" onclick="loginForm();" value="Regresar al login" />
            </form>
        </div>
        <script>
            function recuperaPwdForm() {
                document.getElementById("login").style.display = "none";
                document.getElementById("recuperacion").style.display = "block";
                limpiaElemento("mensaje");
            }

            function loginForm() {
                document.getElementById("recuperacion").style.display = "none";
                document.getElementById("login").style.display = "block";
                limpiaElemento("mensaje");
            }
            function limpiaElemento(id) {
                document.getElementById(id).innerHTML = "";
            }
        </script>
    </body>
</html>
