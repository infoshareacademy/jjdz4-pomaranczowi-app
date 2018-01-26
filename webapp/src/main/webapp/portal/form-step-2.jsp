<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseAction">Wybierz sposób sposób analizy:</label>
            <select type="text" class="form-control" name="action"
                    id="chooseAction" onchange="toggleActionView()">
                <option value="globalExtremes" <c:if test="${sessionScope.action == 'globalExtremes'}">selected</c:if>>
                    Ekstrema globalne
                </option>
                <option value="localExtremes" <c:if test="${sessionScope.action == 'localExtremes'}">selected</c:if>>
                    Ekstrema lokalne
                </option>
                <option value="singleDate" <c:if test="${sessionScope.action == 'singleDate'}">selected</c:if>>
                    Wartości z danego dnia
                </option>
                <option value="dataSimplification"
                        <c:if test="${sessionScope.action == 'dataSimplification'}">selected</c:if>>
                    Upraszczanie danych
                </option>
            </select>
        </div>
    </div>
    <jsp:include page="data-simplification-input.jsp"/>
    <jsp:include page="signle-date-input.jsp"/>
    <jsp:include page="local-extremes-input.jsp"/>
    <jsp:include page="form-step-nav.jsp"/>

</form>

<script>
    function toggleActionView() {
        var yearSelectView = document.getElementById("chooseYearToggleView");
        var twoDatesSelectView = document.getElementById("chooseTwoDatesToggleView");
        var oneDateSelectView = document.getElementById("chooseOneDateToggleView");
        var actionSelect = document.getElementById("chooseAction").selectedIndex;
        if (actionSelect === 1) {
            yearSelectView.style.display = "none";
            twoDatesSelectView.style.display = "block";
            oneDateSelectView.style.display = "none";
        } else if (actionSelect === 2) {
            yearSelectView.style.display = "none";
            twoDatesSelectView.style.display = "none";
            oneDateSelectView.style.display = "block";
        } else if (actionSelect === 3) {
            yearSelectView.style.display = "block";
            twoDatesSelectView.style.display = "none";
            oneDateSelectView.style.display = "none";
        } else {
            yearSelectView.style.display = "none";
            twoDatesSelectView.style.display = "none";
            oneDateSelectView.style.display = "none";
        }
    }
</script>
