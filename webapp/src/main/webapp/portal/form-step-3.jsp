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
            </c:when>
            <c:when test="${action == 'singleDate'}">
                Notowania z danego dnia dla
            </c:when>
            <c:when test="${action == 'dataSimplification'}">
                Upraszczanie danych finansowych dla
            </c:when>
        </c:choose>
        <c:out value="${data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${code}."/>
    </h2>
    Tutaj znajdą się wyniki analizy w zależności od tego co użytkownik wybrał w formularzu.
</div>
<form action="/portal/home" method="post">
    <jsp:include page="form-step-nav.jsp"/>
</form>
