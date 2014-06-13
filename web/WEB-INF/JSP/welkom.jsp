<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://vdab.be/tags" prefix="vdab"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<html lang="nl">
    <head>
        <title>Pizza Luigi</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp"/>
        <h1>${boodschap}</h1>
        <h2>De zaakvoerder</h2>
        <dl>
            <dt>Naam</dt>
            <dd>${zaakvoerder.naam}</dd>
            <dt>Aantal kinderen</dt>
            <dd>${zaakvoerder.aantalKinderen}</dd>
            <dt>Gehuwd</dt>
            <dd>${zaakvoerder.gehuwd ? 'Ja' : 'Nee' }</dd>
            <dt>Zaak gestart</dt>
            <dd><fmt:formatDate value="${zaakGestart}" type="date" dateStyle="long"/></dd>
            <dt>Aantal pizza's verkocht</dt>
            <dd><fmt:formatNumber value="${aantalPizzasVerkocht}"/></dd>
            <%--<dt>Adres</dt>
            <dd>${zaakvoerder.adres.straat} ${zaakvoerder.adres.huisNr} <br>
            ${zaakvoerder.adres.postcode} ${zaakvoerder.adres.gemeente}</dd>--%>
        </dl>
        <div>Deze pagina werd ${aantalKeerBekeken} keer bekeken.</div>
        <vdab:copyright/>
    </body>
</html>
