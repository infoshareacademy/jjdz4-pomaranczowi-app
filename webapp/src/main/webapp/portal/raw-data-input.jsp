<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="chooseTwoDatesToggleView1" class="hidden" action="/portal/home" method="post">

    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseStartDate">Podaj datę poczatkową</label>
            <input type="date" class="form-control" name="startDate" id="chooseStartDate" required>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseEndDate">Podaj datę koncową</label>
            <input type="date" class="form-control" name="endDate" id="chooseEndDate" required>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-4" style="display: inline-flex; align-content: center;">
            <label for="toConversion">Uprość dane</label>
            <input id="toConversion" type="checkbox" class="form-control" name="toConversion">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-4">
            <select class="form-control" name="conversion" id="chooseConversion">
                <option value="SMA">Simple Moving Average (SMA)</option>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-4">
            <label for="choosePeriod">Ilosc poprzednich notowan do sredniej</label>
            <select class="form-control" name="period" id="choosePeriod">
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
        </div>
    </div>
    <input type="hidden" name="action" value="rawData">
    <jsp:include page="forms/form-step-nav.jsp"/>
</form>