<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
            z okresu <c:out value="${startDate}"/> - <c:out value="${endDate}"/>
        </h5>
        <c:choose>
            <c:when test="${sessionScope.toConversion==true}">
                <h6 style="color: red;">
                    Dane uproszczone za pomocą
                        ${sessionScope.conversion}
                    z ${sessionScope.period}
                    poprzednich okresów
                </h6>
            </c:when>
            <c:otherwise>
                <h6>
                    Dane nieuproszczone.
                </h6>
            </c:otherwise>
        </c:choose>


        <jsp:include page="table-with-rawdata.jsp"/>
    </c:otherwise>
</c:choose>



