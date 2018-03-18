<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>

<div class="alert alert-info" role="alert">
    <div class="row">
        <div class="col col-12 col-md-10 col-sm-9">
            <h4 class="alert-heading"><fmt:message key="app.welcome" bundle="${finAppLanguage}"/>
                <c:out value="${sessionScope.user.name}"/>!</h4>
            <p><fmt:message key="app.mainInfo" bundle="${finAppLanguage}"/></p>
            <hr>
            <p class="mb-0"><fmt:message key="app.stepInfo" bundle="${finAppLanguage}"/></p>
        </div>
        <div class="avatar col col-12 col-md-2 col-sm-3">
            <img src="<c:out value="${sessionScope.user.picture}"/>">
        </div>
    </div>
</div>

<form action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col-sm-10">
            <input type="hidden" name="step" value="1"/>
            <label for="chooseFundOrCurrency"><fmt:message key="app.chooseFundOrCurrency"
                                                           bundle="${finAppLanguage}"/></label>
            <select class="form-control" type="text" name="data" id="chooseFundOrCurrency">
                <option value="fund" <c:if test="${sessionScope.data == 'fund'}">selected</c:if>>
                    <fmt:message key="app.fund" bundle="${finAppLanguage}"/>
                </option>
                <option value="currency" <c:if test="${sessionScope.data == 'currency'}">selected</c:if>>
                    <fmt:message key="app.currency" bundle="${finAppLanguage}"/>
                </option>
            </select>
        </div>
    </div>
    <jsp:include page="form-step-nav.jsp"/>
</form>