<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col-sm-10">
            <c:choose>
                <c:when test="${param.fundOrCurrency == 1}">
                    <c:set var="userQuotation" scope="session" value="funduszu"/>
                </c:when>
                <c:when test="${param.fundOrCurrency == 2}">
                    <c:set var="userQuotation" scope="session" value="waluty"/>
                </c:when>
            </c:choose>
            <label for="chooseCode">Podaj kod ${sessionScope.userQuotation}:</label>
            <input type="text" class="form-control" name="code" id="chooseCode">
        </div>
    </div>
    <%@include file="form-step-nav.jsp" %>
</form>