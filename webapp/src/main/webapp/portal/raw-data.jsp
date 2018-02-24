<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4>
    Dane surowe z okresu dla
    <c:out value="${sessionScope.data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${sessionScope.code}"/>
</h4>

<c:choose>
    <c:when test="${dateLogicError != null}">
        <h5 style="color: red;">${dateLogicError}</h5>
    </c:when>
    <c:otherwise>
        <h5>
            z okresu <c:out value="${startDate}"/> - <c:out value="${endDate}"/>
        </h5>
        <hr>
        <p>Upraszczanie danych:
        <p>Simple Moving Average (SMA) z
        <select name="period">
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select>
        poprzednich okresow.
        <hr>
        <jsp:include page="table-with-rawdata.jsp"/>
    </c:otherwise>
</c:choose>



