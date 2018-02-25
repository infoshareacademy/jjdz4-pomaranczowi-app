<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>

<form id="chooseTwoDatesToggleView" class="hidden" action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseStartDate">
                <fmt:message key="localExtremesInput.chooseStartDate" bundle="${finAppLanguage}"/></label>
            <input type="date" class="form-control" name="startDate" id="chooseStartDate" required>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseEndDate">
                <fmt:message key="localExtremesInput.chooseEndDate" bundle="${finAppLanguage}"/></label>
            <input type="date" class="form-control" name="endDate" id="chooseEndDate" required>
        </div>
    </div>
    <input type="hidden" name="action" value="localExtremes">
    <jsp:include page="../forms/form-step-nav.jsp"/>
</form>