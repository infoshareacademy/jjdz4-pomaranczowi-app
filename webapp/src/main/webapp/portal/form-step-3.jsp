<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="alert alert-success" role="alert">
    <h2>
        <c:choose>
            <c:when test="${action == 'globalExtremes'}">
                Ekstrema globalne dla
            </c:when>
            <c:when test="${action == 'localExtremes'}">
                Ekstrema lokalne dla
                <label for="chooseStartDate">Podaj date poczatkowa w formacie YYYY-MM-DD:</label>
                <input type="text" class="form-control" name="startDate" id="chooseStartDate">
                <label for="chooseEndDate">Podaj date koncowa w formacie YYYY-MM-DD:</label>
                <input type="text" class="form-control" name="endDate" id="chooseEndDate">
            </c:when>
            <c:when test="${action == 'singleDate'}">
                Notowania z danego dnia dla
                <label for="chooseDate">Podaj date w formacie YYYY-MM-DD:</label>
                <input type="text" class="form-control" name="date" id="chooseDate">
            </c:when>
            <c:when test="${action == 'dataSimplification'}">
                Upraszczanie danych finansowych dla
                <label for="chooseYear">Wybierz rok:</label>
                <select class="form-control" type="text" name="year" id="chooseYear">
                    <option>2018</option>
                    <option>2017</option>
                </select>
            </c:when>
        </c:choose>
        <c:out value="${data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${code}."/>
    </h2>
    Tutaj znajdą się wyniki analizy w zależności od tego co użytkownik wybrał w formularzu.
</div>
<form action="/portal/home" method="post">
    <jsp:include page="form-step-nav.jsp"/>
</form>
