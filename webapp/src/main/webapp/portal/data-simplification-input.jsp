<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="chooseYearToggleView" class="hidden" action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseYear">Wybierz rok:</label>
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
            <label for="chooseMonth">Wybierz miesiąc:</label>
            <select class="form-control" type="text" name="month" id="chooseMonth">
                <option value="0"></option>
                <option value="1">styczeń</option>
                <option value="2">luty</option>
                <option value="3">marzec</option>
                <option value="4">kwieceń</option>
                <option value="5">maj</option>
                <option value="6">czerwiec</option>
                <option value="7">lipiec</option>
                <option value="8">sierpień</option>
                <option value="9">wrzesień</option>
                <option value="10">październik</option>
                <option value="11">listopad</option>
                <option value="12">grudzień</option>
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
