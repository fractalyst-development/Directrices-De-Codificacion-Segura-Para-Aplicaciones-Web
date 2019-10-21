<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            html {
                background-image: url("images/fondo.png");
            }
        </style>
    </head>
    <body>
        <h1>Carga de archivos</h1>
        <form action="cargaArchivo.do" method="post" enctype="multipart/form-data">
            Select File to Upload:<input type="file" name="fileName">
            <br>
            <input type="submit" value="Upload">
        </form>
    </body>
</html>
