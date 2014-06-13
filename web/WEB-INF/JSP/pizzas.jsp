<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html lang="nl">
    <head>
        <title>Pizza Luigi - pizza's</title>
        <c:url value="/styles/default.css" var="URLDefaultCSS"/>
        <link rel="stylesheet" href="${URLDefaultCSS}"/>
    </head>
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp"/>
        <h1>Onze pizza's
            <c:forEach begin="1" end="${sterren}">
                &#9733;
            </c:forEach>
        </h1>
        <ul class="zebra">
            <c:forEach var="pizza" items="${pizzas}" varStatus="status">
                <li class="${status.count % 2 == 0 ? 'even':'oneven'}">
                    <c:out value="${pizza.naam}"/> ${pizza.prijs}&euro;
                    ${pizza.pikant ? "pikant" : "niet pikant"}
                    <c:url value="/pizzas/detail.htm" var="detailURL">
                        <c:param name="nummer" value="${pizza.nummer}"/>
                    </c:url>
                    <a href="<c:out value='${detailURL}'/>">Detail</a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
