<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col-sm-10">
            <c:choose>
                <c:when test="${param.action == 1}">
                    <h4 class="alert-heading">Ekstrema globalne:</h4>
                </c:when>
                <c:when test="${param.action == 2}">
                    <h4 class="alert-heading">Ekstrema lokalne:</h4>
                    <label for="chooseStartDate">Podaj date poczatkowa w formacie YYYY-MM-DD:</label>
                    <input type="text" class="form-control" name="startDate" id="chooseStartDate">
                    <label for="chooseEndDate">Podaj date koncowa w formacie YYYY-MM-DD:</label>
                    <input type="text" class="form-control" name="endDate" id="chooseEndDate">
                </c:when>
                <c:when test="${param.action == 3}">
                    <h4 class="alert-heading">Wartosci z danego dnia:</h4>
                    <label for="chooseDate">Podaj date w formacie YYYY-MM-DD:</label>
                    <input type="text" class="form-control" name="date" id="chooseDate">
                </c:when>
                <c:when test="${param.action == 3}">
                    <h4 class="alert-heading">Upraszczanie danych:</h4>
                    <label for="chooseYear">Wybierz rok:</label>
                    <select class="form-control" type="text" name="year" id="chooseYear">
                        <option>2018</option>
                        <option>2017</option>
                    </select>
                </c:when>
            </c:choose>
        </div>
    </div>
    <%@include file="form-step-nav.jsp" %>
</form>