<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>A2 - Broken Authentication</title>
    </head>
    <body>

        <h1>Detalle usuarios</h1>

        <div id="mensaje">${mensaje}</div>

        <c:forEach items="${usuarios}" var="u">
            ${u}<br>
        </c:forEach>
        <br>
        <a href="index.jsp">inicio</a>

    </body>
</html>
