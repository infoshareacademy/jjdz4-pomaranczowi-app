<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseAction">Wybierz sposób sposób analizy:</label>
            <select type="text" class="form-control" name="action" id="chooseAction">
                <option value="1">Ekstrema globalne</option>
                <option value="2">Ekstrema lokalne</option>
                <option value="3">Wartości z danego dnia</option>
                <option value="4">Upraszczanie danych</option>
            </select>
        </div>
    </div>
    <%@include file="form-step-nav.jsp" %>
</form>