<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 11.03.18
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-bordered">

    <tr>
        <td>name</td>
        <td>code</td>
        <td>quotationType</td>
    </tr>
    <tr>
        <td>${sessionScope.name}</td>
        <td>${sessionScope.code}</td>
        <td>${sessionScope.quotationType}</td>
    </tr>
   <%-- <tr>
        <c:forEach var="qu" items="elements">
            Element: <c:out value="${entry}"/>
        </c:forEach>
    </tr>--%>
</table>