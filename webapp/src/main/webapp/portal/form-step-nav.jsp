<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group row">
    <div class="col-sm-10">
        <button type="submit"
                class="btn btn-dark<c:if test="${sessionScope.step == 0}"> disabled</c:if>"
                name="step"
                value="<c:out value="${sessionScope.step-1}"/>"
                <c:if test="${sessionScope.step == 0}">disabled</c:if>>
            Wstecz
        </button>
        <button type="submit"
                class="btn btn-dark<c:if test="${sessionScope.step == applicationScope.steps}"> disabled</c:if>"
                name="step"
                value="<c:out value="${sessionScope.step+1}"/>"
                <c:if test="${sessionScope.step == applicationScope.steps}">disabled</c:if>>
            Dalej
        </button>
    </div>
</div>