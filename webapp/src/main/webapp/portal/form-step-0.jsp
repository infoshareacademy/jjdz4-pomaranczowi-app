<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="alert alert-info" role="alert">
    <h4 class="alert-heading">Witaj!</h4>
    <p>Za pomocą naszej aplikacji uzyskasz informacje na temat notowań kursów walut oraz funduszy inwestycyjnych.
        Będziesz mógł odnaleźć ekstrema dla interesujących Cię wartości dla dowolnego okresu czasu, obejrzeć wykresy
        oraz je uprościć.</p>
    <hr>
    <p class="mb-0">Aby skorzystać z tych możliwości przejdź przez wszystkie kroki poniższego formularza.</p>
</div>

<form action="/portal/home" method="post">
    <div class="form-group row">
        <div class="col-sm-10">
            <input type="hidden" name="step" value="1"/>
            <label for="chooseFundOrCurrency">Wybierz proszę, jakie dane chcesz przeanalizować:</label>
            <select class="form-control" type="text" name="fundOrCurrency" id="chooseFundOrCurrency">
                <option>Notowania funduszy inwestycyjnych</option>
                <option>Notowania kursów walut</option>
            </select>
        </div>
    </div>
    <%@include file="form-step-nav.jsp" %>
</form>