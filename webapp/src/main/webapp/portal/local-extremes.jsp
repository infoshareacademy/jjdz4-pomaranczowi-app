<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4>
    Ekstrema lokalne dla
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
        <jsp:include page="table-with-quotations.jsp"/>
    </c:otherwise>
</c:choose>



