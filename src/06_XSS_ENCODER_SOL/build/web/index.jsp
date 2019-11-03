<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>A7 - Cross-Site Scripting</title>
    </head>
    <body>
        <h2>A7 - Cross-Site Scripting</h2>

        <div >
            <h2>Escribe un breve comentario</h2>
            <form method="post" action="comentario.do">
                <input type="text" name="nombre" placeholder="Nombre" autocomplete="off"/><br>
                <input type="email" name="email" placeholder="Correo electrónico" autocomplete="off"/><br>
                <textarea name="comentario" placeholder="Escriba aquí su comentario" rows="6"></textarea><br>
                <input type="submit" value="Enviar" />
            </form>
        </div>

    </body>
</html>