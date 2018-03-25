<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>

<table class="table">
    <tr>
        <th></th>
        <th colspan="2">OPEN</th>
        <th colspan="2">LOW</th>
        <th colspan="2">HIGH</th>
        <th colspan="2">CLOSE</th>
    </tr>
    <tr>
        <td></td>
        <td>max</td>
        <td>min</td>
        <td>max</td>
        <td>min</td>
        <td>max</td>
        <td>min</td>
        <td>max</td>
        <td>min</td>
    </tr>

    <c:forEach var="singlePeriodPrice" items="${sessionScope.periodPriceList}">
        <tr>
            <c:choose>
                <c:when test="${sessionScope.monthsLanguage != null}">
                    <td><fmt:message key="${singlePeriodPrice.getPeriod()}" bundle="${finAppLanguage}"/>:</td>
                </c:when>
                <c:otherwise>
                    <td>
                        <c:if test="${sessionScope.weeksLanguage != null}">
                            <fmt:message key="dataSimplification.week" bundle="${finAppLanguage}"/>
                        </c:if>
                        <c:out value="${singlePeriodPrice.getPeriod()}"/>:
                    </td>
                </c:otherwise>
            </c:choose>
            <td><c:out value="${singlePeriodPrice.getMaxOpen()}"/></td>
            <td><c:out value="${singlePeriodPrice.getMinOpen()}"/></td>
            <td><c:out value="${singlePeriodPrice.getMaxLow()}"/></td>
            <td><c:out value="${singlePeriodPrice.getMinLow()}"/></td>
            <td><c:out value="${singlePeriodPrice.getMaxHigh()}"/></td>
            <td><c:out value="${singlePeriodPrice.getMinHigh()}"/></td>
            <td><c:out value="${singlePeriodPrice.getMaxClose()}"/></td>
            <td><c:out value="${singlePeriodPrice.getMinClose()}"/></td>
        </tr>
    </c:forEach>

</table>