<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración roles</title>
    </head>
    <body>
        <h1>Administración Roles</h1>
        <form method="get" action="adminRoles.do">

            <select name="idUsuario">
                <c:forEach items="${sessionScope.usuarios}" var="u">
                    <option value="${u.idUsuario}">${u.nombre}</option>
                </c:forEach>
            </select>
            <input type="checkbox" name="read" value="true"><label for="read">Read</label>
            <input type="checkbox" name="write" value="true"><label for="write">Write</label>
            <input type="checkbox" name="execute" value="true"><label for="execute">Execute</label>
            <input type="hidden" name="tokenSincronizador" value="${tokenSincronizador}" />
            <input type="submit" name="submit" value="Submit">
        </form>
        <a href="index.jsp">inicio</a>|<a href="ListadoPermisos.jsp">permisos</a>|
    </body>
</html>
