<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>Podaj kod funduszu lub waluty:</p>
<form action="/portal/home" method="post" class="form-inline">
    <input type="hidden" name="step" value="2"/>
    <div class="form-row align-items-center">
        <div class="col-auto">
            <input type="text" class="form-control" name="code">
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary">Dalej</button>
        </div>
    </div>
</form>