<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

    <c:forEach var="singleYearPrice" items="${yearsPriceList}">
        <tr>
            <td><c:out value="${singleYearPrice.getPeriod()}"/>:</td>
            <td><c:out value="${singleYearPrice.getMaxOpen()}"/></td>
            <td><c:out value="${singleYearPrice.getMinOpen()}"/></td>
            <td><c:out value="${singleYearPrice.getMaxLow()}"/></td>
            <td><c:out value="${singleYearPrice.getMinLow()}"/></td>
            <td><c:out value="${singleYearPrice.getMaxHigh()}"/></td>
            <td><c:out value="${singleYearPrice.getMinHigh()}"/></td>
            <td><c:out value="${singleYearPrice.getMaxClose()}"/></td>
            <td><c:out value="${singleYearPrice.getMinClose()}"/></td>
        </tr>
    </c:forEach>

</table>