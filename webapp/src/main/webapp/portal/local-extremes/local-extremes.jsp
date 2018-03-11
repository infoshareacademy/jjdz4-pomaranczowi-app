<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>

<h4>
    <fmt:message key="${localExtremesMessage}" bundle="${finAppLanguage}"/>
    <c:out value="${sessionScope.code}"/>
</h4>

<c:choose>
    <c:when test="${dateLogicError != null}">
        <h5 style="color: red;"><fmt:message key="${dateLogicError}" bundle="${finAppLanguage}"/></h5>
    </c:when>
    <c:otherwise>
        <h5>
            <fmt:message key="extremes.period" bundle="${finAppLanguage}"/>
            <c:out value="${startDate}"/> - <c:out value="${endDate}"/>
        </h5>
        <jsp:include page="../general/table-with-quotations.jsp"/>
    </c:otherwise>
</c:choose>



