<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!doctype html>

<html lang="nl">
    
    <head>
        <title>Pizza Luigi - pizza's bestellen</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <h1>Pizza's bestellen</h1>
        <c:if test="${not empty allePizzas}">
            <h2>Ons assortiment</h2>
            <c:url value="/pizzas/bestellen.htm" var="bestelURL" />
            <form method="post" action="${bestelURL}" id="toevoegform">
                <ul class="zonderbolletjes">
                    <c:forEach var="pizza" items="${allePizzas}">
                        <li><label><input type="checkbox" name="nummer"
                        value="${pizza.nummer}">
                        <c:out value="${pizza.naam}" /></label></li>
                    </c:forEach>
                </ul>
                <input type="submit" value="Toevoegen aan mandje" id="toevoegknop"/>
            </form>
        </c:if>
        <c:if test="${not empty pizzasInMandje}">
            <h2>Uw mandje</h2>
            <ul>
                <c:forEach var="pizza" items="${pizzasInMandje}">
                    <li><c:out value="${pizza.naam}" /></li>
                </c:forEach>
            </ul>
        </c:if>
        <script>
            document.getElementById('toevoegform').onsubmit = function() {
               document.getElementById('toevoegknop').disabled=true;
            };
        </script>
    </body>
    
</html>