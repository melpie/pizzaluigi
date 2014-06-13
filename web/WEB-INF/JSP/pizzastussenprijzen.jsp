<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!doctype html>

<html lang="nl">
    <head>
        <title>Pizza Luigi – pizza's tussen prijzen</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <h1>Pizza's tussen prijzen</h1>
        <c:url value="/pizzas/tussenprijzen.htm" var="url" />
        <form method="get" action="${url}">
            <label>Van prijs<span class="fout">${fouten.van}</span>
            <input name="van" value="${param.van}" autofocus></label>
            <label>Tot prijs<span class="fout">${fouten.tot}</span>
            <input name="tot" value="${param.tot}"></label>
            <input type="submit" value="Zoeken">
        </form>
        <c:if test="${not empty pizzas}">
            <ul class="zebra">
                <c:forEach var="pizza" items="${pizzas}">
                    <li><c:out value="${pizza.naam}" /> ${pizza.prijs}&euro;</li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty fouten and pizzas.size()==0}">
            <div class="fout">geen pizza's gevonden</div>
        </c:if>
    </body>
</html>
