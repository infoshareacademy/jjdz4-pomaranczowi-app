<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>

<c:choose>
    <c:when test="${errorMessage != null}">
        <h5 style="color: red;">${errorMessage}</h5>
    </c:when>
    <c:otherwise>
        <h4>
            <fmt:message key="${dataSimplificationMessage}" bundle="${finAppLanguage}"/>

            <c:out value="${sessionScope.data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${sessionScope.code}"/>
        </h4>
        <h5>
            <fmt:message key="dataSimplification.period" bundle="${finAppLanguage}"/>
            <c:out value="${startDate}"/> - <c:out value="${endDate}"/>
        </h5>
        <jsp:include page="table-with-quotations.jsp"/>
    </c:otherwise>
</c:choose>

