<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Date', 'Open', 'Low', 'High', 'Close'],
            <c:forEach var="price" items="${prices}">
            ['<c:out value="${price.getDate()}"/>',
                <c:out value="${price.getOpen()}, "/>
                <c:out value="${price.getLow()}, "/>
                <c:out value="${price.getHigh()}, "/>
                <c:out value="${price.getClose()}], "/>
                </c:forEach>
            ]);

        var options = {
            curveType: 'none',
            legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
    }
</script>

<div id="curve_chart" style="width: 100%; height: 500px;"></div>

<table class="table table-bordered">
    <tr>
        <th colspan="1">DATA</th>
        <th colspan="1">OPEN</th>
        <th colspan="1">LOW</th>
        <th colspan="1">HIGH</th>
        <th colspan="1">CLOSE</th>
        <th colspan="1">VOLUME</th>
    </tr>
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
</table>


