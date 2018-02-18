<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="alert alert-info" role="alert">
    <div class="row">
        <div class="col col-12 col-md-10 col-sm-9">
            <h4 class="alert-heading">Witaj <c:out value="${sessionScope.user.name}"/>!</h4>
            <p>Za pomocą naszej aplikacji uzyskasz informacje na temat notowań kursów walut oraz funduszy
                inwestycyjnych.
                Będziesz mógł odnaleźć ekstrema dla interesujących Cię wartości dla dowolnego okresu czasu, obejrzeć
                wykresy
                oraz je uprościć.</p>
            <hr>
            <p class="mb-0">Aby skorzystać z tych możliwości przejdź przez wszystkie kroki poniższego formularza.</p>
        </div>
        <div class="avatar col col-12 col-md-2 col-sm-3">
            <img src="<c:out value="${sessionScope.user.picture}"/>">
        </div>
    </div>
</div>

<form action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col-sm-10">
            <input type="hidden" name="step" value="1"/>
            <label for="chooseFundOrCurrency">Wybierz proszę, jakie dane chcesz przeanalizować:</label>
            <select class="form-control" type="text" name="data" id="chooseFundOrCurrency">
                <option value="fund" <c:if test="${sessionScope.data == 'fund'}">selected</c:if>>
                    Notowania funduszy inwestycyjnych
                </option>
                <option value="currency" <c:if test="${sessionScope.data == 'currency'}">selected</c:if>>
                    Notowania kursów walut
                </option>
            </select>
        </div>
    </div>
    <jsp:include page="form-step-nav.jsp"/>
</form>