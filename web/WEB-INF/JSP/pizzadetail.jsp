<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!doctype html>

<html lang="nl">
    <head>
        <title>Pizza Luigi - pizza ${pizza.naam}</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>

    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp"/>
        <c:if test="${not empty pizza}">
            <h1>Pizza ${pizza.naam}</h1>
            <dl>
                <dt>Nummer</dt><dd>${pizza.nummer}</dd>
                <dt>Naam</dt><dd>${pizza.naam}</dd>
                <dt>Prijs</dt><dd>${pizza.prijs}</dd>
                <dt>Pikant</dt><dd>${pizza.pikant ? 'ja' : 'nee'}</dd>
            </dl>
        </c:if>
        <c:if test="${not empty fout}">
            <div class="fout">${fout}</div>
        </c:if>
    </body>
    
</html>
