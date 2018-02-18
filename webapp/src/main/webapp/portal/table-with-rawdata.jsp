<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-bordered">
    <tr>
        <th colspan="1">DATA</th>
        <th colspan="1">OPEN</th>
        <th colspan="1">LOW</th>
        <th colspan="1">HIGH</th>
        <th colspan="1">CLOSE</th>
        <th colspan="1">VOLUME</th>
        <%--<th colspan="2">VOLUME</th>--%>
    </tr>
   <%-- <tr>

        <td>value</td>
        <td>value</td>
        <td>value</td>
        <td>value</td>
        <td>value</td>
        <td>value</td>
        &lt;%&ndash;<td>max</td>
        <td>min</td>&ndash;%&gt;
    </tr>--%>

    <c:forEach var="price" items="${prices}">
        <tr>
            <td><c:out value="${price.getDate()}"/></td>
            <td><c:out value="${price.getOpen()}"/></td>
            <td><c:out value="${price.getLow()}"/></td>
            <td><c:out value="${price.getHigh()}"/></td>
            <td><c:out value="${price.getClose()}"/></td>
            <td><c:out value="${price.getVolume()}"/></td>
        </tr>
    </c:forEach>

<%--    <tr>
        <td>${sessionScope.maxOpen}</td>
        <td>${sessionScope.minOpen}</td>
        <td>${sessionScope.maxLow}</td>
        <td>${sessionScope.minLow}</td>
        <td>${sessionScope.maxHigh}</td>
        <td>${sessionScope.minHigh}</td>
        <td>${sessionScope.maxClose}</td>
        <td>${sessionScope.minClose}</td>
        &lt;%&ndash;<td>${sessionScope.maxVolume}</td>
        <td>${sessionScope.minVolume}</td>&ndash;%&gt;
    </tr>--%>
</table>