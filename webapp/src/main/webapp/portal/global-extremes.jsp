<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4>
    Ekstrema globalne dla
    <c:out value="${sessionScope.data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${sessionScope.code}"/>
</h4>
<h5>
    z okresu <c:out value="${startDate}"/> - <c:out value="${endDate}"/>
</h5>

<jsp:include page="table-with-quotations.jsp"/>