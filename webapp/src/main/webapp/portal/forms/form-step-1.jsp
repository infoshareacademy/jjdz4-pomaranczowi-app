<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>

<form id="form" action="/portal/home" method="post" novalidate>
    <div class="form-group row">
        <div class="col-sm-10">
            <label for="chooseCode">
                <fmt:message key="${chooseCodeMessage}" bundle="${finAppLanguage}"/>
            </label>
            <select type="text" class="form-control" name="code" id="chooseCode" required>
                <c:forEach var="CodeFromDB" items="${codeList}">
                    <option <c:if test="${CodeFromDB == sessionScope.code}">selected</c:if>>
                        <c:out value="${CodeFromDB}"/></option>
                </c:forEach>
            </select>
        </div>
    </div>
    <jsp:include page="form-step-nav.jsp"/>
</form>