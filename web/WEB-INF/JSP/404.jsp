<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<html lang="nl">
    
    <head>
        <title>Pizza Luigi - pagina niet gevonden</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>

    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp"/>
        <h1>Pagina niet gevonden</h1>
        <img src="${contextPath}/images/fout.jpg" alt="fout"/>
        <p>De pagina die u zocht bestaat niet op onze website.</p>
    </body>
    
</html>
