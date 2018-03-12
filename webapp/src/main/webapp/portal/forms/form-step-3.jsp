<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="alert alert-success" role="alert">
    <c:choose>
        <c:when test="${action == 'globalExtremes'}">
            <jsp:include page="../global-extremes/global-extremes.jsp"/>
        </c:when>
        <c:when test="${action == 'localExtremes'}">
            <jsp:include page="../local-extremes/local-extremes.jsp"/>
        </c:when>
        <c:when test="${action == 'singleDate'}">
            <jsp:include page="../single-date/single-date.jsp"/>
        </c:when>
        <c:when test="${action == 'dataSimplification'}">
            <jsp:include page="../data-simplification/data-simplification.jsp"/>
        </c:when>
        <c:when test="${action == 'rawData'}">
            <jsp:include page="../raw-data.jsp"/>
        </c:when>
    </c:choose>
</div>
<form action="/portal/home" method="post">
    <jsp:include page="form-step-nav.jsp"/>
</form>
