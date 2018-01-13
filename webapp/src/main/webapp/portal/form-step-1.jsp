<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="form" action="/portal/home" method="post" novalidate>
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseCode">Podaj kod funduszu lub waluty:</label>
            <input type="text" class="form-control" name="code" id="chooseCode" required>
            <div class="invalid-feedback">
                Proszę podać kod funduszu lub waluty.
            </div>
        </div>
    </div>
    <%@include file="form-step-nav.jsp" %>
</form>