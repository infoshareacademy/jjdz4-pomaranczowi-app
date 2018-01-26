<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="chooseYearToggleView" style="display: none">
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
            <label for="chooseMonth">Wybierz miesiac:</label>
            <select class="form-control" type="text" name="month" id="chooseMonth">
                <option></option>
                <option>styczen</option>
                <option>luty</option>
                <option>marzec</option>
                <option>kwiecen</option>
                <option>maj</option>
                <option>czerwiec</option>
                <option>lipiec</option>
                <option>sierpien</option>
                <option>wrzesien</option>
                <option>pazdziernik</option>
                <option>listopad</option>
                <option>grudzien</option>
            </select>
        </div>
    </div>
</div>

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
