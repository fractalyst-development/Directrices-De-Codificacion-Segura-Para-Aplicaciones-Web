<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de usuarios</h1>

        <c:forEach items="${sessionScope.usuarios}" var="u">
            ${u} <br>
        </c:forEach>

        <c:if test="${esAdmin}">
            <a href="permisosForm.jsp">editar permisos</a> | 
        </c:if>
        <a href="index.jsp">inicio</a>
    </body>
</html>
