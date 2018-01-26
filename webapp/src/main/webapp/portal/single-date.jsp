<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4>
    Notowania z dnia <c:out value="${sessionScope.date}"/> dla
    <c:out value="${sessionScope.data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${sessionScope.code}."/>
</h4>

<c:choose>
    <c:when test="${dateError != null}">
        <h5 style="color: red;">${dateError}</h5>
    </c:when>
    <c:otherwise>
        <jsp:include page="single-date-table.jsp"/>
    </c:otherwise>
</c:choose>

