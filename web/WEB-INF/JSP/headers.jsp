<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!doctype html>

<html lang="nl">
    <head>
        <title>Pizza Luigi - headers</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <dl>
            <c:forEach var="h" items="${headers}">
                <dt>${h.key}</dt>
                <dd>${h.value}</dd>
            </c:forEach>
        </dl>
    </body>
</html>
