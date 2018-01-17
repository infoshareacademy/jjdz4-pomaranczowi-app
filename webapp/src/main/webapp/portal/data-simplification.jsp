<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4>
    Upraszczanie danych finansowych dla
    <c:out value="${sessionScope.data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${sessionScope.code}."/>
</h4>
<label for="chooseYear">Wybierz rok:</label>
<select class="form-control" type="text" name="year" id="chooseYear">
    <option>2018</option>
    <option>2017</option>
</select>