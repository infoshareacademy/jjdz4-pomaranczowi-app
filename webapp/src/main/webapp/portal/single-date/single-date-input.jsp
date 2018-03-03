<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>

<form id="chooseOneDateToggleView" class="hidden" action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseDate">
                <fmt:message key="singleDateInput.chooseDate" bundle="${finAppLanguage}"/></label>
            <input type="date" class="form-control" name="date" id="chooseDate" required>
        </div>
    </div>
    <input type="hidden" name="action" value="singleDate">
    <jsp:include page="../forms/form-step-nav.jsp"/>
</form>