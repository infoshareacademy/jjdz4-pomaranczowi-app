<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-bordered">
    <tr>
        <th>OPEN</th>
        <th>LOW</th>
        <th>HIGH</th>
        <th>CLOSE</th>
        <%--<th>VOLUME</th>--%>
    </tr>
    <tr>
        <td>${sessionScope.Open}</td>
        <td>${sessionScope.Low}</td>
        <td>${sessionScope.High}</td>
        <td>${sessionScope.Close}</td>
        <%--<td>${sessionScope.maxVolume}</td>--%>
    </tr>
</table>