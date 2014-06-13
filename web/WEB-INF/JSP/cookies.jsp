<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename='resourceBundles.teksten'/>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!doctype html>

<html lang="nl">
    
    <head>
        <title>Pizza Luigi - cookies</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <c:url value="/cookies.htm" var="action"/>
        <h1><fmt:message key='cookieVoorbeeld'/></h1>
        <form method="post" action="${action}">
            <label><fmt:message key="naam"/>
            <input name="naam" value="${naam}" autofocus/></label>
            <input type="submit" value="<fmt:message key='onthoudMe'/>"/>
        </form>
        <c:if test="${not empty naam}">
            <div>
                <fmt:message key="jeNaamBestaatUitLetters">
                    <fmt:param value="${naam.length()}"/>
                </fmt:message>
            </div>
        </c:if>
    </body>
    
</html>