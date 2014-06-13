<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!doctype html>

<html lang="nl">
    <head>
        <title>Pizza Luigi - voorkeurpizza's</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <h1>Dit zijn je voorkeurpizza's</h1>
        <ul class="zebra">
            <c:forEach var="pizza" items="${pizzas}">
                <li><c:out value="${pizza.naam}"/></li>
            </c:forEach>
        </ul>
    </body>
</html>
