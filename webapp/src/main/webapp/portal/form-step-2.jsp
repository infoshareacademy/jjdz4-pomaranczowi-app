<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/portal/home" method="post">
    <input type="hidden" name="step" value="3"/>
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseAction">Wybierz sposób sposób analizy:</label>
            <select type="text" class="form-control" name="chooseAction" id="chooseAction">
                <option>Ekstrema globalne</option>
                <option>Ekstrema lokalne</option>
                <option>Wartości z danego dnia</option>
                <option>Upraszczanie danych</option>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Dalej</button>
        </div>
    </div>
</form>