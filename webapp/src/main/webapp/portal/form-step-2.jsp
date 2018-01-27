<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" method="">
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
</form>
<jsp:include page="data-simplification-input.jsp"/>
<jsp:include page="signle-date-input.jsp"/>
<jsp:include page="local-extremes-input.jsp"/>
<form id="globalExtremes" action="/portal/home" method="post">
    <input type="hidden" name="action" value="globalExtremes">
    <jsp:include page="form-step-nav.jsp"/>
</form>
<script src="../js/toggleActionView.js"></script>
