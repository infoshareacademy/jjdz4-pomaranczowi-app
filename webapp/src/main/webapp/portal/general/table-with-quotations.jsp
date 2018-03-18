<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table">
    <tr>
        <th colspan="2">OPEN</th>
        <th colspan="2">LOW</th>
        <th colspan="2">HIGH</th>
        <th colspan="2">CLOSE</th>
        <%--<th colspan="2">VOLUME</th>--%>
    </tr>
    <tr>
        <td>max</td>
        <td>min</td>
        <td>max</td>
        <td>min</td>
        <td>max</td>
        <td>min</td>
        <td>max</td>
        <td>min</td>
        <%--<td>max</td>
        <td>min</td>--%>
    </tr>
    <tr>
        <td>${sessionScope.maxOpen}</td>
        <td>${sessionScope.minOpen}</td>
        <td>${sessionScope.maxLow}</td>
        <td>${sessionScope.minLow}</td>
        <td>${sessionScope.maxHigh}</td>
        <td>${sessionScope.minHigh}</td>
        <td>${sessionScope.maxClose}</td>
        <td>${sessionScope.minClose}</td>
        <%--<td>${sessionScope.maxVolume}</td>
        <td>${sessionScope.minVolume}</td>--%>
    </tr>
</table>