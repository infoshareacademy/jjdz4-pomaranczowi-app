<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>


<h4>

    <fmt:message key="${rawDataMessage}" bundle="${finAppLanguage}"/>
    <c:out value="${sessionScope.code}"/>
</h4>

<c:choose>
    <c:when test="${dateLogicError != null}">
        <h5 style="color: red;">${dateLogicError}</h5>
    </c:when>
    <c:otherwise>
        <h5>
            <fmt:message key="localExtremesInput.period" bundle="${finAppLanguage}"/>
            <c:out value="${startDate}"/> - <c:out value="${endDate}"/>
        </h5>
        <c:choose>
            <c:when test="${sessionScope.toConversion==true}">
                <h6 style="color: red;">
                    <fmt:message key="localExtremesInput.simpl" bundle="${finAppLanguage}"/>
                        ${sessionScope.conversion}
                    <fmt:message key="localExtremesInput.from" bundle="${finAppLanguage}"/>
                    ${sessionScope.period}
                    <fmt:message key="localExtremesInput.periods" bundle="${finAppLanguage}"/>

                </h6>
            </c:when>
            <c:otherwise>
                <h6>
                    <fmt:message key="localExtremesInput.dataNotSimpl" bundle="${finAppLanguage}"/>

                </h6>
            </c:otherwise>
        </c:choose>


        <jsp:include page="table-with-rawdata.jsp"/>
    </c:otherwise>
</c:choose>



