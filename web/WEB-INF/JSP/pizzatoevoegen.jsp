<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!doctype html>
<html lang="nl">
    
    <head>
        <title>Pizza Luigi - pizza toevoegen</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <h1>Pizza toevoegen</h1>
        <c:url value="/pizzas/toevoegen.htm" var="url" />
        <form method="post" action="${url}" id="toevoegform">
            <label>Naam<span class="fout">${fouten.naam}</span>
            <input name="naam" value="${param.naam}" autofocus></label>
            <label>Prijs<span class="fout">${fouten.prijs}</span>
            <input name="prijs" value="${param.prijs}" type="number"></label>
            <div>
                <label>
                    <input type="checkbox" name="pikant" value="pikant"/> Pikant
                </label>
            </div>
            <input type="submit" value="Toevoegen" id="toevoegknop">
        </form>
    </body>
    
</html>