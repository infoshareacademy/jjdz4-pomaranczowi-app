<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="alert alert-success" role="alert">
    <c:choose>
        <c:when test="${action == 'globalExtremes'}">
            <h4>
                Ekstrema globalne dla
                <c:out value="${data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${code}."/>
            </h4>
        </c:when>
        <c:when test="${action == 'localExtremes'}">
            <h4>
                Ekstrema lokalne dla
                <c:out value="${data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${code}."/>
            </h4>
            <label for="chooseStartDate">Podaj date poczatkowa</label>
            <input type="date" class="form-control" name="startDate" id="chooseStartDate">
            <label for="chooseEndDate">Podaj date koncowa</label>
            <input type="date" class="form-control" name="endDate" id="chooseEndDate">
        </c:when>
        <c:when test="${action == 'singleDate'}">
            <h4>
                Notowania z danego dnia dla
                <c:out value="${data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${code}."/>
            </h4>
            <label for="chooseDate">Podaj date</label>
            <input type="date" class="form-control" name="date" id="chooseDate">
        </c:when>
        <c:when test="${action == 'dataSimplification'}">
            <h4>
                Upraszczanie danych finansowych dla
                <c:out value="${data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${code}."/>
            </h4>
            <label for="chooseYear">Wybierz rok:</label>
            <select class="form-control" type="text" name="year" id="chooseYear">
                <option>2018</option>
                <option>2017</option>
            </select>
        </c:when>
    </c:choose>
    Tutaj znajdą się wyniki analizy w zależności od tego co użytkownik wybrał w formularzu.
</div>
<form action="/portal/home" method="post">
    <jsp:include page="form-step-nav.jsp"/>
</form>
