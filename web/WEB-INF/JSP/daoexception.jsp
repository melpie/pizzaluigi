<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!doctype html>

<html lang="nl">
    <head>
        <title>Pizza Luigi - probleem bij ophalen data</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp"/>
        <h1>Problemen bij het ophalen van data</h1>
        <img src="${contextPath}/images/datafout.jpg" alt="data fout"/>
        <p>We kunnen de gevraagde data niet ophalen
        wegens een technische storing.<br/>
        Gelieve de helpdesk te contacteren.</p>
    </body>
</html>
