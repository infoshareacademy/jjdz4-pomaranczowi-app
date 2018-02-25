<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>

<form id="chooseYearToggleView" class="hidden" action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseYear">
                <fmt:message key="dataSimplificationInput.chooseYear" bundle="${finAppLanguage}"/></label>
            <select class="form-control" type="text" name="year" id="chooseYear" onchange="showOrHideMonths()">
                <option></option>
                <c:forEach var="singleYear" items="${yearsList}">
                    <option <c:if test="${singleYear == sessionScope.singleYear}">selected</c:if>>
                        <c:out value="${singleYear}"/></option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group row" id="chooseMonthToggleView" style="display: none">
        <div class="col-sm-10">
            <label for="chooseMonth">
                <fmt:message key="dataSimplificationInput.chooseMonth" bundle="${finAppLanguage}"/></label>
            <select class="form-control" type="text" name="month" id="chooseMonth">
                <option value="0"></option>
                <option value="1"><fmt:message key="month.january" bundle="${finAppLanguage}"/></option>
                <option value="2"><fmt:message key="month.february" bundle="${finAppLanguage}"/></option>
                <option value="3"><fmt:message key="month.march" bundle="${finAppLanguage}"/></option>
                <option value="4"><fmt:message key="month.april" bundle="${finAppLanguage}"/></option>
                <option value="5"><fmt:message key="month.may" bundle="${finAppLanguage}"/></option>
                <option value="6"><fmt:message key="month.june" bundle="${finAppLanguage}"/></option>
                <option value="7"><fmt:message key="month.july" bundle="${finAppLanguage}"/></option>
                <option value="8"><fmt:message key="month.august" bundle="${finAppLanguage}"/></option>
                <option value="9"><fmt:message key="month.september" bundle="${finAppLanguage}"/></option>
                <option value="10"><fmt:message key="month.october" bundle="${finAppLanguage}"/></option>
                <option value="11"><fmt:message key="month.november" bundle="${finAppLanguage}"/></option>
                <option value="12"><fmt:message key="month.december" bundle="${finAppLanguage}"/></option>
            </select>
        </div>
    </div>
    <input type="hidden" name="action" value="dataSimplification">
    <jsp:include page="form-step-nav.jsp"/>
</form>
<script>
    function showOrHideMonths() {
        var monthSelectView = document.getElementById("chooseMonthToggleView");
        var yearSelect = document.getElementById("chooseYear").selectedIndex;
        if (yearSelect === 0) {
            monthSelectView.style.display = "none";
        } else {
            monthSelectView.style.display = "block";
        }
    }
</script>
