<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4>
    Ekstrema lokalne dla
    <c:out value="${sessionScope.data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${sessionScope.code}."/>
</h4>
<label for="chooseStartDate">Podaj date poczatkowa</label>
<input type="date" class="form-control" name="startDate" id="chooseStartDate" required>
<label for="chooseEndDate">Podaj date koncowa</label>
<input type="date" class="form-control" name="endDate" id="chooseEndDate" required>