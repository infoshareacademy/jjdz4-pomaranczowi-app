<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col col-sm-10">
            <label for="chooseCode">Podaj kod funduszu lub waluty:</label>
            <input type="text" class="form-control" name="code" id="chooseCode">
        </div>
    </div>
    <%@include file="form-step-nav.jsp" %>
</form>