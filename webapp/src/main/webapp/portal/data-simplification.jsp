<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4>
    Upraszczanie danych finansowych dla
    <c:out value="${sessionScope.data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${sessionScope.code}."/>
</h4>
<label for="chooseYear">Wybierz rok:</label>
<select class="form-control" type="text" name="year" id="chooseYear" onchange="showOrHideMonths()">
    <option></option>
    <option>2018</option>
    <option>2017</option>
</select>

<label for="chooseMonth" id="chooseMonthLabel" style="display: none">Wybierz miesiac:</label>
<select class="form-control" type="text" name="month" id="chooseMonth" style="display: none">
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

<script>
    function showOrHideMonths() {
        var monthSelect = document.getElementById("chooseMonth");
        var monthSelectLabel = document.getElementById("chooseMonthLabel");
        var yearSelect = document.getElementById("chooseYear").selectedIndex;
        if (yearSelect === 0) {
            monthSelect.style.display = "none";
            monthSelectLabel.style.display = "none";
        } else {
            monthSelect.style.display = "block";
            monthSelectLabel.style.display = "block";
        }
    }
</script>