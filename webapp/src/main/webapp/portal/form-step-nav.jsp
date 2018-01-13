<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group row">
    <div class="col-sm-10">
        <button type="submit"
                id="back"
                class="btn btn-dark<c:if test="${step == 0}"> disabled</c:if>"
                name="step"
                value="<c:out value="${step-1}"/>"
                <c:if test="${step == 0}">disabled</c:if>
                formnovalidate>
            Wstecz
        </button>
        <button type="submit"
                id="next"
                class="btn btn-dark<c:if test="${step == steps}"> disabled</c:if>"
                name="step"
                value="<c:out value="${step+1}"/>"
                <c:if test="${step == steps}">disabled</c:if>>
            Dalej
        </button>
    </div>
</div>