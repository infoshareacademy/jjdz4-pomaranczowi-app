<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="chooseTwoDatesToggleView" style="display: none">
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseStartDate">Podaj datę poczatkową</label>
            <input type="date" class="form-control" name="startDate" id="chooseStartDate">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseEndDate">Podaj datę koncową</label>
            <input type="date" class="form-control" name="endDate" id="chooseEndDate">
        </div>
    </div>
</div>