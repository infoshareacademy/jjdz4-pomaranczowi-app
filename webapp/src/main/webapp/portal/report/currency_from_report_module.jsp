<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 11.03.18
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table">

    <tr>
        <th>Quotation Name</th>
        <th>Quotation Code</th>
        <th>Quotation Type</th>
    </tr>

    <c:forEach var="entry" items="${quotationReportCurrencyList}">
        <tr>
            <td><c:out value="${entry.name}"/>
            <td><c:out value="${entry.code}"/>
            <td><c:out value="${entry.quotationType}"/>
        </tr>

    </c:forEach>
</table>
