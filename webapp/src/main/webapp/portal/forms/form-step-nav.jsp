<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>

<div class="form-group row">
    <div class="col-sm-10">
        <button type="submit"
                id="back"
                class="btn btn-dark<c:if test="${step == 0}"> disabled</c:if>"
                name="step"
                value="<c:out value="${step-1}"/>"
                <c:if test="${step == 0}">disabled</c:if>
                formnovalidate>
            <fmt:message key="button.back" bundle="${finAppLanguage}"/>
        </button>
        <button type="submit"
                id="next"
                class="btn btn-dark<c:if test="${step == steps}"> disabled</c:if>"
                name="step"
                value="<c:out value="${step+1}"/>"
                <c:if test="${step == steps}">disabled</c:if> autofocus>
            <fmt:message key="button.next" bundle="${finAppLanguage}"/>
        </button>
    </div>
</div>