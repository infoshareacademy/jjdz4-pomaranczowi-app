<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>

<form action="" method="">
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseAction"><fmt:message key="chooseAction.header" bundle="${finAppLanguage}"/></label>
            <select type="text" class="form-control" name="action"
                    id="chooseAction" onchange="toggleActionView()">
                <option value="globalExtremes" <c:if test="${sessionScope.action == 'globalExtremes'}">selected</c:if>>
                    <fmt:message key="chooseAction.globalExtremes" bundle="${finAppLanguage}"/>
                </option>
                <option value="localExtremes" <c:if test="${sessionScope.action == 'localExtremes'}">selected</c:if>>
                    <fmt:message key="chooseAction.localExtremes" bundle="${finAppLanguage}"/>
                </option>
                <option value="singleDate" <c:if test="${sessionScope.action == 'singleDate'}">selected</c:if>>
                    <fmt:message key="chooseAction.singleDate" bundle="${finAppLanguage}"/>
                </option>
                <option value="dataSimplification"
                        <c:if test="${sessionScope.action == 'dataSimplification'}">selected</c:if>>
                    <fmt:message key="chooseAction.dataSimplification" bundle="${finAppLanguage}"/>
                </option>
                <option value="rawData"
                        <c:if test="${sessionScope.action == 'rawData'}">selected</c:if>>
                    <fmt:message key="chooseAction.dataFromPeriod" bundle="${finAppLanguage}"/>
                </option>

            </select>
        </div>
    </div>
</form>
<jsp:include page="../data-simplification/data-simplification-input.jsp"/>
<jsp:include page="../single-date/signle-date-input.jsp"/>
<jsp:include page="../local-extremes/local-extremes-input.jsp"/>
<jsp:include page="../raw-data-input.jsp"/>
<form id="globalExtremes" action="/portal/home" method="post">
    <input type="hidden" name="action" value="globalExtremes">
    <jsp:include page="form-step-nav.jsp"/>
</form>
<script src="../../js/toggleActionView.js"></script>
