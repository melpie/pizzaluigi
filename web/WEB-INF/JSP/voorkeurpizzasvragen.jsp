<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!doctype html>

<html lang="nl">
    <head>
        <title>Pizza Luigi – voorkeurpizza's</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <h1>Voorkeurpizza's</h1>
        <c:url value="/pizzas/voorkeuren.htm" var="url" />
        <form method="get" action="${url}">
            <ul class="zonderbolletjes">
                <c:forEach var="pizza" items="${pizzas}">
                    <li>
                        <label><input type="checkbox" name="nummer" value="${pizza.nummer}">
                        <c:out value="${pizza.naam}"/></label>
                    </li>
                </c:forEach>
            </ul>
            <input type="submit" value="Toon mijn keuzes"/>
        </form>
    </body>
</html>