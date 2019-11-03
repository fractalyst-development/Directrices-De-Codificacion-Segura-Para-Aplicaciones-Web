<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>05 CONTROL ACCESO FORM</title>
    </head>
    <body>
        <h3>Usuarios</h3>
        <ul>
            <li>usuario/Welcome1/usuario</li>
            <li>admin/Welcome1/admin</li>
        </ul>
        <div id="login">
            <p>Inicio de sesi&oacute;n</p>
            <form id="formLogin" action="j_security_check" method="POST">
                <input type="text" name="j_username" placeholder="E-mail" />
                <input type="password" name="j_password" placeholder="Contrase&ntilde;a" />
                <br>
                <input type="submit" value="Iniciar Sesi&oacute;n" />  </form>
        </div>

    </body>
</html>
