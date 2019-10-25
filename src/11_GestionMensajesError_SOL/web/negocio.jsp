<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="WEB-INF/gestorErrores.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            // Throw an exception to invoke the error page
            int x = 1;
            if (x == 1) {
                throw new RuntimeException("Error condition!!!");
            }
        %>
    </body>
</html>
