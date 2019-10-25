<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <h3>${mensaje}</h3>
        <div id="login">
            <p>Inicio de sesi&oacute;n</p>
            <form id="formLogin" action="login.do" method="POST">
                <input type="text" name="nombre" placeholder="nombre" value="admin" />
                <input type="password" name="password" placeholder="Contrase&ntilde;a"  value="pwd"/>
                <br>
                <input type="submit" value="Iniciar Sesi&oacute;n" />
            </form>
        </div>
        <br>
        <a href="index.jsp">inicio</a>|
    </body>
</html>
