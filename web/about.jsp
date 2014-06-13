<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!doctype html>
<html lang="nl">
    <head>
        <title>Pizza Luigi - About</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    
    <body>
        <dl>
            <dt>Naam</dt>
            <dd>${initParam.voornaam} ${initParam.familienaam}</dd>
            <dt>Aantal kinderen</dt>
            <dd>${initParam.aantalKinderen}</dd>
            <dt>Gehuwd</dt>
            <dd>${initParam.gehuwd ? 'Ja' : 'Nee' }</dd>
        </dl>
    </body>
</html>
